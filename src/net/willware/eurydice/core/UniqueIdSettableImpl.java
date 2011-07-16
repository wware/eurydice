package net.willware.eurydice.core;

/**
 * For small structures, a 32-bit int is fine for a unique ID. For larger structures
 * that don't fit in the memory of a single computer, something larger will be needed,
 * maybe a 64-bit long, or maybe a UUID.
 */
public class UniqueIdSettableImpl implements UniqueIdSettable {

    private int myvalue;
    private static int counter = 0;

    /**
     * Instantiates a new unique id impl.
     */
    public UniqueIdSettableImpl() {
        myvalue = counter++;
    }

    /**
     * Instantiates a new unique id impl.
     *
     * @param count the count
     */
    public UniqueIdSettableImpl(int count) {
        if (count < counter)
            throw new RuntimeException("Unique IDs may not be unique");
        counter = count;
        myvalue = counter++;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + myvalue;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        try {
            return ((UniqueIdSettableImpl) obj).myvalue == myvalue;
        } catch (Exception e) {
            return false;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.UniqueId#toInteger()
     */
    public int toInteger() {
        return myvalue;
    }

    @Override
    public int compareTo(UniqueId arg) {
        try {
            UniqueIdSettableImpl other = (UniqueIdSettableImpl) arg;
            if (myvalue < other.myvalue)
                return -1;
            else if (myvalue > other.myvalue)
                return -1;
            return 0;
        } catch (ClassCastException e) {
            return -1;
        }
    }

    @Override
    public void setNumericValue(int n) {
        // I'm tempted to decrement counter at this point, but I don't really know that this
        // was the last UniqueId created, which is the only time that would be safe. So we'll
        // just hope we don't waste too many values this way.
        myvalue = n;
    }
}
