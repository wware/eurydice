package net.willware.eurydice.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.elements.ElementFactory;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.nanocad.NanocadStyleStructure;

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
            ps.print(a.getSymbol() + " " +
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
            Atom a = ElementFactory.getInstance().get(symbol);
            a.setPosition(new Vector(x, y, z));
            struc.addAtom(a);
        }
        struc.inferBonds();
        return struc;
    }
}
