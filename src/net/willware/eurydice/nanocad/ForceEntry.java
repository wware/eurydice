package net.willware.eurydice.nanocad;

import net.willware.eurydice.core.Color;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.view.DisplayListEntry;
import net.willware.eurydice.view.ScreenSpace;

/**
 * The Class ForceEntry.
 */
public class ForceEntry extends DisplayListEntry {

    /** The f. */
    private Vector begin, end, orig, f;

    /** The arrow head size. */
    private double arrowHeadSize = 5;

    /** The ort. */
    private ScreenSpace ort;

    /** The force_color. */
    protected static Color force_color;

    /** The Constant sqrtHalf. */
    private static final double sqrtHalf = Math.sqrt(0.5);

    /** The engine. */
    private DrawingEngineImpl engine;

    /**
     * Instantiates a new force entry.
     *
     * @param o the o
     * @param origin the origin
     * @param f0 the f0
     * @param e the e
     */
    public ForceEntry(ScreenSpace o, Vector origin, Vector f0, DrawingEngineImpl e) {
        ort = o;
        orig = new Vector();
        f = new Vector();
        engine = e;
        begin = o.xyzToScreen(origin);
        f = f0.copy();
        orig = origin.copy();
        setForceMultiplier(10.0);
    }

    /**
     * Sets the force multiplier.
     *
     * @param fm the new force multiplier
     */
    public void setForceMultiplier(double fm) {
        end = ort.xyzToScreen(orig.add(f.scale(fm)));
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Entry#zvalue()
     */
    public double zvalue() {
        return (begin.getZ() + end.getZ()) / 2;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Entry#quickpaint()
     */
    public void quickDraw() {
        if (force_color == null)
            force_color = Color.getColor("green");
        BondEntry.drawBondLine(engine, force_color, ForceEntry.force_color, begin, end);
        // u is perpendicular to the force vector in screen space
        Vector u = new Vector(end.getY() - begin.getY(),
                              begin.getX() - end.getX(),
                              0.0);
        // v is parallel to the force vector in screen space
        Vector v = new Vector(end.getX() - begin.getX(),
                              end.getY() - begin.getY(),
                              0.0);
        double m = u.length();
        if (m > arrowHeadSize)
            m = ForceEntry.sqrtHalf * arrowHeadSize / m;
        else
            m = ForceEntry.sqrtHalf;
        u = u.scale(m);
        v = v.scale(m);
        engine.setCurrentColor(ForceEntry.force_color);
        engine.drawLine(end.getX(), end.getY(),
                        end.getX() + u.getX() - v.getX(),
                        end.getY() + u.getY() - v.getY());
        engine.drawLine(end.getX(), end.getY(),
                        end.getX() - u.getX() - v.getX(),
                        end.getY() - u.getY() - v.getY());
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Entry#paint()
     */
    public void draw() {
        /* dumb for now, smarten it up later */
        quickDraw();
    }
}
