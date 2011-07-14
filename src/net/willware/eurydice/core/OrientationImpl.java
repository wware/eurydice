package net.willware.eurydice.core;

import net.willware.eurydice.math.Quaternion;
import net.willware.eurydice.math.Vector;

/**
 * The Class OrientationImpl.
 */
public class OrientationImpl implements Orientation {

    /** The translation. */
    private Vector translation;

    /** The rotation. */
    private Quaternion rotation;

    /**
     * Instantiates a new orientation impl.
     */
    public OrientationImpl() {
        translation = new Vector();
        rotation =  new Quaternion();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Orientation#getTranslation()
     */
    public Vector getTranslation() {
        return translation;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Orientation#getRotation()
     */
    public Quaternion getRotation() {
        return rotation;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Orientation#rotateX(double)
     */
    public void rotateX(double radians) {
        rotation = Quaternion.makeRotator(radians, new Vector(1, 0, 0)).multiply(rotation);
        rotation = rotation.normalize();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Orientation#rotateY(double)
     */
    public void rotateY(double radians) {
        rotation = Quaternion.makeRotator(radians, new Vector(0, 1, 0)).multiply(rotation);
        rotation = rotation.normalize();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Orientation#rotateZ(double)
     */
    public void rotateZ(double radians) {
        rotation = Quaternion.makeRotator(radians, new Vector(0, 0, 1)).multiply(rotation);
        rotation = rotation.normalize();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Orientation#translate(net.willware.eurydice.math.Vector)
     */
    public void translate(Vector delta) { }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Orientation#apply(net.willware.eurydice.math.Vector)
     */
    public Vector apply(Vector xyz) {
        return rotation.rotate(xyz).add(translation);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Orientation#unapply(net.willware.eurydice.math.Vector)
     */
    public Vector unapply(Vector xyz) {
        return rotation.conjugate().rotate(xyz.subtract(translation));
    }
}
