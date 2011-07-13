package net.willware.eurydice.math;

/**
 * A rectangular region of 3-space, delineated by two Vectors at opposing corners.
 */
public class Region {

    /** Bit code indicating this region partially covers another in the X dimension. */
    public static final int X_PARTIAL = 1;
    /** Bit code indicating this region completely covers another in the X dimension. */
    public static final int X_COMPLETE = 2;
    /** Bit code indicating this region partially covers another in the Y dimension. */
    public static final int Y_PARTIAL = 4;
    /** Bit code indicating this region completely covers another in the Y dimension. */
    public static final int Y_COMPLETE = 8;
    /** Bit code indicating this region partially covers another in the Z dimension. */
    public static final int Z_PARTIAL = 16;
    /** Bit code indicating this region completely covers another in the Z dimension. */
    public static final int Z_COMPLETE = 32;

    // This might work better:
    //public static final int X_NEG_COMPLETE = 1 << 0;
    //public static final int X_NEG_PARTIAL  = 1 << 1;
    //public static final int X_POS_COMPLETE = 1 << 2;
    //public static final int X_POS_PARTIAL  = 1 << 3;
    //public static final int Y_NEG_COMPLETE = 1 << 4;
    //public static final int Y_NEG_PARTIAL  = 1 << 5;
    //public static final int Y_POS_COMPLETE = 1 << 6;
    //public static final int Y_POS_PARTIAL  = 1 << 7;
    //public static final int Z_NEG_COMPLETE = 1 << 8;
    //public static final int Z_NEG_PARTIAL  = 1 << 9;
    //public static final int Z_POS_COMPLETE = 1 << 10;
    //public static final int Z_POS_PARTIAL  = 1 << 11;


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

    /**
     * Return a combination of bits that tell whether this region partially or completely
     * encloses another in the X, Y, and Z dimensions.
     *
     * @param the other region
     * @return the inclusive-OR of the bits
     */
    public int covers(Region other) {
        int r = 0;
        if (minCorner.getX() < other.minCorner.getX() && maxCorner.getX() >= other.maxCorner.getX())
            r |= X_COMPLETE;
        else if (minCorner.getX() < other.maxCorner.getX() || maxCorner.getX() >= other.minCorner.getX())
            r |= X_PARTIAL;
        if (minCorner.getY() < other.minCorner.getY() && maxCorner.getY() >= other.maxCorner.getY())
            r |= Y_COMPLETE;
        else if (minCorner.getY() < other.maxCorner.getY() || maxCorner.getY() >= other.minCorner.getY())
            r |= Y_PARTIAL;
        if (minCorner.getZ() < other.minCorner.getZ() && maxCorner.getZ() >= other.maxCorner.getZ())
            r |= Z_COMPLETE;
        else if (minCorner.getZ() < other.maxCorner.getZ() || maxCorner.getZ() >= other.minCorner.getZ())
            r |= Z_PARTIAL;
        return r;
    }
}
