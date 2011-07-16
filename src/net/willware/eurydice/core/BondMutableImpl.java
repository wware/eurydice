/**
 * Bond.java - definition of a bond
 * Copyright (c) 1998,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.core;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class BondImpl.
 */
public class BondMutableImpl extends BondMutable {

    /** The order. */
    private int order = 1;

    /** One of the two atoms participating in this bond. */
    private Atom a1;
    /** One of the two atoms participating in this bond. */
    private Atom a2;

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Bond#getFirstAtom()
     */
    public Atom getFirstAtom() {
        return a1;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Bond#getSecondAtom()
     */
    public Atom getSecondAtom() {
        return a2;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Bond#order()
     */
    public int getOrder() {
        return order;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Bond#incrOrder()
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
        return "<Bond " + a1 + " " + a2 + " " + order + ">";
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
            if (b.getFirstAtom() == a || b.getSecondAtom() == a)
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
            if (b.getFirstAtom() == a || b.getSecondAtom() == a)
                return true;
        }
        return false;
    }

    @Override
    public void setFirstAtom(Atom a) {
        a1 = a;
    }

    @Override
    public void setOrder(int o) {
        order = o;
    }

    @Override
    public void setSecondAtom(Atom a) {
        a2 = a;
    }
}
