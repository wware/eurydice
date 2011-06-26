/**
 * Propane.java
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.library;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.NanocadStyleStructure;
import net.willware.eurydice.elements.Carbon;
import net.willware.eurydice.elements.Hydrogen;
import net.willware.eurydice.math.Vector;

public class Propane extends NanocadStyleStructure {
    public Propane() {
        addAtom(new Carbon(Atom.SP3),
                new Vector(-0.85748833891984, 0.34794546061805,
                           0.98214417192606));
        addAtom(new
                Carbon(Atom.SP3), new Vector(0.4065315061009,
                                             -0.28637730259981, 0.32481170697201));
        addAtom(new
                Carbon(Atom.SP3), new Vector(0.53857043456917,
                                             -0.1123325081226, -1.2159381954418));
        addAtom(new
                Hydrogen(), new Vector(1.3229946018417, 0.041931101228472,
                                       0.86981518860896));
        addAtom(new
                Hydrogen(), new Vector(0.53148792074281, -1.3725391912445,
                                       0.54573546004739));
        addAtom(new
                Hydrogen(), new Vector(-0.80732381517125, 0.36113988946089,
                                       2.1001247594196));
        addAtom(new
                Hydrogen(), new Vector(-1.8541623309875, -0.1029264385221,
                                       0.78237823858956));
        addAtom(new
                Hydrogen(), new Vector(-1.0258178277451, 1.3652158493738,
                                       0.56894179293594));
        addAtom(new
                Hydrogen(), new Vector(-0.39545492653663, -0.38422555092091,
                                       -1.7565781981979));
        addAtom(new
                Hydrogen(), new Vector(0.7434912085366, 0.88851602455593,
                                       -1.6627706717391));
        addAtom(new
                Hydrogen(), new Vector(1.3971715675692, -0.74634733382723,
                                       -1.5386642531208));
        addBond(3, 1);
        addBond(1, 4);
        addBond(2, 10);
        addBond(2, 9);
        addBond(2, 8);
        addBond(1, 2);
        addBond(0, 1);
        addBond(0, 7);
        addBond(0, 6);
        addBond(5, 0);
        getMetadata().setProperty("lyrics.dead.grateful",
                                  "drivin.that.train.high.on.propane.casey.jones.you.better.watch.your.speed");
        getMetadata().setProperty("foo","bar");
    }
}