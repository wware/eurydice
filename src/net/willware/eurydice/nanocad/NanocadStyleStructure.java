/**
 * Structure.java - group of atoms and terms
 * Copyright (c) 1997,1998,1999,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.nanocad;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.JigMutableImpl;
import net.willware.eurydice.core.StructureMutableImpl;
import net.willware.eurydice.core.UniqueId;
import net.willware.eurydice.forcefields.ForceField;
import net.willware.eurydice.math.Vector;

/**
 * NanoCAD was a Java applet I wrote in 1997, hoping that I'd find the time and energy
 * to make it a useful tool for nanotechnological design.
 */
public class NanocadStyleStructure extends StructureMutableImpl {

    /** flag indicating the structure has changed since the last time it was saved. */
    private boolean changedSinceLastSave = false;

    /** flag indicating whether force vectors should be included in display. */
    private boolean showForces = false;

    /** arbitrary multiplier for length of force vectors, chosen for visual clarity. */
    private double forceMultiplier = 100.0;

    /** the center of gravity of this structure in 3-space. */
    private Vector centerOfGravity;

    /**
     * Constructor.
     */
    public NanocadStyleStructure() {
        empty();
    }

    /**
     * Constructor.
     *
     * @param pid the parent unique id
     */
    public NanocadStyleStructure(UniqueId pid) {
        setParentUniqueId(pid);
        empty();
    }

    /**
     * Empty.
     */
    public void empty() {
        changedSinceLastSave = true;
        setForceField((ForceField) JigMutableImpl.getJig(this,
                      "net.willware.eurydice.forcefields.mm2.MM2"));
    }

    /**
     * Sets the show forces.
     *
     * @param sf the new show forces
     */
    public void setShowForces(boolean sf) {
        setShowForceVectors(sf);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.SmallStructure#addAtom(net.willware.eurydice.core.Atom)
     */
    public void addAtom(Atom a) {
        super.addAtom(a);
        changedSinceLastSave = true;
    }

    /**
     * Center the atoms in this structure around the point (0,0,0) in 3-space.
     */
    public void centerAtoms() {
        centerOfGravity = new Vector();   // start at (0,0,0)
        process(new AtomProcessor() {
            public void process(Atom a) {
                centerOfGravity = centerOfGravity.add(a.getPosition());
            }
        });
        centerOfGravity = centerOfGravity.scale(-1.0 / size());
        process(new AtomProcessor() {
            public void process(Atom a) {
                a.move(centerOfGravity);
            }
        });
    }

    /**
     * Compute the structure's internal forces, using the force field assigned
     * to this structure.
     */
    public void computeInternalForces() {
        ForceField ff = getForceField();
        if (ff != null)
            ff.computeForces();
    }

    /**
     * Perform an energy minimization step.
     *
     * @param stepsize a parameter for trying to keep this process stable
     */
    public void energyMinimizeStep(final double stepsize) {
        computeInternalForces();
        process(new AtomProcessor() {
            public void process(Atom a) {
                Vector force = a.getForce();
                double flen = force.length();
                if (flen > 0.0) {
                    double m = stepsize / flen;
                    a.move(force.scale(m));
                }
            }
        });
    }

    /* These are used for the stuff in the library. */

    /**
     * Adds the bond.
     *
     * @param index1 the index of one atom
     * @param index2 the index of the other atom
     * @param order the order of the bond
     */
    public void addBond(int index1, int index2, int order) {
        // let's infer bonds instead of explicitly adding them
        // but all those addBond calls are still in the library package
        // too bad it's hard to infer bond order
    }

    /**
     * Adds the bond.
     *
     * @param index1 the index of one atom
     * @param index2 the index of the other atom
     */
    public void addBond(int index1, int index2) {
        // let's infer bonds instead of explicitly adding them
        // but all those addBond calls are still in the library package
    }

    /**
     * Adds an atom to this structure. Used extensively in {@link net.willware.eurydice.library}.
     *
     * @param a the atom to be added
     * @param vector the position vector of the atom
     */
    public void addAtom(Atom a, Vector vector) {
        a.setPosition(vector);
        addAtom(a);
    }

    /**
     * Tells whether the structure has changed since the last time it was saved.
     *
     * @return true if the structure has changed and will need re-saving
     */
    public boolean hasChangedSinceLastSave() {
        return changedSinceLastSave;
    }

    /**
     * Sets an arbitrary constant controlling the length of displayed force vectors, chosen
     * for visual clarity.
     *
     * @param forceMultiplier the new force multiplier
     */
    public void setForceMultiplier(double forceMultiplier) {
        this.forceMultiplier = forceMultiplier;
    }

    /**
     * Gets an arbitrary constant controlling the length of displayed force vectors, chosen
     * for visual clarity.
     *
     * @return the force multiplier
     */
    public double getForceMultiplier() {
        return forceMultiplier;
    }

    /**
     * Sets the flag indicating whether to include force vectors in visual display of structure.
     *
     * @param showForces new value for whether to display force vectors
     */
    public void setShowForceVectors(boolean showForces) {
        this.showForces = showForces;
    }

    /**
     * Should show force vectors.
     *
     * @return true if force vectors should be included in visual display of structure
     */
    public boolean shouldShowForceVectors() {
        return showForces;
    }
}

