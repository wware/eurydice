package net.willware.eurydice.core;

/**
 * A unique identifier for an atom or structure. Implementors should
 * implement {@link #toString()} and {@link #equals(Object)}.
 */
public abstract class UniqueIdSettable extends UniqueId {
    public abstract void setNumericValue(int n);
}
