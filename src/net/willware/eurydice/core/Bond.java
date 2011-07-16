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
public abstract class Bond {

    /**
     * Return the first of the two atoms.
     *
     * @return the first atom
     */
    public abstract Atom getFirstAtom();

    /**
     * Return the second of the two atoms.
     *
     * @return the second atom
     */
    public abstract Atom getSecondAtom();

    /**
     * Return the numerical order of this bond, for example 1 for a single bond, 2 for a
     * double bond, etc.
     *
     * @return the order of this bond as an integer
     */
    public abstract int getOrder();

    /**
     * Increment the order of this bond, if it's less than triple.
     */
    public abstract void incrOrder();

    /**
     * Does this bond contain the given atom?.
     *
     * @param atm1 the atom to be checked
     * @return true, if the atom is part of this bond
     */
    public abstract boolean contains(Atom atm1);

    /**
     * Given one of the atoms in this bond, return the other atom.
     *
     * @param atm1 the atom you know about
     * @return the atom you don't (or null if first atom isn't in this bond)
     */
    public abstract Atom otherAtom(Atom atm1);

    public interface Factory {
        public Bond newInstance();
    }
    private static class DefaultFactory implements Factory {
        public Bond newInstance() {
            return new BondMutableImpl();
        }
    }
    private static Factory factory = null;
    public static void setFactory(Factory f) {
        factory = f;
    }
    public static Bond newInstance() {
        if (factory == null)
            factory = new DefaultFactory();
        return factory.newInstance();
    }
}
