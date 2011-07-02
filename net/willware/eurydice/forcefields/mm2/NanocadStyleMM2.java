package net.willware.eurydice.forcefields.mm2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.JigImpl;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.core.Structure.AtomProcessor;
import net.willware.eurydice.elements.Carbon;
import net.willware.eurydice.forcefields.ForceField;

/**
 * NanoCAD was a hobbyist effort written in 1997, when I didn't know Java well and
 * didn't know how to plan for large structures (exceeding 4 billion atoms). The MM2
 * implementation uses data structures that require a 32-bit atom index, where a
 * 64-bit index would be much more scalable. This force field is not scalable for other
 * reasons as well, including the inefficient {@link #enumerateTerms()} method.<p>
 * Most of what I know about the MM2 force field comes from Chapter 3 of K. Eric
 * Drexler's book <i>Nanosystems</i>, around page 44 if memory serves.
 * @see <a href="http://en.wikipedia.org/wiki/Molecular_modelling">Wikipedia article on molecular modeling</a>
 */
public class NanocadStyleMM2 extends JigImpl implements ForceField {

    /** A list of the energy terms used to compute forces on the atoms in {@link #struc}. */
    private List<Term> termList;

    /**
     * A flag indicating a change in the topology of the structure (an atom or bond has been added
     * or removed) which indicates that the list of energy terms must be updated before forces can
     * be accurately computed again.
     */
    private boolean hasTopologyChanged;

    /**
     * Constructor.
     */
    public NanocadStyleMM2() {
        termList = new ArrayList<Term>();
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
    public List<Long> atomIndices() {
        Iterator<Atom> iter = getStruc().getIterator();
        List<Long> lst = new ArrayList<Long>();
        while (iter.hasNext())
            lst.add(iter.next().getId());
        return lst;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.core.IJig#computeForces(net.willware.eurydice.core.Structure)
     */
    public void computeForces(Structure struc) {
        //System.out.println("COMPUTE FORCES");
        if (hasTopologyChanged) {
            hasTopologyChanged = false;
            enumerateTerms();
        }
        struc.process(new AtomProcessor() {
            public void process(Atom a) {
                a.zeroForce();
            }
        });
        for (int i = 0; i < termList.size(); i++)
            termList.get(i).computeForces(struc);
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
        /*
         * Design flaw in the Java language: You can't inherit static methods.
         * I would love to type something like
         *   LengthTerm.enumerate(termList, struc);
         *   AngleTerm.enumerate(termList, struc);
         *   TorsionTerm.enumerate(termList, struc);
         *   LongRangeTerm.enumerate(termList, struc);
         * instead of the silliness below, but it is what it is.
         */
        Atom a = new Carbon();
        new LengthTerm(a, a).enumerate(termList, getStruc());
        new AngleTerm(a, a, a).enumerate(termList, getStruc());
        new TorsionTerm(a, a, a, a).enumerate(termList, getStruc());
        new LongRangeTerm(a, a).enumerate(termList, getStruc());
        // System.out.println("NUMBER OF TERMS IS " + termList.size());
    }
}
