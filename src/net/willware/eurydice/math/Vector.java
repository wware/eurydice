package net.willware.eurydice.math;

/**
 * Vectors are useful for positions, forces, and other quantities with magnitudes and directions.
 */
public class Vector {

    /** The X component of the vector. */
    private double x;

    /** The Y component of the vector. */
    private double y;

    /** The Z component of the vector. */
    private double z;

    /** The units. */
    private PhysicalUnit units = null;

    /**
     * Constructor, creates a zero-length vector.
     */
    public Vector() {
        setX(0.0);
        setY(0.0);
        setZ(0.0);
    }

    /**
     * Constructor with X, Y, and Z args.
     *
     * @param x the X component
     * @param y the Y component
     * @param z the Z component
     */
    public Vector(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * Approximately equal to another vector.
     *
     * @param v the other vector
     * @return true if the two vectors are approximately equal
     */
    public boolean approximatelyEqual(Vector v) {
        if (!PhysicalUnit.matches(units, v.getUnits()))
            return false;
        return subtract(v).length() < 1.0e-5;
    }

    /**
     * Copy.
     *
     * @return a copy of the vector
     */
    public Vector copy() {
        return new Vector(x, y, z);
    }

    /**
     * Sets the X component.
     *
     * @param x the new X value
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the Y component.
     *
     * @param y the new Y value
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets the Z component.
     *
     * @param z the new Z value
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Gets the X component.
     *
     * @return the X component
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y component.
     *
     * @return the Y component
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the Z component.
     *
     * @return the Z component
     */
    public double getZ() {
        return z;
    }

    /**
     * Adds another vector to this one.
     *
     * @param other the other vector
     * @return the sum vector
     */
    public Vector add(Vector other) {
        if (!PhysicalUnit.matches(units, other.getUnits()))
            throw new PhysicalUnit.Mismatch();
        return new Vector(x + other.x, y + other.y, z + other.z);
    }

    /**
     * Negate this vector (additive inverse).
     *
     * @return the negated vector
     */
    public Vector negate() {
        return new Vector(-x, -y, -z);
    }

    /**
     * Subtract another vector from this one.
     *
     * @param other the other vector
     * @return the difference vector
     */
    public Vector subtract(Vector other) {
        if (!PhysicalUnit.matches(units, other.getUnits()))
            throw new PhysicalUnit.Mismatch();
        return new Vector(x - other.x, y - other.y, z - other.z);
    }

    /**
     * Scale the vector by a scalar multiplier.
     *
     * @param m the multiplier
     * @return the scaled vector
     */
    public Vector scale(double m) {
        return new Vector(x * m, y * m, z * m);
    }

    /**
     * Dot product of this vector with another.
     *
     * @param other the other vector
     * @return the dot product of the two vectors
     */
    public double dotProduct(Vector other) {
        return x * other.x + y * other.y + z * other.z;
    }

    /**
     * Square of the distance between this vector and another
     *
     * @return the distance squared
     */
    public double distsq(Vector v) {
        v = v.subtract(this);
        return v.dotProduct(v);
    }

    /**
     * Square of the Euclidean length of this vector.
     *
     * @return the euclidean length squared
     */
    public double lensq() {
        return dotProduct(this);
    }

    /**
     * Euclidean length of this vector.
     *
     * @return the euclidean length
     */
    public double length() {
        return Math.sqrt(dotProduct(this));
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String r = "<" + x + " " + y + " " + z;
        if (units != null)
            r += " " + units;
        return r + ">";
    }

    /**
     * Cross product of this vector with another.
     *
     * @param other the other vector
     * @return the cross product result vector
     */
    public Vector crossProduct(Vector other) {
        Vector v = new Vector(getY() * other.getZ() - other.getY() * getZ(),
                              getZ() * other.getX() - other.getZ() * getX(),
                              getX() * other.getY() - other.getX() * getY());
        if (units != null && other.units != null) {
            v.units = units.times(other.units);
        }
        return v;
    }

    /**
     * Multiply this vector by a quaternion.
     *
     * @param q the quaternion being multiplied
     * @return the quaternion result
     */
    public Quaternion multiplyQuaternion(Quaternion q) {
        Quaternion q2 = (new Quaternion(0.0, this)).multiply(q);
        if (units != null && q.getUnits() != null)
            q2.setUnits(units.times(q.getUnits()));
        return q2;
    }

    /**
     * Sets the physical units.
     *
     * @param units the new physical units
     */
    public void setUnits(PhysicalUnit units) {
        this.units = units;
    }

    /**
     * Gets the physical units.
     *
     * @return the physical units
     */
    public PhysicalUnit getUnits() {
        return units;
    }
}
