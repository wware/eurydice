package net.willware.eurydice.core;

import java.util.Iterator;
import java.util.List;

import net.willware.eurydice.math.Region;

/**
 * A structure is composed of a collection of atoms and jigs, and can also contain
 * substructures.
 * @see Atom
 * @see Jig
 */
public interface Structure {

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
    public void process(AtomProcessor p);

    /**
     * The size of a structure is the number of atoms in it.
     *
     * @return the number of atoms in this structure
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    public int size() throws IndexOutOfBoundsException;
    /**
     * Give the index of an atom in the atom list, -1 if not found.
     * @param a the atom to be found
     * @return the index, or -1 if not found
     */
    public long indexOf(Atom a);

    /**
     * Structures can have jigs (see {@link Jig}).
     *
     * @return the number of jigs in this structure
     */
    public int numJigs();

    /**
     * Given an index into a structure's list of jig, return the corresponding jig.
     *
     * @param index an index into this structure's list of jigs
     * @return the jig for that index
     */
    public abstract Jig getJig(int index);
    /**
     * Versioning is done ala Git, with a tree structure built of parent links. Each version is
     * identified by a UniqueId, and all versions except the root have a non-null parent.
     * @return the UniqueId for this structure's parent, or null if it's a root
     */
    public UniqueId getParentUniqueId();

    /**
     * Gets the unique ID for this structure.
     *
     * @return the unique ID for this structure, may not be null
     */
    public UniqueId getUniqueId();
    /**
     * A bounding box is useful. This is a promise from the position list that all
     * atom positions will be inside the returned region
     * @return a bounding box in 3-space containing all the atoms
     */
    public Region getBoundingBox();

    /**
     * Gets the metadata for this structure, if any exists.
     *
     * @return metadata for this position list if any exists, otherwise null
     */
    public Properties getMetadata();

    /**
     * Gets an atom from the structure's list of atoms, indexed by {@link Atom#getUniqueId()}.
     *
     * @param index an index into the list of atoms
     * @return the corresponding atom
     */
    public Atom get(UniqueId index);

    /**
     * Gets an atom from the structure's list of atoms, indexed by an int, if applicable.
     *
     * @param index an index into the list of atoms
     * @return the corresponding atom
     */
    public Atom get(int index);

    /**
     * We like iterators because they're scalable.
     * @return an iterator over all the atoms in this structure
     */
    public Iterator<Atom> getIterator();
    /**
     * If (x1, y1, z1) is the min corner of the region and (x2, y2, z2) is the max
     * corner of the region, then create a list of those atoms whose position (x,y,z)
     * satisfies x1 &lt;= x &lt; x2, y1 &lt;= y &lt; y2, z1 &lt;= z &lt; z2.
     * @param r a rectangular region of 3-space
     * @return a Struction containing only those atoms inside that region
     */
    public Structure sublist(Region r);

    /**
     * Produce a JSON representation of this structure, used for AJAX updates in web app.
     *
     * @return the JSON representation
     */
    public String toJson();

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    public boolean equals(Object obj);

    /**
     * Infer the bonds for this structure, based on positions and types of atoms.
     *
     * @return a list of the bonds connecting the atoms in this structure
     */
    public List<Bond> inferBonds();

    /**
     * Prepare for a Verlet integration.
     */
    public void verletPrep();

    /**
     * This method implements the "Basic Verlet" step described in
     * http://en.wikipedia.org/wiki/Verlet_integration. The next position
     * equals the current position, plus current minus previous, plus
     * acceleration times the square of the time step. The acceleration
     * vector is 1/mass times the force vector.
     *
     * @param dt the time step for this integration
     */
    public void verletStep(double dt);

    /**
     * Adds a substructure to the list of substructures.
     *
     * @param s the substructure to be added
     */
    public void addSubstructure(Substructure s);

    /**
     * Removes a substructure from the list of substructures.
     *
     * @param s the substructure to be removed
     */
    public void removeSubstructure(Substructure s);

    /**
     * Gets the list of substructures.
     *
     * @return the substructures list
     */
    public List<Substructure> getSubstructures();
}
