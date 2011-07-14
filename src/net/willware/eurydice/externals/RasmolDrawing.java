package net.willware.eurydice.externals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import net.willware.eurydice.core.Structure;
import net.willware.eurydice.forcefields.ForceField;
import net.willware.eurydice.serialization.PdbFile;
import net.willware.eurydice.view.DrawingEngine;

/**
 * A drawing engine that exports a file to RasMol, which does a lovely job.
 */
public class RasmolDrawing implements DrawingEngine {

    // keep those two files alive til we're done with them
    // avoid having the compiler optimize them into oblivion
    /** The molecule file. */
    private File moleculeFile = null;

    /** The script file. */
    private File scriptFile = null;

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.DrawingEngine#drawWithForces(net.willware.eurydice.core.Structure, net.willware.eurydice.forcefields.ForceField)
     */
    @Override
    public void drawWithForces(Structure s, ForceField ff) {
        draw(s);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.DrawingEngine#draw(net.willware.eurydice.core.Structure)
     */
    @Override
    public void draw(Structure s) {
        try {
            // store the file in a XYZ file
            moleculeFile = File.createTempFile("rasmol", ".pdb");
            String filename = moleculeFile.getAbsolutePath();
            OutputStream out = new FileOutputStream(moleculeFile);
            new PdbFile().dump(out, s);
            out.close();
            // a little script to make it space-filling
            scriptFile = File.createTempFile("rasmol", ".txt");
            String scriptname = scriptFile.getAbsolutePath();
            PrintStream out2 = new PrintStream(new FileOutputStream(scriptFile));
            out2.println("load " + filename);
            out2.println("spacefill on");
            out2.close();
            // call Rasmol
            String[] cmd = new String[] { "/usr/bin/rasmol", "-script", scriptname };
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.DrawingEngine#quickDraw(net.willware.eurydice.core.Structure)
     */
    @Override
    public void quickDraw(Structure s) {
        try {
            // store the file in a XYZ file
            moleculeFile = File.createTempFile("rasmol", ".pdb");
            String filename = moleculeFile.getAbsolutePath();
            OutputStream out = new FileOutputStream(moleculeFile);
            new PdbFile().dump(out, s);
            out.close();
            // call Rasmol
            String[] cmd = new String[] { "/usr/bin/rasmol", filename };
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
        }
    }

    /**
     * The main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //new RasmolDrawing().draw(null, new net.willware.eurydice.library.Aspirin());
        new RasmolDrawing().draw(new net.willware.eurydice.library.DiamondRod());
    }
}
