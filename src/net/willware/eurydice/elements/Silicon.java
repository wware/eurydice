/**
 * Carbon.java
 * Copyright (c) 1997,1998,1999,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.elements;

import java.util.List;

import net.willware.eurydice.core.AtomImpl;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Color;
import net.willware.eurydice.math.Vector;

/**
 * In the great drama of life on Earth, carbon is one of the good guys.
 */
public class Silicon extends AtomImpl {

    /**
     * Constructor.
     */
    public Silicon() {
        setHybridization(SP3);
    }

    /**
     * Constructor with position vector argument.
     *
     * @param v the position vector
     */
    public Silicon(Vector v) {
        setHybridization(SP3);
        setPosition(v);
    }

    /**
     * Constructor with hybridization argument.
     *
     * @param h the hybridization argument
     * @see Atom#SP3
     * @see Atom#SP2
     * @see Atom#SP
     * @see Atom#NONE
     */
    public Silicon(int h) {
        setHybridization(h);
    }

    /**
     * Constructor with hybridization arg and position vector arg.
     *
     * @param h the hybridization type
     * @param v the position vector
     * @see Atom#SP3
     * @see Atom#SP2
     * @see Atom#SP
     * @see Atom#NONE
     */
    public Silicon(int h, Vector v) {
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
        return 1.11;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#name()
     */
    public String name() {
        return "Silicon";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#symbol()
     */
    public String symbol() {
        return "Si";
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#atomicNumber()
     */
    public int atomicNumber() {
        return 14;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#mass()
     */
    public double mass() {
        return 28.0855;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#color(net.willware.eurydice.view.DrawingEngine)
     */
    public Color color() {
        return Color.getColor("Gray60");
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#vdwEnergy()
     */
    public double vdwEnergy() {
        return 0.357;   // TODO - correct value??
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#vdwRadius()
     */
    public double vdwRadius() {
        return 2.1;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Atom#correctNumBonds()
     */
    public int correctNumBonds() {
        return 4;
    }
}
