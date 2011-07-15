package net.willware.eurydice.core;

import net.willware.eurydice.math.Quaternion;
import net.willware.eurydice.math.Vector;

/**
 * An orientation is a translation and a rotation in 3-space.
 */
public class Orientation {

    /** The translation. */
    private Vector translation;

    /** The rotation. */
    private Quaternion rotation;

    /**
     * Instantiates a new orientation impl.
     */
    public Orientation() {
        translation = new Vector();
        rotation =  new Quaternion();
    }

    /**
     * Gets the translation.
     *
     * @return the translation
     */
    public Vector getTranslation() {
        return translation;
    }

    /**
     * Gets the rotation quaternion.
     *
     * @return the rotation
     */
    public Quaternion getRotation() {
        return rotation;
    }

    /**
     * Add a rotation about the X axis.
     *
     * @param radians the radians
     */
    public void rotateX(double radians) {
        rotation = Quaternion.makeRotator(radians, new Vector(1, 0, 0)).multiply(rotation);
        if (!rotation.closeToUnitLength())
            rotation = rotation.normalize();
    }

    /**
     * Add a rotation about the Y axis.
     *
     * @param radians the radians
     */
    public void rotateY(double radians) {
        rotation = Quaternion.makeRotator(radians, new Vector(0, 1, 0)).multiply(rotation);
        if (!rotation.closeToUnitLength())
            rotation = rotation.normalize();
    }

    /**
     * Add a rotation about the Z axis.
     *
     * @param radians the radians
     */
    public void rotateZ(double radians) {
        rotation = Quaternion.makeRotator(radians, new Vector(0, 0, 1)).multiply(rotation);
        if (!rotation.closeToUnitLength())
            rotation = rotation.normalize();
    }

    /**
     * Add an increment to the translation vector.
     *
     * @param delta the delta
     */
    public void translate(Vector delta) {
        translation = translation.add(delta);
    }

    /**
     * Apply a rotation, and then a translation, to a vector.
     *
     * @param xyz the xyz
     * @return the vector
     */
    public Vector apply(Vector xyz) {
        return rotation.rotate(xyz).add(translation);
    }

    /**
     * Unapply a translation, and then a rotation, to a vector.
     *
     * @param xyz the xyz
     * @return the vector
     */
    public Vector unapply(Vector xyz) {
        return rotation.conjugate().rotate(xyz.subtract(translation));
    }
}
