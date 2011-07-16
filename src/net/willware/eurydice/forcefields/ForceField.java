package net.willware.eurydice.forcefields;

import net.willware.eurydice.core.JigMutableImpl;

/**
 * Force fields (such as MM2 or GROMACS) compute forces just as jigs do.
 * @see <a href="http://en.wikipedia.org/wiki/Force_field_(chemistry)">Wikipedia entry for Force Field</a>
 */
public abstract class ForceField extends JigMutableImpl {
    /**
     * Since a force field may need to update energy terms or other bookkeeping when
     * atoms or bonds are added or deleted, there needs to be a way to notify the
     * force field of changes in the structure.
     */
    public abstract void structureChanged();
}
