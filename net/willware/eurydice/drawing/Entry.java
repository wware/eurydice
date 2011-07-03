/**
 * Entry.java - entry in a drawing list
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.drawing;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.drawing.Color;
import net.willware.eurydice.math.Vector;

/**
 * An entry in a display list, for drawing purposes.
 */
public abstract class Entry {
    protected DrawingEngineImpl engine;
    // empirical good-looking multiplier
    protected static final double radiusRatio = 0.6;
    private static Color force_color;
    private final static double sqrtHalf = Math.sqrt(0.5);

    /**
     * Zvalue.
     *
     * @return the double
     */
    public abstract double zvalue();

    /**
     * When an object (together with many others) is being rotated or moved, drawing needs to be quick,
     * maybe a wireframe, or if even that's too much, maybe a partial wireframe or a bounding box.
     */
    public abstract void quickDraw();

    /**
     * When an object (together with many others) is done being rotated or moved, there is time to draw
     * it in some more beautiful way.
     */
    public abstract void draw();

    /**
     * Draw line to atom.
     *
     * @param a the a
     * @param x the x
     * @param y the y
     * @param struc the struc
    public void drawLineToAtom(Atom a, double x, double y, Structure struc) {
        Vector scr = engine.xyzToScreen(a.getPosition());
        engine.setCurrentColor(engine.getColor("black"));
        engine.drawLine(scr.getX(), scr.getY(), x, y);
    }
     */

    protected void drawBondLine(Color c1, Color c2,
                                Vector v1, Vector v2) {
        Color oldcolor = engine.getCurrentColor();
        Vector vmid = v1.add(v2).scale(0.5);
        engine.setCurrentColor(c1);
        engine.drawLine(v1.getX(), v1.getY(), vmid.getX(), vmid.getY());
        engine.setCurrentColor(c2);
        engine.drawLine(vmid.getX(), vmid.getY(), v2.getX(), v2.getY());
        engine.setCurrentColor(oldcolor);
    }

    /**
     * The Class AtomEntry.
     */
    public static class AtomEntry extends Entry {
        private Vector screencoords;    // screen coordinates for atom
        private double radius;    // radius in pixels for atom
        private Atom atom;
        //private boolean bogus;

        /**
         * Instantiates a new atom entry.
         *
         * @param a the a
         * @param e the e
         * @param struc the struc
         */
        public AtomEntry(Orientation o, Atom a, DrawingEngineImpl e, Structure struc) {
            atom = a;
            engine = e;
            screencoords = o.xyzToScreen(a.getPosition());
            radius = radiusRatio * a.covalentRadius() * o.getZoomFactor()
                     * o.perspectiveFactor(screencoords.getZ());
            screencoords = screencoords.subtract(new Vector(radius, radius, 0.0));
            //bogus = a.currentNumBonds() != a.correctNumBonds();
        }

        // perspective preserves Z ordering
        /* (non-Javadoc)
         * @see net.willware.eurydice.drawing.Entry#zvalue()
         */
        public double zvalue() {
            return screencoords.getZ();
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.drawing.Entry#quickpaint()
         */
        public void quickDraw() {
            engine.drawCircle(screencoords.getX(), screencoords.getY(), 2 * radius);
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.drawing.Entry#paint()
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

    /**
     * The Class BondEntry.
     */
    public static class BondEntry extends Entry {
        private Vector x1, x2;      // screen coordinates for each atom
        private double r1, r2;      // radius in pixels for each atom
        // x3 is a vector that is perpendicular on screen to the direction of
        // the bond, used to space out multiple bonds, so we can have two parallel
        // lines for a double bond, three for a triple bond
        private Vector perpendicularGap;
        private Bond myBond;
        // gap between lines in double and triple bonds, in angstroms
        private static final double gap = 0.2;

        /**
         * Instantiates a new bond entry.
         *
         * @param b the b
         * @param e the e
         * @param struc the struc
         */
        public BondEntry(Orientation o, Bond b, DrawingEngineImpl e, Structure struc) {
            myBond = b;
            engine = e;

            Vector pos1 = myBond.getFirstAtom().getPosition();
            x1 = o.xyzToScreen(pos1);
            r1 = radiusRatio * myBond.getFirstAtom().covalentRadius() * o.getZoomFactor();
            r1 *= o.perspectiveFactor(x1.getZ());

            x2 = o.xyzToScreen(myBond.getSecondAtom().getPosition());
            r2 = radiusRatio * myBond.getSecondAtom().covalentRadius() * o.getZoomFactor();
            r2 *= o.perspectiveFactor(x2.getZ());

            // compute a perpendicular vector in screen space
            Vector perpendicular = new Vector(x1.getY() - x2.getY(),
                                              x2.getX() - x1.getX(),
                                              0.0);
            // move it to atom space
            perpendicularGap = o.screenToXyz(perpendicular);
            // adjust the length
            perpendicularGap = perpendicularGap.scale(gap / perpendicularGap.length());
            // move it back to screen space
            perpendicularGap = o.xyzToScreen(perpendicularGap);
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.drawing.Entry#zvalue()
         */
        public double zvalue() {
            return (x1.getZ() + x2.getZ()) / 2;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.drawing.Entry#quickpaint()
         */
        public void quickDraw() {
            Color black = engine.getColor("black");
            Color gray = engine.getColor("gray");
            Color c1 = myBond.getFirstAtom().color(engine);
            Color c2 = myBond.getSecondAtom().color(engine);
            // Gray isn't quite dark enough to look good in a wireframe
            if (c1.equals(gray))
                c1 = black;
            if (c2.equals(gray))
                c2 = black;
            drawBondLine(c1, c2, x1, x2);
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.drawing.Entry#paint()
         */
        public void draw() {
            Vector xdiff = x1.subtract(x2);
            double len = xdiff.length();
            Vector v1 = x1.subtract(xdiff.scale(r1 / len));
            Vector v2 = x2.add(xdiff.scale(r2 / len));
            Color black = engine.getColor("black");
            Vector perpGapHalf = null;
            if (myBond.order() > 1)
                perpGapHalf = perpendicularGap.scale(0.5);
            switch (myBond.order()) {
            default:
            case 1:
                drawBondLine(black, black, v1, v2);
                break;
            case 2:
                drawBondLine(black, black,
                             v1.add(perpGapHalf),
                             v2.add(perpGapHalf));
                drawBondLine(black, black,
                             v1.subtract(perpGapHalf),
                             v2.subtract(perpGapHalf));
                break;
            case 3:
                drawBondLine(black, black,
                             v1.add(perpGapHalf),
                             v2.add(perpGapHalf));
                drawBondLine(black, black, v1, v2);
                drawBondLine(black, black,
                             v1.subtract(perpGapHalf),
                             v2.subtract(perpGapHalf));
            }
        }
    }

    /**
     * The Class ForceEntry.
     */
    public static class ForceEntry extends Entry {
        private Vector begin, end, orig, f;
        private double arrowHeadSize = 5;
        private Orientation ort;

        /**
         * Instantiates a new force entry.
         *
         * @param origin the origin
         * @param f0 the f0
         * @param e the e
         */
        public ForceEntry(Orientation o, Vector origin, Vector f0, DrawingEngineImpl e) {
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
         * @see net.willware.eurydice.drawing.Entry#zvalue()
         */
        public double zvalue() {
            return (begin.getZ() + end.getZ()) / 2;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.drawing.Entry#quickpaint()
         */
        public void quickDraw() {
            if (force_color == null)
                force_color = engine.getColor("green");
            drawBondLine(force_color, force_color, begin, end);
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
                m = sqrtHalf * arrowHeadSize / m;
            else
                m = sqrtHalf;
            u = u.scale(m);
            v = v.scale(m);
            engine.setCurrentColor(force_color);
            engine.drawLine(end.getX(), end.getY(),
                            end.getX() + u.getX() - v.getX(),
                            end.getY() + u.getY() - v.getY());
            engine.drawLine(end.getX(), end.getY(),
                            end.getX() - u.getX() - v.getX(),
                            end.getY() - u.getY() - v.getY());
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.drawing.Entry#paint()
         */
        public void draw() {
            /* dumb for now, smarten it up later */
            quickDraw();
        }
    }
}
