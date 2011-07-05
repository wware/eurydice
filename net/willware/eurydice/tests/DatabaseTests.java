package net.willware.eurydice.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Bond;
import net.willware.eurydice.core.Jig;
import net.willware.eurydice.core.Properties;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.core.StructureImpl;
import net.willware.eurydice.core.UniqueId;
import net.willware.eurydice.db.StructureDatabase;
import net.willware.eurydice.math.Region;
import net.willware.eurydice.math.Vector;

/**
 * JUnit tests for database mechanics.
 */
public class DatabaseTests extends TestCase {

    /**
     * A simple test database.
     */
    private class TestDatabase implements StructureDatabase {

        /** All the structures (and anything else) this database knows about. */
        private Map<UniqueId,Object> everything;

        /**
         * Constructor.
         */
        private TestDatabase() {
            everything = new HashMap<UniqueId,Object>();
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.db.StructureDatabase#store(net.willware.eurydice.core.Structure)
         */
        public boolean store(Structure ip) {
            if (ip == null)
                throw new IllegalArgumentException();
            everything.put(ip.getUniqueId(), ip);
            return true;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.db.StructureDatabase#fetch(net.willware.eurydice.core.UniqueId)
         */
        public Structure fetch(UniqueId uid) {
            if (uid == null)
                throw new IllegalArgumentException();
            return (Structure) everything.get(uid);
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.db.StructureDatabase#fetchByRegion(net.willware.eurydice.core.UniqueId, net.willware.eurydice.math.Region)
         */
        public Structure fetchByRegion(UniqueId uid, Region r) {
            if (uid == null)
                throw new IllegalArgumentException();
            Structure struc = (Structure) everything.get(uid);
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
         * @param parentID the parent unique id
         */
        public TestSmallStructure(UniqueId parentID) {
            super(parentID);
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
            UniqueId uid = new UniqueIdImpl();
            TestSmallStructure newguy = new TestSmallStructure(uid);
            // same unique ID? different unique ID?
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
        public int size() {
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
        public Atom get(int index) {
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
         * @param parentID the parent unique id
         */
        public TestBigPositionList(UniqueId parentID) {
            super(parentID);
            lst = new ArrayList<Vector>();
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.core.StructureImpl#size()
         */
        public int size() throws IndexOutOfBoundsException {
            throw new IndexOutOfBoundsException();
        }

        /* (non-Javadoc)
         * @see java.lang.Object#clone()
         */
        public TestBigPositionList clone() {
            TestBigPositionList newguy =
                new TestBigPositionList(getUniqueId());
            // same unique ID? different unique ID?
            newguy.metadata = metadata;
            newguy.lst = new ArrayList<Vector>();
            for (Vector v: lst)
                newguy.lst.add(v);
            return newguy;
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
        StructureDatabase sdb = new TestDatabase();
        TestCase.assertTrue(sdb.store(struc));
        Structure s = sdb.fetch(struc.getUniqueId());
        TestCase.assertEquals("expected: " + struc.toJson() + ", got: " + s.toJson(),
                              struc, s);
        TestCase.assertEquals("expected: " + struc.getUniqueId() + ", got: " + s.getUniqueId(),
                              struc.getUniqueId(), s.getUniqueId());
        Structure child = struc.clone();
        TestCase.assertNotSame(struc, child);
        TestCase.assertTrue(sdb.store(child));
        s = sdb.fetch(child.getUniqueId());
        TestCase.assertEquals("expected: " + child.toJson() + ", got: " + s.toJson(),
                              child, s);
        TestCase.assertEquals("expected: " + child.getUniqueId() + ", got: " + s.getUniqueId(),
                              child.getUniqueId(), s.getUniqueId());
    }

    // @Test
    /**
     * Test a big structure.
     */
    public void testBigStructure() {
        TestBigPositionList struc = new TestBigPositionList(null);
        StructureDatabase sdb = new TestDatabase();
        TestCase.assertTrue(sdb.store(struc));
        TestCase.assertEquals(sdb.fetch(struc.getUniqueId()), struc);
        Structure child = struc.clone();
        TestCase.assertNotSame(struc, child);
        TestCase.assertTrue(sdb.store(child));
        TestCase.assertEquals(sdb.fetch(child.getUniqueId()), child);
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
