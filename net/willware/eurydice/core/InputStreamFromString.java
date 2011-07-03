package net.willware.eurydice.core;

import java.io.InputStream;

/**
 * The Class InputStreamFromString.
 */
public class InputStreamFromString extends InputStream {

    /** The s. */
    private String s;

    /** The index. */
    private int index;

    /**
     * Instantiates a new input stream from string.
     *
     * @param s the s
     */
    public InputStreamFromString(String s) {
        this.s = s;
        index = 0;
    }

    /* (non-Javadoc)
     * @see java.io.InputStream#read()
     */
    public int read() {
        if (index >= s.length())
            return -1;
        return (int) s.charAt(index++);
    }
}