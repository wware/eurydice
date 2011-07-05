package net.willware.eurydice.nanocad;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.elements.Carbon;
import net.willware.eurydice.elements.Hydrogen;
import net.willware.eurydice.elements.Nitrogen;
import net.willware.eurydice.elements.Oxygen;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.serialization.Filetype;

/**
 * The NanoCAD native format was created to preserve the information used by the
 * 1997 NanoCAD Java applet. It is NOT in common usage and should probably not be
 * used for anything.
 */
public class NanocadNativeFormat extends Filetype {

    /* (non-Javadoc)
     * @see net.willware.eurydice.serialization.Filetype#dump(java.io.PrintStream, net.willware.eurydice.core.Structure)
     */
    public void dump(final PrintStream ps, Structure struc) {
        ps.print(struc.size() + "\n");
        int i;
        for (i = 0; i < struc.size(); i++) {
            ps.print(struc.get(i) + "\n");
        }
        List<Bond> bondlist = struc.inferBonds();
        for (i = 0; i < bondlist.size(); i++) {
            ps.print(bondlist.get(i) + "\n");
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.serialization.Filetype#load(java.io.InputStream)
     */
    public Structure load(InputStream ins) throws IOException {
        int numatoms, numbonds;
        NanocadStyleStructure struc = new NanocadStyleStructure();
        numatoms = scanInt();
        bagLine();
        while (numatoms-- > 0) {
            String zs, symbol, hybrid;
            double x, y, z;
            int h = Atom.SP3;
            if (nextChar() != '<') {
                continue;
            }
            read(1);
            symbol = scanWord();
            hybrid = scanWord();
            x = scanDouble();
            y = scanDouble();
            zs = scanWord();
            if (zs.charAt(zs.length() - 1) != '>')
                continue;
            try {
                z = (new Double(zs)).doubleValue();
            } catch (Exception e) {
                z = 0.0;
            }
            /* hybridizations */
            if (hybrid.equals("NONE"))
                h = Atom.NONE;
            else if (hybrid.equals("SP3"))
                h = Atom.SP3;
            else if (hybrid.equals("SP2"))
                h = Atom.SP2;
            else if (hybrid.equals("SP"))
                h = Atom.SP;
            /* which element */
            if (symbol.equals("H"))
                struc.addAtom(new Hydrogen(), new Vector(x, y, z));
            else if (symbol.equals("C"))
                struc.addAtom(new Carbon(h), new Vector(x, y, z));
            else if (symbol.equals("O"))
                struc.addAtom(new Oxygen(h), new Vector(x, y, z));
            else if (symbol.equals("N"))
                struc.addAtom(new Nitrogen(h), new Vector(x, y, z));
            bagLine();
        }

        numbonds = scanInt();
        bagLine();
        while (numbonds-- > 0) {
            String ordstr;
            int index1, index2, order;
            String bondq = read(6);
            if ("<Bond ".equals(bondq)) {
                unread(bondq);
                continue;
            }
            index1 = scanInt();
            index2 = scanInt();
            ordstr = scanWord();
            if (ordstr.charAt(ordstr.length() - 1) != '>')
                continue;
            ordstr = ordstr.substring(0, ordstr.length() - 1);
            try {
                order = (new Integer(ordstr)).intValue();
            } catch (Exception e) {
                order = 1;
            }
            struc.addBond(index1, index2, order);
            bagLine();
        }
        return struc;
    }
}
