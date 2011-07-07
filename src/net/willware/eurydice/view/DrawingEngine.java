package net.willware.eurydice.view;

import net.willware.eurydice.core.Structure;
import net.willware.eurydice.forcefields.ForceField;

/**
 * Drawing engines are used to draw structures in various graphics environments, and
 * share a common interface.
 */
public interface DrawingEngine {

    /**
     * Draw a structure, prioritizing beauty over performance.
     *
     * @param s the structure to be drawn.
     */
    public void draw(Structure s);

    /**
     * Draw a structure, prioritizing beauty over performance.
     *
     * @param s the structure to be drawn.
     * @param ff the structure to be drawn.
     */
    public void drawWithForces(Structure s, ForceField ff);

    /**
     * Draw a structure, prioritizing performance over beauty, for instance as an
     * animation frame while rotating the structure.
     *
     * @param s the structure to be drawn.
     */
    public void quickDraw(Structure s);

    /**
     * Given a color name like "red" or "white" or "green", return a wrapper containing
     * the native representation for that color (for example "#FF0000" for HTML).
     * @param colorname the familiar name of the color
     * @return a Color wrapper with a native instance of that color
     */
    public Color getColor(String colorname);
}
