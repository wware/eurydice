package net.willware.eurydice.math;

/**
 * A rectangular region of 3-space, delineated by two Vectors at opposing corners.
 */
public class Region {

    /** Bit code indicating this region completely covers another in the X dimension. */
    public static final int X_COMPLETE = 1 << 0;
    /** Bit code indicating this region completely covers another in the Y dimension. */
    public static final int Y_COMPLETE = 1 << 1;
    /** Bit code indicating this region completely covers another in the Z dimension. */
    public static final int Z_COMPLETE = 1 << 2;

    protected Vector minCorner, maxCorner;

    /**
     * Constructor.
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

    /**
     * Gets the center of the region.
     *
     * @return a Vector marking the center of this region
     */
    public Vector getCenter() {
        return maxCorner.add(minCorner).scale(0.5);
    }

    public boolean interior(Vector v) {
    	return (minCorner.getX() < v.getX() && v.getX() < maxCorner.getX() &&
    			minCorner.getY() < v.getY() && v.getY() < maxCorner.getY() &&
    			minCorner.getY() < v.getY() && v.getY() < maxCorner.getY());
    }

    public boolean interior(Region other) {
    	return interior(other.minCorner) && interior(other.maxCorner);
    }

    public boolean exterior(Vector v) {
    	return ((minCorner.getX() >= v.getX() || v.getX() >= maxCorner.getX()) &&
    			(minCorner.getY() >= v.getY() || v.getY() >= maxCorner.getY()) &&
    			(minCorner.getY() >= v.getY() || v.getY() >= maxCorner.getY()));
    }

    public boolean exterior(Region other) {
    	return exterior(other.minCorner) && exterior(other.maxCorner);
    }
}
