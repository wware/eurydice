/**
 * LongRangeTerm.java - MM2-style long-range (electrostatic and Van der Waals) energy term
 * Copyright (c) 1997 Will Ware, all rights reserved.
 */

package net.willware.eurydice.forcefields.mm2;

import java.util.ArrayList;
import java.util.List;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.math.Vector;

/**
 * An energy term involving long-range electrostatic and Van der Waals interactions.
 * Please see Sections 3.3.2.d and 3.3.2.e of <i>Nanosystems: Molecular Machinery, Manufacturing,
 * and Computation</i> by K. Eric Drexler, copyright 1992, published by John Wiley and Sons.
 */
public class LongRangeForces {

    /** The structure to which this energy term applies. */
    private Structure struc;

    /** The bonds. */
    List<Bond> bonds;

    public LongRangeForces(Structure struc) {
        this.struc = struc;
    }

    private class AtomPair {
        private Atom a1;
        private Atom a2;
        public AtomPair(Atom a1, Atom a2) {
            if (a1.getUniqueId().compareTo(a2.getUniqueId()) >= 0) {
                Atom temp = a2;
                a2 = a1;
                a1 = temp;
            }
            this.a1 = a1;
            this.a2 = a2;
        }
        public String toString() {
            return "<Pair " + a1 + " " + a2 + ">";
        }
        public boolean equals(Object obj) {
            try {
                AtomPair pair2 = (AtomPair) obj;
                return (a1.getUniqueId().equals(pair2.a1.getUniqueId()) &&
                        a2.getUniqueId().equals(pair2.a2.getUniqueId()));
            } catch (Exception e) {
                return false;
            }
        }
    }

    private ArrayList<AtomPair> exclusions = new ArrayList<AtomPair>();

    public void addExclusion(Atom a1, Atom a2) {
        AtomPair pair = new AtomPair(a1, a2);
        // if (DEBUG) System.out.println("add " + pair);
        if (!exclusions.contains(pair))
            exclusions.add(pair);
    }

    public boolean hasExclusion(Atom a1, Atom a2) {
        AtomPair pair = new AtomPair(a1, a2);
        // if (DEBUG) System.out.println("check " + pair);
        return exclusions.contains(pair);
    }

    // TODO figure out correct constant for dipole charge assignments
    private static final double dontKnowCorrectUnits = 1.0;

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

    private static final boolean DEBUG = false;

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.Term#computeForces(net.willware.eurydice.core.Structure)
     */
    public void computeForces() {
        int i, j, n = (int) struc.size();
        for (i = 0; i < n - 1; i++) {
            Atom a1 = struc.get(i);
            for (j = i + 1; j < n; j++) {
                Atom a2 = struc.get(j);
                if (!hasExclusion(a1, a2)) {
                    if (DEBUG)
                        System.out.println(a1 + " " + a2);
                    else
                        computeForces(a1, a2);
                }
            }
        }
    }

    /* units here are (maJ * nm) / (e * e), where e is charge on a proton */
    private final static double electricConstant =
        // (8.9876 * 0.160206 * 0.160206 * 1000.0);
        -1.0e-3;

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
    private void computeForces(Atom a1, Atom a2) {
        double rvdw = a1.vdwRadius() + a2.vdwRadius();
        double evdw = (a1.vdwEnergy() + a2.vdwEnergy()) / 2;
        // let's ignore integer charge for the time being
        //double q1q2 = a1.fractionalCharge * a2.fractionalCharge;
        Vector diff = a1.getPosition().subtract(a2.getPosition());
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
        a1.addForce(f.negate());
        a2.addForce(f);
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
        {Term.C, Atom.SP3, Term.C, Atom.SP2, 0.300 / 1.497},
        {Term.C, Atom.SP3, Term.C, Atom.SP, 0.750 / 1.470},
        {Term.C, Atom.SP3, Term.O, Atom.SP3, 0.440 / 1.402},
        {Term.C, Atom.SP3, Term.N, Atom.SP3, 0.040 / 1.438},
        {Term.C, Atom.SP3, Term.N, Atom.SP2, 1.470 / 1.437},
        {Term.C, Atom.SP3, Term.C, Atom.SP3, 0.150 / 1.502},
        {Term.C, Atom.SP3, Term.N, Atom.SP2, 1.260 / 1.470},
        {Term.C, Atom.SP3, Term.C, Atom.SP2, 0.300 / 1.497},
        {Term.C, Atom.SP3, Term.O, Atom.SP2, 0.220 / 1.414},
        {Term.C, Atom.SP3, Term.N, Atom.SP2, 1.260 / 1.488},
        {Term.C, Atom.SP3, Term.N, Atom.SP2, 1.350 / 1.498},
        {Term.C, Atom.SP3, Term.C, Atom.SP2, 0.300 / 1.497},
        {Term.C, Atom.SP3, Term.O, Atom.SP3, 1.900 / 1.480},
        {Term.C, Atom.SP3, Term.C, Atom.SP3, 0.300 / 1.509},
        {Term.C, Atom.SP3, Term.N, Atom.SP2, 1.260 / 1.470},
        {Term.C, Atom.SP2, Term.O, Atom.SP3, 0.001 / 1.355},
        {Term.C, Atom.SP2, Term.N, Atom.SP3, -0.400 / 1.377},
        {Term.C, Atom.SP2, Term.N, Atom.SP2, 1.300 / 1.410},
        {Term.C, Atom.SP2, Term.C, Atom.SP3, -0.150 / 1.467},
        {Term.C, Atom.SP2, Term.N, Atom.SP2, 0.583 / 1.260},
        {Term.C, Atom.SP2, Term.N, Atom.SP2, 0.870 / 1.266},
        {Term.C, Atom.SP2, Term.O, Atom.SP2, 0.950 / 1.225},
        {Term.C, Atom.SP2, Term.N, Atom.SP2, 1.700 / 1.463},
        {Term.C, Atom.SP2, Term.N, Atom.SP2, 0.583 / 1.260},
        {Term.C, Atom.SP, Term.N, Atom.SP, 3.400 / 1.158},
        {Term.O, Atom.SP3, Term.H, Atom.NONE, -1.115 / 0.942},
        {Term.O, Atom.SP3, Term.H, Atom.NONE, -0.700 / 0.972},
        {Term.O, Atom.SP3, Term.H, Atom.NONE, -0.700 / 0.972},
        {Term.O, Atom.SP2, Term.N, Atom.SP2, -2.600 / 1.268},
        {Term.O, Atom.SP2, Term.N, Atom.SP2, -2.530 / 1.220},
        {Term.N, Atom.SP3, Term.H, Atom.NONE, -0.760 / 1.020},
        {Term.N, Atom.SP2, Term.H, Atom.NONE, -1.310 / 1.022},
        {Term.C, Atom.SP3, Term.N, Atom.SP2, 1.700 / 1.477},
        {Term.H, Atom.NONE, Term.N, Atom.SP2, 0.600 / 1.022},
        {Term.H, Atom.NONE, Term.N, Atom.SP2, 0.600 / 1.022},
        {Term.H, Atom.NONE, Term.O, Atom.SP2, 0.700 / 0.972},
        {Term.N, Atom.SP2, Term.N, Atom.SP2, 0.300 / 1.230},
        {Term.O, Atom.SP3, Term.C, Atom.SP3, -2.800 / 1.236}
    };
}
