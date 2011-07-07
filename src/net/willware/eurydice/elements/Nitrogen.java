/**
 * Nitrogen.java
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.elements;

import java.util.List;

import net.willware.eurydice.core.AtomImpl;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.view.Color;
import net.willware.eurydice.view.DrawingEngine;

/**
 * The Class Nitrogen.
 */
public class Nitrogen extends AtomImpl {

    /**
     * Instantiates a new nitrogen.
     */
    public Nitrogen() {
        setHybridization(SP3);
    }

    /**
     * Instantiates a new nitrogen.
     *
     * @param v the v
     */
    public Nitrogen(Vector v) {
        setHybridization(SP3);
        setPosition(v);
    }

    /**
     * Instantiates a new nitrogen.
     *
     * @param h the h
     */
    public Nitrogen(int h) {
        setHybridization(h);
    }

    /**
     * Instantiates a new nitrogen.
     *
     * @param h the h
     * @param v the v
     */
    public Nitrogen(int h, Vector v) {
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
    public void rehybridize(List<Bond> bonds) {  // based on number of bonds
        BondInfo bi = this.getMyBonds(bonds);
        switch (bi.singles) {
        default:
        case 3:
            setHybridization(SP3);
            break;
        case 2:
            setHybridization(SP2);
            break;
        case 1:
            setHybridization(SP);
            break;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#covalentRadius()
     */
    public double covalentRadius() {
        switch (getHybridization()) {
        default:
        case SP3:
            return 0.74;
        case SP2:
            return 0.62;
        case SP:
            return 0.55;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#name()
     */
    public String name() {
        return "Nitrogen";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#symbol()
     */
    public String symbol() {
        return "N";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#atomicNumber()
     */
    public int atomicNumber() {
        return 7;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#mass()
     */
    public double mass() {
        return 14.0;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#color(net.willware.eurydice.view.DrawingEngine)
     */
    public Color color(DrawingEngine de) {
        return de.getColor("blue");
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwEnergy()
     */
    public double vdwEnergy() {
        return 0.447;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwRadius()
     */
    public double vdwRadius() {
        return 1.5;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#correctNumBonds()
     */
    public int correctNumBonds() {
        return 3;
    }
}
