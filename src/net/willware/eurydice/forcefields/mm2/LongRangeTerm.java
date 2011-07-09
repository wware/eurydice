/**
 * LongRangeTerm.java - MM2-style long-range (electrostatic and Van der Waals) energy term
 * Copyright (c) 1997 Will Ware, all rights reserved.
 */

package net.willware.eurydice.forcefields.mm2;

import java.util.List;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.BondImpl;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.math.Vector;

/**
 * An energy term involving long-range electrostatic and Van der Waals interactions.
 * Please see Sections 3.3.2.d and 3.3.2.e of <i>Nanosystems: Molecular Machinery, Manufacturing,
 * and Computation</i> by K. Eric Drexler, copyright 1992, published by John Wiley and Sons.
 */
public class LongRangeTerm extends TermImpl {

    /** The structure to which this energy term applies. */
    private Structure struc;

    /** The bonds. */
    List<Bond> bonds;

    /** The exclusions. */
    private int[][] exclusions;

    /**
     * Constructor.
     *
     * @param a1 the first atom
     * @param a2 the second atom
     */
    public LongRangeTerm(Atom a1, Atom a2) {
        myAtoms = new Atom[2];
        myAtoms[0] = a1;
        myAtoms[1] = a2;
        // anything else?
    }

    // TODO figure out correct constant for dipole charge assignments
    /** The Constant dontKnowCorrectUnits. */
    private final static double dontKnowCorrectUnits = 1.0;

    /**
     * Step through pairs of atoms, converting dipole moments into fractional electrostatic charges
     * on each atom.
     */
    private void hackCharges() {
        int i, j, k;
        final int n = (int) struc.size();
        boolean found;
        Atom a1, a2;

        for (j = 0; j < n; j++) {
            a1 = struc.get(j);
            for (k = j + 1; k < n; k++) {
                a2 = struc.get(k);
                for (i = 0, found = false;
                        i < dipoleMoments.length && !found;
                        i++) {
                    if (a1.atomicNumber() == dipoleMoments[i][0] &&
                            a1.getHybridization() == dipoleMoments[i][1] &&
                            a2.atomicNumber() == dipoleMoments[i][2] &&
                            a2.getHybridization() == dipoleMoments[i][3]) {
                        double diffCharge = dontKnowCorrectUnits * dipoleMoments[i][4];
                        found = true;
                        a1.setFractionalCharge(a1.getFractionalCharge() + diffCharge);
                        a2.setFractionalCharge(a2.getFractionalCharge() - diffCharge);
                    } else if (a1.atomicNumber() == dipoleMoments[i][2] &&
                               a1.getHybridization() == dipoleMoments[i][3] &&
                               a2.atomicNumber() == dipoleMoments[i][0] &&
                               a2.getHybridization() == dipoleMoments[i][1]) {
                        double diffCharge = dontKnowCorrectUnits * dipoleMoments[i][4];
                        found = true;
                        a1.setFractionalCharge(a1.getFractionalCharge() - diffCharge);
                        a2.setFractionalCharge(a2.getFractionalCharge() + diffCharge);
                    }
                }
            }
        }
    }

    /**
     * Bond chain.
     *
     * @param a1 the a1
     * @param a2 the a2
     * @param depth the depth
     * @return true, if successful
     */
    private boolean bondChain(Atom a1, Atom a2, int depth) {
        if (a1 == a2)
            return true;
        if (depth == 0)
            return false;
        List<Bond> a1bonds = BondImpl.filterList(a1, bonds);
        if (a1bonds == null)
            return false;
        if (depth == 1)
            return BondImpl.touchesAtom(a1bonds, a2);
        for (Bond b: a1bonds)
            if (bondChain(b.otherAtom(a1), a2, depth - 1))
                return true;
        return false;
    }

    /** The Constant maxNumChained. */
    private final static int maxNumChained = 50;

    /**
     * Enumerate.
     *
     * @param struc the struc
     * @param termList the term list
     */
    public void enumerate(Structure struc, List<TermImpl> termList) {
        int i, j, n;
        this.struc = struc;
        bonds = struc.inferBonds();
        hackCharges();
        n = (int) struc.size();
        exclusions = new int[n][maxNumChained];
        for (i = 0; i < n; i++) {
            int numChained = 0;
            Atom a1 = struc.get(i);
            for (j = i + 1; j < n; j++) {
                Atom a2 = struc.get(j);
                if (bondChain(a1, a2, 2))
                    exclusions[i][numChained++] = j;
            }
            /* trim each subarray to the smallest possible size */
            int[] temp = new int[numChained];
            for (j = 0; j < numChained; j++)
                temp[j] = exclusions[i][j];
            exclusions[i] = temp;
        }
        termList.add(this);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.Term#computeForces(net.willware.eurydice.core.Structure)
     */
    public void computeForces(Structure struc) {
        int i, j, k, n = (int) struc.size();
        for (i = 0; i < n; i++) {
            Atom a1 = struc.get(i);
            k = i + 1;
            for (j = 0; j < exclusions[i].length; j++) {
                for (; k < exclusions[i][j]; k++) {
                    Atom a2 = struc.get(k);
                    computeForces(a1, a2, struc);
                }
                k++;
            }
            for (; k < n; k++) {
                Atom a2 = struc.get(k);
                computeForces(a1, a2, struc);
            }
        }
    }

    /* units here are (maJ * nm) / (e * e), where e is charge on a proton */
    /*
    private final static double electricConstant =
        // (8.9876 * 0.160206 * 0.160206 * 1000.0);
        -1.0e-3;
    */

    // should be negative, -1.0 is too big, -1.0e-12 is too small
    // -1e-6 too small, -1.0e-3 is in the ballpark

    /**
     * Compute force contributions on a pair of atoms due to electrostatic
     * and Van der Waals forces.
     *
     * @param a1 the first atom
     * @param a2 the second atom
     * @param struc the structure the atoms belong to
     */
    private void computeForces(Atom a1, Atom a2, Structure struc) {
        double rvdw = a1.vdwRadius() + a2.vdwRadius();
        double evdw = (a1.vdwEnergy() + a2.vdwEnergy()) / 2;
        // let's ignore integer charge for the time being
        //double q1q2 = a1.fractionalCharge * a2.fractionalCharge;
        Vector diff = myAtoms[0].getPosition().subtract(myAtoms[1].getPosition());
        double r = diff.length();
        double m, r_1, r_2, r_6;
        // m = electricConstant * q1q2 / (r2 * r);
        r_1 = rvdw / r;
        r_2 = r_1 * r_1;
        r_6 = r_2 * r_2 * r_2;
        // m -= 0.012 * evdw * r_1 * r_6 * (r_6 - 1.0);
        m = -0.012 * evdw * r_1 * r_6 * (r_6 - 1.0);

        // m > 0 attract, m < 0 repel
        Vector f = diff.scale(m);
        /**
         * NOTE that these indices are INTS, not LONGS, reflecting the limited and
         * half-baked tenor of Nanocad's MM2 implementation. It cannot scale to big
         * structures where a 32-bit index would be insufficient.
         */
        myAtoms[0].addForce(f.negate());
        myAtoms[1].addForce(f);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.TermImpl#toStringHelper()
     */
    protected String toStringHelper() {
        return " torsion";
    }

    // These are covalent bond dipole moments, due to
    // differences in electronegativity. Actually, these
    // are dipoleMoments divided by bondLengths, which
    // gives fractionalCharges
    /** The Constant dipoleMoments. */
    private final static double[][] dipoleMoments = {
        {C, Atom.SP3, C, Atom.SP2, 0.300 / 1.497},
        {C, Atom.SP3, C, Atom.SP, 0.750 / 1.470},
        {C, Atom.SP3, O, Atom.SP3, 0.440 / 1.402},
        {C, Atom.SP3, N, Atom.SP3, 0.040 / 1.438},
        {C, Atom.SP3, N, Atom.SP2, 1.470 / 1.437},
        {C, Atom.SP3, C, Atom.SP3, 0.150 / 1.502},
        {C, Atom.SP3, N, Atom.SP2, 1.260 / 1.470},
        {C, Atom.SP3, C, Atom.SP2, 0.300 / 1.497},
        {C, Atom.SP3, O, Atom.SP2, 0.220 / 1.414},
        {C, Atom.SP3, N, Atom.SP2, 1.260 / 1.488},
        {C, Atom.SP3, N, Atom.SP2, 1.350 / 1.498},
        {C, Atom.SP3, C, Atom.SP2, 0.300 / 1.497},
        {C, Atom.SP3, O, Atom.SP3, 1.900 / 1.480},
        {C, Atom.SP3, C, Atom.SP3, 0.300 / 1.509},
        {C, Atom.SP3, N, Atom.SP2, 1.260 / 1.470},
        {C, Atom.SP2, O, Atom.SP3, 0.001 / 1.355},
        {C, Atom.SP2, N, Atom.SP3, -0.400 / 1.377},
        {C, Atom.SP2, N, Atom.SP2, 1.300 / 1.410},
        {C, Atom.SP2, C, Atom.SP3, -0.150 / 1.467},
        {C, Atom.SP2, N, Atom.SP2, 0.583 / 1.260},
        {C, Atom.SP2, N, Atom.SP2, 0.870 / 1.266},
        {C, Atom.SP2, O, Atom.SP2, 0.950 / 1.225},
        {C, Atom.SP2, N, Atom.SP2, 1.700 / 1.463},
        {C, Atom.SP2, N, Atom.SP2, 0.583 / 1.260},
        {C, Atom.SP, N, Atom.SP, 3.400 / 1.158},
        {O, Atom.SP3, H, Atom.NONE, -1.115 / 0.942},
        {O, Atom.SP3, H, Atom.NONE, -0.700 / 0.972},
        {O, Atom.SP3, H, Atom.NONE, -0.700 / 0.972},
        {O, Atom.SP2, N, Atom.SP2, -2.600 / 1.268},
        {O, Atom.SP2, N, Atom.SP2, -2.530 / 1.220},
        {N, Atom.SP3, H, Atom.NONE, -0.760 / 1.020},
        {N, Atom.SP2, H, Atom.NONE, -1.310 / 1.022},
        {C, Atom.SP3, N, Atom.SP2, 1.700 / 1.477},
        {H, Atom.NONE, N, Atom.SP2, 0.600 / 1.022},
        {H, Atom.NONE, N, Atom.SP2, 0.600 / 1.022},
        {H, Atom.NONE, O, Atom.SP2, 0.700 / 0.972},
        {N, Atom.SP2, N, Atom.SP2, 0.300 / 1.230},
        {O, Atom.SP3, C, Atom.SP3, -2.800 / 1.236}
    };
}
