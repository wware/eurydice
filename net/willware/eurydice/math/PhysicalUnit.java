package net.willware.eurydice.math;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Physical units can be multiplied and divided, and some (m, s, g, C) are fundamental.
 */
public class PhysicalUnit extends HashMap<String,Integer> {

    public static final long serialVersionUID = 1;

    public static class Mismatch extends RuntimeException {
        public static final long serialVersionUID = 1;
    }

    /** The metric prefix KILO. */
    public static final double KILO = 1000.0;

    /** The metric prefix MEGA. */
    public static final double MEGA = KILO * KILO;

    /** The metric prefix GIGA. */
    public static final double GIGA = KILO * MEGA;

    /** The metric prefix TERA. */
    public static final double TERA = KILO * GIGA;

    /** The metric prefix PETA. */
    public static final double PETA = KILO * TERA;

    /** The metric prefix EXA. */
    public static final double EXA = KILO * PETA;

    /** The metric prefix MILLI. */
    public static final double MILLI = 0.001;

    /** The metric prefix MICRO. */
    public static final double MICRO = MILLI * MILLI;

    /** The metric prefix NANO. */
    public static final double NANO = MILLI * MICRO;

    /** The metric prefix PICO. */
    public static final double PICO = MILLI * NANO;

    /** The metric prefix PICO. */
    public static final double FEMTO = MILLI * PICO;

    /** The metric prefix PICO. */
    public static final double ATTO = MILLI * FEMTO;

    private static PhysicalUnit fundamental(final String abbrev) {
        PhysicalUnit y = new PhysicalUnit();
        y.put(abbrev, 1);
        return y;
    }

    /**
     * Meter.
     *
     * @return the physical unit
     */
    public static PhysicalUnit meter() {
        return fundamental("m");
    }

    /**
     * Gram.
     *
     * @return the physical unit
     */
    public static PhysicalUnit gram() {
        return fundamental("g");
    }

    /**
     * Second.
     *
     * @return the physical unit
     */
    public static PhysicalUnit second() {
        return fundamental("s");
    }

    /**
     * Coulomb.
     *
     * @return the physical unit
     */
    public static PhysicalUnit coulomb() {
        return fundamental("C");
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> keyIter = keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            int power = get(key);
            sb.append(" " + key);
            if (power != 1)
                sb.append("^" + power);
        }
        return sb.toString().substring(1);
    }

    public static boolean matches(PhysicalUnit unit1, PhysicalUnit unit2) {
        if (unit1 == null && unit2 == null)
            return true;
        if (unit1 == null || unit2 == null)
            return false;
        return unit1.equals(unit2);
    }

    public boolean equals(Object x) {
        PhysicalUnit u;
        if (x == null)
            return false;
        try {
            u = (PhysicalUnit) x;
        } catch (Exception e) {
            return false;
        }
        // make sure the other guy has all the same units I have
        Iterator<String> keyIter = keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            if (u.get(key) != get(key))
                return false;
        }
        // make sure he doesn't have any other units
        keyIter = u.keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            if (!containsKey(key))
                return false;
        }
        return true;
    }

    /**
     * Multiply by another PhysicalUnit.
     *
     * @param other the other
     * @return the product physical unit
     */
    public PhysicalUnit times(PhysicalUnit other) {
        PhysicalUnit result = new PhysicalUnit();
        Iterator<String> keyIter = keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            int power = get(key);
            result.put(key, power);
        }
        keyIter = other.keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            int power = other.get(key);
            if (result.containsKey(key)) {
                power += result.get(key);
            }
            result.put(key, power);
        }
        return result;
    }

    public PhysicalUnit inverse() {
        PhysicalUnit result = new PhysicalUnit();
        Iterator<String> keyIter = keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            result.put(key, -get(key));
        }
        return result;
    }

    /**
     * Divide by another PhysicalUnit.
     *
     * @param other the other
     * @return the quotient physical unit
     */
    public PhysicalUnit divide(PhysicalUnit other) {
        return times(other.inverse());
    }

    /**
     * Tests.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        PhysicalUnit m = meter();
        PhysicalUnit g = gram();
        PhysicalUnit sec = second();
        PhysicalUnit millinewton = m.times(g).divide(sec.times(sec));
        System.out.println(millinewton);
    }
}
