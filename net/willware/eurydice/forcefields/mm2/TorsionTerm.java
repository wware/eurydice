/**
 * TorsionTerm.java - MM2-style torsion energy term
 * Copyright (c) 1997,1998 Will Ware, all rights reserved.
 */

package net.willware.eurydice.forcefields.mm2;

import java.lang.Math;
import java.util.List;
import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.math.Vector;

/**
 * An energy term involving the torsion angle described by four atoms bonded in a linear chain.
 * Please see Section 3.3.2.c and Table 3.5 of <i>Nanosystems: Molecular Machinery, Manufacturing,
 * and Computation</i> by K. Eric Drexler, copyright 1992, published by John Wiley and Sons.
 */
public class TorsionTerm extends TermImpl {

    /** Something to do with potential energy which I've forgotten. */
    private double v1;
    /** Something to do with potential energy which I've forgotten. */
    private double v2;
    /** Something to do with potential energy which I've forgotten. */
    private double v3;

    /**
     * Constructor.
     *
     * @param a1 the first atom
     * @param a2 the second atom
     * @param a3 the third atom
     * @param a4 the fourth atom
     */
    public TorsionTerm(Atom a1, Atom a2, Atom a3, Atom a4) {
        int i;
        boolean found;
        myAtoms = new Atom[4];
        myAtoms[0] = a1;
        myAtoms[1] = a2;
        myAtoms[2] = a3;
        myAtoms[3] = a4;
        for (i = 0, found = false;
                i < torsionCoeffs.length && !found; i++)
            if ((a1.atomicNumber() == torsionCoeffs[i][0]
                    && a1.getHybridization() == torsionCoeffs[i][1]
                    && a2.atomicNumber() == torsionCoeffs[i][2]
                    && a2.getHybridization() == torsionCoeffs[i][3]
                    && a3.atomicNumber() == torsionCoeffs[i][4]
                    && a3.getHybridization() == torsionCoeffs[i][5]
                    && a4.atomicNumber() == torsionCoeffs[i][6]
                    && a4.getHybridization() == torsionCoeffs[i][7])
                    || (a1.atomicNumber() == torsionCoeffs[i][6]
                        && a1.getHybridization() == torsionCoeffs[i][7]
                        && a2.atomicNumber() == torsionCoeffs[i][4]
                        && a2.getHybridization() == torsionCoeffs[i][5]
                        && a3.atomicNumber() == torsionCoeffs[i][2]
                        && a3.getHybridization() == torsionCoeffs[i][3]
                        && a4.atomicNumber() == torsionCoeffs[i][0]
                        && a4.getHybridization() ==
                        torsionCoeffs[i][1])) {
                found = true;
                // convert table numbers from maJ to aJ (10^-18 joules)
                v1 = 0.001 * torsionCoeffs[i][8];
                v2 = 0.001 * torsionCoeffs[i][9];
                v3 = 0.001 * torsionCoeffs[i][10];
            }
        if (!found)
            v1 = v2 = v3 = 0.0;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.TermImpl#buildTerm(java.util.List, java.util.List, net.willware.eurydice.core.Structure)
     */
    protected void buildTerm(List<Atom> v, List<Term> termList, Structure struc) {
        TorsionTerm t = new TorsionTerm(v.get(0),
                                        v.get(1),
                                        v.get(2),
                                        v.get(3));
        if (v1 == 0.0 && v2 == 0.0 && v3 == 0.0)
            return;
        if (t.myAtoms[0].getPosition().getX() < t.myAtoms[3].getPosition().getX()) {
            termList.add(t);
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.TermImpl#termLength()
     */
    public int termLength() {
        return 4;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.TermImpl#toStringHelper()
     */
    protected String toStringHelper() {
        return " torsion " +
               (new Double(v1)).toString() + " " +
               (new Double(v2)).toString() + " " +
               (new Double(v3)).toString();
    }

    //private final static double PI = 3.14159265258979;
    // I found, much to my dismay, that I had been miscalculating torsion
    // forces for years! How embarassing. Now I've decided to just steal the
    // correct torsion code from the NAMD program and translate it from C++
    // to Java.
    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.mm2.Term#computeForces(net.willware.eurydice.core.Structure)
     */
    public void computeForces(Structure struc) {
        double rA, rB, rC;    //  Length of vectors A, B, and C
        double phi;    //  angle between the plans
        double cos_phi;    //  cos(phi)
        double sin_phi;    //  sin(phi)
        double delta;    //  Phase shift of the current dihedral
        double k;    //  Force constant of the current dihedral
        int n;        //  Periodicity
        //double K;    //  Calculated factor
        double K1;    //  Calculated factor
        //double diff;    //  Difference between phi and phi0
        int mult_num;    //  Current multiple we are calculating

        if (v1 == 0.0 && v2 == 0.0 && v3 == 0.0)
            return;

        Vector f1, f2, f3;    //  Forces 1 through 3

        // Calculate the vectors between atoms
        Vector r12 = myAtoms[0].getPosition().subtract(myAtoms[1].getPosition());
        Vector r23 = myAtoms[1].getPosition().subtract(myAtoms[2].getPosition());
        Vector r34 = myAtoms[2].getPosition().subtract(myAtoms[3].getPosition());

        //  Calculate the cross products
        Vector A = r12.crossProduct(r23);
        Vector B = r23.crossProduct(r34);
        Vector C = r23.crossProduct(A);
        rA = A.length();
        rB = B.length();
        rC = C.length();

        //  Calculate the sin and cos
        //  cos = A*B/(rA*rB)
        //  sin = C*B/(rC*rB)
        cos_phi = A.dotProduct(B) / (rA * rB);
        sin_phi = B.dotProduct(C) / (rB * rC);

        //  Normalize B
        rB = 1.0 / rB;
        B = B.scale(rB);

        //  Get phi, assign the sign based on the sine value

        //  Make sure that the cosine value is acceptable.  With roundoff, you
        //  can get values like 1.0+2e-16, which makes acos puke.  So instead,
        //  just set these kinds of values to exactly 1.0
        //                if (cos_phi>1.0)
        //                        cos_phi = 1.0;
        //                else if (cos_phi < -1.0)
        //                        cos_phi = -1.0;

        //                phi = acos(cos_phi);
        //                CHECK_DOMAIN();
        //                phi = -copysign(phi, sin_phi);

        // I think atan2 will do all the above stuff accurately
        // RKB
        phi = -Math.atan2(sin_phi, cos_phi);
        // CHECK_DOMAIN(); ??????

        Vector dcosdA = null;    //  Derivative d(cos(phi))/dA
        Vector dcosdB = null;    //  Derivative d(cos(phi))/dB
        Vector dsindC = null;    //  Derivative d(sin(phi))/dC
        Vector dsindB = null;    //  Derivative d(sin(phi))/dB
        // if (fabs(sin_phi) > 0.1)
        if (sin_phi > 0.1 || sin_phi < -0.1) {
            //  Normalize A
            rA = 1 / rA;
            A = A.scale(rA);
            dcosdA = B.subtract(A.scale(cos_phi)).scale(-rA);
            dcosdB = A.subtract(B.scale(cos_phi)).scale(-rB);
        } else {
            //  Normalize C
            rC = 1 / rC;
            C = C.scale(rC);
            dsindC = B.subtract(C.scale(sin_phi)).scale(-rC);
            dsindB = C.subtract(B.scale(cos_phi)).scale(-rB);
        }

        //  Loop through the multiple parameter sets for this
        //  bond.  We will only loop more than once if this
        //  has multiple parameter sets from Charmm22
        for (mult_num = 0; mult_num < 3; mult_num++) {
            switch (mult_num) {
            case 0:
                n = 1;
                k = v1;
                break;
            case 1:
                n = 2;
                k = -v2;
                break;
            default:
                n = 3;
                k = v3;
                break;
            }
            delta = 0;

            if (k != 0.0) {
                //  Calculate the energy
                //K = k * (1 + Math.cos(n * phi + delta));
                K1 = -n * k * Math.sin(n * phi + delta);

                //  Next, we want to calculate the forces.  In order
                //  to do that, we first need to figure out whether the
                //  sin or cos form will be more stable.  For this,
                //  just look at the value of phi
                // if (fabs(sin_phi) > 0.1)
                if (sin_phi > 0.1 || sin_phi < -0.1) {
                    //  use the sin version to avoid 1/cos terms
                    K1 = K1 / sin_phi;
                    f1 = r23.crossProduct(dcosdA).scale(K1);
                    f3 = r23.crossProduct(dcosdB).scale(K1);
                    f2 = f1.add(f3).negate();
                } else {
                    //  This angle is closer to 0 or 180 than it is to
                    //  90, so use the cos version to avoid 1/sin terms
                    K1 = -K1 / cos_phi;

                    f1 = new Vector(
                        K1 * ((r23.getY() * r23.getY() + r23.getZ() * r23.getZ()) * dsindC.getX() -
                              r23.getX() * r23.getY() * dsindC.getY() -
                              r23.getX() * r23.getZ() * dsindC.getZ()),
                        K1 * ((r23.getZ() * r23.getZ() + r23.getX() * r23.getX()) * dsindC.getY() -
                              r23.getY() * r23.getZ() * dsindC.getZ() -
                              r23.getY() * r23.getX() * dsindC.getX()),
                        K1 * ((r23.getX() * r23.getX() + r23.getY() * r23.getY()) * dsindC.getZ() -
                              r23.getZ() * r23.getX() * dsindC.getX() -
                              r23.getZ() * r23.getY() * dsindC.getY()));

                    f3 = dsindB.crossProduct(r23).scale(K1);

                    f2 = new Vector(
                        K1 * (-(r23.getY() * r12.getY() + r23.getZ() * r12.getZ()) * dsindC.getX() +
                              (2.0 * r23.getX() * r12.getY() - r12.getX() * r23.getY()) * dsindC.getY() +
                              (2.0 * r23.getX() * r12.getZ() - r12.getX() * r23.getZ()) * dsindC.getZ() +
                              dsindB.getZ() * r34.getY() - dsindB.getY() * r34.getZ()),
                        K1 * (-(r23.getZ() * r12.getZ() + r23.getX() * r12.getX()) * dsindC.getY() +
                              (2.0 * r23.getY() * r12.getZ() - r12.getY() * r23.getZ()) * dsindC.getZ() +
                              (2.0 * r23.getY() * r12.getX() - r12.getY() * r23.getX()) * dsindC.getX() +
                              dsindB.getX() * r34.getZ() - dsindB.getZ() * r34.getX()),
                        K1 * (-(r23.getX() * r12.getX() + r23.getY() * r12.getY()) * dsindC.getZ() +
                              (2.0 * r23.getZ() * r12.getX() - r12.getZ() * r23.getX()) * dsindC.getX() +
                              (2.0 * r23.getZ() * r12.getY() - r12.getZ() * r23.getY()) * dsindC.getY() +
                              dsindB.getY() * r34.getX() - dsindB.getX() * r34.getY()));
                }

                /**
                 * NOTE that these indices are INTS, not LONGS, reflecting the limited and
                 * half-baked tenor of Nanocad's MM2 implementation. It cannot scale to big
                 * structures where a 32-bit index would be insufficient.
                 */
                myAtoms[0].addForce(f1);
                myAtoms[1].addForce(f2.subtract(f1));
                myAtoms[2].addForce(f3.subtract(f2));
                myAtoms[3].addForce(f3.negate());
            }
        }
    }

    /** Table of torsion term coefficients. */
    private final static double[][] torsionCoeffs = {
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, 0.200, 0.270, 0.093
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, C, Atom.SP2, 0.170, 0.270, 0.093
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, C, Atom.SP, 0.200, -0.260, 0.093
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, H, Atom.NONE, 0.000, 0.000, 0.267
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, O, Atom.SP3, 0.100, 0.100, 0.180
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 0.100, 0.400, 0.500
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, N, Atom.SP2, 0.000, 0.000, 0.400
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 0.100, 0.400, 0.500
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP3, C, Atom.SP2, 2.100, 0.270, 0.093
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP3, C, Atom.SP, 0.000, 0.000, 0.093
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP3, H, Atom.NONE, 0.000, 0.000, 0.500
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP3, O, Atom.SP3, 0.000, 0.000, 0.180
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 0.000, 0.000, 0.180
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP3, N, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 0.000, 0.000, 0.180
        },
        {
            C, Atom.SP, C, Atom.SP3, C, Atom.SP3, C, Atom.SP, 1.000, 0.000, 0.093
        },
        {
            C, Atom.SP, C, Atom.SP3, C, Atom.SP3, H, Atom.NONE, 0.000, 0.000, 0.400
        },
        {
            C, Atom.SP, C, Atom.SP3, C, Atom.SP3, O, Atom.SP3, 0.000, -0.400, 0.180
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP3, H, Atom.NONE, 0.000, 0.000, 0.237
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP3, O, Atom.SP3, 0.000, 0.000, 0.180
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, -0.150, 0.000, 0.150
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP3, N, Atom.SP2, 0.000, 0.000, 0.400
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, -0.150, 0.000, 0.150
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP3, O, Atom.SP2, 0.000, 0.000, 0.180
        },
        {
            O, Atom.SP3, C, Atom.SP3, C, Atom.SP3, O, Atom.SP3, 0.000, -0.600, 0.300
        },
        {
            O, Atom.SP3, C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 0.000, 0.000, 0.000
        },
        {
            O, Atom.SP3, C, Atom.SP3, C, Atom.SP3, N, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            O, Atom.SP3, C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, 0.000, -0.600, 0.300
        },
        {
            N, Atom.SP3, C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, -0.400, -1.100, 1.200
        },
        {
            N, Atom.SP3, C, Atom.SP3, C, Atom.SP3, N, Atom.SP2, 1.170, -1.263, 2.064
        },
        {
            N, Atom.SP2, C, Atom.SP3, C, Atom.SP3, N, Atom.SP2, 0.000, 0.000, -0.500
        },
        {
            O, Atom.SP2, C, Atom.SP3, C, Atom.SP3, O, Atom.SP2, 0.000, -0.600, 0.300
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP2, C, Atom.SP3, 0.400, 0.030, 0.500
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, -0.440, 0.240, 0.060
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP2, C, Atom.SP, -0.440, 0.240, 0.060
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP2, H, Atom.NONE, 0.000, 0.000, 0.010
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP2, O, Atom.SP3, 0.000, 0.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP2, C, Atom.SP3, 0.000, 0.000, 0.300
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, 0.100, 0.000, 0.500
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP2, H, Atom.NONE, 0.000, 0.000, 0.600
        },
        {
            C, Atom.SP2, C, Atom.SP3, C, Atom.SP2, O, Atom.SP3, 0.000, 0.000, 0.000
        },
        {
            C, Atom.SP, C, Atom.SP3, C, Atom.SP2, C, Atom.SP3, 0.000, 0.000, 0.780
        },
        {
            C, Atom.SP, C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 0.100
        },
        {
            C, Atom.SP, C, Atom.SP3, C, Atom.SP2, H, Atom.NONE, 0.000, 0.000, 0.780
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP2, C, Atom.SP3, 0.000, 0.000, 0.540
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, 0.000, 0.000, -0.240
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP2, C, Atom.SP, 0.000, 0.000, -0.240
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP2, H, Atom.NONE, 0.000, 0.000, 0.520
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP2, O, Atom.SP3, 0.000, 0.000, 0.540
        },
        {
            O, Atom.SP3, C, Atom.SP3, C, Atom.SP2, C, Atom.SP3, 0.000, 0.000, 0.000
        },
        {
            O, Atom.SP3, C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            O, Atom.SP3, C, Atom.SP3, C, Atom.SP2, H, Atom.NONE, 0.000, 0.000, 0.000
        },
        {
            N, Atom.SP3, C, Atom.SP3, C, Atom.SP2, C, Atom.SP3, 0.000, 0.000, 0.000
        },
        {
            N, Atom.SP3, C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            N, Atom.SP3, C, Atom.SP3, C, Atom.SP2, H, Atom.NONE, 0.000, 0.000, 0.000
        },
        {
            N, Atom.SP3, C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            C, Atom.SP3, C, Atom.SP3, C, Atom.SP, C, Atom.SP, 0.000, 0.001, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP3, C, Atom.SP, C, Atom.SP, 0.000, 0.001, 0.000
        },
        {
            C, Atom.SP3, C, Atom.SP3, O, Atom.SP3, C, Atom.SP3, 0.400, 0.520, 0.467
        },
        {
            C, Atom.SP3, C, Atom.SP3, O, Atom.SP3, C, Atom.SP2, 0.000, 0.000, 0.400
        },
        {
            C, Atom.SP3, C, Atom.SP3, O, Atom.SP3, O, Atom.SP3, 0.000, 0.000, 0.400
        },
        {
            C, Atom.SP2, C, Atom.SP3, O, Atom.SP3, C, Atom.SP3, 0.000, 0.000, 0.403
        },
        {
            H, Atom.NONE, C, Atom.SP3, O, Atom.SP3, C, Atom.SP3, 0.000, 0.000, 0.530
        },
        {
            H, Atom.NONE, C, Atom.SP3, O, Atom.SP3, C, Atom.SP2, 0.000, 0.000, 0.530
        },
        {
            H, Atom.NONE, C, Atom.SP3, O, Atom.SP3, O, Atom.SP3, 0.000, 0.000, 0.465
        },
        {
            O, Atom.SP3, C, Atom.SP3, O, Atom.SP3, C, Atom.SP3, -0.170, -1.200, 0.000
        },
        {
            O, Atom.SP3, C, Atom.SP3, O, Atom.SP3, O, Atom.SP3, 0.000, 0.000, 0.403
        },
        {
            C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, -0.200, 0.730, 0.800
        },
        {
            C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, N, Atom.SP3, -0.200, 0.730, 0.800
        },
        {
            C, Atom.SP2, C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.000, 0.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP3, N, Atom.SP3, N, Atom.SP3, 0.000, 0.000, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.000, 0.000, 0.520
        },
        {
            H, Atom.NONE, C, Atom.SP3, N, Atom.SP3, C, Atom.SP2, 0.000, 0.000, 0.450
        },
        {
            H, Atom.NONE, C, Atom.SP3, N, Atom.SP3, N, Atom.SP3, 0.000, 0.000, 0.520
        },
        {
            N, Atom.SP3, C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.000, 0.000, 0.350
        },
        {
            N, Atom.SP3, C, Atom.SP3, N, Atom.SP3, N, Atom.SP3, 0.000, 0.000, 0.350
        },
        {
            N, Atom.SP3, C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.000, 0.000, 0.350
        },
        {
            C, Atom.SP3, C, Atom.SP3, N, Atom.SP2, C, Atom.SP3, 0.000, 0.000, 0.910
        },
        {
            C, Atom.SP3, C, Atom.SP3, N, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP3, N, Atom.SP2, C, Atom.SP3, 0.000, 0.000, -0.200
        },
        {
            H, Atom.NONE, C, Atom.SP3, N, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP3, N, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 0.650
        },
        {
            C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, -0.200, 0.730, 0.800
        },
        {
            C, Atom.SP3, C, Atom.SP3, N, Atom.SP3, H, Atom.NONE, 0.000, 0.120, 0.100
        },
        {
            C, Atom.SP2, C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.000, 0.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP3, N, Atom.SP3, H, Atom.NONE, 0.000, 0.000, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.000, 0.000, 0.520
        },
        {
            H, Atom.NONE, C, Atom.SP3, N, Atom.SP3, H, Atom.NONE, 0.000, 0.000, 0.250
        },
        {
            N, Atom.SP3, C, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.000, 0.000, 0.350
        },
        {
            C, Atom.SP3, C, Atom.SP3, O, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 0.400
        },
        {
            H, Atom.NONE, C, Atom.SP3, O, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 0.350
        },
        {
            C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, C, Atom.SP3, -0.100, 10.000, 0.000
        },
        {
            C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, -0.270, 10.000, 0.000
        },
        {
            C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, H, Atom.NONE, 0.000, 12.500, 0.000
        },
        {
            C, Atom.SP3, C, Atom.SP2, C, Atom.SP2, O, Atom.SP3, -1.200, 16.250, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, -0.930, 8.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, C, Atom.SP, 0.000, 15.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, H, Atom.NONE, 0.000, 9.000, -1.060
        },
        {
            C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, O, Atom.SP3, 0.000, 16.250, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, N, Atom.SP3, 0.000, 15.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, N, Atom.SP2, 0.000, 12.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, C, Atom.SP2, O, Atom.SP2, 0.000, 15.000, 0.000
        },
        {
            C, Atom.SP, C, Atom.SP2, C, Atom.SP2, H, Atom.NONE, 0.000, 15.000, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP2, C, Atom.SP2, H, Atom.NONE, 0.000, 15.000, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP2, C, Atom.SP2, O, Atom.SP3, 0.000, 16.250, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP2, C, Atom.SP2, N, Atom.SP3, 0.000, 15.000, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP2, C, Atom.SP2, N, Atom.SP2, 0.000, 12.000, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP2, C, Atom.SP2, O, Atom.SP2, 0.000, 15.000, 0.000
        },
        {
            O, Atom.SP3, C, Atom.SP2, C, Atom.SP2, O, Atom.SP3, -2.000, 16.250, 0.000
        },
        {
            O, Atom.SP2, C, Atom.SP2, C, Atom.SP2, O, Atom.SP2, -2.000, 15.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, C, Atom.SP, C, Atom.SP, 0.000, 0.001, 0.000
        },
        {
            C, Atom.SP3, C, Atom.SP2, O, Atom.SP3, C, Atom.SP3, 2.300, 4.000, 0.000
        },
        {
            C, Atom.SP3, C, Atom.SP2, O, Atom.SP3, C, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, O, Atom.SP3, C, Atom.SP3, 3.530, 2.300, -3.530
        },
        {
            C, Atom.SP2, C, Atom.SP2, O, Atom.SP3, C, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP2, O, Atom.SP3, C, Atom.SP3, 3.000, 3.100, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP2, O, Atom.SP3, C, Atom.SP2, 0.000, 0.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, N, Atom.SP3, C, Atom.SP3, -1.570, 3.200, 0.000
        },
        {
            H, Atom.NONE, C, Atom.SP2, N, Atom.SP3, C, Atom.SP3, 1.570, 1.690, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, N, Atom.SP2, C, Atom.SP3, 0.000, 2.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, N, Atom.SP2, C, Atom.SP2, 0.000, 0.000, 1.490
        },
        {
            N, Atom.SP2, C, Atom.SP2, N, Atom.SP2, C, Atom.SP3, 0.000, 0.000, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, O, Atom.SP2, C, Atom.SP3, 0.000, 9.200, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP2, O, Atom.SP2, C, Atom.SP2, 0.000, 8.300, -0.800
        },
        {
            H, Atom.NONE, C, Atom.SP2, O, Atom.SP2, C, Atom.SP3, -0.820, 9.200, 3.700
        },
        {
            H, Atom.NONE, C, Atom.SP2, O, Atom.SP2, C, Atom.SP2, -0.460, 2.700, 0.700
        },
        {
            C, Atom.SP3, C, Atom.SP, C, Atom.SP, C, Atom.SP2, 0.000, 0.001, 0.000
        },
        {
            C, Atom.SP3, C, Atom.SP, C, Atom.SP, C, Atom.SP, 0.000, 0.001, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP, C, Atom.SP, C, Atom.SP2, 0.000, 0.001, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP, C, Atom.SP, C, Atom.SP, 0.000, 0.001, 0.000
        },
        {
            C, Atom.SP2, C, Atom.SP, C, Atom.SP, H, Atom.NONE, 0.000, 0.001, 0.000
        },
        {
            C, Atom.SP, C, Atom.SP, C, Atom.SP, C, Atom.SP, 0.000, 0.001, 0.000
        },
        {
            C, Atom.SP3, O, Atom.SP3, O, Atom.SP3, C, Atom.SP3, 2.095, -2.155, -0.113
        },
        {
            C, Atom.SP3, N, Atom.SP3, N, Atom.SP3, C, Atom.SP3, 0.900, -6.800, 0.210
        },
    };
}
