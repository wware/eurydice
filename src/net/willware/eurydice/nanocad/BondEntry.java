package net.willware.eurydice.nanocad;

import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Color;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.view.DisplayListEntry;
import net.willware.eurydice.view.ScreenSpace;

/**
 * The Class BondEntry.
 */
public class BondEntry extends DisplayListEntry {

    /** The x2. */
    private Vector x1, x2;      // screen coordinates for each atom

    /** The r2. */
    private double r1, r2;      // radius in pixels for each atom
    // x3 is a vector that is perpendicular on screen to the direction of
    // the bond, used to space out multiple bonds, so we can have two parallel
    // lines for a double bond, three for a triple bond
    /** The perpendicular gap. */
    private Vector perpendicularGap;

    /** The my bond. */
    private Bond myBond;
    // gap between lines in double and triple bonds, in angstroms
    /** The Constant gap. */
    private static final double gap = 0.2;

    /** The engine. */
    private DrawingEngineImpl engine;

    /**
     * Instantiates a new bond entry.
     *
     * @param screenspace the screenspace
     * @param b the b
     * @param e the e
     * @param struc the struc
     */
    public BondEntry(ScreenSpace screenspace, Bond b, DrawingEngineImpl e, Structure struc) {
        myBond = b;
        engine = e;

        Vector pos1 = myBond.getFirstAtom().getPosition();
        x1 = screenspace.xyzToScreen(pos1);
        r1 = AtomEntry.radiusRatio * myBond.getFirstAtom().covalentRadius() * screenspace.getZoomFactor();
        r1 = screenspace.getPerspective().apply(r1, x1.getZ());

        x2 = screenspace.xyzToScreen(myBond.getSecondAtom().getPosition());
        r2 = AtomEntry.radiusRatio * myBond.getSecondAtom().covalentRadius() * screenspace.getZoomFactor();
        r1 = screenspace.getPerspective().apply(r1, x2.getZ());

        // compute a perpendicular vector in screen space
        Vector perpendicular = new Vector(x1.getY() - x2.getY(),
                                          x2.getX() - x1.getX(),
                                          0.0);
        // move it to atom space
        perpendicularGap = screenspace.screenToXyz(perpendicular);
        // adjust the length
        perpendicularGap = perpendicularGap.scale(gap / perpendicularGap.length());
        // move it back to screen space
        perpendicularGap = screenspace.xyzToScreen(perpendicularGap);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Entry#zvalue()
     */
    public double zvalue() {
        return (x1.getZ() + x2.getZ()) / 2;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Entry#quickpaint()
     */
    public void quickDraw() {
        Color black = Color.getColor("black");
        Color gray = Color.getColor("gray50");
        Color c1 = myBond.getFirstAtom().color();
        Color c2 = myBond.getSecondAtom().color();
        // Gray isn't quite dark enough to look good in a wireframe
        if (c1.equals(gray))
            c1 = black;
        if (c2.equals(gray))
            c2 = black;
        drawBondLine(engine, c1, c2, x1, x2);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Entry#paint()
     */
    public void draw() {
        Vector xdiff = x1.subtract(x2);
        double len = xdiff.length();
        Vector v1 = x1.subtract(xdiff.scale(r1 / len));
        Vector v2 = x2.add(xdiff.scale(r2 / len));
        Color black = Color.getColor("black");
        Vector perpGapHalf = null;
        if (myBond.order() > 1)
            perpGapHalf = perpendicularGap.scale(0.5);
        switch (myBond.order()) {
        default:
        case 1:
            drawBondLine(engine, black, black, v1, v2);
            break;
        case 2:
            drawBondLine(engine, black, black,
                         v1.add(perpGapHalf),
                         v2.add(perpGapHalf));
            drawBondLine(engine, black, black,
                         v1.subtract(perpGapHalf),
                         v2.subtract(perpGapHalf));
            break;
        case 3:
            drawBondLine(engine, black, black,
                         v1.add(perpGapHalf),
                         v2.add(perpGapHalf));
            drawBondLine(engine, black, black, v1, v2);
            drawBondLine(engine, black, black,
                         v1.subtract(perpGapHalf),
                         v2.subtract(perpGapHalf));
        }
    }

    /*package*/ /**
     * Draw bond line.
     *
     * @param engine the engine
     * @param c1 the c1
     * @param c2 the c2
     * @param v1 the v1
     * @param v2 the v2
     */
    static void drawBondLine(DrawingEngineImpl engine, Color c1, Color c2,
                             Vector v1, Vector v2) {
        Color oldcolor = engine.getCurrentColor();
        Vector vmid = v1.add(v2).scale(0.5);
        engine.setCurrentColor(c1);
        engine.drawLine(v1.getX(), v1.getY(), vmid.getX(), vmid.getY());
        engine.setCurrentColor(c2);
        engine.drawLine(vmid.getX(), vmid.getY(), v2.getX(), v2.getY());
        engine.setCurrentColor(oldcolor);
    }
}
