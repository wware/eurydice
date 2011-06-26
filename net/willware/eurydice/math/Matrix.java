package net.willware.eurydice.math;

import java.util.Formatter;
import java.util.Locale;

/**
 * Matrices are useful for rotations, scaling operations, other things.
 */
public class Matrix {

    private double m11, m12, m13, m21, m22, m23, m31, m32, m33;

    /**
     * Constructor.
     *
     * @param m11 the m11
     * @param m12 the m12
     * @param m13 the m13
     * @param m21 the m21
     * @param m22 the m22
     * @param m23 the m23
     * @param m31 the m31
     * @param m32 the m32
     * @param m33 the m33
     */
    public Matrix(double m11, double m12, double m13,
                  double m21, double m22, double m23,
                  double m31, double m32, double m33) {
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb, Locale.US);
        f.format(" %13.6f %13.6f %13.6f\n", m11, m12, m13);
        f.format(" %13.6f %13.6f %13.6f\n", m21, m22, m23);
        f.format(" %13.6f %13.6f %13.6f",   m31, m32, m33);
        return sb.toString();
    }

    /**
     * No-arg constructor returns 3x3 identity matrix.
     */
    public Matrix() {
        m11 = m22 = m33 = 1.0;
        m12 = m13 = m21 = m23 = m31 = m32 = 0.0;
    }

    /**
     * Approximately equal.
     *
     * @param other the other
     * @return true, if successful
     */
    public boolean approximatelyEqual(Matrix other) {
        for (int i = 0; i < 9; i += 3) {
            Vector u = new Vector(getElement(i), getElement(i+1), getElement(i+2));
            Vector v = new Vector(other.getElement(i), other.getElement(i+1), other.getElement(i+2));
            if (!u.approximatelyEqual(v))
                return false;
        }
        return true;
    }

    /**
     * Rotate X and Z about the Y axis.
     *
     * @param angle the angle
     * @return the rotated matrix
     */
    public Matrix rotateXZ(double angle) {
        // why does this not work?
        // return Matrix.rotationY(angle).times(this);
        double sa, ca;
        sa = Math.sin(angle);
        ca = Math.cos(angle);
        return new Matrix(
                   ca * m11 + sa * m31,
                   ca * m12 + sa * m32,
                   ca * m13 + sa * m33,
                   m21,
                   m22,
                   m23,
                   -sa * m11 + ca * m31,
                   -sa * m12 + ca * m32,
                   -sa * m13 + ca * m33
               );
    }

    /**
     * Rotate Y and Z about the X axis.
     *
     * @param angle the angle
     * @return the rotated matrix
     */
    public Matrix rotateYZ(double angle) {
        // why does this not work?
        // return Matrix.rotationX(angle).times(this);
        double sa, ca;
        sa = Math.sin(angle);
        ca = Math.cos(angle);
        return new Matrix(
                   m11,
                   m12,
                   m13,
                   ca * m21 + sa * m31,
                   ca * m22 + sa * m32,
                   ca * m23 + sa * m33,
                   -sa * m21 + ca * m31,
                   -sa * m22 + ca * m32,
                   -sa * m23 + ca * m33
               );
    }

    /**
     * Rotation about the X axis.
     *
     * @param radians the rotation angle in radians
     * @return the rotated matrix
     */
    public static Matrix rotationX(double radians) {
        double s, c;
        s = Math.sin(radians);
        c = Math.cos(radians);
        return new Matrix(1.0, 0.0, 0.0,
                          0.0, c,   s,
                          0.0, -s,  c);
    }

    /**
     * Rotation about the Y axis.
     *
     * @param radians the rotation angle in radians
     * @return the rotated matrix
     */
    public static Matrix rotationY(double radians) {
        double s, c;
        s = Math.sin(radians);
        c = Math.cos(radians);
        return new Matrix(c,   0.0, s,
                          0.0, 1.0, 0.0,
                          -s,  0.0, c);

    }

    /**
     * Rotation about the Z axis.
     *
     * @param radians the rotation angle in radians
     * @return the rotated matrix
     */
    public static Matrix rotationZ(double radians) {
        double s, c;
        s = Math.sin(radians);
        c = Math.cos(radians);
        return new Matrix(c,   s,   0.0,
                          -s,  c,   0.0,
                          0.0, 0.0, 1.0);
    }

    /**
     * Multiply this 3x3 matrix by a 3-element column vector.
     * @param v the column vector
     * @return the product is another 3-element column vector
     */
    public Vector times(Vector v) {
        double x = v.getX();
        double y = v.getY();
        double z = v.getZ();
        return new Vector(m11 * x + m12 * y + m13 * z,
                          m21 * x + m22 * y + m23 * z,
                          m31 * x + m32 * y + m33 * z);
    }

    /**
     * Multiply this 3x3 matrix by another 3x3 matrix.
     * @param y the other matrix
     * @return the product is another 3x3 matrix
     */
    public Matrix times(Matrix y) {
        return new Matrix(m11 * y.m11 + m12 * y.m21 + m13 * y.m31,
                          m21 * y.m11 + m22 * y.m21 + m23 * y.m31,
                          m31 * y.m11 + m32 * y.m21 + m33 * y.m31,
                          m11 * y.m12 + m12 * y.m22 + m13 * y.m32,
                          m21 * y.m12 + m22 * y.m22 + m23 * y.m32,
                          m31 * y.m12 + m32 * y.m22 + m33 * y.m32,
                          m11 * y.m13 + m12 * y.m23 + m13 * y.m33,
                          m21 * y.m13 + m22 * y.m23 + m23 * y.m33,
                          m31 * y.m13 + m32 * y.m23 + m33 * y.m33);
    }

    /**
     * Determinant.
     *
     * @return the double
     */
    public double determinant() {
        return m11 * (m22 * m33 - m23 * m32) +
               m12 * (m23 * m31 - m21 * m33) +
               m13 * (m21 * m32 - m22 * m31);
    }

    /**
     * See http://www.dr-lex.be/random/matrix_inv.html for formula.
     * @return matrix inverse, if all goes well
     */
    public Matrix inverse() {
        double det = determinant();
        return new Matrix((m22 * m33 - m23 * m32) / det,
                          (m13 * m32 - m12 * m33) / det,
                          (m12 * m23 - m13 * m22) / det,
                          (m23 * m31 - m21 * m33) / det,
                          (m11 * m33 - m13 * m31) / det,
                          (m13 * m21 - m11 * m23) / det,
                          (m32 * m21 - m22 * m31) / det,
                          (m31 * m12 - m11 * m32) / det,
                          (m11 * m22 - m12 * m21) / det);
    }

    /**
     * Sets an element in the matrix.
     *
     * @param index an index from 0 to 8
     * @param x the new value for that position in the matrix
     */
    public void setElement(int index, double x) {
        switch (index) {
        case 0:
            m11 = x;
            break;
        case 1:
            m12 = x;
            break;
        case 2:
            m13 = x;
            break;
        case 3:
            m21 = x;
            break;
        case 4:
            m22 = x;
            break;
        case 5:
            m23 = x;
            break;
        case 6:
            m31 = x;
            break;
        case 7:
            m32 = x;
            break;
        case 8:
            m33 = x;
            break;
        }
    }

    /**
     * Gets an element from the matrix.
     *
     * @param index an index from 0 to 8
     * @return the element at that position
     */
    public double getElement(int index) {
        switch (index) {
        case 0:
            return m11;
        case 1:
            return m12;
        case 2:
            return m13;
        case 3:
            return m21;
        case 4:
            return m22;
        case 5:
            return m23;
        case 6:
            return m31;
        case 7:
            return m32;
        case 8:
            return m33;
        default:
            return 0.0;
        }
    }
}
