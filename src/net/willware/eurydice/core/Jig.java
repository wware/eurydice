package net.willware.eurydice.core;

import java.util.List;

/**
 * A jig can be used to apply external forces to the atoms in a structure, or to perform
 * measurements on the structure. Examples of external forces would be anchors that hold
 * some atoms at fixed positions, or linear or rotary motors that apply linear or rotational
 * forces to some of the atoms in a structure. Examples of measurements could be temperature
 * (averaging Brownian motion over a few time steps), or lengths or angles.
 */
public abstract class Jig {

    /**
     * Compute a map of force vector based on atom positions. The keys are atom indices
     * and the values are the force vectors applicable to each atom.
     *
     * @param struc the struc
     */
    public abstract void computeForces();

    /**
     * Return a list of indices for the atoms this jig is connected to.
     *
     * @return the list
     */
    public abstract List<UniqueId> getAtomIndices();

    /**
     * Jigs have properties.
     *
     * @param str a stringified Properties instance to import stuff from
     */
    public abstract void loadProperties(String str);

    /**
     * Set all the properties of this jig.
     *
     * @param p the new Properties for this jig
     */
    public abstract void setProperties(Properties p);

    /**
     * Set a property of this jig.
     *
     * @param key the key of the property
     * @param value the value of the property
     */
    public abstract void setProperty(String key, String value);

    /**
     * Jigs have properties.
     *
     * @return the properties
     * @returns the properties of this jig
     */
    public abstract Properties getProperties();

    /**
     * Jigs refer to specific Structures.
     *
     * @return the struc
     * @returns the structure to which this jig applies
     */
    public abstract Structure getStructure();

    /**
     * Creates an instance of a jig, given the name
     *
     * @param struc the struc
     * @param jigName the jig name
     * @return the jig
     */
    public static JigMutable getJig(Structure struc, String jigName) {
        JigMutable j;
        if ("net.willware.eurydice.forcefields.mm2.MM2".equals(jigName))
            j = new net.willware.eurydice.forcefields.mm2.MM2();
        else
            throw new RuntimeException("cannot find jig: " + jigName);
        j.setStructure(struc);
        j.setProperties(new Properties());
        return j;
    }
}
