/**
 * Water.java
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.library;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.NanocadStyleStructure;
import net.willware.eurydice.elements.Oxygen;
import net.willware.eurydice.elements.Hydrogen;
import net.willware.eurydice.math.Vector;

public class Water extends NanocadStyleStructure {
    public Water() {
        addAtom(new Oxygen(Atom.SP3, new Vector(-2.3179271590246, -1.245842432839, -3.225993108704)));
        addAtom(new Oxygen(Atom.SP3, new Vector(2.3592808043861, 1.2883138211754, -4.0566716208121)));
        addAtom(new Oxygen(Atom.SP3, new Vector(3.4464918152871, -2.3984359834831, -1.3053134766819)));
        addAtom(new Oxygen(Atom.SP3, new Vector(0.92385048777157, -0.53954091389895, 3.7928522696704)));
        addAtom(new Oxygen(Atom.SP3, new Vector(-4.2677459289202, 1.9193549862933, 4.356427009362)));
        addAtom(new Hydrogen(new Vector(1.0789273562621, 1.3419090146687, -4.3584421728616)));
        addAtom(new Hydrogen(new Vector(3.245743080874, 2.2672242711381, -4.1464906605444)));
        addAtom(new Hydrogen(new Vector(2.3516554179415, -1.6877883462116, -1.414699257383)));
        addAtom(new Hydrogen(new Vector(4.584157024776, -2.0385189650844, -0.71848866494464)));
        addAtom(new Hydrogen(new Vector(2.2164881262824, -0.39165908867432, 3.6347739960268)));
        addAtom(new Hydrogen(new Vector(0.30142049535067, -1.4851276405958, 4.4894810725234)));
        addAtom(new Hydrogen(new Vector(-3.628563270266, -1.2525119524143, -3.2705210501593)));
        addAtom(new Hydrogen(new Vector(-1.5480820293511, -0.74756572413648, -2.264618871057)));
        addAtom(new Hydrogen(new Vector(-3.2418205250508, 2.7491808852943, 4.4662953756944)));
        addAtom(new Hydrogen(new Vector(-5.5038756963187, 2.2210080687682, 4.0214091598709)));
        addBond(4, 14);
        addBond(13, 4);
        addBond(0, 11);
        addBond(12, 0);
        addBond(3, 10);
        addBond(9, 3);
        addBond(2, 8);
        addBond(7, 2);
        addBond(1, 6);
        addBond(5, 1);
    }
}
