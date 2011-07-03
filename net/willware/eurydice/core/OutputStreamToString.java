package net.willware.eurydice.core;

import java.io.OutputStream;

/**
 * OutputStreamToString is a handy class that saves characters written to an
 * OutputStream, then presents them as a String.
 */
public class OutputStreamToString extends OutputStream {

    /** Characters are stored in a StringBuffer. */
    private StringBuilder sb;

    /**
     * Constructor.
     */
    public OutputStreamToString() {
        sb = new StringBuilder();
    }

    /* (non-Javadoc)
     * @see java.io.OutputStream#write(int)
     */
    public void write(int x) {
        sb.append((char) x);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return sb.toString();
    }
}