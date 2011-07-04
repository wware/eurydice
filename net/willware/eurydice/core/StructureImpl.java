package net.willware.eurydice.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.willware.eurydice.math.Quaternion;
import net.willware.eurydice.math.Region;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.forcefields.ForceField;

/**
 * An implementation of {@link Structure} suitable for small structures, or
 * portions of large structures that are small enough to reside in the memory
 * of a single computer.
 */
public class StructureImpl implements Structure {

    /** The atom list. */
    private List<Atom> atomList;

    /** The jig list. */
    private List<Jig> jigList;

    /** The metadata. */
    private Properties metadata;

    /** The unique ID that identifies this structure. */
    protected UniqueId id;   // might need access to implement clone method

    /** The unique ID of the parent structure, if this structure has a parent. */
    protected UniqueId parentID;

    /** The force field used to compute interatomic forces for this structure. */
    private ForceField forceField;

    /** a list of substructures, allowing structures to be hierarchical. */
    protected List<Structure> substructures;

    /** The position. */
    private Vector position;

    /** The orientation. */
    private Quaternion orientation;

    /** The previous bond list, used to memoize inferBonds. */
    private List<Bond> previousBondList = null;

    /**
     * Constructor.
     *
     * @param parentID the unique ID of the parent structure, or null
     */
    public StructureImpl(UniqueId parentID) {
        id = new UniqueIdImpl();
        this.parentID = parentID;
        forceField = null;
        position = new Vector();
        orientation = new Quaternion();
        atomList = new ArrayList<Atom>();
        jigList = new ArrayList<Jig>();
        metadata = new Properties();
        substructures = new java.util.ArrayList<Structure>();
    }

    /**
     * Constructor.
     *
     * @param parentID the unique ID of the parent structure, or null
     * @param pos position within containing Structure
     */
    public StructureImpl(UniqueId parentID, Vector pos) {
        id = new UniqueIdImpl();
        this.parentID = parentID;
        forceField = null;
        position = pos;
        orientation = new Quaternion();
        atomList = new ArrayList<Atom>();
        jigList = new ArrayList<Jig>();
        metadata = new Properties();
        substructures = new java.util.ArrayList<Structure>();
    }

    /**
     * Constructor.
     *
     * @param parentID the unique ID of the parent structure, or null
     * @param pos position within containing Structure
     * @param ort the orientation relative to the containing Structure
     */
    public StructureImpl(UniqueId parentID, Vector pos, Quaternion ort) {
        id = new UniqueIdImpl();
        this.parentID = parentID;
        forceField = null;
        position = pos;
        orientation = ort;
        atomList = new ArrayList<Atom>();
        jigList = new ArrayList<Jig>();
        metadata = new Properties();
        substructures = new java.util.ArrayList<Structure>();
    }

    /**
     * Sets the position.
     *
     * @param position the new position
     */
    public void setPosition(Vector position) {
        this.position = position;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getPosition()
     */
    public Vector getPosition() {
        return position;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#setOrientation(net.willware.eurydice.math.Quaternion)
     */
    public void setOrientation(Quaternion orientation) {
        this.orientation = orientation;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getOrientation()
     */
    public Quaternion getOrientation() {
        return orientation;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#process(net.willware.eurydice.core.Structure.AtomProcessor)
     */
    public void process(AtomProcessor p) {
        Iterator<Atom> iter = getIterator();
        while (iter.hasNext()) {
            p.process(iter.next());
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getparentID()
     */
    public UniqueId getParentUniqueId() {
        return parentID;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#setForceField(net.willware.eurydice.forcefields.ForceField)
     */
    public void setForceField(ForceField ff) {
        forceField = ff;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getForceField()
     */
    public ForceField getForceField() {
        return forceField;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getUniqueId()
     */
    public UniqueId getUniqueId() {
        return id;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#toJson()
     */
    public String toJson() {
        long numAtoms = 0;
        StringBuilder sb = new StringBuilder();
        Iterator<Atom> iter = getIterator();
        sb.append("{");
        while (iter.hasNext()) {
            Atom a = iter.next();
            Vector p = a.getPosition();
            sb.append("\"atom" + numAtoms + "\":{");
            sb.append("\"symbol\":\"");
            sb.append(a.symbol());
            sb.append("\",\"x\":");
            sb.append(p.getX());
            sb.append(",\"y\":");
            sb.append(p.getY());
            sb.append(",\"z\":");
            sb.append(p.getZ());
            sb.append("},");
            numAtoms++;
        }
        sb.append("\"numAtoms\":" + numAtoms);
        sb.append("}");
        return sb.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        try {
            StructureImpl other = (StructureImpl) obj;
            Iterator<Atom> iter1 = getIterator();
            Iterator<Atom> iter2 = other.getIterator();
            while (iter1.hasNext()) {
                Atom a1 = iter1.next();
                Atom a2 = iter2.next();
                if (!a1.name().equals(a2.name()))
                    throw new Exception();
                if (a1.getHybridization() != a2.getHybridization())
                    throw new Exception();
                if (a1.getCharge() != a2.getCharge())
                    throw new Exception();
                Vector pos1 = a1.getPosition();
                Vector pos2 = a2.getPosition();
                if (!pos1.approximatelyEqual(pos2))
                    throw new Exception();
            }
            if (iter2.hasNext())
                throw new Exception();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#verletPrep()
     */
    public void verletPrep() {
        process(new AtomProcessor() {
            public void process(Atom a) {
                Vector pos = a.getPosition();
                a.setPreviousPosition(pos);
            }
        });
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#verletStep(double)
     */
    public void verletStep(final double dt) {
        // Do not compute forces here! This is ONLY integrating
        // equations of motion.
        process(new AtomProcessor() {
            public void process(Atom a) {
                Vector pos = a.getPosition();
                Vector previous = a.getPreviousPosition();
                if (previous == null)
                    previous = pos;
                Vector accel = a.getForce().scale(1.0 / a.mass());
                Vector newPos = pos.scale(2.0)
                                .subtract(previous).add(accel.scale(dt * dt));
                a.setPreviousPosition(pos);
                a.setPosition(newPos);
                a.zeroForce();
            }
        });
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#addSubstructure(net.willware.eurydice.core.Structure)
     */
    public void addSubstructure(Structure s) {
        substructures.add(s);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#removeSubstructure(net.willware.eurydice.core.Structure)
     */
    public void removeSubstructure(Structure s) {
        substructures.remove(s);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getSubstructures()
     */
    public List<Structure> getSubstructures() {
        return substructures;
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
            xmin = (xmin < v.getX()) ? xmin : v.getX();
            ymin = (ymin < v.getY()) ? ymin : v.getY();
            zmin = (zmin < v.getZ()) ? zmin : v.getZ();
            xmax = (xmax > v.getX()) ? xmax : v.getX();
            ymax = (ymax > v.getY()) ? ymax : v.getY();
            zmax = (zmax > v.getZ()) ? zmax : v.getZ();
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
    public int size() {
        return atomList.size();
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#get(long)
     */
    public Atom get(UniqueId index) {
        return atomList.get(index.toInteger());
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#get(long)
     */
    public Atom get(int index) {
        return get(UniqueIdImpl.makeTempId(index));
    }

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
        int i, j;
        final int n = atomList.size();
        List<Bond> bondList = new ArrayList<Bond>();
        for (i = 0; i < n - 1; i++) {
            Atom a1 = get(i);
            for (j = i + 1; j < n; j++) {
                Atom a2 = get(j);
                if (a1.getPosition().subtract(a2.getPosition()).length() <
                        (a1.covalentRadius() + a2.covalentRadius() + 0.5)) {
                    bondList.add(new BondImpl(a1, a2, bondList));  // TODO figure out correct bond order
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

    /**
     * Announce change.
     */
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
