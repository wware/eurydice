package net.willware.eurydice.view;

import net.willware.eurydice.math.Vector;

/**
 * Perspective is when farther-away objects appear a little smaller. As with
 * {@link DisplayListEntry#zsort(DisplayListEntry[])}, the Z coordinate increases
 * as the atom moves farther <i>CLOSER</i>.
 */
public class Perspective {

    private double distance = 1.0;

    /**
     * Get perspective distance in angstroms.
     *
     * @return perspective distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Set perspective distance in angstroms.
     *
     * @param dist the new perspective distance
     */
    public void setDistance(double dist) {
        this.distance = dist;
    }

    /**
     * Apply perspective to a distance in the viewing plane, depending on its Z depth.
     *
     * @param x a distance in the viewing plane, to be scaled
     * @param z the Z distance which determines the scaling
     * @return the scaled distance in the viewing plane
     */
    public double apply(double x, double z) {
        return (distance * x) / (distance - z);
    }

    /**
     * Un-apply perspective to a distance in the viewing plane, depending on its Z depth.
     *
     * @param x a distance in the viewing plane, to be scaled
     * @param z the Z distance which determines the scaling
     * @return the scaled distance in the viewing plane
     */
    public double unapply(double x, double z) {
        return ((distance - z) * x) / distance;
    }

    /**
     * Apply perspective translation to a vector.
     *
     * @param xyz the xyz
     * @return the vector
     */
    public Vector apply(Vector xyz) {
        double z = xyz.getZ();
        return new Vector(apply(xyz.getX(), z), apply(xyz.getY(), z), z);
    }

    /**
     * Unapply.
     *
     * @param xyz the xyz
     * @return the vector
     */
    public Vector unapply(Vector xyz) {
        double z = xyz.getZ();
        return new Vector(unapply(xyz.getX(), z), unapply(xyz.getY(), z), z);
    }
}
