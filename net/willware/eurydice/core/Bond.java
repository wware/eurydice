/**
 * Bond.java - definition of a bond
 * Copyright (c) 1998,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.core;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Chemical bonds connect atoms. A bond can be covalent or ionic, and a covalent bond
 * can be single, double or triple, or in some cases it may be fractional, for instance
 * graphene has bonds of approximate order 1.5.
 */
public class Bond {
    private int order;

    /** One of the two atoms participating in this bond. */
    public Atom a1;
    /** One of the two atoms participating in this bond. */
    public Atom a2;

    /**
     * Constructor.
     *
     * @param atm1 one atom
     * @param atm2 another atom
     * @param bonds a list of bonds which will be used to rehybridize these atoms
     */
    public Bond(Atom atm1, Atom atm2, List<Bond> bonds) {
        a1 = atm1;
        a2 = atm2;
        order = 1;
        a1.rehybridize(bonds);
        a2.rehybridize(bonds);
    }

    /**
     * Order.
     *
     * @return the order of this bond as an integer
     */
    public int order() {
        return order;
    }

    /**
     * Increment the order of this bond, if it's less than triple.
     */
    public void incrOrder() {
        if (order < 3)
            order++;
        /* else throw an exception?? */
    }

    /**
     * Does this bond contain the given atom?.
     *
     * @param atm1 the atom to be checked
     * @return true, if the atom is part of this bond
     */
    public boolean contains(Atom atm1) {
        return (a1 == atm1 || a2 == atm1);
    }

    /**
     * Given one of the atoms in this bond, return the other atom.
     *
     * @param atm1 the atom you know about
     * @return the atom you don't (or null if first atom isn't in this bond)
     */
    public Atom otherAtom(Atom atm1) {
        if (atm1 == a1)
            return a2;
        if (atm1 == a2)
            return a1;
        return null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "<Bond " + a1.getId() + " " + a2.getId() + " " +
               (new Integer(order)).toString() + ">";
    }

    /**
     * Filter a list of bonds to include only those containing a particular atom.
     *
     * @param a the atom that should be included
     * @param bondlist the original list of bonds
     * @return the filtered list
     */
    public static List<Bond> filterList(Atom a, List<Bond> bondlist) {
        List<Bond> sublist = new ArrayList<Bond>();
        for (Bond b: bondlist) {
            if (b.a1 == a || b.a2 == a)
                sublist.add(b);
        }
        return sublist;
    }

    /**
     * Given a list of bonds, return true if any of them contain a particular atom.
     *
     * @param bondlist the list of bonds
     * @param a the atom to check
     * @return true, if any of the bonds include this atom
     */
    public static boolean touchesAtom(List<Bond> bondlist, Atom a) {
        for (Bond b: bondlist) {
            if (b.a1 == a || b.a2 == a)
                return true;
        }
        return false;
    }
}
