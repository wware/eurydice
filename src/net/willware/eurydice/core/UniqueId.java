package net.willware.eurydice.core;

/**
 * A unique identifier for an atom or structure. Implementors should
 * implement {@link #toString()} and {@link #equals(Object)}.
 */
public abstract class UniqueId implements Comparable<UniqueId> {

    /**
     * Render this unique ID as an integer. If that can't be done, throw an exception.
     * Values should start at zero.
     *
     * @return the unique ID as an int if possible
     * @throws ClassCastException the class cast exception
     */
    public abstract int toInteger() throws ClassCastException;

    public interface Factory {
        public UniqueId newInstance();
    }
    private static class DefaultFactory implements Factory {
        public UniqueId newInstance() {
            return new UniqueIdSettableImpl();
        }
    }
    private static Factory factory = null;
    public static void setFactory(Factory f) {
        factory = f;
    }
    public static UniqueId newInstance() {
        if (factory == null)
            factory = new DefaultFactory();
        return factory.newInstance();
    }
}
