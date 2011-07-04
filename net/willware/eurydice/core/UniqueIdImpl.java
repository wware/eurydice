package net.willware.eurydice.core;

/**
 * For small structures, a 32-bit int is fine for a unique ID. For larger structures
 * that don't fit in the memory of a single computer, something larger will be needed,
 * maybe a 64-bit long, or maybe a UUID.
 */
public class UniqueIdImpl implements UniqueId {
    private static int counter = 0;
    private int myvalue;
    public UniqueIdImpl() {
        myvalue = counter++;
    }
    public UniqueIdImpl(int count) {
        if (count < counter)
            throw new RuntimeException("Unique IDs may not be unique");
        counter = count;
        myvalue = counter++;
    }
    public String toString() {
        return "" + myvalue;
    }
    public boolean equals(Object obj) {
        try {
            return ((UniqueIdImpl) obj).myvalue == myvalue;
        } catch (Exception e) {
            return false;
        }
    }
    public int toInteger() {
        return myvalue;
    }
    public static UniqueId makeTempId(int x) {
        UniqueIdImpl uii = new UniqueIdImpl();
        uii.myvalue = x;
        counter--;
        return uii;
    }
}
