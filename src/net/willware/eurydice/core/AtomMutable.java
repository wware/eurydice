/**
 * Atom.java - definition of an atom, elements are subclasses of atom
 * Copyright (c) 1997,1998,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.core;

/**
 * Atoms are those little bitty things that all (baryonic) stuff is made out of.
 */
public interface AtomMutable extends Atom {
    void setUniqueId(UniqueId id);
    void setName(String name);
    void setSymbol(String symbol);
    void setAtomicNumber(int n);
    void setMass(double mass);
    void setColor(Color color);
    void setCovalentRadius(double r);
    void setVdwEnergy(double e);
    void setVdwRadius(double r);
    void setCorrectNumBonds(int n);
}
