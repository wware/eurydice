package net.willware.eurydice.drawing;

import net.willware.eurydice.math.Vector;

public interface Orientation {

    /**
     * Update the size of the drawing surface.
     *
     * @param x the width
     * @param y the height
     */
    public void updateSize(int x, int y);

    /**
     * Pan the image left or right or up or down.
     *
     * @param dx a horizontal offset
     * @param dy a vertical offset
     */
    public void pan(int dx, int dy);

    /**
     * Apply X angle to the rotation matrix.
     *
     * @param xAngle the X angle
     */
    public void rotateX(double xAngle);

    /**
     * Apply Y angle to the rotation matrix.
     *
     * @param yAngle the Y angle
     */
    public void rotateY(double yAngle);

    /**
     * Perspective factor corresponding to a given Z depth.
     *
     * @param z the Z depth
     * @return the resulting perspective factor
     */
    public double perspectiveFactor(double z);

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
     * Get a zoom factor for viewing this structure.
     *
     * @return the zoom factor
     */
    public double getZoomFactor();
}
