package net.willware.eurydice.view;

import net.willware.eurydice.core.Orientation;
import net.willware.eurydice.math.Vector;

/**
 * The Interface ScreenSpace.
 */
public interface ScreenSpace {

    /**
     * Gets the orientation.
     *
     * @return the orientation
     */
    Orientation getOrientation();

    /**
     * Gets the perspective.
     *
     * @return the perspective
     */
    Perspective getPerspective();

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
    public Vector xyzToScreen(Vector xyz);

    /**
     * Convert a vector in screen coordinates (pixels) to a position in 3-space
     * where the atoms live.
     *
     * @param vec the vector in screen space
     * @return the vector in atom space
     */
    public Vector screenToXyz(Vector vec);

    /**
     * Get the zoom factor, a multiplier from angstroms to pixels.
     *
     * @return the zoom factor
     */
    public double getZoomFactor();

    /**
     * Set the zoom factor, a multiplier from angstroms to pixels.
     *
     * @param z the zoom factor
     */
    public void setZoomFactor(double z);
}
