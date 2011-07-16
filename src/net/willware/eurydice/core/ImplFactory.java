package net.willware.eurydice.core;

import java.util.HashMap;

/**
 * An ImplFactory is a singleton that maps interface classes to their implementations.
 * This is helpful for <a href="http://en.wikipedia.org/wiki/Dependency_injection">Dependency
 * injection</a>. If you need access to a Foo object, you don't want to hardcode a reference
 * to a particular implementation in your code, you want to request an implementation based
 * only on what interface you're looking for.
 * <pre>     ImplFactory factory = ImplFactory.getInstance();
 *     Foo foo = (Foo) factory.get(Foo.class);</pre>
 * This gives the freedom to change the implementation of Foo later, without rewriting all the
 * code that uses it.
 */
public class ImplFactory {
    private HashMap<Class<?>,Class<?>> implementations;
    private HashMap<String,Class<?>> stringImplementations;
    private static ImplFactory instance = null;
    public static ImplFactory getInstance() {
        if (instance == null)
            instance = new ImplFactory();
        return instance;
    }
    private ImplFactory() {
        implementations = new HashMap<Class<?>,Class<?>>();
        // Atom is problematic because all the elements extend the AtomImpl class. I don't
        // see a way to do that cleanly.
        implementations.put(Atom.class, AtomMutableImpl.class);
        implementations.put(AtomMutable.class, AtomMutableImpl.class);
        implementations.put(Bond.class, BondMutableImpl.class);
        implementations.put(BondMutable.class, BondMutableImpl.class);
        implementations.put(Jig.class, JigMutableImpl.class);
        implementations.put(JigMutable.class, JigMutableImpl.class);
        implementations.put(Structure.class, StructureMutableImpl.class);
        implementations.put(StructureMutable.class, StructureMutableImpl.class);
        implementations.put(UniqueId.class, UniqueIdSettableImpl.class);
        implementations.put(UniqueIdSettable.class, UniqueIdSettableImpl.class);
    }
    public Object get(String name) {
        Class<?> implClass = implementations.get(name);
        try {
            return implClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Object get(Class<?> ifcClass) {
        Class<?> implClass = implementations.get(ifcClass);
        try {
            return implClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void put(String name, Class<?> implClass) {
        stringImplementations.put(name, implClass);
    }
    public void put(Class<?> ifcClass, Class<?> implClass) {
        implementations.put(ifcClass, implClass);
    }
}
