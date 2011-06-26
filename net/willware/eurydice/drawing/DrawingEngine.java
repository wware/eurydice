package net.willware.eurydice.drawing;

import java.util.ArrayList;
import java.util.List;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Structure;

/**
 * An abstraction layer to make any drawing engine look like Java AWT,
 * which was the drawing engine used in the original applet.
 */
public abstract class DrawingEngine implements IDrawingEngine {

    /**
     * A wrapper for the drawing engine's native color definition.
     */
    public interface Color { }
    /**
     * Given a color name like "red" or "white" or "green", return a wrapper containing
     * the native representation for that color (for example "#FF0000" for HTML).
     * @param colorname the familiar name of the color
     * @return a Color wrapper with a native instance of that color
     */
    public abstract Color getColor(String colorname);
    /**
     * Set the current Color being used for drawing.
     * @param c the new Color value
     */
    public abstract void setCurrentColor(Color c);

    /**
     * Gets the current color.
     *
     * @return the current Color being used for drawing
     */
    public abstract Color getCurrentColor();
    /**
     * Draw a line from (x1, y1) to (x2, y2).
     * @param x1 in pixels
     * @param y1 in pixels
     * @param x2 in pixels
     * @param y2 in pixels
     */
    public abstract void drawLine(double x1, double y1, double x2, double y2);
    /**
     * Draw an unfilled circle with the center at (x, y) and with radius r.
     * @param x in pixels
     * @param y in pixels
     * @param r in pixels
     */
    public abstract void drawCircle(double x, double y, double r);
    /**
     * Fill the interior of a circle with the center at (x, y) and with radius r.
     * @param x in pixels
     * @param y in pixels
     * @param r in pixels
     */
    public abstract void fillCircle(double x, double y, double r);

    /**
     * This is like the {@link #quickDraw} method but it only draws atoms, no bonds.
     * @param struc a position list to be drawn
     */
    public void bubbleDraw(Orientation ort, Structure struc) {
        final long n = struc.size();
        for (long i = 0; i < n; i++)
            new Entry.AtomEntry(ort, struc.get(i), DrawingEngine.this, struc).quickDraw();
    }
    /**
     * When an object (together with many others) is being rotated or moved, drawing needs to be quick,
     * maybe a wireframe, or if even that's too much, maybe a partial wireframe or a bounding box.
     * @param struc a structure to be drawn
     */
    public void quickDraw(Orientation ort, final Structure struc) {
        for (Bond b: struc.inferBonds()) {
            new Entry.BondEntry(ort, b, this, struc).quickDraw();
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.drawing.IDrawingEngine#draw(net.willware.eurydice.core.Structure)
     */
    public void draw(Orientation ort, Structure struc) {
        draw(ort, struc, 0.0, false);
    }

    /**
     * When an object (together with many others) is done being rotated or moved, there is time to draw
     * it in some more beautiful way, so call the {@link Entry#draw} method instead of
     * {@link Entry#quickDraw}.
     *
     * @param struc the structure to be drawn
     * @param forceMultiplier a multiplier to scale force vectors (arbitrary, choose for esthetics)
     * @param showForces should we show force vectors when drawing a structure?
     */
    public void draw(final Orientation ort, final Structure struc,
                     final double forceMultiplier, final boolean showForces) {
        final List<Entry> dlist = new ArrayList<Entry>();
        final List<Bond> bondList = struc.inferBonds();
        if (showForces) {
            struc.getForceField().computeForces(struc);
        }
        struc.process(new Structure.AtomProcessor() {
            public void process(Atom a) {
                dlist.add(new Entry.AtomEntry(ort, a, DrawingEngine.this, struc));
            }
        });
        struc.process(new Structure.AtomProcessor() {
            public void process(final Atom a1) {
                for (Bond b: bondList) {
                    Atom a2 = b.otherAtom(a1);
                    if (a2 != null && a1.getPosition().getX() < a2.getPosition().getX()) {
                        dlist.add(new Entry.BondEntry(ort, b, DrawingEngine.this, struc));
                    }
                }
                if (showForces) {
                    Entry.ForceEntry dlf = new Entry.ForceEntry(ort, a1.getPosition(),
                            a1.getForce(), DrawingEngine.this);
                    dlf.setForceMultiplier(forceMultiplier);
                    dlist.add(dlf);
                }
            }
        });
        zsort(dlist, 0, dlist.size() - 1);
        for (Entry e : dlist)
            e.draw();
    }

    /**
     * The quicksort algorithm applied to the drawing list: we start drawing at the back of
     * the scene and work forward, so that things in front obstruct the view of things behind.
     * @param v a list of items to be sorted by Z coordinate
     * @param lo0 the lowest list index being sorted (see quicksort article at wikipedia)
     * @param hi0 the highest list index being sorted
     */
    private void zsort(List<Entry> v, int lo0, int hi0) {
        int lo = lo0;
        int hi = hi0;
        if (hi0 > lo0) {
            double mid = v.get((lo0 + hi0) / 2).zvalue();
            while (lo <= hi) {
                while (lo < hi0 && v.get(lo).zvalue() < mid)
                    ++lo;
                while (hi > lo0 && v.get(hi).zvalue() > mid)
                    --hi;
                if (lo <= hi) {
                    Entry temp = v.get(lo);
                    v.set(lo, v.get(hi));
                    v.set(hi, temp);
                    ++lo;
                    --hi;
                }
            }
            if (lo0 < hi)
                zsort(v, lo0, hi);
            if (lo < hi0)
                zsort(v, lo, hi0);
        }
    }
}
