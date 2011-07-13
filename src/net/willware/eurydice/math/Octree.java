package net.willware.eurydice.math;

import java.util.List;
import java.util.ArrayList;

import net.willware.eurydice.core.Atom;

/**
 * An octree partitions a cubical region of 3-space into smaller cubes in a
 * hierarchy, down to a particular dimension where fine granularity is required,
 * which is wherever there are atoms. Empty regions don't need granularity. The
 * initial cube is the bounding cube of a structure. The purpose of the octree is
 * to make it very efficient to identify an atom's nearby neighbors, which allows
 * you to enumerate a bond list in O(n) time.
 */
public class Octree extends Region {
    private double halfDimension;
    private double granularity;
    private Octree children[];
    private List<Atom> atoms;

    /**
     * Constructor.
     *
     * @param initial the bounding box for all the atoms under consideration
     * @param granularity the granularity, typically a bit bigger than a bond length
     */
    public Octree(Region initial, double granularity) {
        super(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        this.granularity = granularity;
        Vector cmax = initial.getMaxCorner();
        Vector cmin = initial.getMinCorner();
        Vector center = cmax.add(cmin).scale(0.5);
        Vector d = cmax.subtract(center);
        halfDimension = d.getX();
        if (d.getY() > halfDimension) halfDimension = d.getY();
        if (d.getZ() > halfDimension) halfDimension = d.getZ();
        Vector d3 = new Vector(halfDimension, halfDimension, halfDimension);
        children = new Octree[8];
        for (int i = 0; i < 8; i++)
            children[i] = null;
        atoms = null;
        minCorner = center.subtract(d3);
        maxCorner = center.add(d3);
    }

    private Octree(Vector center, double halfDimension, double granularity) {
        super(center.getX() - halfDimension, center.getY() - halfDimension, center.getZ() - halfDimension,
              center.getX() + halfDimension, center.getY() + halfDimension, center.getZ() + halfDimension);
        this.granularity = granularity;
        this.halfDimension = halfDimension;
        children = new Octree[8];
        for (int i = 0; i < 8; i++)
            children[i] = null;
        atoms = null;
    }

    /**
     * Gets the linear dimension of this octree, which is cubical.
     *
     * @return the dimension
     */
    public double getDimension() {
        return halfDimension;
    }

    /**
     * Gets the granularity that octree children will go down to.
     *
     * @return the granularity
     */
    public double getGranularity() {
        return granularity;
    }

    /**
     * Adds an atom to this octree (and its children).
     *
     * @param a the a
     */
    public void addAtom(Atom a) {
        Vector p = a.getPosition();
        if (halfDimension <= granularity) {
            if (atoms == null)
                atoms = new ArrayList<Atom>();
            if (!atoms.contains(p))
                atoms.add(a);
        } else {
            // descend into hierarchy, creating children as needed
            int key = 0;
            Vector v = p.subtract(getCenter());
            if (v.getX() >= 0) key |= 1;
            if (v.getY() >= 0) key |= 2;
            if (v.getZ() >= 0) key |= 4;
            if (children[key] == null) {
                Vector dx = new Vector(0.5 * halfDimension, 0.0, 0.0);
                Vector dy = new Vector(0.0, 0.5 * halfDimension, 0.0);
                Vector dz = new Vector(0.0, 0.0, 0.5 * halfDimension);
                v = getCenter();
                if ((key & 1) != 0) v = v.add(dx);
                else v = v.subtract(dx);
                if ((key & 2) != 0) v = v.add(dy);
                else v = v.subtract(dy);
                if ((key & 4) != 0) v = v.add(dz);
                else v = v.subtract(dz);
                children[key] = new Octree(v, 0.5 * halfDimension, granularity);
            }
            children[key].addAtom(a);
        }
    }

    /**
     * Given a rectangular region of 3-space, get a list of all the atoms
     * in that region.
     *
     * @param r the rectangular region
     * @param lst the atoms in that region
     * TODO - Looks buggy, never uses X_PARTIAL, Y_PARTIAL, Z_PARTIAL, TEST THOROUGHLY
     */
    public void getAtoms(Region r, List<Atom> lst) {
        List<Atom> retval = new ArrayList<Atom>();
        int coverage = r.covers(this);
        if (coverage == 0)
            return;
        if (coverage == (X_COMPLETE | Y_COMPLETE | Z_COMPLETE)) {
            getAllAtoms(retval);
            return;
        }
        for (int i = 0; i < 8; i++)
            if (children[i] != null)
                children[i].getAtoms(r, lst);
    }

    private void getAllAtoms(List<Atom> lst) {
        if (halfDimension < granularity) {
            for (Atom a : atoms)
                lst.add(a);
        } else if (children != null) {
            for (int i = 0; i < 8; i++)
                if (children[i] != null)
                    children[i].getAllAtoms(lst);
        }
    }
}
