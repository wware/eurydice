package net.willware.eurydice.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Global settings for the Eurydice codebase, loaded from a file.
 */
public class Settings extends Properties {

    /** The Constant serialVersionUID. */
    public static final long serialVersionUID = 1;

    private static Settings globalSettings = null;

    /**
     * Load Eurydice settings from a settings file, whose location is given by the
     * environment variable "EURYDICE_SETTINGS". This should work on any platform.
     *
     * @return the settings from the file
     * @throws IOException if there are any I/O problems with the settings file
     */
    public static Settings getGlobalSettings() throws IOException {
        if (globalSettings == null) {
            globalSettings = new Settings();
            InputStream is = new FileInputStream(System.getenv().get("EURYDICE_SETTINGS"));
            globalSettings.load(is);
            is.close();
        }
        return globalSettings;
    }

    /**
     * Gets a settings value, insisting that it not be a null or empty string.
     *
     * @param key the key
     * @return the non-null settings value
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public String getNonNull(String key) {
        String value = this.getProperty(key);
        if (value == null || value.isEmpty())
            throw new RuntimeException("No setting found for " + key);
        return value;
    }
}
