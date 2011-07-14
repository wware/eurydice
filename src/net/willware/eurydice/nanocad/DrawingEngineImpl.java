package net.willware.eurydice.nanocad;

import java.util.ArrayList;
import java.util.List;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Color;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.forcefields.ForceField;
import net.willware.eurydice.view.DisplayListEntry;
import net.willware.eurydice.view.DrawingEngine;
import net.willware.eurydice.view.ScreenSpace;

/**
 * An abstraction layer to make any drawing engine look like Java AWT,
 * which was the drawing engine used in the original applet.
 */
public abstract class DrawingEngineImpl implements DrawingEngine {

    /** The screenspace. */
    private ScreenSpace screenspace;
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
    public void bubbleDraw(Structure struc) {
        final int n = struc.size();
        for (int i = 0; i < n; i++)
            new AtomEntry(screenspace, struc.get(i), DrawingEngineImpl.this, struc).quickDraw();
    }
    /**
     * When an object (together with many others) is being rotated or moved, drawing needs to be quick,
     * maybe a wireframe, or if even that's too much, maybe a partial wireframe or a bounding box.
     * @param struc a structure to be drawn
     */
    public void quickDraw(Structure struc) {
        for (Bond b: struc.inferBonds()) {
            new BondEntry(screenspace, b, this, struc).quickDraw();
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.IDrawingEngine#draw(net.willware.eurydice.core.Structure)
     */
    public void draw(Structure struc) {
        draw(screenspace, struc, 0.0, null);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.IDrawingEngine#draw(net.willware.eurydice.core.Structure)
     */
    public void drawWithForces(Structure struc, ForceField ff) {
        draw(screenspace, struc, 1.0, ff);
    }

    /**
     * When an object (together with many others) is done being rotated or moved, there is time to draw
     * it in some more beautiful way, so call the {@link DisplayListEntry#draw} method instead of.
     *
     * @param screenspace the screenspace
     * @param struc the structure to be drawn
     * @param forceMultiplier a multiplier to scale force vectors (arbitrary, choose for esthetics)
     * @param ff the ff
     * {@link DisplayListEntry#quickDraw}.
     */
    private void draw(final ScreenSpace screenspace, final Structure struc,
                      final double forceMultiplier, final ForceField ff) {
        final List<DisplayListEntry> dlist = new ArrayList<DisplayListEntry>();
        final List<Bond> bondList = struc.inferBonds();
        if (ff != null) {
            ff.computeForces();
        }
        struc.process(new Structure.AtomProcessor() {
            public void process(Atom a) {
                dlist.add(new AtomEntry(screenspace, a, DrawingEngineImpl.this, struc));
            }
        });
        struc.process(new Structure.AtomProcessor() {
            public void process(final Atom a1) {
                for (Bond b: bondList) {
                    Atom a2 = b.otherAtom(a1);
                    if (a2 != null && a1.getPosition().getX() < a2.getPosition().getX()) {
                        dlist.add(new BondEntry(screenspace, b, DrawingEngineImpl.this, struc));
                    }
                }
                if (ff != null) {
                    ForceEntry dlf = new ForceEntry(screenspace, a1.getPosition(),
                                                    a1.getForce(), DrawingEngineImpl.this);
                    dlf.setForceMultiplier(forceMultiplier);
                    dlist.add(dlf);
                }
            }
        });
        // A List was needed previously because the size was unknown. Now that it's known we
        // move to an array.
        int n = dlist.size();
        DisplayListEntry[] dlst = new DisplayListEntry[n];
        for (int i = 0; i < n; i++)
            dlst[i] = dlist.get(i);
        DisplayListEntry.zsort(dlst);
        for (DisplayListEntry e : dlst)
            e.draw();
    }

    /**
     * Sets the screen space.
     *
     * @param ss the new screen space
     */
    public void setScreenSpace(ScreenSpace ss) {
        this.screenspace = ss;
    }

    /**
     * Gets the screen space.
     *
     * @return the screen space
     */
    public ScreenSpace getScreenSpace() {
        return screenspace;
    }
}
