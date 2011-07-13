package net.willware.eurydice.core;

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
     * Creates an instance of a jig, given the name.
     *
     * @param struc the struc
     * @param jigName the jig name
     * @return the jig
     * public static JigImpl getJig(Structure struc, String jigName) {
     * // handle simple jigs
     * // handle force fields
     * try {
     * // The newInstance() call is a work around for some broken Java implementations
     * // I think we just instantiate it and forget it, only need to do that once
     * // It's a bad idea to do imports of com.mysql.jdbc things for some reason
     * JigImpl j = (JigImpl) Class.forName(jigName).newInstance();
     * j.properties = new Properties();
     * j.struc = struc;
     * return j;
     * } catch (Exception ex) {
     * throw new RuntimeException(ex);
     * }
     * }
     */

    protected JigImpl(Structure struc) {
        this.struc = struc;
    }

    /**
     * Creates an instance of a jig, given the name
     *
     * @param struc the struc
     * @param jigName the jig name
     * @return the jig
     */
    public static JigImpl getJig(Structure struc, String jigName) {
        if (!"net.willware.eurydice.forcefields.mm2.MM2".equals(jigName))
            throw new RuntimeException("cannot handle jig named " + jigName);
        JigImpl j = new net.willware.eurydice.forcefields.mm2.MM2(struc);
        j.properties = new Properties();
        return j;
    }

    /**
     * Jigs have properties.
     *
     * @param str a stringified Properties instance to import stuff from
     */
    public void loadProperties(String str) {
        properties.load(str);
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
        properties.put(key, value);
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
