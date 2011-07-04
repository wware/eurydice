package net.willware.eurydice.core;

import java.util.HashMap;

/**
 * Global settings for the Eurydice code base should be loadable from a file.
 */
public class Properties extends HashMap<String,String> {

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;

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

    public void setProperty(String key, String value) {
        put(key, value);
    }

    public String getProperty(String key) {
        return get(key);
    }

    /**
     * Gets a settings value, insisting that it not be a null or empty string.
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
