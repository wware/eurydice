package net.willware.eurydice.forcefields.mm2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.BondChainProcessor;
import net.willware.eurydice.core.JigImpl;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.core.UniqueId;
import net.willware.eurydice.core.Structure.AtomProcessor;
import net.willware.eurydice.forcefields.ForceField;

/**
 * Most of what I know about the MM2 force field comes from Chapter 3 of K. Eric
 * Drexler's book <i>Nanosystems</i>, around page 44 if memory serves.
 * @see <a href="http://en.wikipedia.org/wiki/Molecular_modelling">Wikipedia article on molecular modeling</a>
 */
public class MM2 extends JigImpl implements ForceField {

    /** A list of the energy terms used to compute forces on the atoms in {@link #struc}. */
    private List<Term> termList;

    /**
     * A flag indicating a change in the topology of the structure (an atom or bond has been added
     * or removed) which indicates that the list of energy terms must be updated before forces can
     * be accurately computed again.
     */
    private boolean hasTopologyChanged;
    
    private LongRangeForces longRange;

    /**
     * Constructor.
     */
    public MM2(Structure struc) {
    	super(struc);
        termList = new ArrayList<Term>();
        longRange = new LongRangeForces(struc);
        hasTopologyChanged = true;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.forcefields.IForceField#structureChanged()
     */
    public void structureChanged() {
        hasTopologyChanged = true;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.IJig#atomIndices()
     */
    public List<UniqueId> atomIndices() {
        Iterator<Atom> iter = getStruc().getIterator();
        List<UniqueId> lst = new ArrayList<UniqueId>();
        while (iter.hasNext())
            lst.add(iter.next().getUniqueId());
        return lst;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.IJig#computeForces(net.willware.eurydice.core.Structure)
     */
    public void computeForces() {
        if (hasTopologyChanged) {
            hasTopologyChanged = false;
            enumerateTerms();
        }
        getStruc().process(new AtomProcessor() {
            public void process(Atom a) {
                a.zeroForce();
            }
        });
        for (int i = 0; i < termList.size(); i++)
            termList.get(i).computeForces(getStruc());
        longRange.computeForces();
    }

    /**
     * Enumerate energy terms by finding chains of molecular bonds in the topology of the structure.
     */
    private void enumerateTerms() {
        int i;
        List<Bond> bondlist = getStruc().inferBonds();
        for (i = 0; i < getStruc().size(); i++)
            getStruc().get(i).rehybridize(bondlist);
        termList = new ArrayList<Term>();
        getStruc().processBondChains(new BondChainProcessor() {
            public void process2(Atom a1, Atom a2) {
                if (a1.getUniqueId().compareTo(a2.getUniqueId()) < 0) {
                    termList.add(new LengthTerm(a1, a2));
                    // termList.add(new LongRangeTerm(a1, a2));
                    longRange.addExclusion(a1, a2);
                }
            }
            public void process3(Atom a1, Atom a2, Atom a3) {
                if (a1.getUniqueId().compareTo(a2.getUniqueId()) < 0) {
                    termList.add(new AngleTerm(a1, a2, a3));
                    longRange.addExclusion(a1, a3);
                }
            }
            public void process4(Atom a1, Atom a2, Atom a3, Atom a4) {
                if (a1.getUniqueId().compareTo(a2.getUniqueId()) < 0)
                    termList.add(new TorsionTerm(a1, a2, a3, a4));
            }
        });
    }
}
