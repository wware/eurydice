/**
 * LengthTerm.java - MM2-style length energy term
 * Copyright (c) 1997,1998 Will Ware, all rights reserved.
 */

package net.willware.eurydice.forcefields.mm2;

import java.lang.Math;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.math.*;

/**
 * An energy term associated with bond length. Please see Section 3.3.2.a and Table 3.2 of
 * <i>Nanosystems: Molecular Machinery, Manufacturing, and Computation</i> by K. Eric Drexler,
 * copyright 1992, published by John Wiley and Sons.
 */
public class LengthTerm extends TermImpl {

    /**
     * The spring constant coefficient. Force is measured in attoJoules per Angstroms, so this
     * is attoJoules per Angstroms-squared.
     */
    private double ks;

    /** The rest length coefficient, in Angstroms. */
    private double r0;

    /**
     * Constructor.
     *
     * @param a1 the first atom
     * @param a2 the second atom
     */
    public LengthTerm(Atom a1, Atom a2) {
        int i;
        boolean found;
        myAtoms = new Atom[2];
        myAtoms[0] = a1;
        myAtoms[1] = a2;
        for (i = 0, found = false;
                i < lengthCoeffs.length && !found; i++)
            if ((a1.atomicNumber() == lengthCoeffs[i][0]
                    && a1.getHybridization() == lengthCoeffs[i][1]
                    && a2.atomicNumber() == lengthCoeffs[i][2]
                    && a2.getHybridization() == lengthCoeffs[i][3])
                    || (a1.atomicNumber() == lengthCoeffs[i][2]
                        && a1.getHybridization() == lengthCoeffs[i][3]
                        && a2.atomicNumber() == lengthCoeffs[i][0]
                        && a2.getHybridization() == lengthCoeffs[i][1])) {
                found = true;
                ks = lengthCoeffs[i][4];
                r0 = lengthCoeffs[i][5];
            }
        if (!found) {
            // something innocuous
            ks = 2.0;
            r0 = 1.2;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.Term#toStringHelper()
     */
    protected String toStringHelper() {
        return " length " +
               (new Double(ks)).toString() + " " +
               (new Double(r0)).toString();
    }

    /* I've been hacking a bit with acceptable forms for the length-energy term.
     * _Nanosystems_ lists one simple expression with a square and cubic term
     * for close distances, and various kinds of exponential expressions for
     * farther away. But these depend on numbers called De and beta and I don't
     * have tables for those (just the few examples in _Nanosystems_). So after
     * some puttering and graphing and algebra, I came up with the following.
     * Energies are in attojoules (10^-18 joules), distances are in angstroms
     * (10^-10 m), forces are in attojoules per angstrom (10^-8 N), and
     * spring constants are in attojoules per angstrom-squared (100 N/m). This
     * is consistent with the units in _Nanosystems_, and also the units used
     * in the 'mm2.prm' parameter file I found on Jay Ponder's ftp site.
     * Expressions for energy and force, where ks and r0 are a function of
     * the two atoms involved:
     *
     *   dr = r - r0;
     *
     * Energy (r) :=
     *   if (dr < rthresh)
     *     { return 0.5 * ks * dr * dr * (1 - kc * dr) - z * ks; }
     *   else
     *     { return (-a * ks / beta) * exp (-beta * dr); }
     *
     * Force (r) :=
     *   if (dr < rthresh)
     *     { return -(ks * dr * (1 - 1.5 * kc * dr)); }
     *   else
     *     { return -a * ks * exp (-beta * dr); }
     *
     *
     * A, beta, z, kcubic, and rthresh are defined below. Notice my use of
     * 'beta' differs from the use in _Nanosystems_, but plays a similar role.
     *
     * These follow Drexler's quadratic-cubic form for dr < rthresh, and for
     * dr > rthresh, they follow an exponential drop-off which is pretty
     * continuous for both energy and force. The only point that I think would
     * be worth quibbling over would be the value of beta, which I picked so
     * that it would look "reasonable" on a graph.
     */
    /** The Constant kcubic. */
    private static final double kcubic = 2.0;    /* (0.5 angstrom)^-1 */

    /** The Constant rthresh. */
    private static final double rthresh = 1 / (3 * kcubic);

    /** The Constant beta. */
    private static final double beta = 3.0;

    /** The Constant a. */
    private static final double a =
        rthresh * (1 -
                   1.5 * kcubic * rthresh) * Math.exp(beta * rthresh);
    /*
    private static final double z =
        (a / beta) * Math.exp(-beta * rthresh) +
        0.5 * rthresh * rthresh * (1 - kcubic * rthresh);
    */
    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.Term#computeForces(net.willware.eurydice.core.Structure)
     */
    public void computeForces(Structure struc) {
        // compute forces on each atom, add it to the atom's force vector
        double m;
        Vector diff = myAtoms[0].getPosition().subtract(myAtoms[1].getPosition());
        double r = diff.length();
        double rdiff = (r - r0); // , expr;
        if (rdiff < rthresh)
            m = ks * rdiff * (1 - 1.5 * kcubic * rdiff);
        else
            m = a * ks * Math.exp(-beta * rdiff);
        // at this point, m is du/dr
        m /= r;
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

    // Coefficient data
    // Forces are in aJ per square angstrom (spring constants)
    /** Table of length term coefficients for different pairs of atom types. */
    private final static double[][] lengthCoeffs = {
        // first atom, second atom, ks, r0
        {C, Atom.SP3, C, Atom.SP3, 4.400, 1.523},
        {C, Atom.SP3, C, Atom.SP2, 4.400, 1.497},
        {C, Atom.SP3, C, Atom.SP, 5.200, 1.470},
        {C, Atom.SP3, H, Atom.NONE, 4.600, 1.113},
        {C, Atom.SP3, O, Atom.SP3, 5.360, 1.402},
        {C, Atom.SP3, N, Atom.SP3, 5.100, 1.438},
        {C, Atom.SP3, N, Atom.SP2, 3.520, 1.437},
        {C, Atom.SP3, N, Atom.SP3, 5.100, 1.499},
        {C, Atom.SP3, O, Atom.SP2, 5.360, 1.414},
        {C, Atom.SP2, C, Atom.SP2, 9.600, 1.337},
        {C, Atom.SP2, C, Atom.SP, 9.900, 1.313},
        {C, Atom.SP2, H, Atom.NONE, 4.600, 1.101},
        {C, Atom.SP2, O, Atom.SP3, 6.000, 1.355},
        {C, Atom.SP2, N, Atom.SP3, 6.320, 1.377},
        {C, Atom.SP2, N, Atom.SP2, 5.000, 1.410},
        {C, Atom.SP2, O, Atom.SP2, 10.000, 1.225},
        {C, Atom.SP, C, Atom.SP, 15.600, 1.212},
        {C, Atom.SP, H, Atom.NONE, 5.900, 1.090},
        {C, Atom.SP, N, Atom.SP, 17.730, 1.158},
        {O, Atom.SP3, O, Atom.SP3, 3.950, 1.428},
        {N, Atom.SP3, N, Atom.SP3, 5.600, 1.381},
        {N, Atom.SP3, H, Atom.NONE, 6.100, 1.045}
    };
}
