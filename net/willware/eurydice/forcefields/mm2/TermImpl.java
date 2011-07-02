/**
 * Term.java - MM2-style energy term, for computing interatomic forces
 * Copyright (c) 1997 Will Ware, all rights reserved.
 */

package net.willware.eurydice.forcefields.mm2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.BondImpl;
import net.willware.eurydice.core.Structure;

/**
 * A partial implementation of the Term interface. Specific energy terms complete the
 * implementation.
 */
public abstract class TermImpl implements Term {

    /** An array of atoms participating in this energy term. */
    Atom[] myAtoms;

    /**
     * Enumerate the list of energy terms required to compute internal forces on the atoms
     * of a structure, by studying how those atoms are bonded to one another.
     *
     * @param termList the list of energy terms under construction
     * @param struc the structure to which this applies
     */
    public void enumerate(List<Term> termList, Structure struc) {
        Iterator<Atom> iter = struc.getIterator();
        final int n = termLength() - 1;
        while (iter.hasNext()) {
            List<Atom> atomList = new ArrayList<Atom>();
            List<Bond> bondlist = struc.inferBonds();
            atomList.add(iter.next());
            nextBondChain(atomList, n, termList, struc, bondlist);
        }
    }

    /**
     * A recursive helper function for building chains of bonds.
     *
     * @param atomList a list of atoms of which {@link #myAtoms} are a subset
     * @param n the number of atoms we still need to grow the chain; initially equal to {@link #termLength()}
     * @param termList the term list that is being built as we create chains
     * @param struc the structure that all this applies to
     * @param bonds a bond list for the structure
     */
    private void nextBondChain(List<Atom> atomList, int n, List<Term> termList,
                               Structure struc, List<Bond> bonds) {
        int i;
        Atom a1, a2;
        if (n == 0) {
            buildTerm(atomList, termList, struc);
            return;
        }
        a1 = atomList.get(atomList.size() - 1);
        List<Bond> a1bonds = BondImpl.filterList(a1, bonds);
        for (i = 0; i < a1bonds.size(); i++) {
            a2 = a1bonds.get(i).otherAtom(a1);
            if (!atomList.contains(a2)) {
                atomList.add(a2);
                nextBondChain(atomList, n - 1, termList, struc, bonds);
                atomList.remove(a2);
            }
        }
    }

    /**
     * Term length is the number of atoms involved in this energy term.
     *
     * @return the number of atoms that participate in this kind of energy term
     */
    protected abstract int termLength();

    /**
     * Creates an instance of an energy term, and stores it in the list of terms being constructed.
     *
     * @param atomList a list of the atoms involved in an energy term
     * @param termList the list of energy terms under construction
     * @param struc the structure for which energy terms are being enumerated
     */
    protected abstract void buildTerm(List<Atom> atomList, List<Term> termList, Structure struc);

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
     * A helper function to assist {@link #toString}.
     *
     * @return the string
     */
    protected String toStringHelper() {
        return "";
    }
}
