package net.willware.eurydice.view;

import net.willware.eurydice.core.Orientation;
import net.willware.eurydice.math.Vector;

/**
 * The Class ScreenSpaceImpl.
 */
public class ScreenSpaceImpl implements ScreenSpace {

    /** The zoom factor is in pixels per angstrom. */
    private double zoomFactor = 25;

    /** The orientation. */
    private Orientation orientation;

    /** The perspective. */
    private Perspective perspective;

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.ScreenSpace#getZoomFactor()
     */
    public double getZoomFactor() {
        return zoomFactor;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.ScreenSpace#setZoomFactor(double)
     */
    public void setZoomFactor(double z) {
        zoomFactor = z;
    }

    /*
     * Screen coordinates are in pixels, where positions are in angstroms.
     * Since screens only care about x and y, the z for screen coordinates
     * is the same as the position z (angstroms).
     */

    /**
     * Convert an atom position to screen coordinates (pixels).
     *
     * @param xyz the atom position vector
     * @return the position in screen coordinates
     */
    public Vector xyzToScreen(Vector xyz) {
        // rotate, translate
        xyz = orientation.apply(xyz);
        // perspective
        xyz = perspective.apply(xyz);
        // zoom
        return xyz.scale(zoomFactor);
    }

    /**
     * Convert a vector in screen coordinates (pixels) to a position in 3-space
     * where the atoms live.
     *
     * @param xyz the xyz
     * @return the vector in atom space
     */
    public Vector screenToXyz(Vector xyz) {
        // undo zoom
        xyz = xyz.scale(1.0 / zoomFactor);
        // undo perspective
        xyz = perspective.unapply(xyz);
        // undo translation, rotation
        return orientation.unapply(xyz);
    }

    /**
     * Sets the orientation.
     *
     * @param orientation the new orientation
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.ScreenSpace#getOrientation()
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Sets the perspective.
     *
     * @param perspective the new perspective
     */
    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.ScreenSpace#getPerspective()
     */
    public Perspective getPerspective() {
        return perspective;
    }
}
