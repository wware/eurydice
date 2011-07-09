package net.willware.eurydice.nanocad;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import net.willware.eurydice.core.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class AWTEngine.
 */
public class AWTEngine extends DrawingEngineImpl implements Color.ColorFactory {

    /** The graphics. */
    private Graphics2D graphics;

    /**
     * The Class AwtColor.
     */
    private class AwtColor extends Color {
        private java.awt.Color acolor;
        public AwtColor(final int red, final int green, final int blue) {
            acolor = new java.awt.Color(red, green, blue);
        }
    }

    public Color getColor(int red, int green, int blue) {
        return new AwtColor(red, green, blue);
    }

    /** The current color. */
    private AwtColor currentColor;

    /**
     * Instantiates a new aWT engine.
     *
     * @param g the g
     */
    public AWTEngine(Graphics g) {
        Color.setFactory(this);
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
