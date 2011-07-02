package net.willware.eurydice.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Jig;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.core.StructureImpl;
import net.willware.eurydice.db.IStructureDatabase;
import net.willware.eurydice.math.Region;
import net.willware.eurydice.math.Vector;

/**
 * JUnit tests for database mechanics.
 */
public class DatabaseTests extends TestCase {

    /**
     * A simple test database.
     */
    private class TestDatabase implements IStructureDatabase {

        /** All the structures (and anything else) this database knows about. */
        private Map<UUID,Object> everything;

        /**
         * Constructor.
         */
        private TestDatabase() {
            everything = new HashMap<UUID,Object>();
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.db.IStructureDatabase#store(net.willware.eurydice.core.Structure)
         */
        public boolean store(Structure ip) {
            if (ip == null)
                throw new IllegalArgumentException();
            everything.put(ip.getUUID(), ip);
            return true;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.db.IStructureDatabase#fetch(java.util.UUID)
         */
        public Structure fetch(UUID uuid) {
            if (uuid == null)
                throw new IllegalArgumentException();
            return (Structure) everything.get(uuid);
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.db.IStructureDatabase#fetchByRegion(java.util.UUID, net.willware.eurydice.math.Region)
         */
        public Structure fetchByRegion(UUID uuid, Region r) {
            if (uuid == null)
                throw new IllegalArgumentException();
            Structure struc = (Structure) everything.get(uuid);
            return struc.sublist(r);
        }
    }

    /**
     * The Class TestSmallStructure.
     */
    private class TestSmallStructure extends StructureImpl {

        /** The metadata. */
        Properties metadata;

        /**
         * Instantiates a new test small structure.
         *
         * @param parentUUID the parent uuid
         */
        public TestSmallStructure(UUID parentUUID) {
            super(parentUUID);
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#getBoundingBox()
         */
        public Region getBoundingBox() {
            return null;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#clone()
         */
        public TestSmallStructure clone() {
            UUID uuid = getUUID();
            TestSmallStructure newguy = new TestSmallStructure(uuid);
            // same UUID? different UUID?
            newguy.metadata = metadata;
            return newguy;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#sublist(net.willware.eurydice.math.Region)
         */
        public Structure sublist(Region r) {
            throw new RuntimeException("not implemented yet");
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#getIterator()
         */
        public Iterator<Atom> getIterator() {
            return new Iterator<Atom>() {
                public boolean hasNext() {
                    return false;
                }
                public Atom next() {
                    return null;
                }
                public void remove() { }
            };
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#getMetadata()
         */
        public Properties getMetadata() {
            return metadata;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#size()
         */
        public long size() {
            return 0;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#indexOf(net.willware.eurydice.core.Atom)
         */
        public long indexOf(Atom a) {
            return 0;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#get(long)
         */
        public Atom get(long index) {
            throw new RuntimeException("not implemented yet");
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#numJigs()
         */
        public int numJigs() {
            return 0;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#getJig(int)
         */
        public Jig getJig(int index) {
            return null;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#inferBonds()
         */
        public List<Bond> inferBonds() {
            throw new RuntimeException("not implemented yet");
        }
    }

    /** The Constant BigNumberOfAtoms. */
    private static final long BigNumberOfAtoms = 1L << 33;  // a little too big for 32-bit index

    /**
     * The Class TestBigPositionList.
     */
    private class TestBigPositionList extends StructureImpl {

        /** The metadata. */
        Properties metadata;

        /** The lst. */
        private List<Vector> lst;

        /**
         * Instantiates a new test big position list.
         *
         * @param parentUUID the parent uuid
         */
        public TestBigPositionList(UUID parentUUID) {
            super(parentUUID);
            lst = new ArrayList<Vector>();
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#getBoundingBox()
         */
        public Region getBoundingBox() {
            return null;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#indexOf(net.willware.eurydice.core.Atom)
         */
        public long indexOf(Atom a) {
            throw new RuntimeException("not implemented yet");
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#size()
         */
        public long size() {
            return BigNumberOfAtoms;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#clone()
         */
        public TestBigPositionList clone() {
            TestBigPositionList newguy =
                new TestBigPositionList(getUUID());
            // same UUID? different UUID?
            newguy.metadata = metadata;
            newguy.lst = new ArrayList<Vector>();
            for (Vector v: lst)
                newguy.lst.add(v);
            return newguy;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#sublist(net.willware.eurydice.math.Region)
         */
        public Structure sublist(Region r) {
            throw new RuntimeException("not implemented yet");
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#getIterator()
         */
        public Iterator<Atom> getIterator() {
            return new Iterator<Atom>() {
                public boolean hasNext() {
                    return false;
                }
                public Atom next() {
                    return null;
                }
                public void remove() { }
            };
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#getMetadata()
         */
        public Properties getMetadata() {
            return metadata;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#get(long)
         */
        public Atom get(long index) {
            throw new RuntimeException("not implemented yet");
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#numJigs()
         */
        public int numJigs() {
            return 0;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#getJig(int)
         */
        public Jig getJig(int index) {
            return null;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#inferBonds()
         */
        public List<Bond> inferBonds() {
            // atoms are too far apart to be bonded
            return new ArrayList<Bond>();
        }
    }

    /** A singleton instance of this class. */
    private static DatabaseTests instance = null;

    /**
     * Gets the singleton instance of DatabaseTests.
     *
     * @return singleton instance of DatabaseTests
     */
    public static DatabaseTests getInstance() {
        if (instance == null)
            instance = new DatabaseTests();
        return instance;
    }

    // @Test
    /**
     * Test basic db operations.
     */
    public void testBasicDbOperations() {
        TestSmallStructure struc = new TestSmallStructure(null);
        IStructureDatabase sdb = new TestDatabase();
        TestCase.assertTrue(sdb.store(struc));
        Structure s = sdb.fetch(struc.getUUID());
        TestCase.assertEquals("expected: " + struc.toJson() + ", got: " + s.toJson(),
                              struc, s);
        TestCase.assertEquals("expected: " + struc.getUUID() + ", got: " + s.getUUID(),
                              struc.getUUID(), s.getUUID());
        Structure child = struc.clone();
        TestCase.assertNotSame(struc, child);
        TestCase.assertTrue(sdb.store(child));
        s = sdb.fetch(child.getUUID());
        TestCase.assertEquals("expected: " + child.toJson() + ", got: " + s.toJson(),
                              child, s);
        TestCase.assertEquals("expected: " + child.getUUID() + ", got: " + s.getUUID(),
                              child.getUUID(), s.getUUID());
    }

    // @Test
    /**
     * Test a big structure.
     */
    public void testBigStructure() {
        TestBigPositionList struc = new TestBigPositionList(null);
        IStructureDatabase sdb = new TestDatabase();
        TestCase.assertTrue(sdb.store(struc));
        TestCase.assertEquals(sdb.fetch(struc.getUUID()), struc);
        Structure child = struc.clone();
        TestCase.assertNotSame(struc, child);
        TestCase.assertTrue(sdb.store(child));
        TestCase.assertEquals(sdb.fetch(child.getUUID()), child);
    }

    /**
     * Suite.
     *
     * @return the test
     */
    public static Test suite() {
        return new TestSuite(DatabaseTests.class);
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
