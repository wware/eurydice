/**
 * Carbon.java
 * Copyright (c) 1997,1998,1999,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.elements;

import java.util.List;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
//import net.willware.eurydice.basics.Vector;
import net.willware.eurydice.drawing.DrawingEngine;
import net.willware.eurydice.drawing.DrawingEngine.Color;
import net.willware.eurydice.math.Vector;

/**
 * In the great drama of life on Earth, carbon is one of the good guys.
 */
public class Carbon extends Atom {

    /**
     * Constructor.
     */
    public Carbon() {
        setHybridization(SP3);
    }

    /**
     * Constructor with position vector argument.
     *
     * @param v the position vector
     */
    public Carbon(Vector v) {
        setHybridization(SP3);
        setPosition(v);
    }

    /**
     * Constructor with hybridization argument.
     * @see Atom#SP3
     * @see Atom#SP2
     * @see Atom#SP
     * @see Atom#NONE
     *
     * @param h the hybridization argument
     */
    public Carbon(int h) {
        setHybridization(h);
    }

    /**
     * Constructor with hybridization arg and position vector arg.
     * @see Atom#SP3
     * @see Atom#SP2
     * @see Atom#SP
     * @see Atom#NONE
     *
     * @param h the hybridization type
     * @param v the position vector
     */
    public Carbon(int h, Vector v) {
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
     * @see net.willware.eurydice.core.Atom#rehybridize(java.util.List)
     */
    public void rehybridize(List<Bond> bonds) {
        BondInfo bi = this.getMyBonds(bonds);
        if (bi.triples != 0) {
            setHybridization(SP);
            return;
        }
        switch (bi.doubles) {
        case 0:
            setHybridization(SP3);
            break;
        case 1:
            setHybridization(SP2);
            break;
        default:
            setHybridization(SP);
            break;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#covalentRadius()
     */
    public double covalentRadius() {
        switch (getHybridization()) {
        default:
        case SP3:
            return 0.77;
        case SP2:
            return 0.67;
        case SP:
            return 0.6;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#name()
     */
    public String name() {
        return "Carbon";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#symbol()
     */
    public String symbol() {
        return "C";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#atomicNumber()
     */
    public int atomicNumber() {
        return 6;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#mass()
     */
    public double mass() {
        return 12.0;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#color(net.willware.eurydice.drawing.DrawingEngine)
     */
    public Color color(DrawingEngine de) {
        return de.getColor("gray");
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#vdwEnergy()
     */
    public double vdwEnergy() {
        return 0.357;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#vdwRadius()
     */
    public double vdwRadius() {
        return 1.85;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#correctNumBonds()
     */
    public int correctNumBonds() {
        return 4;
    }
}
