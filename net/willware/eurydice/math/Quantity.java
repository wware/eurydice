package net.willware.eurydice.math;

/**
 * A Quantity is a number with physical dimensions, for example 9.8 m sec^-2.
 */
public class Quantity {
    private double amount;
    private PhysicalUnit units;

    /**
     * Constructor.
     *
     * @param amount the numerical coefficient
     * @param units the physical dimensions
     */
    public Quantity(double amount, PhysicalUnit units) {
        this.amount = amount;
        this.units = units;
    }

    /**
     * Constructor for a dimensionless number.
     *
     * @param amount the numerical coefficient
     */
    public Quantity(double amount) {
        this.amount = amount;
        this.units = new PhysicalUnit();
    }

    /**
     * Constructor with no args, dimensionless zero.
     */
    public Quantity() {
        this.amount = 0.0;
        this.units = new PhysicalUnit();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "<" + amount + " " + units + ">";
    }

    /**
     * Gets the numerical coefficient for this quantity.
     *
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the dimensions for this quantity.
     *
     * @return the units
     */
    public PhysicalUnit getUnits() {
        return units;
    }

    /**
     * Adds another quantity to this one.
     *
     * @param other the other quantity
     * @return the sum quantity
     */
    public Quantity add(Quantity other) {
        if (!PhysicalUnit.matches(units, other.getUnits()))
            throw new PhysicalUnit.Mismatch();
        return new Quantity(amount + other.amount, units);
    }

    /**
     * This quantity multiplied by -1.
     *
     * @return the negated quantity
     */
    public Quantity negate() {
        return new Quantity(-amount, units);
    }

    /**
     * Subtracts another quantity from this one.
     *
     * @param other the other quantity
     * @return the difference quantity
     */
    public Quantity subtract(Quantity other) {
        if (!PhysicalUnit.matches(units, other.getUnits()))
            throw new PhysicalUnit.Mismatch();
        return new Quantity(amount - other.amount, units);
    }

    /**
     * Multiplies this quantity by another.
     *
     * @param other the other quantity
     * @return the product quantity
     */
    public Quantity multiply(Quantity other) {
        return new Quantity(amount * other.amount, units.times(other.units));
    }

    /**
     * The multiplicative inverse (or reciprocal) of this quantity.
     *
     * @return the inverse
     */
    public Quantity inverse() {
        return new Quantity(1.0 / amount, units.inverse());
    }

    /**
     * Divides this quantity by another.
     *
     * @param other the other quantity
     * @return the quotient quantity
     */
    public Quantity divide(Quantity other) {
        return new Quantity(amount / other.amount, units.divide(other.units));
    }
}
