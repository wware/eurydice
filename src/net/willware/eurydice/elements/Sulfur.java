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
public class Sulfur extends AtomImpl {

    /**
     * Instantiates a new oxygen.
     */
    public Sulfur() {
        setHybridization(SP3);
    }

    /**
     * Instantiates a new oxygen.
     *
     * @param v the v
     */
    public Sulfur(Vector v) {
        setHybridization(SP3);
        setPosition(v);
    }

    /**
     * Instantiates a new oxygen.
     *
     * @param h the h
     */
    public Sulfur(int h) {
        setHybridization(h);
    }

    /**
     * Instantiates a new oxygen.
     *
     * @param h the h
     * @param v the v
     */
    public Sulfur(int h, Vector v) {
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
        case 2:
            setHybridization(SP3);
            break;
        case 1:
            setHybridization(SP2);
            break;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#covalentRadius()
     */
    public double covalentRadius() {
        return 1.05;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#name()
     */
    public String name() {
        return "Sulfur";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#symbol()
     */
    public String symbol() {
        return "S";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#atomicNumber()
     */
    public int atomicNumber() {
        return 16;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#mass()
     */
    public double mass() {
        return 32.065;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#color(net.willware.eurydice.view.DrawingEngine)
     */
    public Color color() {
        return Color.getColor("Red");
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwEnergy()
     */
    public double vdwEnergy() {
        return 0.536;   // TODO - correct value??
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwRadius()
     */
    public double vdwRadius() {
        return 1.8;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#correctNumBonds()
     */
    public int correctNumBonds() {
        return 2;
    }
}
