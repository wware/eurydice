package net.willware.eurydice.core;

/**
 * A unique identifier for an atom or structure. Implementors should
 * implement {@link #toString()} and {@link #equals(Object)}.
 */
public interface UniqueId {
    /**
     * Render this unique ID as an integer. If that can't be done, throw an exception.
     * Values should start at zero.
     *
     * @return the unique ID as an int if possible
     */
    public int toInteger() throws ClassCastException;
}
