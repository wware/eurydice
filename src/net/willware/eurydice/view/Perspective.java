package net.willware.eurydice.view;

import net.willware.eurydice.math.Vector;

/**
 * Perspective is when farther-away objects appear a little smaller.
 */
public interface Perspective {
    /**
     * Get perspective distance in angstroms.
     *
     * @return perspective distance
     */
    double getDistance();

    /**
     * Set perspective distance in angstroms.
     *
     * @param dist the new perspective distance
     */
    void setDistance(double dist);

    /**
     * Apply perspective to a distance in the viewing plane, depending on its Z depth.
     *
     * @param x a distance in the viewing plane, to be scaled
     * @param z the Z distance which determines the scaling
     * @return the scaled distance in the viewing plane
     */
    double apply(double x, double z);

    /**
     * Un-apply perspective to a distance in the viewing plane, depending on its Z depth.
     *
     * @param x a distance in the viewing plane, to be scaled
     * @param z the Z distance which determines the scaling
     * @return the scaled distance in the viewing plane
     */
    double unapply(double x, double z);

    /**
     * Apply perspective translation to a vector.
     *
     * @param xyz the xyz
     * @return the vector
     */
    Vector apply(Vector xyz);

    /**
     * Unapply.
     *
     * @param xyz the xyz
     * @return the vector
     */
    Vector unapply(Vector xyz);
}
