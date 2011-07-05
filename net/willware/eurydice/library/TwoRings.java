/**
 * TwoRings.java
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.library;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.elements.Carbon;
import net.willware.eurydice.elements.Hydrogen;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.nanocad.NanocadStyleStructure;

/**
 * The Class TwoRings.
 */
public class TwoRings extends NanocadStyleStructure {

    /**
     * Instantiates a new two rings.
     */
    public TwoRings() {
        addAtom(new Carbon(Atom.SP3),
                new Vector(2.1445892122006, -1.2708629993337,
                           -1.6747665667467));
        addAtom(new
                Carbon(Atom.SP3), new Vector(0.60667770257047,
                                             -1.8833729265506, -1.0162669414044));
        addAtom(new
                Carbon(Atom.SP3), new Vector(-0.39214367493379,
                                             -0.49333718442082, -0.59928665504497));
        addAtom(new
                Hydrogen(), new Vector(2.8585942114205, -2.2571626609672,
                                       -2.0083092571337));
        addAtom(new
                Hydrogen(), new Vector(0.84927187954563, -2.5559174958512,
                                       0.024634921285566));
        addAtom(new
                Hydrogen(), new Vector(0.029936406054837, -2.540809098483,
                                       -1.9309193254346));
        addAtom(new
                Hydrogen(), new Vector(1.8942090976127, -0.47129533498539,
                                       -2.6192355745498));
        addAtom(new
                Hydrogen(), new Vector(-0.59469793112033, 0.1915662637029,
                                       -1.6110507630611));
        addAtom(new
                Carbon(Atom.SP3), new Vector(2.9775686160599,
                                             -0.38199157648467, -0.37845061136559));
        addAtom(new
                Carbon(Atom.SP3), new Vector(0.39338011064232,
                                             0.46332620464764, 0.64962683154327));
        addAtom(new
                Carbon(Atom.SP3), new Vector(1.9822472052201, 1.0148928662904,
                                             0.085087783408252));
        addAtom(new
                Hydrogen(), new Vector(4.0718770714489, 0.050889129433384,
                                       -0.84149926942414));
        addAtom(new
                Hydrogen(), new Vector(2.5620697486121, 1.5919211394139,
                                       1.0533234851411));
        addAtom(new
                Hydrogen(), new Vector(0.5335005640293, -0.19739537236352,
                                       1.6863116639397));
        addAtom(new
                Hydrogen(), new Vector(3.1062330897224, -1.1434466418592,
                                       0.61985241340774));
        addAtom(new
                Hydrogen(), new Vector(1.8235199286315, 1.7487975993067,
                                       -0.92959488446414));
        addAtom(new
                Carbon(Atom.SP3), new Vector(-1.9397122789795,
                                             -1.0731601139773, 0.045993404578277));
        addAtom(new
                Carbon(Atom.SP3), new Vector(-0.60295262758153,
                                             1.8879066430492, 0.96575239191884));
        addAtom(new
                Carbon(Atom.SP3), new Vector(-2.9730108685688,
                                             0.34074805977008, 0.35076676211071));
        addAtom(new
                Carbon(Atom.SP3), new Vector(-2.1896065097216, 1.3567266554995,
                                             1.5833118672817));
        addAtom(new
                Hydrogen(), new Vector(-2.0064735637112, 0.66621561021317,
                                       2.6231707076255));
        addAtom(new
                Hydrogen(), new Vector(-2.9054744619067, 2.3828242039181,
                                       1.761932567168));
        addAtom(new
                Hydrogen(), new Vector(-3.0794108513533, 1.0063640987831,
                                       -0.71701154336086));
        addAtom(new
                Hydrogen(), new Vector(-4.0746760493782, -0.066973312519202,
                                       0.81607863169224));
        addAtom(new
                Hydrogen(), new Vector(-1.7358671864621, -1.668323985338,
                                       1.1412783333111));
        addAtom(new
                Hydrogen(), new Vector(-2.5008625806638, -1.7893687360072,
                                       -0.83186852445932));
        addAtom(new
                Hydrogen(), new Vector(-0.048608068598665, 2.5783493762877,
                                       1.8680697685076));
        addAtom(new
                Hydrogen(), new Vector(-0.79017819079182, 2.5128895888254,
                                       -0.11693161647039));
        addBond(17, 27);
        addBond(17, 26);
        addBond(16, 25);
        addBond(16, 24);
        addBond(18, 22);
        addBond(23, 18);
        addBond(19, 21);
        addBond(20, 19);
        addBond(17, 9);
        addBond(17, 19);
        addBond(18, 19);
        addBond(16, 18);
        addBond(2, 16);
        addBond(10, 15);
        addBond(8, 14);
        addBond(13, 9);
        addBond(12, 10);
        addBond(11, 8);
        addBond(9, 2);
        addBond(10, 9);
        addBond(8, 10);
        addBond(0, 8);
        addBond(0, 6);
        addBond(1, 4);
        addBond(1, 5);
        addBond(2, 7);
        addBond(1, 2);
        addBond(0, 1);
        addBond(3, 0);
    }
}
