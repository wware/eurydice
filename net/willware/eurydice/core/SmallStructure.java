package net.willware.eurydice.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import net.willware.eurydice.forcefields.ForceField;
import net.willware.eurydice.math.Vector;

// TODO: Auto-generated Javadoc
/**
 * This implementation of IPositionList is suitable for small structures. "Small"
 * means that the entire structure will fit into RAM on a typical desktop.
 */
public class SmallStructure extends Structure {
    private List<Atom> atomList;
    private List<Jig> jigList;
    private Properties metadata;

    /**
     * Constructor.
     *
     * @param parentUUID the UUID of the parent structure, or null
     */
    public SmallStructure(UUID parentUUID) {
        super(parentUUID);
        atomList = new ArrayList<Atom>();
        jigList = new ArrayList<Jig>();
        metadata = new Properties();
    }
    private double min(double x, double y) {
        return (x < y) ? x : y;
    }
    private double max(double x, double y) {
        return (x > y) ? x : y;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getBoundingBox()
     */
    public Region getBoundingBox() {
        Vector pos = atomList.get(0).getPosition();
        double xmin = pos.getX();
        double ymin = pos.getY();
        double zmin = pos.getZ();
        double xmax = xmin;
        double ymax = ymin;
        double zmax = zmin;
        for (Atom a: atomList) {
            Vector v = a.getPosition();
            xmin = min(xmin, v.getX());
            ymin = min(ymin, v.getY());
            zmin = min(zmin, v.getZ());
            xmax = max(xmax, v.getX());
            ymax = max(ymax, v.getY());
            zmax = max(zmax, v.getZ());
        }
        Region r = new Region(xmin, ymin, zmin, xmax, ymax, zmax);
        return r;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#sublist(net.willware.eurydice.core.Region)
     */
    public Structure sublist(Region r) {
        throw new RuntimeException("not implemented yet");
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getMetadata()
     */
    public Properties getMetadata() {
        return metadata;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getIterator()
     */
    public Iterator<Atom> getIterator() {
        return atomList.iterator();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#size()
     */
    public long size() {
        return atomList.size();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#get(long)
     */
    public Atom get(long index) {
        return atomList.get((int)index);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#set(long, net.willware.eurydice.core.Atom)
     */
    public void set(long index, Atom a) {
        atomList.set((int)index, a);
    }

    private List<Bond> previousBondList = null;

    /**
     * This will do for small structures, but may become painful
     * for big ones, as it is O(N^2). If performance suffers, it
     * can be improved by sorting atoms into spatial partitions
     * (an O(N) operation) and then searching for potential bond
     * mates only in nearby partitions (also O(N)).
     *
     * @return the list of bonds inferred from atom types and positions
     */
    public List<Bond> inferBonds() {
        if (previousBondList != null)
            return previousBondList;
        long i, j;
        final int n = atomList.size();
        List<Bond> bondList = new ArrayList<Bond>();
        for (i = 0; i < n - 1; i++) {
            Atom a1 = get(i);
            for (j = i + 1; j < n; j++) {
                Atom a2 = get(j);
                if (a1.getPosition().subtract(a2.getPosition()).length() <
                        (a1.covalentRadius() + a2.covalentRadius() + 0.5)) {
                    bondList.add(new Bond(a1, a2, bondList));  // TODO figure out correct bond order
                }
            }
        }
        previousBondList = bondList;
        return bondList;
    }

    /**
     * Adds an atom to this structure.
     *
     * @param a the atom to be added
     */
    public void addAtom(Atom a) {
        a.setId(size());
        atomList.add(a);
        announceChange();
    }

    /**
     * Removes an atom from this structure.
     *
     * @param a the atom to be removed
     */
    public void removeAtom(Atom a) {
        atomList.remove(a);
        announceChange();
    }
    private void announceChange() {
        ForceField ff = getForceField();
        if (ff != null)
            ff.structureChanged();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#indexOf(net.willware.eurydice.core.Atom)
     */
    public long indexOf(Atom a) {
        return atomList.indexOf(a);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#numJigs()
     */
    public int numJigs() {
        return jigList.size();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getJig(int)
     */
    public Jig getJig(int index) {
        return jigList.get(index);
    }

    /**
     * Adds a new jig to this structure.
     *
     * @param j the jig to be added
     */
    public void addJig(Jig j) {
        jigList.add(j);
    }
}
