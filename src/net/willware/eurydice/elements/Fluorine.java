/**
 * Oxygen.java
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.elements;

import java.util.List;

import net.willware.eurydice.core.AtomImpl;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Color;
import net.willware.eurydice.math.Vector;

/**
 * The Class Oxygen.
 */
public class Fluorine extends AtomImpl {

    /**
     * Instantiates a new oxygen.
     */
    public Fluorine() {
        setHybridization(SP3);
    }

    /**
     * Instantiates a new oxygen.
     *
     * @param v the v
     */
    public Fluorine(Vector v) {
        setHybridization(SP3);
        setPosition(v);
    }

    /**
     * Instantiates a new oxygen.
     *
     * @param h the h
     */
    public Fluorine(int h) {
        setHybridization(h);
    }

    /**
     * Instantiates a new oxygen.
     *
     * @param h the h
     * @param v the v
     */
    public Fluorine(int h, Vector v) {
        setHybridization(h);
        setPosition(v);
    }

    /**
     * Rehybridize.
     *
     * @param hybrid the hybrid
     */
    public void rehybridize(int hybrid) {
        setHybridization(hybrid);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#rehybridize(java.util.List)
     */
    public void rehybridize(List<Bond> bonds) {
        BondInfo bi = this.getMyBonds(bonds);
        switch (bi.singles) {
        default:
        case 1:
            setHybridization(SP3);
            break;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#covalentRadius()
     */
    public double covalentRadius() {
        return 0.6;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#name()
     */
    public String name() {
        return "Fluorine";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#symbol()
     */
    public String symbol() {
        return "F";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#atomicNumber()
     */
    public int atomicNumber() {
        return 9;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#mass()
     */
    public double mass() {
        return 19.0;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#color(net.willware.eurydice.view.DrawingEngine)
     */
    public Color color() {
        return Color.getColor("Green");
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwEnergy()
     */
    public double vdwEnergy() {
        return 0.6;   // TODO what should this really be??
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwRadius()
     */
    public double vdwRadius() {
        return 1.47;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#correctNumBonds()
     */
    public int correctNumBonds() {
        return 1;
    }
}
