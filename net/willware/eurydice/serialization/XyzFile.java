package net.willware.eurydice.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.NanocadStyleStructure;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.elements.Carbon;
import net.willware.eurydice.elements.Hydrogen;
import net.willware.eurydice.elements.Nitrogen;
import net.willware.eurydice.elements.Oxygen;
import net.willware.eurydice.math.Vector;

/**
 * XYZ is a popular file format for serializing molecules.
 */
public class XyzFile extends Filetype {

    /**
     * Prints a structure in XYZ format to standard output.
     *
     * @param s the structure to be printed
     */
    public static void print(Structure s) {
        try {
            System.out.println(new XyzFile().dumps(s));
        } catch (IOException ex) { }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.serialization.Filetype#dump(java.io.PrintStream, net.willware.eurydice.core.Structure)
     */
    public void dump(PrintStream ps, Structure struc) {
        int i;
        ps.print("" + struc.size() + "\n");
        ps.print("Icky sticky goo\n");
        for (i = 0; i < struc.size(); i++) {
            Atom a = struc.get(i);
            ps.print(a.symbol() + " " +
                     formatDouble(a.getPosition().getX(), 4, 3) +
                     formatDouble(a.getPosition().getY(), 4, 3) +
                     formatDouble(a.getPosition().getZ(), 4, 3) + "\n");
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.serialization.Filetype#load(java.io.InputStream)
     */
    public Structure load(InputStream ins) throws IOException {
        pbis = new PushbackInputStream(ins);
        NanocadStyleStructure struc = new NanocadStyleStructure();
        int numatoms = scanInt();
        String symbol;
        double x, y, z;
        bagLine();
        bagLine();
        while (numatoms-- > 0) {
            symbol = scanWord();
            x = scanDouble();
            y = scanDouble();
            z = scanDouble();
            if (symbol.equals("H"))
                struc.addAtom(new Hydrogen(), new Vector(x, y, z));
            else if (symbol.equals("C"))
                struc.addAtom(new Carbon(Atom.SP3), new Vector(x, y, z));
            else if (symbol.equals("O"))
                struc.addAtom(new Oxygen(Atom.SP3), new Vector(x, y, z));
            else if (symbol.equals("N"))
                struc.addAtom(new Nitrogen(Atom.SP3), new Vector(x, y, z));
        }
        struc.inferBonds();
        return struc;
    }
}
