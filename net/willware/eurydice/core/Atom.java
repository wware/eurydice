/**
 * Atom.java - definition of an atom, elements are subclasses of atom
 * Copyright (c) 1997,1998,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.core;

import java.util.List;

import net.willware.eurydice.math.Vector;
import net.willware.eurydice.view.Color;
import net.willware.eurydice.view.DrawingEngine;

/**
 * Atoms are those little bitty things that all (baryonic) stuff is made out of.
 */
public interface Atom {
    // hybridizations are a virtual enum
    /** SP3 hybridization type. */
    public static final int SP3 = 0;

    /** SP2 hybridization type. */
    public static final int SP2 = 1;

    /** SP hybridization type. */
    public static final int SP = 2;

    /** NONE hybridization type. */
    public static final int NONE = 3;

    // these should be defined within elements, as class variables
    /**
     * Name.
     *
     * @return the name of the element, such as "Carbon" or "Hydrogen"
     */
    public String name();

    /**
     * Symbol.
     *
     * @return the official chemical symbol, such as "C" or "H"
     */
    public abstract String symbol();

    /**
     * Atomic number.
     *
     * @return the atomic number of this element
     */
    public abstract int atomicNumber();

    /**
     * Mass.
     *
     * @return the mass of this element (ignoring isotopes)
     */
    public abstract double mass();

    /**
     * Color.
     *
     * @param de an instance of a DrawingEngine
     * @return the display color of this atom
     */
    public abstract Color color(DrawingEngine de);

    /**
     * Covalent radius.
     *
     * @return the covalent radius of this atom, in angstroms
     */
    public abstract double covalentRadius();

    /**
     * Vdw energy.
     *
     * @return the van-der-Waals energy
     */
    public abstract double vdwEnergy();

    /**
     * Vdw radius.
     *
     * @return the van-der-Waals radius of this atom
     */
    public abstract double vdwRadius();

    /**
     * Correct num bonds.
     *
     * @return the number of single bonds for this atom when SP3-hybridized,
     * such as 4 for carbon or 3 for nitrogen
     */
    public abstract int correctNumBonds();

    // overload me, unless I'm hydrogen
    /**
     * Rehybridize this atom, given a list of bonds.
     * @param bonds a bond list
     */
    public void rehybridize(List<Bond> bonds);

    /**
     * Sets the electrostatic charge for an ionized atom. This is not the
     * same as fractional charge resulting from a bond with an atom
     * of differing electronegativity, which forms an electric dipole moment.
     * @param charge the new charge
     */
    public void setCharge(int charge);

    /**
     * Gets the atom's charge due to ionization.
     *
     * @return the charge
     */
    public int getCharge();

    /**
     * Sets the fractional charge resulting from a bond with an atom
     * of differing electronegativity, which forms an electric dipole moment.
     *
     * @param fractionalCharge the new fractional charge
     */
    public void setFractionalCharge(double fractionalCharge);

    /**
     * Gets the fractional charge resulting from a bond with an atom
     * of differing electronegativity, which forms an electric dipole moment.
     *
     * @return the fractional charge
     */
    public double getFractionalCharge();

    /**
     * Sets the hybridization of this atom.
     *
     * @param hybridization the new hybridization
     */
    public void setHybridization(int hybridization);

    /**
     * Gets the hybridization of this atom using one of the integer constants
     * such as {@link #SP3}, {@link #SP2}, {@link #SP} or {@link #NONE}.
     *
     * @return the hybridization as an integer
     */
    public int getHybridization();

    /**
     * Gets the hybridization of this atom as a string, for example
     * "SP3", "SP2", "SP" for most small atoms, or "NONE" for hydrogen.
     *
     * @return the hybridization as a string
     */
    public String getHybridizationString();

    /**
     * Sets the position vector of this atom.
     *
     * @param position the new position
     */
    public void setPosition(Vector position);

    /**
     * Move this atom by a delta position vector.
     *
     * @param delta the delta position vector
     */
    public void move(Vector delta);

    /**
     * Gets the position vector of this atom.
     *
     * @return the position
     */
    public Vector getPosition();

    /**
     * Sets the previous position of this atom, used in Verlet integration.
     *
     * @param previousPosition the new previous position
     */
    public void setPreviousPosition(Vector previousPosition);

    /**
     * Gets the previous position of this atom, used in Verlet integration.
     *
     * @return the previous position
     */
    public Vector getPreviousPosition();

    /**
     * Sets the force vector acting on this atom.
     *
     * @param force the new force
     */
    public void setForce(Vector force);

    /**
     * Set the force vector of this atom to zero.
     */
    public void zeroForce();

    /**
     * Adds an increment vector to this atom's force vector.
     *
     * @param dforce the dforce
     */
    public void addForce(Vector dforce);

    /**
     * Gets the force vector acting on this atom.
     *
     * @return the force
     */
    public Vector getForce();

    /**
     * Set the unique ID for this atom.
     *
     * @param id the new unique id
     */
    public void setUniqueId(UniqueId id);

    /**
     * Get the unique ID for this atom.
     *
     * @return the unique ID
     */
    public UniqueId getUniqueId();
}
