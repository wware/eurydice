package net.willware.eurydice.core;

import net.willware.eurydice.math.Quaternion;
import net.willware.eurydice.math.Vector;

/**
 * Substructures allow a Structure to be defined hierarchically.
 */
public class Substructure {
    private Vector position;
    private Quaternion orientation;
    private Structure structure;

    /**
     * Constructor.
     *
     * @param pos position within containing Structure
     * @param s the substructure
     */
    public Substructure(Vector pos, Structure s) {
        position = pos;
        orientation = new Quaternion();
        structure = s;
    }

    /**
     * Constructor.
     *
     * @param pos position within containing Structure
     * @param ort the orientation relative to the containing Structure
     * @param s the substructure
     */
    public Substructure(Vector pos, Quaternion ort, Structure s) {
        position = pos;
        orientation = ort;
        structure = s;
    }

    /**
     * Sets the position.
     *
     * @param position the new position
     */
    public void setPosition(Vector position) {
        this.position = position;
    }

    /**
     * Gets the position.
     *
     * @return the position
     */
    public Vector getPosition() {
        return position;
    }

    /**
     * Sets the orientation.
     *
     * @param orientation the new orientation
     */
    public void setOrientation(Quaternion orientation) {
        this.orientation = orientation;
    }

    /**
     * Gets the orientation.
     *
     * @return the orientation
     */
    public Quaternion getOrientation() {
        return orientation;
    }

    /**
     * Sets the structure.
     *
     * @param structure the new structure
     */
    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    /**
     * Gets the structure.
     *
     * @return the structure
     */
    public Structure getStructure() {
        return structure;
    }
}
