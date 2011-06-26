package net.willware.eurydice.drawing;

import net.willware.eurydice.math.Matrix;
import net.willware.eurydice.math.Vector;

public class Orientation {
    /** Rotation matrix from atom space to screen space. */
    private Matrix m = new Matrix();

    /** The zoom factor is in pixels per angstrom. */
    public double zoomFactor = 25;

    /** The perspective distance in the Z direction, in pixels. */
    public double perspDist = 400;    // z distance for perspective, in pixels

    /** The center. */
    private Vector center = new Vector(400.0, 300.0, 0.0);

    /** The renorm_counter. */
    private int renorm_counter = 0;

    /**
     * Update the size of the drawing surface.
     *
     * @param x the width
     * @param y the height
     */
    public void updateSize(int x, int y) {
        center.setX(x / 2);
        center.setY(y / 2);
        center.setZ(0.0);
    }

    /**
     * Pan the image left or right or up or down.
     *
     * @param dx a horizontal offset
     * @param dy a vertical offset
     */
    public void pan(int dx, int dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dx);
    }

    /**
     * Renormalize the rotation matrix periodically.
     *
     * @param i first of three indices for this renormalization
     * @param j second of three indices for this renormalization
     * @param k third of three indices for this renormalization
     */
    private void renormalize(int i, int j, int k) {
        double a = m.getElement(i);
        double b = m.getElement(j);
        double c = m.getElement(k);
        double r = Math.sqrt(a * a + b * b + c * c);
        m.setElement(i, a / r);
        m.setElement(j, b / r);
        m.setElement(k, c / r);
    }

    /**
     * Apply X angle to the rotation matrix.
     *
     * @param xAngle the X angle
     */
    public void rotateX(double xAngle) {
        //m = m.times(Matrix.rotationX(xAngle));
        m = m.rotateXZ(xAngle);
        renormalize();
    }

    /**
     * Apply Y angle to the rotation matrix.
     *
     * @param yAngle the Y angle
     */
    public void rotateY(double yAngle) {
        //m = m.times(Matrix.rotationY(yAngle));
        m = m.rotateYZ(yAngle);
        renormalize();
    }

    private void renormalize() {
        switch (renorm_counter++) {
        case 0:
            renormalize(0, 1, 2);
            break;
        case 1:
            renormalize(3, 4, 5);
            break;
        case 2:
            renormalize(6, 7, 8);
            break;
        case 3:
            renormalize(0, 3, 6);
            break;
        case 4:
            renormalize(1, 4, 7);
            break;
        default:
            renormalize(2, 5, 8);
            renorm_counter = 0;
            break;
        }
    }

    /**
     * Perspective factor corresponding to a given Z depth.
     *
     * @param z the Z depth
     * @return the resulting perspective factor
     */
    public double perspectiveFactor(double z) {
        double denom = perspDist - z;
        if (denom < 5)
            denom = 5;
        return perspDist / denom;
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
        // rotate
        xyz = m.times(xyz);
        // zoom
        xyz = xyz.scale(zoomFactor);
        // perspective
        double perspective = perspectiveFactor(xyz.getZ());
        xyz.setX(perspective * xyz.getX());
        xyz.setY(perspective * xyz.getY());
        // translation
        return xyz.add(center);
    }

    /**
     * Convert a vector in screen coordinates (pixels) to a position in 3-space
     * where the atoms live.
     *
     * @param vec the vector in screen space
     * @return the vector in atom space
     */
    public Vector screenToXyz(Vector vec) {
        // undo translation
        Vector xyz = vec.subtract(center);
        // undo perspective
        double perspective = perspectiveFactor(xyz.getZ());
        xyz.setX(xyz.getX() / perspective);
        xyz.setY(xyz.getY() / perspective);
        // undo zoom
        xyz = xyz.scale(1.0 / zoomFactor);
        // undo rotation
        return m.inverse().times(xyz);
    }


}
