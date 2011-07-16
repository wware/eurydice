package net.willware.eurydice.core;

/**
 * A jig can be used to apply external forces to the atoms in a structure, or to perform
 * measurements on the structure. Examples of external forces would be anchors that hold
 * some atoms at fixed positions, or linear or rotary motors that apply linear or rotational
 * forces to some of the atoms in a structure. Examples of measurements could be temperature
 * (averaging Brownian motion over a few time steps), or lengths or angles.
 */
public interface JigMutable extends Jig {

    /**
     * Set the properties.
     *
     * @param the properties
     */
    void setProperties(Properties properties);

    /**
     * Set the structure to which this jig refers.
     *
     * @param the struc
     */
    void setStructure(Structure struc);
}
