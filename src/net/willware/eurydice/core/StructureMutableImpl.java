package net.willware.eurydice.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import net.willware.eurydice.math.Region;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.forcefields.ForceField;

/**
 * An implementation of {@link Structure} suitable for small structures, or
 * portions of large structures that are small enough to reside in the memory
 * of a single computer.
 */
public class StructureMutableImpl extends StructureMutable {

    private static Logger logger = Logger.getLogger("eurydice");

    /** The atom list. */
    private ArrayList<Integer> atomIds;
    private HashMap<Integer,Atom> atomList;

    /** The jig list. */
    private List<Jig> jigList;

    /** Any metadata for this structure: author, publication, date, etc. */
    private Properties metadata;

    /** The unique ID that identifies this structure. */
    private UniqueId id;   // might need access to implement clone method

    /** The unique ID of the parent structure, if this structure has a parent. */
    private UniqueId parentID;

    /** The force field used to compute interatomic forces for this structure. */
    private ForceField forceField;

    /** a list of substructures, allowing structures to be hierarchical. */
    private List<Substructure> substructures;

    /** The previous bond list, used to memoize inferBonds. */
    private List<Bond> previousBondList = null;

    /**
     * Constructor.
     *
     * @param parentID the unique ID of the parent structure, or null
     */
    public StructureMutableImpl() {
        id = UniqueId.newInstance();
        forceField = null;
        atomList = new HashMap<Integer,Atom>();
        atomIds = new ArrayList<Integer>();
        jigList = new ArrayList<Jig>();
        metadata = new Properties();
        substructures = new java.util.ArrayList<Substructure>();
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

    /**
     * Sets the force field.
     *
     * @param ff the new force field
     */
    public void setForceField(ForceField ff) {
        forceField = ff;
    }

    /**
     * Gets the force field.
     *
     * @return the force field
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
        sb.append("\"numAtoms\":" + numAtoms);
        while (iter.hasNext()) {
            Atom a = iter.next();
            Vector p = a.getPosition();
            sb.append(",");
            sb.append("\"atom" + numAtoms + "\":{");
            sb.append("\"symbol\":");
            sb.append("\"" + a.getSymbol() + "\"");
            sb.append(",\"uniqueid\":");
            sb.append(a.getUniqueId());
            sb.append(",\"position\":{\"x\":");
            sb.append(p.getX());
            sb.append(",\"y\":");
            sb.append(p.getY());
            sb.append(",\"z\":");
            sb.append(p.getZ());
            sb.append("}}");
            numAtoms++;
        }
        sb.append("}");
        return sb.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        try {
            StructureMutableImpl other = (StructureMutableImpl) obj;
            Iterator<Atom> iter1 = getIterator();
            Iterator<Atom> iter2 = other.getIterator();
            while (iter1.hasNext()) {
                Atom a1 = iter1.next();
                Atom a2 = iter2.next();
                if (!a1.getName().equals(a2.getName()))
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
     * @see net.willware.eurydice.core.Structure#getAtomList()
     */
    public Atom[] getAtomArray() {
        Atom[] array = new Atom[atomList.size()];
        for (int i = 0; i < atomList.size(); i++)
            array[i] = atomList.get(i);
        return array;
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
                Vector accel = a.getForce().scale(1.0 / a.getMass());
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
    public void addSubstructure(Substructure s) {
        substructures.add(s);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#removeSubstructure(net.willware.eurydice.core.Structure)
     */
    public void removeSubstructure(Substructure s) {
        substructures.remove(s);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getSubstructures()
     */
    public List<Substructure> getSubstructures() {
        return substructures;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#getBoundingBox()
     */
    public Region getBoundingBox() {
        double xmin = 1.0e20;
        double ymin = 1.0e20;
        double zmin = 1.0e20;
        double xmax = -1.0e20;
        double ymax = -1.0e20;
        double zmax = -1.0e20;
        for (Atom a: atomList.values()) {
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
        return atomList.values().iterator();
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
    	/*
        UniqueIdSettable id = (UniqueIdSettable) UniqueId.newInstance();
        id.setNumericValue(index);
        return get(id);
        */
    	return atomList.get(index);
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
        final int n = atomIds.size();
        List<Bond> bondList = new ArrayList<Bond>();
        for (i = 0; i < n - 1; i++) {
            Atom a1 = get(atomIds.get(i));
            for (j = i + 1; j < n; j++) {
                Atom a2 = get(atomIds.get(j));
                if (a1.getPosition().subtract(a2.getPosition()).length() <
                        (a1.getCovalentRadius() + a2.getCovalentRadius() + 0.5)) {
                    BondMutable bond = (BondMutable) Bond.newInstance();
                    bond.setFirstAtom(a1);
                    bond.setSecondAtom(a2);
                    // TODO figure out correct bond order
                    bondList.add(bond);
                    a1.rehybridize(bondList);
                    a2.rehybridize(bondList);
                }
            }
        }
        previousBondList = bondList;
        return bondList;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.Structure#processBondChains(net.willware.eurydice.core.BondChainProcessor)
     */
    public void processBondChains(BondChainProcessor proc) {
        inferBonds();
        for (Atom a : atomList.values())
            processBondChainHelper(a, proc, 3);
    }

    private void processBondChainHelper(final Atom a, final BondChainProcessor proc, int n) {
        if (n == 0)
            return;
        BondChainProcessor proc2 = new BondChainProcessor() {
            public void process2(Atom w, Atom x) {
                proc.process3(a, w, x);
            }
            public void process3(Atom w, Atom x, Atom y) {
                proc.process4(a, w, x, y);
            }
            public void process4(Atom w, Atom x, Atom y, Atom z) {
                // do nothing
            }
            public boolean alreadyHave(Atom w) {
                return proc.alreadyHave(w) || (w == a);
            }
        };
        for (Bond b: previousBondList) {
            if (b.contains(a)) {
                Atom x = b.otherAtom(a);
                if (!proc2.alreadyHave(x)) {
                    proc.process2(a, x);
                    processBondChainHelper(x, proc2, n - 1);
                }
            }
        }
    }

    /**
     * Adds an atom to this structure.
     *
     * @param a the atom to be added
     */
    public void addAtom(Atom a) {
    	UniqueId id = a.getUniqueId();
    	if (id != null) {
    		if (atomList.containsKey(id))
    			throw new RuntimeException("duplicate atom ID?");
    	} else {
            id = UniqueId.newInstance();
            ((AtomMutable)a).setUniqueId(id);
    	}
    	atomIds.add(id.toInteger());
        atomList.put(id.toInteger(), a);
        announceChange();
    }

    /**
     * Adds an atom to this structure, with a particular unique ID.
     *
     * @param a the atom to be added
     * @param id the unique ID for this atom
     */
    public void addAtom(Atom a, UniqueId id) {
        ((AtomMutable)a).setUniqueId(id);
    	atomIds.add(id.toInteger());
        atomList.put(id.toInteger(), a);
        announceChange();
    }

    /**
     * Removes an atom from this structure.
     *
     * @param a the atom to be removed
     */
    public void removeAtom(Atom a) {
    	atomIds.remove(a.getUniqueId().toInteger());
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
        return a.getUniqueId().toInteger();
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

    @Override
    public void getUniqueId(UniqueId uid) {
        this.id = uid;
    }

    @Override
    public void setParentUniqueId(UniqueId puid) {
        this.parentID = puid;
    }

    @Override
    public String serialize() {
        final StringBuilder sb = new StringBuilder();
        final boolean firstAtom[] = new boolean[1];
        firstAtom[0] = true;
        process(new AtomProcessor() {
            @Override
            public void process(Atom a) {
                if (firstAtom[0]) {
                    firstAtom[0] = false;
                } else {
                    sb.append("\n");
                }
                sb.append(a.getSymbol());
                sb.append(":");
                sb.append(a.getHybridizationString());
                sb.append(":");
                Vector pos = a.getPosition();
                sb.append(doubleAsString(pos.getX()));
                sb.append(":");
                sb.append(doubleAsString(pos.getY()));
                sb.append(":");
                sb.append(doubleAsString(pos.getZ()));
            }
            private String doubleAsString(double x) {
                String s = "" + x;
                int endIndex = (s.length() < 8) ? s.length() : 8;
                return ("" + x).substring(0, endIndex);
            }
        });
        return sb.toString();
    }
}
