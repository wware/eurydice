/**
 * Atom.java - definition of an atom, elements are subclasses of atom
 * Copyright (c) 1997,1998,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.core;

/**
 * Atoms are those little bitty things that all (baryonic) stuff is made out of.
 */
public abstract class AtomMutable extends Atom {
    public abstract void setUniqueId(UniqueId id);
    public abstract void setName(String name);
    public abstract void setSymbol(String symbol);
    public abstract void setAtomicNumber(int n);
    public abstract void setMass(double mass);
    public abstract void setColor(Color color);
    public abstract void setCovalentRadius(double r);
    public abstract void setVdwEnergy(double e);
    public abstract void setVdwRadius(double r);
    public abstract void setCorrectNumBonds(int n);
}
