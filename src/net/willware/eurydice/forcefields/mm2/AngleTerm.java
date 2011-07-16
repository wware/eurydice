/**
 * AngleTerm.java - MM2-style angle energy term
 * Copyright (c) 1997,1998 Will Ware, all rights reserved.
 */

package net.willware.eurydice.forcefields.mm2;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.math.Vector;

// TODO: Auto-generated Javadoc
/**
 * A MM2 energy term for the angle formed by three atoms. Please see Section 3.3.2.b and Table 3.3
 * of <i>Nanosystems: Molecular Machinery, Manufacturing, and Computation</i> by K. Eric Drexler,
 * copyright 1992, published by John Wiley and Sons.
 */
public class AngleTerm extends TermImpl {

    /** A conversion constant from degrees to radians. */
    private static final double radiansPerDegree = 3.1415926 / 180;    // degrees to radians

    /**
     * The kth coefficient, in units of force divided by degrees (or radians, I forget which).
     * I don't remember the physical units involved.
     */
    private double kth;

    /** The resting angle coefficient, in degrees. */
    private double th0;

    /**
     * Constructor.
     *
     * @param a1 the first atom in a chain
     * @param a2 the second atom in a chain
     * @param a3 the third atom in a chain
     */
    public AngleTerm(Atom a1, Atom a2, Atom a3) {
        int i;
        boolean found;
        myAtoms = new Atom[3];
        myAtoms[0] = a1;
        myAtoms[1] = a2;
        myAtoms[2] = a3;
        for (i = 0, found = false;
                i < angleCoeffs.length && !found; i++)
            if ((a1.getAtomicNumber() == angleCoeffs[i][0]
                    && a1.getHybridization() == angleCoeffs[i][1]
                    && a2.getAtomicNumber() == angleCoeffs[i][2]
                    && a2.getHybridization() == angleCoeffs[i][3]
                    && a3.getAtomicNumber() == angleCoeffs[i][4]
                    && a3.getHybridization() == angleCoeffs[i][5])
                    || (a1.getAtomicNumber() == angleCoeffs[i][4]
                        && a1.getHybridization() == angleCoeffs[i][5]
                        && a2.getAtomicNumber() == angleCoeffs[i][2]
                        && a2.getHybridization() == angleCoeffs[i][3]
                        && a3.getAtomicNumber() == angleCoeffs[i][0]
                        && a3.getHybridization() == angleCoeffs[i][1])) {
                found = true;
                kth = angleCoeffs[i][6];
                th0 = angleCoeffs[i][7] * radiansPerDegree;
            }
        if (!found) {
            kth = 0.3;
            th0 = 120.0 * radiansPerDegree;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.Term#toStringHelper()
     */
    protected String toStringHelper() {
        return " angle " +
               (new Double(kth)).toString() + " " +
               (new Double(th0)).toString();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.Term#computeForces(net.willware.eurydice.core.Structure)
     */
    public void computeForces(Structure struc) {
        if (kth == 0.0)
            return;
        // compute forces on each atom, add it to the atom's force vector
        double th, tdif, duDth;
        Vector adiff = myAtoms[0].getPosition().subtract(myAtoms[1].getPosition());
        Vector bdiff = myAtoms[2].getPosition().subtract(myAtoms[1].getPosition());
        double aa = adiff.dotProduct(adiff);
        double ab = adiff.dotProduct(bdiff);
        double bb = bdiff.dotProduct(bdiff);
        if (aa > 3.0 || bb > 3.0)
            return;
        th = Math.acos(ab / Math.sqrt(aa * bb));
        tdif = th - th0;
        duDth = kth * (tdif * (1.0 + 1.508 * tdif * tdif));
        Vector f0 = bdiff.scale(aa).subtract(adiff.scale(ab));
        Vector f2 = adiff.scale(bb).subtract(adiff.scale(ab));
        f0 = f0.scale(duDth / Math.sqrt(f0.dotProduct(f0) * aa));
        f2 = f2.scale(duDth / Math.sqrt(f2.dotProduct(f2) * bb));
        /**
         * NOTE that these indices are INTS, not LONGS, reflecting the limited and
         * half-baked tenor of Nanocad's MM2 implementation. It cannot scale to big
         * structures where a 32-bit index would be insufficient.
         */
        myAtoms[0].addForce(f0);
        myAtoms[1].addForce(f0.add(f2).negate());
        myAtoms[2].addForce(f2);
    }

    /** Table of coefficients for various triplets of atom types. */
    private final static double[][] angleCoeffs = {
        // atom1, atom2, atom3, kth, th0 (in degrees)
        {C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, 0.450, 109.470},
        {C, Atom.SP3, C, Atom.SP3, C, Atom.SP2, 0.450, 109.470},
        {C, Atom.SP3, C, Atom.SP3, C, Atom.SP, 0.450, 109.470},
        {C, Atom.SP3, C, Atom.SP3, H, Atom.NONE, 0.360, 109.390},
        {C, Atom.SP3, C, Atom.SP3, O, Atom.SP3, 0.700, 107.500},
        {C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 0.570, 109.470},
        {C, Atom.SP3, C, Atom.SP3, N, Atom.SP2, 0.500, 109.280},
        {C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 0.570, 103.500},
        {C, Atom.SP3, C, Atom.SP3, O, Atom.SP2, 0.700, 107.500},
        {C, Atom.SP2, C, Atom.SP3, C, Atom.SP2, 0.450, 109.470},
        {C, Atom.SP2, C, Atom.SP3, C, Atom.SP, 0.470, 109.470},
        {C, Atom.SP2, C, Atom.SP3, H, Atom.NONE, 0.360, 109.390},
        {C, Atom.SP2, C, Atom.SP3, O, Atom.SP3, 0.700, 109.500},
        {C, Atom.SP2, C, Atom.SP3, N, Atom.SP3, 1.045, 110.740},
        {C, Atom.SP2, C, Atom.SP3, N, Atom.SP2, 0.500, 109.800},
        {C, Atom.SP2, C, Atom.SP3, N, Atom.SP3, 1.045, 110.740},
        {C, Atom.SP, C, Atom.SP3, C, Atom.SP, 0.470, 109.470},
        {C, Atom.SP, C, Atom.SP3, H, Atom.NONE, 0.360, 109.390},
        {H, Atom.NONE, C, Atom.SP3, H, Atom.NONE, 0.320, 109.400},
        {H, Atom.NONE, C, Atom.SP3, O, Atom.SP3, 0.540, 106.700},
        {H, Atom.NONE, C, Atom.SP3, N, Atom.SP3, 0.500, 108.800},
        {H, Atom.NONE, C, Atom.SP3, N, Atom.SP2, 0.420, 109.000},
        {H, Atom.NONE, C, Atom.SP3, N, Atom.SP3, 0.500, 108.800},
        {H, Atom.NONE, C, Atom.SP3, O, Atom.SP2, 0.540, 106.700},
        {O, Atom.SP3, C, Atom.SP3, O, Atom.SP3, 0.460, 99.900},
        {N, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 1.045, 110.740},
        {N, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 1.045, 110.740},
        {C, Atom.SP3, C, Atom.SP2, C, Atom.SP3, 0.450, 117.200},
        {C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, 0.550, 121.400},
        {C, Atom.SP3, C, Atom.SP2, C, Atom.SP, 0.470, 122.000},
        {C, Atom.SP3, C, Atom.SP2, H, Atom.NONE, 0.360, 118.200},
        {C, Atom.SP3, C, Atom.SP2, O, Atom.SP3, 0.500, 120.000},
        {C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, 0.430, 120.000},
        {C, Atom.SP2, C, Atom.SP2, H, Atom.NONE, 0.360, 120.000},
        {C, Atom.SP2, C, Atom.SP2, O, Atom.SP3, 0.700, 124.300},
        {C, Atom.SP2, C, Atom.SP2, N, Atom.SP3, 0.616, 123.000},
        {C, Atom.SP2, C, Atom.SP2, N, Atom.SP2, 0.500, 118.000},
        {C, Atom.SP2, C, Atom.SP2, O, Atom.SP2, 0.600, 120.000},
        {C, Atom.SP, C, Atom.SP2, H, Atom.NONE, 0.360, 121.100},
        {H, Atom.NONE, C, Atom.SP2, H, Atom.NONE, 0.320, 119.000},
        {H, Atom.NONE, C, Atom.SP2, O, Atom.SP3, 0.540, 116.400},
        {H, Atom.NONE, C, Atom.SP2, N, Atom.SP3, 0.540, 119.000},
        {H, Atom.NONE, C, Atom.SP2, N, Atom.SP2, 0.300, 109.000},
        {H, Atom.NONE, C, Atom.SP2, O, Atom.SP2, 0.450, 108.000},
        {N, Atom.SP2, C, Atom.SP2, N, Atom.SP2, 0.400, 120.000},
        {C, Atom.SP3, C, Atom.SP, C, Atom.SP, 0.200, 180.000},
        {C, Atom.SP3, C, Atom.SP, N, Atom.SP, 0.325, 180.000},
        {C, Atom.SP2, C, Atom.SP, C, Atom.SP2, 0.400, 180.000},
        {C, Atom.SP2, C, Atom.SP, C, Atom.SP, 0.470, 180.000},
        {C, Atom.SP, C, Atom.SP, H, Atom.NONE, 0.360, 180.000},
        {C, Atom.SP, C, Atom.SP, O, Atom.SP3, 0.360, 180.000},
        {C, Atom.SP, C, Atom.SP, O, Atom.SP2, 0.360, 180.000},
        {C, Atom.SP, C, Atom.SP, N, Atom.SP3, 0.360, 180.000},
        {C, Atom.SP, C, Atom.SP, N, Atom.SP2, 0.360, 180.000},
        {C, Atom.SP, C, Atom.SP, N, Atom.SP, 0.360, 180.000},
        {C, Atom.SP3, O, Atom.SP3, C, Atom.SP3, 0.770, 106.800},
        {C, Atom.SP3, O, Atom.SP3, C, Atom.SP2, 0.770, 110.800},
        {C, Atom.SP3, O, Atom.SP3, O, Atom.SP3, 0.635, 98.700},
        {C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.630, 107.700},
        {C, Atom.SP3, N, Atom.SP3, C, Atom.SP2, 0.698, 107.000},
        {C, Atom.SP3, N, Atom.SP3, N, Atom.SP3, 0.740, 105.500},
        {C, Atom.SP3, N, Atom.SP2, C, Atom.SP3, 0.760, 126.000},
        {C, Atom.SP3, N, Atom.SP2, C, Atom.SP2, 0.630, 119.900},
        {C, Atom.SP2, N, Atom.SP2, C, Atom.SP2, 0.400, 107.000},
        {C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.630, 108.600},
        {C, Atom.SP3, N, Atom.SP3, H, Atom.NONE, 0.500, 109.470},
        {H, Atom.NONE, N, Atom.SP3, H, Atom.NONE, 0.500, 104.500},
        {C, Atom.SP3, O, Atom.SP2, C, Atom.SP2, 0.770, 113.600},
        {C, Atom.SP2, O, Atom.SP2, C, Atom.SP2, 0.870, 113.950}
    };
}
