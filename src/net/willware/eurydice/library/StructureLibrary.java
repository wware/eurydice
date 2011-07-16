package net.willware.eurydice.library;

import java.io.BufferedReader;
import java.io.FileReader;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.core.StructureMutable;
import net.willware.eurydice.elements.ElementFactory;
import net.willware.eurydice.math.Vector;

public abstract class StructureLibrary {

    private static ElementFactory factory = ElementFactory.getInstance();
    private static String preamble =
        "/home/wware/eurydice/src/net/willware/eurydice/library/structures/";
    public static void setPreamble(String s) {
        preamble = s;
    }

    private static String getTextFilename(String strucname) {
        return preamble + strucname + ".txt";
    }

    public static Structure get(String strucname) {
        StructureMutable s = (StructureMutable) Structure.newInstance();
        try {
            FileReader fr = new FileReader(getTextFilename(strucname));
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                String[] fields = line.split(":");
                String hybridization = fields[1].toLowerCase();
                Atom a = factory.get(fields[0]);
                if ("sp3".equals(hybridization))
                    a.setHybridization(Atom.SP3);
                else if ("sp2".equals(hybridization))
                    a.setHybridization(Atom.SP2);
                else if ("sp".equals(hybridization))
                    a.setHybridization(Atom.SP);
                else
                    a.setHybridization(Atom.NONE);
                a.setPosition(new Vector(Double.parseDouble(fields[2]),
                                         Double.parseDouble(fields[3]),
                                         Double.parseDouble(fields[4])));
                s.addAtom(a);
            }
        } catch (Exception e) {
            System.err.println(e);
            System.err.println(e.getMessage());
        }
        return s;
    }
}
