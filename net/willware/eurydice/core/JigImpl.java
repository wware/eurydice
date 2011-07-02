package net.willware.eurydice.core;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import net.willware.eurydice.serialization.InputStreamFromString;

/**
 * A jig can be used to apply external forces to the atoms in a structure, or to perform
 * measurements on the structure. Examples of external forces would be anchors that hold
 * some atoms at fixed positions, or linear or rotary motors that apply linear or rotational
 * forces to some of the atoms in a structure. Examples of measurements could be temperature
 * (averaging Brownian motion over a few time steps), or lengths or angles.
 */
public abstract class JigImpl implements Jig {

    /** The properties. */
    private Properties properties;
    /** The structure to which this jig applies. */
    private Structure struc;

    /**
     * Gets the jig.
     *
     * @param struc the struc
     * @param jigName the jig name
     * @return the jig
     */
    public static JigImpl getJig(Structure struc, String jigName) {
        // handle simple jigs
        // handle force fields
        try {
            // The newInstance() call is a work around for some broken Java implementations
            // I think we just instantiate it and forget it, only need to do that once
            // It's a bad idea to do imports of com.mysql.jdbc things for some reason
            JigImpl j = (JigImpl) Class.forName(jigName).newInstance();
            j.properties = new Properties();
            j.struc = struc;
            return j;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        //if ("NanocadStyleMM2".equals(jigName))
        //    return new NanocadStyleMM2((NanocadStyleStructure) struc);
    }

    /**
     * Return a list of indices for the atoms this jig is connected to.
     *
     * @return the list
     */
    public abstract List<Long> atomIndices();

    /**
     * Compute a map of force vector based on atom positions. The keys are atom indices
     * and the values are the force vectors applicable to each atom.
     *
     * @param struc the struc
     */
    public abstract void computeForces(Structure struc);

    /**
     * Jigs have properties.
     *
     * @param str a stringified Properties instance to import stuff from
     */
    public void loadProperties(String str) {
        try {
            properties.load(new InputStreamFromString(str));
        } catch (IOException ex) { }
    }

    /**
     * Set all the properties of this jig.
     *
     * @param p the new Properties for this jig
     */
    public void setProperties(Properties p) {
        properties = p;
    }

    /**
     * Set a property of this jig.
     *
     * @param key the key of the property
     * @param value the value of the property
     */
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    /**
     * Jigs have properties.
     *
     * @return the properties
     * @returns the properties of this jig
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Jigs refer to specific Structures.
     *
     * @return the struc
     * @returns the structure to which this jig applies
     */
    public Structure getStruc() {
        return struc;
    }
}
