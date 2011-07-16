/**
 * Bond.java - definition of a bond
 * Copyright (c) 1998,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.core;

/**
 * Chemical bonds connect atoms. A bond can be covalent or ionic, and a covalent bond
 * can be single, double or triple, or in some cases it may be fractional, for instance
 * graphene has bonds of approximate order 1.5.
 */
public interface Bond {

    /**
     * Return the first of the two atoms.
     *
     * @return the first atom
     */
    public Atom getFirstAtom();

    /**
     * Return the second of the two atoms.
     *
     * @return the second atom
     */
    public Atom getSecondAtom();

    /**
     * Return the numerical order of this bond, for example 1 for a single bond, 2 for a
     * double bond, etc.
     *
     * @return the order of this bond as an integer
     */
    public int getOrder();

    /**
     * Increment the order of this bond, if it's less than triple.
     */
    public void incrOrder();

    /**
     * Does this bond contain the given atom?.
     *
     * @param atm1 the atom to be checked
     * @return true, if the atom is part of this bond
     */
    public boolean contains(Atom atm1);

    /**
     * Given one of the atoms in this bond, return the other atom.
     *
     * @param atm1 the atom you know about
     * @return the atom you don't (or null if first atom isn't in this bond)
     */
    public Atom otherAtom(Atom atm1);
}
