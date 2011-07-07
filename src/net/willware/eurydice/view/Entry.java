/**
 * Entry.java - entry in a drawing list
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.view;

import java.util.List;

/**
 * An entry in a display list, for drawing purposes.
 */
public abstract class Entry {
    /**
     * The Z coordinate of the object (usually its center of gravity), which allows objects to be
     * Z-sorted for the painter's algorithm.
     *
     * @return the double
     */
    public abstract double zvalue();

    /**
     * When an object (together with many others) is being rotated or moved, drawing needs to be quick,
     * maybe a wireframe, or if even that's too much, maybe a partial wireframe or a bounding box.
     */
    public abstract void quickDraw();

    /**
     * When an object (together with many others) is done being rotated or moved, there is time to draw
     * it in some more beautiful way.
     */
    public abstract void draw();

    /**
     * The quicksort algorithm applied to a drawing list: we start drawing at the back of
     * the scene and work forward, so that things in front obstruct the view of things behind.
     *
     * @param dlist the dlist
     */
    public static void zsort(List<Entry> dlist) {
        zsort(dlist, 0, dlist.size() - 1);
    }

    /**
     * Zsort.
     *
     * @param v the v
     * @param lo0 the lo0
     * @param hi0 the hi0
     */
    private static void zsort(List<Entry> v, int lo0, int hi0) {
        int lo = lo0;
        int hi = hi0;
        if (hi0 > lo0) {
            double mid = v.get((lo0 + hi0) / 2).zvalue();
            while (lo <= hi) {
                while (lo < hi0 && v.get(lo).zvalue() < mid)
                    ++lo;
                while (hi > lo0 && v.get(hi).zvalue() > mid)
                    --hi;
                if (lo <= hi) {
                    Entry temp = v.get(lo);
                    v.set(lo, v.get(hi));
                    v.set(hi, temp);
                    ++lo;
                    --hi;
                }
            }
            if (lo0 < hi)
                zsort(v, lo0, hi);
            if (lo < hi0)
                zsort(v, lo, hi0);
        }
    }
}
