/**
 * Atom.java - definition of an atom, elements are subclasses of atom
 * Copyright (c) 1997,1998,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.core;

import java.util.List;

import net.willware.eurydice.math.Vector;

/**
 * Atoms are those little bitty things that all (baryonic) stuff is made out of.
 */
public abstract class Atom {
    // hybridizations are a virtual enum
    /** NONE hybridization type. */
    public static final int NONE = 0;

    /** SP hybridization type. */
    public static final int SP = 1;

    /** SP2 hybridization type. */
    public static final int SP2 = 2;

    /** SP3 hybridization type. */
    public static final int SP3 = 3;

    /**
     * Get the unique ID for this atom.
     *
     * @return the unique ID
     */
    public abstract UniqueId getUniqueId();

    /**
     * Name.
     *
     * @return the name of the element, such as "Carbon" or "Hydrogen"
     */
    public abstract String getName();

    /**
     * Symbol.
     *
     * @return the official chemical symbol, such as "C" or "H"
     */
    public abstract String getSymbol();

    /**
     * Atomic number.
     *
     * @return the atomic number of this element
     */
    public abstract int getAtomicNumber();

    /**
     * Mass.
     *
     * @return the mass of this element (ignoring isotopes)
     */
    public abstract double getMass();

    /**
     * Color.
     *
     * @return the display color of this atom
     */
    public abstract Color getColor();

    /**
     * Covalent radius.
     *
     * @return the covalent radius of this atom, in angstroms
     */
    public abstract double getCovalentRadius();

    /**
     * Van-der-Waals energy; see Table 3.1 and Equation 3.8 in <i>Nanosystems</i>
     * by Drexler.
     *
     * @return the van-der-Waals energy
     */
    public abstract double getVdwEnergy();

    /**
     * Vdw radius.
     *
     * @return the van-der-Waals radius of this atom
     */
    public abstract double getVdwRadius();

    /**
     * Correct num bonds.
     *
     * @return the number of single bonds for this atom when SP3-hybridized,
     * such as 4 for carbon or 3 for nitrogen
     */
    public abstract int getCorrectNumBonds();

    // overload me, unless I'm hydrogen
    /**
     * Rehybridize this atom, given a list of bonds.
     * @param bonds a bond list
     */
    public abstract void rehybridize(List<Bond> bonds);

    /**
     * Sets the electrostatic charge for an ionized atom. This is not the
     * same as fractional charge resulting from a bond with an atom
     * of differing electronegativity, which forms an electric dipole moment.
     * @param charge the new charge
     */
    public abstract void setCharge(int charge);

    /**
     * Gets the atom's charge due to ionization.
     *
     * @return the charge
     */
    public abstract int getCharge();

    /**
     * Sets the fractional charge resulting from a bond with an atom
     * of differing electronegativity, which forms an electric dipole moment.
     *
     * @param fractionalCharge the new fractional charge
     */
    public abstract void setFractionalCharge(double fractionalCharge);

    /**
     * Gets the fractional charge resulting from a bond with an atom
     * of differing electronegativity, which forms an electric dipole moment.
     *
     * @return the fractional charge
     */
    public abstract double getFractionalCharge();

    /**
     * Sets the hybridization of this atom. Needed for rehybridization.
     *
     * @param hybridization the new hybridization
     */
    public abstract void setHybridization(int hybridization);

    /**
     * Gets the hybridization of this atom using one of the integer constants
     * such as {@link #SP3}, {@link #SP2}, {@link #SP} or {@link #NONE}.
     *
     * @return the hybridization as an integer
     */
    public abstract int getHybridization();

    /**
     * Gets the hybridization of this atom as a string, for example
     * "SP3", "SP2", "SP" for most small atoms, or "NONE" for hydrogen.
     *
     * @return the hybridization as a string
     */
    public abstract String getHybridizationString();

    /**
     * Sets the position vector of this atom.
     *
     * @param position the new position
     */
    public abstract void setPosition(Vector position);

    /**
     * Move this atom by a delta position vector.
     *
     * @param delta the delta position vector
     */
    public abstract void move(Vector delta);

    /**
     * Gets the position vector of this atom.
     *
     * @return the position
     */
    public abstract Vector getPosition();

    /**
     * Sets the previous position of this atom, used in Verlet integration.
     *
     * @param previousPosition the new previous position
     */
    public abstract void setPreviousPosition(Vector previousPosition);

    /**
     * Gets the previous position of this atom, used in Verlet integration.
     *
     * @return the previous position
     */
    public abstract Vector getPreviousPosition();

    /**
     * Sets the force vector acting on this atom.
     *
     * @param force the new force
     */
    public abstract void setForce(Vector force);

    /**
     * Set the force vector of this atom to zero.
     */
    public abstract void zeroForce();

    /**
     * Adds an increment vector to this atom's force vector.
     *
     * @param dforce the dforce
     */
    public abstract void addForce(Vector dforce);

    /**
     * Gets the force vector acting on this atom.
     *
     * @return the force
     */
    public abstract Vector getForce();

    public interface Factory {
        public Atom newInstance();
    }
    private static class DefaultFactory implements Factory {
        public Atom newInstance() {
            return new AtomMutableImpl();
        }
    }
    private static Factory factory = null;
    public static void setFactory(Factory f) {
        factory = f;
    }
    public static Atom newInstance() {
        if (factory == null)
            factory = new DefaultFactory();
        return factory.newInstance();
    }
}
