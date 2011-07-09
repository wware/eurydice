/**
 * Hydrogen.java
 * Copyright (c) 1997 Will Ware, all rights reserved.
 */

package net.willware.eurydice.elements;

import net.willware.eurydice.core.AtomImpl;
import net.willware.eurydice.core.Color;
import net.willware.eurydice.math.Vector;

/**
 * The Class Hydrogen.
 */
public class Hydrogen extends AtomImpl {

    /**
     * Instantiates a new hydrogen.
     */
    public Hydrogen() {
        setHybridization(NONE);
    }

    /**
     * Instantiates a new hydrogen.
     *
     * @param v the v
     */
    public Hydrogen(Vector v) {
        setHybridization(NONE);
        setPosition(v);
    }

    /**
     * Rehybridize.
     *
     * @param hybrid the hybrid
     */
    public void rehybridize(int hybrid) {
    }

    /**
     * Rehybridize.
     */
    public void rehybridize() {
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#covalentRadius()
     */
    public double covalentRadius() {
        return 0.3;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#name()
     */
    public String name() {
        return "Hydrogen";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#symbol()
     */
    public String symbol() {
        return "H";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#atomicNumber()
     */
    public int atomicNumber() {
        return 1;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#mass()
     */
    public double mass() {
        return 1.0;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#color(net.willware.eurydice.view.DrawingEngine)
     */
    public Color color() {
        return Color.getColor("White");
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwEnergy()
     */
    public double vdwEnergy() {
        return 0.382;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwRadius()
     */
    public double vdwRadius() {
        return 1.2;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#correctNumBonds()
     */
    public int correctNumBonds() {
        return 1;
    }
}
