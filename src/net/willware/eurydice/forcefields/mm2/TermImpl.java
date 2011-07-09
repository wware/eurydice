/**
 * Term.java - MM2-style energy term, for computing interatomic forces
 * Copyright (c) 1997 Will Ware, all rights reserved.
 */

package net.willware.eurydice.forcefields.mm2;

import net.willware.eurydice.core.Atom;

/**
 * A partial implementation of the Term interface. Specific energy terms complete the
 * implementation.
 */
public abstract class TermImpl implements Term {

    /** An array of atoms participating in this energy term. */
    Atom[] myAtoms;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        int i;
        if (myAtoms == null)
            return "<Term ???>";
        String s = "<Term";
        for (i = 0; i < myAtoms.length; i++)
            s += " " + myAtoms[i].symbol();
        return s + toStringHelper() + ">";
    }

    /**
     * A helper function to assist {@link #toString}, to be extended by subclasses.
     *
     * @return the string
     */
    protected String toStringHelper() {
        return "";
    }
}
