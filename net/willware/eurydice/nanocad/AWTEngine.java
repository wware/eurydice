package net.willware.eurydice.nanocad;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import net.willware.eurydice.view.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class AWTEngine.
 */
public class AWTEngine extends DrawingEngineImpl {

    /** The graphics. */
    private Graphics2D graphics;

    /**
     * The Class AwtColor.
     */
    private class AwtColor implements Color {

        /** The acolor. */
        java.awt.Color acolor;
    }

    /** The current color. */
    private AwtColor currentColor;

    /**
     * Instantiates a new aWT engine.
     *
     * @param g the g
     */
    public AWTEngine(Graphics g) {
        currentColor = new AwtColor();
        currentColor.acolor = java.awt.Color.white;
        graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                  RenderingHints.VALUE_ANTIALIAS_ON);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.DrawingEngine#drawCircle(double, double, double)
     */
    @Override
    public void drawCircle(double x, double y, double r) {
        graphics.drawOval((int) x, (int) y, (int) r, (int) r);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.DrawingEngine#drawLine(double, double, double, double)
     */
    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.DrawingEngine#fillCircle(double, double, double)
     */
    @Override
    public void fillCircle(double x, double y, double r) {
        graphics.fillOval((int) x, (int) y, (int) r, (int) r);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.DrawingEngine#getColor(java.lang.String)
     */
    @Override
    public Color getColor(String colorname) {
        AwtColor ac = new AwtColor();
        if ("white".equals(colorname))
            ac.acolor = java.awt.Color.white;
        else if ("black".equals(colorname))
            ac.acolor = java.awt.Color.black;
        else if ("red".equals(colorname))
            ac.acolor = java.awt.Color.red;
        else if ("green".equals(colorname))
            ac.acolor = java.awt.Color.green;
        else if ("blue".equals(colorname))
            ac.acolor = java.awt.Color.blue;
        else if ("yellow".equals(colorname))
            ac.acolor = java.awt.Color.yellow;
        else if ("gray".equals(colorname))
            ac.acolor = java.awt.Color.gray;
        else if ("orange".equals(colorname))
            ac.acolor = java.awt.Color.orange;
        else
            throw new RuntimeException("not handling this color: " + colorname);
        return ac;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.DrawingEngine#getCurrentColor()
     */
    @Override
    public Color getCurrentColor() {
        return currentColor;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.DrawingEngine#setCurrentColor(net.willware.eurydice.view.DrawingEngine.Color)
     */
    @Override
    public void setCurrentColor(Color c) {
        currentColor = (AwtColor) c;
        graphics.setColor(currentColor.acolor);
    }
}
