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
public class AtomMutableImpl implements AtomMutable {
    /** The Constant hybridnames. */
    private static final String hybridnames[] = { "SP3", "SP2", "SP", "NONE" };

    private UniqueId id;

    /** The force. */
    private Vector position, previousPosition, force;

    // instance variables
    // ideally these would be accessed only with setters and getters

    /** The charge. */
    private int charge;

    /** The fractional charge. */
    private double fractionalCharge;

    /** The hybridization. */
    private int hybridization;

    /**
     * Instantiates a new atom.
     */
    public AtomMutableImpl() {
        position = new Vector();
        force = new Vector();
        previousPosition = null;
        setHybridization(NONE);
        setCharge(0);
        setFractionalCharge(0.0);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "<" + getSymbol() + " " + id + " " + hybridnames[getHybridization()] + ">";
    }

    /**
     * The Class BondInfo.
     */
    protected class BondInfo {

        /** The singles. */
        public int singles;

        /** The doubles. */
        public int doubles;

        /** The triples. */
        public int triples;
    }

    /**
     * Gets the my bonds.
     *
     * @param bonds the bonds
     * @return the my bonds
     */
    protected BondInfo getMyBonds(List<Bond> bonds) {
        BondInfo bi = new BondInfo();
        bi.singles = 0;
        bi.doubles = 0;
        bi.triples = 0;
        for (Bond b: bonds) {
            switch (b.getOrder()) {
            default:
                bi.singles++;
                break;
            case 2:
                bi.doubles++;
                break;
            case 3:
                bi.triples++;
                break;
            }
        }
        return bi;
    }
    // overload me, unless I'm hydrogen
    /**
     * Rehybridize this atom, given a list of bonds.
     * @param bonds a bond list
     */
    public void rehybridize(List<Bond> bonds) {
        hybridization = NONE;
    }

    /**
     * Sets the electrostatic charge for an ionized atom. This is not the
     * same as fractional charge resulting from a bond with an atom
     * of differing electronegativity, which forms an electric dipole moment.
     * @param charge the new charge
     */
    public void setCharge(int charge) {
        this.charge = charge;
    }

    /**
     * Gets the atom's charge due to ionization.
     *
     * @return the charge
     */
    public int getCharge() {
        return charge;
    }

    /**
     * Sets the fractional charge resulting from a bond with an atom
     * of differing electronegativity, which forms an electric dipole moment.
     *
     * @param fractionalCharge the new fractional charge
     */
    public void setFractionalCharge(double fractionalCharge) {
        this.fractionalCharge = fractionalCharge;
    }

    /**
     * Gets the fractional charge resulting from a bond with an atom
     * of differing electronegativity, which forms an electric dipole moment.
     *
     * @return the fractional charge
     */
    public double getFractionalCharge() {
        return fractionalCharge;
    }

    /**
     * Sets the hybridization of this atom.
     *
     * @param hybridization the new hybridization
     */
    public void setHybridization(int hybridization) {
        this.hybridization = hybridization;
    }

    /**
     * Gets the hybridization of this atom.
     *
     * @return the hybridization
     */
    public int getHybridization() {
        return hybridization;
    }

    /**
     * Gets the hybridization of this atom.
     *
     * @return the hybridization
     */
    public String getHybridizationString() {
        switch (hybridization) {
        default:
        case SP3:
            return "SP3";
        case SP2:
            return "SP2";
        case SP:
            return "SP";
        case NONE:
            return "NONE";
        }
    }

    /**
     * Sets the position vector of this atom.
     *
     * @param position the new position
     */
    public void setPosition(Vector position) {
        this.position = position;
    }

    /**
     * Move this atom by a delta position vector.
     *
     * @param delta the delta position vector
     */
    public void move(Vector delta) {
        position = position.add(delta);
    }

    /**
     * Gets the position vector of this atom.
     *
     * @return the position
     */
    public Vector getPosition() {
        return position;
    }

    /**
     * Sets the previous position of this atom, used in Verlet integration.
     *
     * @param previousPosition the new previous position
     */
    public void setPreviousPosition(Vector previousPosition) {
        this.previousPosition = previousPosition;
    }

    /**
     * Gets the previous position of this atom, used in Verlet integration.
     *
     * @return the previous position
     */
    public Vector getPreviousPosition() {
        return previousPosition;
    }

    /**
     * Sets the force vector acting on this atom.
     *
     * @param force the new force
     */
    public void setForce(Vector force) {
        this.force = force;
    }

    /**
     * Set the force vector of this atom to zero.
     */
    public void zeroForce() {
        if (force == null)
            force = new Vector();
        else {
            force.setX(0.0);
            force.setY(0.0);
            force.setZ(0.0);
        }
    }

    /**
     * Adds an increment vector to this atom's force vector.
     *
     * @param dforce the dforce
     */
    public void addForce(Vector dforce) {
        force = force.add(dforce);
    }

    /**
     * Gets the force vector acting on this atom.
     *
     * @return the force
     */
    public Vector getForce() {
        return force;
    }

    /**
     * Gets the 64-bit id for this atom, unique within its structure.
     *
     * @param id the new unique id
     * @return the id
     */
    public void setUniqueId(UniqueId id) {
        this.id = id;
    }

    /**
     * Gets the 64-bit id for this atom, unique within its structure.
     *
     * @return the id
     */
    public UniqueId getUniqueId() {
        return id;
    }

    private int atomicnumber;
    private Color color;
    private int numbonds;
    private double covalentradius;
    private double vdwradius;
    private double vdwenergy;
    private double mass;
    private String name;
    private String symbol;

    @Override
    public void setAtomicNumber(int n) {
        atomicnumber = n;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setCorrectNumBonds(int n) {
        numbonds = n;
    }

    @Override
    public void setCovalentRadius(double r) {
        covalentradius = r;
    }

    @Override
    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void setVdwEnergy(double e) {
        vdwenergy = e;
    }

    @Override
    public void setVdwRadius(double r) {
        vdwradius = r;
    }

    @Override
    public int getAtomicNumber() {
        return atomicnumber;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getCorrectNumBonds() {
        return numbonds;
    }

    @Override
    public double getCovalentRadius() {
        return covalentradius;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public double getVdwEnergy() {
        return vdwenergy;
    }

    @Override
    public double getVdwRadius() {
        return vdwradius;
    }
}
