package net.willware.eurydice.core;

import net.willware.eurydice.math.Vector;

// TODO: Auto-generated Javadoc
/**
 * A rectangular region of 3-space, delineated by two Vectors at opposing corners.
 */
public class Region {
    private Vector minCorner, maxCorner;

    /**
     * Instantiates a new region.
     *
     * @param x1 an x coordinate of one corner of the region
     * @param y1 an y coordinate of one corner of the region
     * @param z1 an z coordinate of one corner of the region
     * @param x2 an x coordinate of another corner of the region
     * @param y2 an y coordinate of another corner of the region
     * @param z2 an z coordinate of another corner of the region
     */
    public Region(double x1, double y1, double z1, double x2, double y2, double z2) {
        double xmin, ymin, zmin, xmax, ymax, zmax;
        if (x1 < x2) {
            xmin = x1;
            xmax = x2;
        } else {
            xmin = x2;
            xmax = x1;
        }
        if (y1 < y2) {
            ymin = y1;
            ymax = y2;
        } else {
            ymin = y2;
            ymax = y1;
        }
        if (z1 < z2) {
            zmin = z1;
            zmax = z2;
        } else {
            zmin = z2;
            zmax = z1;
        }
        minCorner = new Vector(xmin, ymin, zmin);
        maxCorner = new Vector(xmax, ymax, zmax);
    }

    /**
     * Gets the min corner.
     *
     * @return a Vector marking the corner with the minimal values for x, y, and z
     */
    public Vector getMinCorner() {
        return minCorner;
    }

    /**
     * Gets the max corner.
     *
     * @return a Vector marking the corner with the maximal values for x, y, and z
     */
    public Vector getMaxCorner() {
        return maxCorner;
    }
}
