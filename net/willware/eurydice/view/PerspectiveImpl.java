package net.willware.eurydice.view;

import net.willware.eurydice.math.Vector;

/**
 * Perspective is when farther-away objects appear a little smaller.
 */
public class PerspectiveImpl implements Perspective {

    /** The distance. */
    private double distance = 1.0;

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Perspective#getDistance()
     */
    public double getDistance() {
        return distance;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Perspective#setDistance(double)
     */
    public void setDistance(double dist) {
        this.distance = dist;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Perspective#apply(double, double)
     */
    public double apply(double x, double z) {
        return (z * x) / (z + distance);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Perspective#unapply(double, double)
     */
    public double unapply(double x, double z) {
        return ((z + distance) * x) / z;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Perspective#apply(net.willware.eurydice.math.Vector)
     */
    public Vector apply(Vector xyz) {
        double z = xyz.getZ();
        return new Vector(apply(xyz.getX(), z), apply(xyz.getY(), z), z);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.view.Perspective#unapply(net.willware.eurydice.math.Vector)
     */
    public Vector unapply(Vector xyz) {
        double z = xyz.getZ();
        return new Vector(unapply(xyz.getX(), z), unapply(xyz.getY(), z), z);
    }
}
