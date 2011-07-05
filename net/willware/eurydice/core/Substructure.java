package net.willware.eurydice.core;

/**
 * The Class Substructure.
 */
public class Substructure {

    /** The structure. */
    private Structure structure;

    /** The orientation. */
    private Orientation orientation;



    /**
     * Sets the structure.
     *
     * @param struc the new structure
     */
    public void setStructure(Structure struc) {
        this.structure = struc;
    }

    /**
     * Gets the structure.
     *
     * @return the structure
     */
    public Structure getStructure() {
        return structure;
    }

    /**
     * Sets the orientation.
     *
     * @param orientation the new orientation
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Gets the orientation.
     *
     * @return the orientation
     */
    public Orientation getOrientation() {
        return orientation;
    }
}
