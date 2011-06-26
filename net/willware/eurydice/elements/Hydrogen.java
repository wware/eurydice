/**
 * Hydrogen.java
 * Copyright (c) 1997 Will Ware, all rights reserved.
 */

package net.willware.eurydice.elements;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.drawing.DrawingEngine;
import net.willware.eurydice.drawing.DrawingEngine.Color;
import net.willware.eurydice.math.Vector;

public class Hydrogen extends Atom {
    public Hydrogen() {
        setHybridization(NONE);
    }
    public Hydrogen(Vector v) {
        setHybridization(NONE);
        setPosition(v);
    }
    public void rehybridize(int hybrid) {
    }
    public void rehybridize() {
    }
    public double covalentRadius() {
        return 0.3;
    }
    public String name() {
        return "Hydrogen";
    }
    public String symbol() {
        return "H";
    }
    public int atomicNumber() {
        return 1;
    }
    public double mass() {
        return 1.0;
    }
    public Color color(DrawingEngine de) {
        return de.getColor("white");
    }
    public double vdwEnergy() {
        return 0.382;
    }
    public double vdwRadius() {
        return 1.2;
    }
    public int correctNumBonds() {
        return 1;
    }
}
