package net.willware.eurydice.core;

import net.willware.eurydice.math.Quaternion;
import net.willware.eurydice.math.Vector;

/**
 * The Interface Orientation.
 */
public interface Orientation {

    /**
     * Gets the translation.
     *
     * @return the translation
     */
    Vector getTranslation();

    /**
     * Gets the rotation.
     *
     * @return the rotation
     */
    Quaternion getRotation();

    /**
     * Add a rotation about the X axis.
     *
     * @param radians the radians
     */
    void rotateX(double radians);

    /**
     * Add a rotation about the Y axis.
     *
     * @param radians the radians
     */
    void rotateY(double radians);

    /**
     * Add a rotation about the Z axis.
     *
     * @param radians the radians
     */
    void rotateZ(double radians);

    /**
     * Add an increment to the translation vector.
     *
     * @param delta the delta
     */
    void translate(Vector delta);

    /**
     * Apply a rotation, and then a translation, to a vector.
     *
     * @param xyz the xyz
     * @return the vector
     */
    Vector apply(Vector xyz);

    /**
     * Unapply a translation, and then a rotation, to a vector.
     *
     * @param xyz the xyz
     * @return the vector
     */
    Vector unapply(Vector xyz);
}
