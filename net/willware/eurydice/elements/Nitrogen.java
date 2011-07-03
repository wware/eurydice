/**
 * Nitrogen.java
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.elements;

import java.util.List;

import net.willware.eurydice.core.AtomImpl;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.drawing.DrawingEngine;
import net.willware.eurydice.drawing.Color;
import net.willware.eurydice.math.Vector;

public class Nitrogen extends AtomImpl {
    public Nitrogen() {
        setHybridization(SP3);
    }
    public Nitrogen(Vector v) {
        setHybridization(SP3);
        setPosition(v);
    }
    public Nitrogen(int h) {
        setHybridization(h);
    }
    public Nitrogen(int h, Vector v) {
        setHybridization(h);
        setPosition(v);
    }
    public void rehybridize(int hybrid) {
        setHybridization(hybrid);
    }
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
    public String name() {
        return "Nitrogen";
    }
    public String symbol() {
        return "N";
    }
    public int atomicNumber() {
        return 7;
    }
    public double mass() {
        return 14.0;
    }
    public Color color(DrawingEngine de) {
        return de.getColor("blue");
    }
    public double vdwEnergy() {
        return 0.447;
    }
    public double vdwRadius() {
        return 1.5;
    }
    public int correctNumBonds() {
        return 3;
    }
}
