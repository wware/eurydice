/**
 * Entry.java - entry in a drawing list
 * Copyright (c) 1997,2011 Will Ware, all rights reserved.
 */

package net.willware.eurydice.view;

/**
 * An entry in a display list, for use in the <a href="http://en.wikipedia.org/wiki/Painter's_algorithm">Painter's
 * algorithm</a> where opaque things are drawn starting with the ones in the back, so that as the front ones
 * are drawn later, they obscure the things behind them.
 */
public abstract class DisplayListEntry {
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
    public static void zsort(DisplayListEntry[] dlist) {
        zsort(dlist, 0, dlist.length - 1);
    }

    /*
     * All the work of Z sort is really done in this helper method. This is an implementation of
     * quicksort.
     */
    private static void zsort(DisplayListEntry[] dlst, int lo0, int hi0) {
        int lo = lo0;
        int hi = hi0;
        if (hi0 > lo0) {
            double mid = dlst[(lo0 + hi0) / 2].zvalue();
            while (lo <= hi) {
                while (lo < hi0 && dlst[lo].zvalue() < mid)
                    ++lo;
                while (hi > lo0 && dlst[hi].zvalue() > mid)
                    --hi;
                if (lo <= hi) {
                    DisplayListEntry temp = dlst[lo];
                    dlst[lo] = dlst[hi];
                    dlst[hi] = temp;
                    ++lo;
                    --hi;
                }
            }
            if (lo0 < hi)
                zsort(dlst, lo0, hi);
            if (lo < hi0)
                zsort(dlst, lo, hi0);
        }
    }
}
