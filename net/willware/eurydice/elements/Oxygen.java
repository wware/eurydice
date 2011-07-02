/**
 * Oxygen.java
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.elements;

import java.util.List;

import net.willware.eurydice.core.AtomImpl;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.drawing.DrawingEngine;
import net.willware.eurydice.drawing.DrawingEngine.Color;
import net.willware.eurydice.math.Vector;

public class Oxygen extends AtomImpl {
    public static String ename = "Oxygen";
    public static String symbol = "O";
    public static int atomicNumber = 8;
    public static double mass = 16.0;
    public static double vdwRadius = 1.4;
    public static int expectedNumBonds = 2;
    public Oxygen() {
        setHybridization(SP3);
    }
    public Oxygen(Vector v) {
        setHybridization(SP3);
        setPosition(v);
    }
    public Oxygen(int h) {
        setHybridization(h);
    }
    public Oxygen(int h, Vector v) {
        setHybridization(h);
        setPosition(v);
    }
    public void rehybridize(int hybrid) {
        setHybridization(hybrid);
    }
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
        return "Oxygen";
    }
    public String symbol() {
        return "O";
    }
    public int atomicNumber() {
        return 8;
    }
    public double mass() {
        return 16.0;
    }
    public Color color(DrawingEngine de) {
        return de.getColor("red");
    }
    public double vdwEnergy() {
        if (getHybridization() == SP3)
            return 0.406;
        else
            return 0.536;
    }
    public double vdwRadius() {
        return 1.4;
    }
    public int correctNumBonds() {
        return 2;
    }
}
