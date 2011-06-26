package net.willware.eurydice.drawing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import net.willware.eurydice.core.Structure;
import net.willware.eurydice.serialization.PdbFile;

/**
 * A drawing engine that exports a file to RasMol, which does a lovely job.
 */
public class RasmolDrawing implements IDrawingEngine {

    // keep those two files alive til we're done with them
    // avoid having the compiler optimize them into oblivion
    private File moleculeFile = null;
    private File scriptFile = null;

    /* (non-Javadoc)
     * @see net.willware.eurydice.drawing.IDrawingEngine#draw(net.willware.eurydice.drawing.Orientation, net.willware.eurydice.core.Structure)
     */
    @Override
    public void draw(Orientation o, Structure s) {
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
     * @see net.willware.eurydice.drawing.IDrawingEngine#quickDraw(net.willware.eurydice.drawing.Orientation, net.willware.eurydice.core.Structure)
     */
    @Override
    public void quickDraw(Orientation o, Structure s) {
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
        new RasmolDrawing().draw(null, new net.willware.eurydice.library.DiamondRod());
    }
}
