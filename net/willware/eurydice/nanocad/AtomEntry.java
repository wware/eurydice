package net.willware.eurydice.nanocad;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.view.Entry;
import net.willware.eurydice.view.ScreenSpace;

/**
 * The Class AtomEntry.
 */
public class AtomEntry extends Entry {

    /** The screencoords. */
    private Vector screencoords;    // screen coordinates for atom

    /** The radius. */
    private double radius;    // radius in pixels for atom

    /** The atom. */
    private Atom atom;

    /** The engine. */
    private DrawingEngineImpl engine;
    //private boolean bogus;
    // empirical good-looking multiplier
    /*package*/ /** The Constant radiusRatio. */
    static final double radiusRatio = 0.6;

    /**
     * Instantiates a new atom entry.
     *
     * @param screenspace the screenspace
     * @param a the a
     * @param e the e
     * @param struc the struc
     */
    public AtomEntry(ScreenSpace screenspace, Atom a, DrawingEngineImpl e, Structure struc) {
        atom = a;
        engine = e;
        screencoords = screenspace.xyzToScreen(a.getPosition());
        radius = screenspace.getPerspective().apply(AtomEntry.radiusRatio * a.covalentRadius()
                 * screenspace.getZoomFactor(), screencoords.getZ());
        screencoords = screencoords.subtract(new Vector(radius, radius, 0.0));
        //bogus = a.currentNumBonds() != a.correctNumBonds();
    }

    // perspective preserves Z ordering
    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Entry#zvalue()
     */
    public double zvalue() {
        return screencoords.getZ();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Entry#quickpaint()
     */
    public void quickDraw() {
        engine.drawCircle(screencoords.getX(), screencoords.getY(), 2 * radius);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Entry#paint()
     */
    public void draw() {
        engine.setCurrentColor(atom.color(engine));
        engine.fillCircle(screencoords.getX(), screencoords.getY(), 2 * radius);
        //if (bogus)
        //    engine.setCurrentColor(engine.getColor("orange"));
        //else
        engine.setCurrentColor(engine.getColor("black"));
        engine.drawCircle(screencoords.getX(), screencoords.getY(), 2 * radius);
    }
}
