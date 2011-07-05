package net.willware.eurydice.core;

import java.util.HashMap;

/**
 * Useful repository for various kinds of metadata. For instance, global settings
 * for the Eurydice code base should be loadable from a file. This is intended as a
 * GWT-JavaScript-safe version of java.util.Properties.
 */
public class Properties extends HashMap<String,String> {

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;

    /**
     * Load properties settings from a string. The string could be the contents of a file.
     *
     * @param s the s
     */
    public void load(String s) {
        for (String s2 : s.split("\n")) {
            String[] fields = s2.split("=");
            if (fields.length == 2) {
                String key = fields[0];
                String value = fields[1];
                put(key, value);
            }
        }
    }

    /**
     * Set a settings value.
     *
     * @param key the key
     * @param value the value
     */
    public void setProperty(String key, String value) {
        put(key, value);
    }

    /**
     * Get a settings value.
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(String key) {
        return get(key);
    }

    /**
     * Get a settings value, insisting that it not be a null or empty string.
     *
     * @param key the key
     * @return the non-null settings value
     */
    public String getNonNull(String key) {
        String value = this.get(key);
        if (value == null || value.isEmpty())
            throw new RuntimeException("No setting found for " + key);
        return value;
    }
}
