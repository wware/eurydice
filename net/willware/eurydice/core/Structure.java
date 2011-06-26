package net.willware.eurydice.core;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import net.willware.eurydice.math.Vector;
import net.willware.eurydice.forcefields.ForceField;

// TODO: Auto-generated Javadoc
/**
 * A structure is composed of a collection of atoms and jigs.
 * @see Atom
 * @see Jig
 */
public abstract class Structure {

    /** The unique UUID that identifies this structure. */
    protected UUID uuid;   // might need access to implement clone method

    /** The UUID of the parent structure, if this structure has a parent. */
    protected UUID parentUUID;

    /** The force field used to compute interatomic forces for this structure. */
    private ForceField forceField;

    /** a list of substructures, allowing structures to be hierarchical */
    protected List<Substructure> substructures;

    /**
     * Constructor.
     *
     * @param parentUUID the UUID of the parent structure, or null
     */
    public Structure(UUID parentUUID) {
        uuid = UUID.randomUUID();
        this.parentUUID = parentUUID;
        forceField = null;
        substructures = new java.util.ArrayList<Substructure>();
    }

    /**
     * The AtomProcessor interface is a convenient way to perform a batch operation on all
     * atoms in the structure. Gee, there should be one with a filter operation too.
     */
    public interface AtomProcessor {

        /**
         * Process the atom in some useful way.
         *
         * @param a the atom to be processed
         */
        public void process(Atom a);
    }

    /**
     * Apply a {@link AtomProcessor} instance to all the atoms in this structure.
     *
     * @param p the processor instance to apply
     */
    public void process(AtomProcessor p) {
        Iterator<Atom> iter = getIterator();
        while (iter.hasNext()) {
            p.process(iter.next());
        }
    }

    /**
     * The size of a structure is the number of atoms in it.
     *
     * @return the number of atoms in this structure
     */
    public abstract long size();
    /**
     * Give the index of an atom in the atom list, -1 if not found.
     * @param a the atom to be found
     * @return the index, or -1 if not found
     */
    public abstract long indexOf(Atom a);

    /**
     * Structures can have jigs (see {@link Jig}).
     *
     * @return the number of jigs in this structure
     */
    public abstract int numJigs();

    /**
     * Given an index into a structure's list of jig, return the corresponding jig.
     *
     * @param index an index into this structure's list of jigs
     * @return the jig for that index
     */
    public abstract Jig getJig(int index);
    /**
     * Versioning is done ala Git, with a tree structure built of parent links. Each version is
     * identified by a UUID, and all versions except the root have a non-null parent.
     * @return the UUID for this structure's parent, or null if it's a root
     */
    public UUID getParentUUID() {
        return parentUUID;
    }

    /**
     * Force fields (such as MM2 or GROMACS) compute forces just as jigs do, and share
     * the IJig interface. Set the force field for this position list.
     *
     * @param ff the new force field
     */
    public void setForceField(ForceField ff) {
        forceField = ff;
    }

    /**
     * Gets the force field currently assigned to this structure.
     *
     * @return the force field for this structure
     */
    public ForceField getForceField() {
        return forceField;
    }

    /**
     * Sets the unique UUID for this structure.
     *
     * @param uuid the new uUID
     */
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
    /**
     * Gets the unique UUID for this structure.
     *
     * @return the unique ID for this structure, may not be null
     */
    public UUID getUUID() {
        return uuid;
    }
    /**
     * A bounding box is useful. This is a promise from the position list that all
     * atom positions will be inside the returned region
     * @return a bounding box in 3-space containing all the atoms
     */
    public abstract Region getBoundingBox();

    /**
     * Gets the metadata for this structure, if any exists.
     *
     * @return metadata for this position list if any exists, otherwise null
     */
    public abstract Properties getMetadata();

    /**
     * Gets an atom from the structure's list of atoms, indexed by {@link Atom#getId()}.
     *
     * @param index an index into the list of atoms
     * @return the corresponding atom
     */
    public abstract Atom get(long index);

    /**
     * Sets an atom in the structure's list of atoms, indexed by {@link Atom#getId()}.
     *
     * @param index an index into the list of atoms
     * @param a the a
     */
    public abstract void set(long index, Atom a);
    /**
     * We like iterators because they're scalable.
     * @return an iterator over all the atoms in this structure
     */
    public abstract Iterator<Atom> getIterator();
    /**
     * If (x1, y1, z1) is the min corner of the region and (x2, y2, z2) is the max
     * corner of the region, then create a list of those atoms whose position (x,y,z)
     * satisfies x1 &lt;= x &lt; x2, y1 &lt;= y &lt; y2, z1 &lt;= z &lt; z2.
     * @param r a rectangular region of 3-space
     * @return a PositionList of those atoms inside that region
     */
    public abstract Structure sublist(Region r);

    /**
     * Produce a JSON representation of this structure, used for AJAX updates in web app.
     *
     * @return the JSON representation
     */
    public String toJson() {
        long numAtoms = 0;
        StringBuilder sb = new StringBuilder();
        Iterator<Atom> iter = getIterator();
        sb.append("{");
        while (iter.hasNext()) {
            Atom a = iter.next();
            Vector p = a.getPosition();
            sb.append("\"atom" + numAtoms + "\":{");
            sb.append("\"symbol\":\"");
            sb.append(a.symbol());
            sb.append("\",\"x\":");
            sb.append(p.getX());
            sb.append(",\"y\":");
            sb.append(p.getY());
            sb.append(",\"z\":");
            sb.append(p.getZ());
            sb.append("},");
            numAtoms++;
        }
        sb.append("\"numAtoms\":" + numAtoms);
        sb.append("}");
        return sb.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        try {
            Structure other = (Structure) obj;
            Iterator<Atom> iter1 = getIterator();
            Iterator<Atom> iter2 = other.getIterator();
            while (iter1.hasNext()) {
                Atom a1 = iter1.next();
                Atom a2 = iter2.next();
                if (!a1.name().equals(a2.name()))
                    throw new Exception();
                if (a1.getHybridization() != a2.getHybridization())
                    throw new Exception();
                if (a1.getCharge() != a2.getCharge())
                    throw new Exception();
                Vector pos1 = a1.getPosition();
                Vector pos2 = a2.getPosition();
                if (!pos1.approximatelyEqual(pos2))
                    throw new Exception();
            }
            if (iter2.hasNext())
                throw new Exception();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Infer the bonds for this structure, based on positions and types of atoms.
     *
     * @return a list of the bonds connecting the atoms in this structure
     */
    public abstract List<Bond> inferBonds();

    /**
     * Prepare for a Verlet integration.
     */
    public void verletPrep() {
        process(new AtomProcessor() {
            public void process(Atom a) {
                Vector pos = a.getPosition();
                a.setPreviousPosition(pos);
            }
        });
    }

    /**
     * This method implements the "Basic Verlet" step described in
     * http://en.wikipedia.org/wiki/Verlet_integration. The next position
     * equals the current position, plus current minus previous, plus
     * acceleration times the square of the time step. The acceleration
     * vector is 1/mass times the force vector.
     *
     * @param dt the time step for this integration
     */
    public void verletStep(final double dt) {
        // Do not compute forces here! This is ONLY integrating
        // equations of motion.
        process(new AtomProcessor() {
            public void process(Atom a) {
                Vector pos = a.getPosition();
                Vector previous = a.getPreviousPosition();
                if (previous == null)
                    previous = pos;
                Vector accel = a.getForce().scale(1.0 / a.mass());
                Vector newPos = pos.scale(2.0)
                                .subtract(previous).add(accel.scale(dt * dt));
                a.setPreviousPosition(pos);
                a.setPosition(newPos);
                a.zeroForce();
            }
        });
    }

    /**
     * Adds a substructure to the list of substructures.
     *
     * @param ss the substructure to be added
     */
    public void addSubstructure(Substructure ss) {
        substructures.add(ss);
    }

    /**
     * Removes a substructure from the list of substructures.
     *
     * @param ss the substructure to be removed
     */
    public void removeSubstructure(Substructure ss) {
        substructures.remove(ss);
    }

    /**
     * Gets the list of substructures.
     *
     * @return the substructures list
     */
    public List<Substructure> getSubstructures() {
        return substructures;
    }
}
