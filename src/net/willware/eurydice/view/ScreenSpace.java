package net.willware.eurydice.view;

import net.willware.eurydice.core.Orientation;
import net.willware.eurydice.math.Vector;

/**
 * The Interface ScreenSpace.
 */
public class ScreenSpace {

    /** The zoom factor is in pixels per angstrom. */
    private double zoomFactor = 25;

    /** The orientation. */
    private Orientation orientation;

    /** The perspective. */
    private Perspective perspective;

    /**
     * Constructor
     */
    public ScreenSpace() {
        orientation = new Orientation();
        perspective = new Perspective();
    }

    /**
     * Sets the orientation.
     *
     * @param orientation the new orientation
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Gets the orientation.
     *
     * @return the orientation
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

    /**
     * Gets the perspective.
     *
     * @return the perspective
     */
    public Perspective getPerspective() {
        return perspective;
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
     * @param vec the vector in screen space
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
     * Determine the local scaling factor from angstroms to pixels after applying orientation,
     * perspective, and scaling, in the neighborhood of a given position in atom space.
     *
     * @param p the position in atom space
     * @return the local scaling factor of angstroms to pixels
     */
    public double scaleNear(Vector p) {
        double h = 1.0e-6;
        double x = xyzToScreen(p.add(new Vector(h, 0.0, 0.0))).subtract(xyzToScreen(p)).length();
        return x / h;
    }

    /**
     * Determine the local scaling factor from pixels to angstroms after applying orientation,
     * perspective, and scaling, in the neighborhood of a given position in screen space.
     *
     * @param p the position in screen space
     * @return the local scaling factor of pixels to angstroms
     */
    public double unscaleNear(Vector p) {
        double h = 1.0e-6;
        double x = screenToXyz(p.add(new Vector(h, 0.0, 0.0))).subtract(screenToXyz(p)).length();
        return x / h;
    }

    /**
     * Get the zoom factor, a multiplier from angstroms to pixels.
     *
     * @return the zoom factor
     */
    public double getZoomFactor() {
        return zoomFactor;
    }

    /**
     * Set the zoom factor, a multiplier from angstroms to pixels.
     *
     * @param z the zoom factor
     */
    public void setZoomFactor(double z) {
        zoomFactor = z;
    }
}
