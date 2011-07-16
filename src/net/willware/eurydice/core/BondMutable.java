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
public interface BondMutable extends Bond {

    /**
     * Set the first of the two atoms.
     *
     * @return the first atom
     */
    void setFirstAtom(Atom a);

    /**
     * Set the second of the two atoms.
     *
     * @return the second atom
     */
    void setSecondAtom(Atom a);

    /**
     * Set the numerical order of this bond, for example 1 for a single bond, 2 for a
     * double bond, etc.
     */
    void setOrder(int o);
}
