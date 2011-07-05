/**
 * Oxygen.java
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
 * The Class Oxygen.
 */
public class Oxygen extends AtomImpl {

    /** The ename. */
    public static String ename = "Oxygen";

    /** The symbol. */
    public static String symbol = "O";

    /** The atomic number. */
    public static int atomicNumber = 8;

    /** The mass. */
    public static double mass = 16.0;

    /** The vdw radius. */
    public static double vdwRadius = 1.4;

    /** The expected num bonds. */
    public static int expectedNumBonds = 2;

    /**
     * Instantiates a new oxygen.
     */
    public Oxygen() {
        setHybridization(SP3);
    }

    /**
     * Instantiates a new oxygen.
     *
     * @param v the v
     */
    public Oxygen(Vector v) {
        setHybridization(SP3);
        setPosition(v);
    }

    /**
     * Instantiates a new oxygen.
     *
     * @param h the h
     */
    public Oxygen(int h) {
        setHybridization(h);
    }

    /**
     * Instantiates a new oxygen.
     *
     * @param h the h
     * @param v the v
     */
    public Oxygen(int h, Vector v) {
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
        return "Oxygen";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#symbol()
     */
    public String symbol() {
        return "O";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#atomicNumber()
     */
    public int atomicNumber() {
        return 8;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#mass()
     */
    public double mass() {
        return 16.0;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#color(net.willware.eurydice.view.DrawingEngine)
     */
    public Color color(DrawingEngine de) {
        return de.getColor("red");
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwEnergy()
     */
    public double vdwEnergy() {
        if (getHybridization() == SP3)
            return 0.406;
        else
            return 0.536;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#vdwRadius()
     */
    public double vdwRadius() {
        return 1.4;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.AtomImpl#correctNumBonds()
     */
    public int correctNumBonds() {
        return 2;
    }
}
