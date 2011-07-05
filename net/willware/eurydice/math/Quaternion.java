package net.willware.eurydice.math;

/**
 * Quaternions are a <a href="http://en.wikipedia.org/wiki/Quaternions_and_spatial_rotation">convenient</a>
 * way to scale and rotate 3-dimensional objects.
 */
public class Quaternion {

    /** The real part. */
    private double realPart;

    /** The imaginary part. */
    private Vector imaginaryPart;

    /** The units. */
    private PhysicalUnit units = null;

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
        String r = "<Quat " + realPart + " "
                   + imaginaryPart.getX() + " "
                   + imaginaryPart.getY() + " "
                   + imaginaryPart.getZ();
        if (units != null)
            r += " " + units;
        return r + ">";
    }

    /**
     * Add another quaternion.
     *
     * @param other the other quaternion
     * @return the quaternion sum
     */
    public Quaternion add(Quaternion other) {
        if (!PhysicalUnit.matches(units, other.getUnits()))
            throw new PhysicalUnit.Mismatch();
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
        if (!PhysicalUnit.matches(units, other.getUnits()))
            throw new PhysicalUnit.Mismatch();
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
        Quaternion q = new Quaternion(a*e - b*f - c*g - d*h,
                                      new Vector(a*f + b*e + c*h - d*g, a*g - b*h + c*e + d*f, a*h + b*g - c*f + d*e));
        if (units != null && other.units != null) {
            q.units = units.times(other.units);
        }
        return q;
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
    public Quaternion multiply(Vector other) {
        Quaternion q = multiply(new Quaternion(0.0, other));
        if (units != null && other.getUnits() != null) {
            q.units = units.times(other.getUnits());
        }
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
        Quaternion q = new Quaternion(k * realPart, imaginaryPart.scale(-k));
        if (units != null)
            q.units = units.inverse();
        return q;
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
        if (!PhysicalUnit.matches(units, other.getUnits()))
            return false;
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
     * Rotate a Vector using this quaternion as a rotator. A rotator quaterion has
     * an {@link #absoluteValue()} of 1, so if this is not the case throw an exception.
     *
     * @param v the vector to be rotated
     * @return the vector result
     * @throws ArithmeticException if quaternion absolute value is too far from 1
     */
    public Vector rotate(Vector v) throws ArithmeticException {
        double h = 1.0e-6;
        double av = absoluteValue();
        if (av < 1.0 - h || av > 1.0 + h)
            throw new ArithmeticException();
        return multiply(v).multiply(inverse()).imaginaryPart;
    }

    /**
     * Sets the physical units.
     *
     * @param units the new units
     */
    public void setUnits(PhysicalUnit units) {
        this.units = units;
    }

    /**
     * Gets the physical units.
     *
     * @return the units
     */
    public PhysicalUnit getUnits() {
        return units;
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
        System.out.println(rotator.multiply(v).multiply(rotator.inverse()));
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
