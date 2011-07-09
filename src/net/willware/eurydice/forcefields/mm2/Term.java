package net.willware.eurydice.forcefields.mm2;

import net.willware.eurydice.core.Structure;

/**
 * MM2 uses energy terms for lengths, angles, torsions, and long-range forces.
 */
public interface Term {

    /** The atomic number of hydrogen. */
    public static final int H = 1;

    /** The atomic number of carbon. */
    public static final int C = 6;

    /** The atomic number of nitrogen. */
    public static final int N = 7;

    /** The atomic number of oxygen. */
    public static final int O = 8;

    /**
     * Compute the internal forces acting upon the atoms in a structure.
     *
     * @param struc the structure containing the atoms
     */
    public void computeForces(Structure struc);
}
