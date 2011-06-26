package net.willware.eurydice.drawing;

import net.willware.eurydice.core.Structure;

/**
 * Drawing engines are used to draw structures in various graphics environments, and
 * share a common interface.
 */
public interface IDrawingEngine {

    /**
     * Draw a structure, prioritizing beauty over performance.
     *
     * @param s the structure to be drawn.
     */
    public void draw(Orientation o, Structure s);

    /**
     * Draw a structure, prioritizing performance over beauty, for instance as an
     * animation frame while rotating the structure.
     *
     * @param s the structure to be drawn.
     */
    public void quickDraw(Orientation o, Structure s);
}
