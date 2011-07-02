package net.willware.eurydice.forcefields.mm2;

import java.util.List;

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

    /**
     * Enumerate the list of energy terms required to compute internal forces on the atoms
     * of a structure, by studying how those atoms are bonded to one another.
     *
     * @param termList the list of energy terms under construction
     * @param struc the structure to which this applies
     */
    public void enumerate(List<Term> termList, Structure struc);
}
