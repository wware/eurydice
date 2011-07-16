package net.willware.eurydice.core;

/**
 * A structure is composed of a collection of atoms and jigs, and can also contain
 * substructures.
 * @see Atom
 * @see Jig
 */
public interface StructureMutable extends Structure {

    /**
     * Adds an atom to this structure.
     *
     * @param a the atom to be added
     */
    void addAtom(Atom a);

    /**
     * Adds an atom to this structure, with a particular unique ID.
     *
     * @param a the atom to be added
     * @param id the unique ID for this atom
     */
    void addAtom(Atom a, UniqueId id);

    /**
     * Removes an atom from this structure.
     *
     * @param a the atom to be removed
     */
    void removeAtom(Atom a);

    /**
     * Adds a new jig to this structure.
     *
     * @param j the jig to be added
     */
    void addJig(Jig j);

    /**
     * Versioning is done ala Git, with a tree structure built of parent links. Each version is
     * identified by a UniqueId, and all versions except the root have a non-null parent.
     * @return the UniqueId for this structure's parent, or null if it's a root
     */
    void setParentUniqueId(UniqueId puid);

    /**
     * Gets the unique ID for this structure.
     *
     * @return the unique ID for this structure, may not be null
     */
    void getUniqueId(UniqueId uid);

}
