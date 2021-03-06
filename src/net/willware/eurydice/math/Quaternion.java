package net.willware.eurydice.math;

/**
 * Quaternions are a
 * <a href="http://en.wikipedia.org/wiki/Quaternions_and_spatial_rotation">convenient</a>
 * way to scale and rotate 3-dimensional objects.
 */
public class Quaternion {

    /** The real part. */
    private double realPart;

    /** The imaginary part. */
    private Vector imaginaryPart;

    /**
     * Constructor.
     *
     * @param re the real part, a scalar
     * @param im the imaginary part, a 3-vector
     */
    public Quaternion(double re, Vector im) {
        realPart = re;
        imaginaryPart = im;
    }

    /**
     * Constructor, no args, creates unit quaternion (1,0,0,0).
     */
    public Quaternion() {
        realPart = 1.0;
        imaginaryPart = new Vector();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "<Quat " + realPart + " " + imaginaryPart.toString() + ">";
    }

    /**
     * Add another quaternion.
     *
     * @param other the other quaternion
     * @return the quaternion sum
     */
    public Quaternion add(Quaternion other) {
        return new Quaternion(realPart + other.realPart,
                              imaginaryPart.add(other.imaginaryPart));
    }

    /**
     * Subtract another quaternion.
     *
     * @param other the other quaternion
     * @return the quaternion difference
     */
    public Quaternion subtract(Quaternion other) {
        return new Quaternion(realPart - other.realPart,
                              imaginaryPart.subtract(other.imaginaryPart));
    }

    /**
     * Multiply another quaternion.
     *
     * @param other the other quaternion
     * @return the quaternion product
     */
    public Quaternion multiply(Quaternion other) {
        double a = realPart, b = imaginaryPart.getX();
        double c = imaginaryPart.getY(), d = imaginaryPart.getZ();
        double e = other.realPart, f = other.imaginaryPart.getX();
        double g = other.imaginaryPart.getY(), h = other.imaginaryPart.getZ();
        return new Quaternion(a*e - b*f - c*g - d*h,
                              new Vector(a*f + b*e + c*h - d*g,
                                         a*g - b*h + c*e + d*f,
                                         a*h + b*g - c*f + d*e));
    }

    /**
     * Additive inverse of this quaternion.
     *
     * @return the negated quaternion
     */
    public Quaternion negate() {
        return scale(-1);
    }

    /**
     * Scale by a real-valued number.
     *
     * @param other the factor to scale by
     * @return the quaternion result
     */
    public Quaternion scale(double other) {
        return new Quaternion(other * realPart, imaginaryPart.scale(other));
    }

    /**
     * Multiply by a Vector.
     *
     * @param other the vector to be multiplied
     * @return the quaternion result
     */
    public Quaternion multiplyVector(Vector other) {
        Quaternion q = multiply(new Quaternion(0.0, other));
        return q;
    }

    /**
     * Divide by another quaternion.
     *
     * @param other the other quaternion
     * @return the quaternion quotient
     */
    public Quaternion divide(Quaternion other) {
        return multiply(other.inverse());
    }

    /**
     * Absolute value squared.
     *
     * @return the double
     */
    private double absoluteValueSquared() {
        return realPart * realPart + imaginaryPart.dotProduct(imaginaryPart);
    }

    /**
     * Absolute value of this quaternion.
     *
     * @return the absolute value
     */
    public double absoluteValue() {
        return Math.sqrt(absoluteValueSquared());
    }

    /**
     * Multiplicative inverse of this quaternion.
     *
     * @return the quaternion reciprocal
     */
    public Quaternion inverse() {
        double k = 1.0 / absoluteValueSquared();
        return new Quaternion(k * realPart, imaginaryPart.scale(-k));
    }

    /**
     * Sets the real part.
     *
     * @param realPart the new real part
     */
    public void setReal(double realPart) {
        this.realPart = realPart;
    }

    /**
     * Gets the real part.
     *
     * @return the real part
     */
    public double getReal() {
        return realPart;
    }

    /**
     * Sets the imaginary part.
     *
     * @param imaginaryPart the new imaginary part
     */
    public void setImaginary(Vector imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Gets the imaginary part.
     *
     * @return the imaginary part
     */
    public Vector getImaginary() {
        return imaginaryPart;
    }

    /**
     * Compare to another quaternion and tell whether they are approximately equal.
     * Useful for some kinds of regression testing.
     *
     * @param other the other
     * @return true, if approximately equal
     */
    public boolean approximatelyEqual(Quaternion other) {
        other = subtract(other);
        return other.absoluteValueSquared() < 1.0e-6;
    }

    /**
     * Produce a quaternion representing a rotation about an axis. A rotator quaterion has
     * an {@link #absoluteValue()} of 1.
     *
     * @param theta the rotation angle
     * @param axis the axis about which to rotate
     * @return the quaternion result
     */
    public static Quaternion makeRotator(double theta, Vector axis) {
        return new Quaternion(Math.cos(0.5 * theta),
                              axis.scale(Math.sin(0.5 * theta) / axis.length()));
    }

    /**
     * Test (quickly) whether the quaternion is very close to unit length. If it isn't, and
     * you want to use it as a rotation quaternion, you need to call normalize on it.
     *
     * @return true if the quaternion is very close to unit length
     */
    public boolean closeToUnitLength() {
        double h = 1.0e-6;
        double avs = absoluteValueSquared();
        return (avs > 1.0 - h && avs < 1.0 + h);
    }

    /**
     * Rotate a Vector using this UNIT-LENGTH quaternion as a rotator. A rotator quaterion has
     * an {@link #absoluteValue()} of 1, so if this is not the case, be sure to normalize the
     * quaternion first.
     *
     * @param v the vector to be rotated
     * @return the vector result
     */
    public Vector rotate(Vector v) {
        return multiplyVector(v).multiply(inverse()).imaginaryPart;
    }

    /**
     * A normalized version of this quaternion; do the scaling operation only if necessary.
     *
     * @return the normalized quaternion
     */
    public Quaternion normalize() {
        return scale(1.0 / absoluteValue());
    }

    /**
     * Run some tests.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Quaternion q1 = new Quaternion(1, new Vector(1, 0, 0));
        Quaternion q2 = new Quaternion(0, new Vector(0, 1, 0));
        System.out.println(q1.multiply(q2));
        Quaternion rotator = makeRotator(2*Math.PI/3, new Vector(1.0,1.0,1.0));
        System.out.println(rotator);
        Vector v = new Vector(1, 0, 0);
        System.out.println(rotator.multiplyVector(v).multiply(rotator.inverse()));
    }

    /**
     * Conjugate.
     *
     * @return the quaternion
     */
    public Quaternion conjugate() {
        return new Quaternion(realPart, imaginaryPart.negate());
    }
}
