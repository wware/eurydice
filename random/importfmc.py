# Do most of the work of translating the fine motion controller's PDB file to
# the format used in net.willware.eurydice.library. Often PDB files elide
# hydrogens, and categorize other elements into incomprehensible categories
# (it's not just a carbon or even an sp3 carbon, it's a *carbonyl* carbon).
# Luckily this isn't the case with the FMC PDB, which spells out plain old
# chemical symbols, and provides the bond list that can be used to infer
# hybridization.
#
# Elements used: C, F, H, N, O, S, SI

import string

lines = open('fineMotion970116.pdb').readlines()

class Atom:
    pass

atoms = [ ]
numbonds = { }

for L in lines:
    if L.startswith('HETATM'):
        fields = L.split()
        sym, x, y, z = [fields[2]] + map(string.atof, fields[4:7])
        #print sym, x, y, z
        if sym == "SI":
            sym = "Si"
        a = Atom()
        a.symbol = sym
        a.x = x
        a.y = y
        a.z = z
        atoms.append(a)

hybridizations = {
    ('C', 4): 'SP3',
    ('C', 3): 'SP2',
    ('C', 2): 'SP',
    ('F', 1): 'SP3',
    ('H', 1): 'NONE',
    ('N', 3): 'SP3',
    ('N', 2): 'SP2',
    ('O', 2): 'SP3',
    ('S', 2): 'SP3',
    ('Si', 4): 'SP3',
    ('Si', 3): 'SP2',
    ('Si', 2): 'SP',
    }

i = 0
for L in lines:
    if L.startswith('CONECT'):
        n = int(L[7:11])
        others = map(string.atoi, L[11:].split())
        numbonds = len(others)
        sym = atoms[i].symbol
        atoms[i].others = others
        atoms[i].hyb = hybridizations[(sym, numbonds)]
        i += 1

print """/**
 * FineMotionController.java
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.library;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.elements.Carbon;
import net.willware.eurydice.elements.Hydrogen;
import net.willware.eurydice.elements.Oxygen;
import net.willware.eurydice.elements.Nitrogen;
import net.willware.eurydice.elements.Fluorine;
import net.willware.eurydice.elements.Sulfur;
import net.willware.eurydice.elements.Silicon;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.nanocad.NanocadStyleStructure;

/**
 * Eric Drexler's fine motion controller design.
 */
public class FineMotionController extends NanocadStyleStructure {

    /**
     * Constructor
     */
    public FineMotionController() {"""

fmt = """        addAtom(new %s(Atom.%s),
                new Vector(%f, %f, %f));"""

fmt_h = """        addAtom(new Hydrogen(),
                new Vector(%f, %f, %f));"""

for a in atoms:
    if a.symbol == 'H':
        print fmt_h % (a.x, a.y, a.z)
    else:
        ename = {'C': 'Carbon',
                 'F': 'Fluorine',
                 'N': 'Nitrogen',
                 'O': 'Oxygen',
                 'S': 'Sulfur',
                 'Si': 'Silicon'
                 }[a.symbol]
        print fmt % (ename, a.hyb, a.x, a.y, a.z)

for i in range(len(atoms)):
    a = atoms[i]
    for other in a.others:
        if other > i:
            print '        addBond(%d, %d);' % (i, other)

print """    }
}
"""
