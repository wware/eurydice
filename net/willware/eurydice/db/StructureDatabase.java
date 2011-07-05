package net.willware.eurydice.db;

import net.willware.eurydice.core.Structure;
import net.willware.eurydice.core.UniqueId;
import net.willware.eurydice.math.Region;

/**
 * This is the fundamental API for storing and fetching structures in any kind of
 * database. This provides an abstraction layer to conceal details like whether the
 * database is an RDBMS or some non-SQL thing, and whether it runs locally or remotely.
 */
public interface StructureDatabase {

    /**
     * Store a structure, or a portion of a structure. Two store operations will be assumed
     * to refer to the same structure if the structure arguments share the same unique ID (see
     *
     * @param s      a structure to be stored
     * @return       true if database operation is successful
     * {@link Structure#getUniqueId()}). This allows very large structures to be stored in a
     * database incrementally, or to be processed in pieces.
     */
    public boolean store(Structure s);

    /**
     * Fetch a structure corresponding to a given unique ID.
     *
     * @param id        a unique ID for the structure being fetched
     * @return          the structure being sought, or null if not found
     */
    public Structure fetch(UniqueId id);

    /**
     * Fetch a substructure bounded by a rectangular region of 3-space.
     *
     * @param id        a unique ID for the structure being fetched
     * @param r         the {@link Region} within which atoms are being fetched
     * @return          the portion of the structure bounded by the region, or null if not found
     */
    public Structure fetchByRegion(UniqueId id, Region r);
}
