package net.willware.eurydice.core;

/**
 * Process all chains of two, three, or four atoms connected by chemical bonds.
 * Ordinarily I'd use an interface here, but these print statements will be handy
 * for debugging.
 */
public class BondChainProcessor {

    /**
     * This atom already appears in this chain somewhere; we need to know this to
     * avoid chains that go back and forth between the same couple of atoms.
     *
     * @param a the atom to check
     * @return true if the atom is already in the chain
     */
    public boolean alreadyHave(Atom a) {
        return false;
    }

    /**
     * Process a chain of two atoms connected by one chemical bond.
     *
     * @param a1 the first atom in the chain
     * @param a2 the second atom in the chain
     */
    public void process2(Atom a1, Atom a2) {
        System.out.println("process2(" + a1 + ", " + a2 + ");");
    }

    /**
     * Process a chain of three atoms connected by two chemical bonds.
     *
     * @param a1 the first atom in the chain
     * @param a2 the second atom in the chain
     * @param a3 the third atom in the chain
     */
    public void process3(Atom a1, Atom a2, Atom a3) {
        System.out.println("process3(" + a1 + ", " + a2 + ", " + a3 + ");");
    }

    /**
     * Process a chain of four atoms connected by three chemical bonds.
     *
     * @param a1 the first atom in the chain
     * @param a2 the second atom in the chain
     * @param a3 the third atom in the chain
     * @param a4 the fourth atom in the chain
     */
    public void process4(Atom a1, Atom a2, Atom a3, Atom a4) {
        System.out.println("process4(" + a1 + ", " + a2 + ", " + a3 + ", " + a4 + ");");
    }
}
