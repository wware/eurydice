package net.willware.eurydice.serialization;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Structure;

/**
 * Serialization for the standard PDB file format.
 */
public class PdbFile extends Filetype {

    /*
     * When I _do_ get around to implementing the load method, I can pull in things like this:
     * http://www.pdb.org/pdb/download/downloadFile.do?fileFormat=pdb&compression=NO&structureId=2X72
     * which is (I think) a rhodopsin molecule.
     */

    /**
     * NOTE THAT THIS METHOD IS NOT YET IMPLEMENTED!.
     *
     * @param ins an InputStream from which a serialization is obtained
     * @return the de-serialized structure
     */
    public Structure load(InputStream ins) {
        throw new RuntimeException("not implemented yet");
    }

    /**
     * Serialize the group to the standard PDB file format.
     *
     * @param ps the PrintStream to which this structure should be serialized
     * @param struc the structure to be serialized
     */
    public void dump(PrintStream ps, Structure struc) {
        int i;
        ps.print("REMARK Icky sticky goo\n");
        for (i = 0; i < struc.size(); i++) {
            Atom a = struc.get(i);
            ps.print("ATOM  " +
                     formatInt(i + 1, 5, RIGHT) +
                     "  " +
                     formatString(a.getSymbol(), 4, LEFT) +
                     "UNK     1    " +
                     formatDouble(struc.get(i).getPosition().getX(), 4, 3) +
                     formatDouble(struc.get(i).getPosition().getY(), 4, 3) +
                     formatDouble(struc.get(i).getPosition().getZ(), 4, 3) +
                     "  1.00  0.00 \n");
        }
        List<Bond> bondList = struc.inferBonds();
        for (i = 0; i < bondList.size(); i++) {
            try {
                Bond b = bondList.get(i);
                int i1 = b.getFirstAtom().getUniqueId().toInteger();
                int i2 = b.getFirstAtom().getUniqueId().toInteger();
                ps.print("CONECT");
                ps.print(formatInt(i1 + 1, 5, RIGHT));
                ps.print(formatInt(i2 + 1, 5, RIGHT));
                ps.print("\n");
            } catch (Exception e) {
                // TODO do something intelligent here
            }
        }
        ps.print("END\n");
    }
}
