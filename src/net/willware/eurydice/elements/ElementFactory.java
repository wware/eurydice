package net.willware.eurydice.elements;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.AtomMutable;
import net.willware.eurydice.core.Color;
import net.willware.eurydice.core.UniqueId;

public class ElementFactory {

    private static ElementFactory instance;
    public static ElementFactory getInstance() {
        if (instance == null) {
            instance = new ElementFactory();
        }
        return instance;
    }

    private Atom makeAtom(String name, String symbol, int num, double mass,
                          String colorname, double cr, double vdwr, double vdwe, int bonds) {
        AtomMutable a = (AtomMutable) Atom.newInstance();
        a.setUniqueId(UniqueId.newInstance());
        a.setName(name);
        a.setSymbol(symbol);
        a.setMass(mass);
        a.setColor(Color.getColor(colorname));
        a.setCovalentRadius(cr);
        a.setVdwRadius(vdwr);
        a.setVdwEnergy(vdwe);
        a.setCorrectNumBonds(bonds);
        return a;
    }

    private static final double UNKNOWN = 0.4;  // vdw energy
    private static final String UNDECIDED = "Gray";

    public Atom get(String s) {
        s = s.toLowerCase();
        if ("h".equals(s) || "hydrogen".equals(s))
            return makeAtom("Hydrogen", "H", 1, 1.0, "White", 0.3, 1.2, 0.382, 1);
        else if ("li".equals(s) || "lithium".equals(s))
            return makeAtom("Lithium", "Li", 3, 6.941, "Gray50", 1.28, 1.82, UNKNOWN, 1);
        else if ("be".equals(s) || "beryllium".equals(s))
            return makeAtom("Beryllium", "Be", 4, 9.012, UNDECIDED, 1.96, 1.53, UNKNOWN, 4);
        else if ("b".equals(s) || "boron".equals(s))
            return makeAtom("Boron", "B", 5, 10.811, UNDECIDED, 0.84, 1.92, UNKNOWN, 4);
        else if ("c".equals(s) || "carbon".equals(s))
            // TODO: different covalent radii for different hybridizations: 77(sp3), 73(sp2), 69(sp) pm
            return makeAtom("Carbon", "C", 6, 12.01, "Gray30", 0.77, 1.7, 0.357, 4);
        else if ("n".equals(s) || "nitrogen".equals(s))
            return makeAtom("Nitrogen", "N", 7, 14.007, "Blue", 0.71, 1.55, 0.447, 4);
        else if ("o".equals(s) || "oxygen".equals(s))
            return makeAtom("Oxygen", "O", 8, 16.0, "Red", 0.66, 1.52, 0.406, 4);
        else if ("f".equals(s) || "fluorine".equals(s))
            return makeAtom("Fluorine", "F", 9, 19.0, "Green", 0.6, 1.47, 0.6, 4);
        else if ("na".equals(s) || "sodium".equals(s))
            return makeAtom("Sodium", "Na", 11, 22.99, UNDECIDED, 1.66, 2.27, UNKNOWN, 4);
        else if ("mg".equals(s) || "magnesium".equals(s))
            return makeAtom("Magnesium", "Mg", 12, 24.305, UNDECIDED, 1.41, 1.73, UNKNOWN, 4);
        else if ("al".equals(s) || "aluminum".equals(s))
            return makeAtom("Aluminum", "Al", 13, 26.98, UNDECIDED, 1.21, 1.84, UNKNOWN, 4);
        else if ("si".equals(s) || "silicon".equals(s))
            return makeAtom("Silicon", "Si", 14, 28.085, "Gray70", 1.11, 2.1, UNKNOWN, 4);
        else if ("p".equals(s) || "phosphorus".equals(s))
            return makeAtom("Phosphorus", "P", 15, 30.97, UNDECIDED, 1.07, 1.8, UNKNOWN, 4);
        else if ("s".equals(s) || "sulfur".equals(s))
            return makeAtom("Sulfur", "S", 16, 32.065, "Yellow", 1.05, 1.8, UNKNOWN, 4);
        else if ("Cl".equals(s) || "chlorine".equals(s))
            return makeAtom("Chlorine", "Cl", 17, 35.45, UNDECIDED, 1.02, 1.75, UNKNOWN, 4);
        return null;
    }
}
