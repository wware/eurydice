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
import net.willware.eurydice.core.Region;
import net.willware.eurydice.db.IStructureDatabase;
import net.willware.eurydice.math.Vector;

public class DatabaseTests extends TestCase {
    private class TestDatabase implements IStructureDatabase {
        private Map<UUID,Object> everything;
        private TestDatabase() {
            everything = new HashMap<UUID,Object>();
        }
        public boolean store(Structure ip) {
            if (ip == null)
                throw new IllegalArgumentException();
            everything.put(ip.getUUID(), ip);
            return true;
        }
        public Structure fetch(UUID uuid) {
            if (uuid == null)
                throw new IllegalArgumentException();
            return (Structure) everything.get(uuid);
        }
        public Structure fetchByRegion(UUID uuid, Region r) {
            if (uuid == null)
                throw new IllegalArgumentException();
            Structure struc = (Structure) everything.get(uuid);
            return struc.sublist(r);
        }
    }
    private class TestSmallPositionList extends Structure {
        Properties metadata;
        private List<Vector> lst;
        public TestSmallPositionList(UUID parentUUID) {
            super(parentUUID);
            lst = new ArrayList<Vector>();
        }
        public Region getBoundingBox() {
            return null;
        }
        public TestSmallPositionList clone() {
            TestSmallPositionList newguy = new TestSmallPositionList(getUUID());
            // same UUID? different UUID?
            newguy.metadata = metadata;
            newguy.lst = new ArrayList<Vector>();
            for (Vector v: lst)
                newguy.lst.add(v);
            return newguy;
        }
        public Structure sublist(Region r) {
            throw new RuntimeException("not implemented yet");
        }
        public Iterator<Atom> getIterator() {
            throw new RuntimeException("not implemented yet");
        }
        public Properties getMetadata() {
            return metadata;
        }
        public long size() {
            return 0;
        }
        public long indexOf(Atom a) {
            return 0;
        }
        public void set(long index, Atom a) {
            throw new RuntimeException("not implemented yet");
        }
        public Atom get(long index) {
            throw new RuntimeException("not implemented yet");
        }
        public int numJigs() {
            return 0;
        }
        public Jig getJig(int index) {
            return null;
        }
        public List<Bond> inferBonds() {
            throw new RuntimeException("not implemented yet");
        }
    }
    private static final long BigNumberOfAtoms = 1L << 33;  // a little too big for 32-bit index
    private class TestBigPositionList extends Structure {
        Properties metadata;
        private List<Vector> lst;
        public TestBigPositionList(UUID parentUUID) {
            super(parentUUID);
            lst = new ArrayList<Vector>();
        }
        public Region getBoundingBox() {
            return null;
        }
        /**
         * The reason this is problematic is that a Topology is presumed to be a structure residing
         * in the memory of a single desktop, but if you have say 100 billion atom types, that
         * won't work. That's why we have
         * {@link IStructureDatabase#fetchTopologyByRegion}. Maybe that's unnecessary if an implementor
         * of ITopology acts as a database proxy.
         */
        public long indexOf(Atom a) {
            throw new RuntimeException("problematic for big structures");
        }
        public long size() {
            return BigNumberOfAtoms;
        }
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
        public Structure sublist(Region r) {
            throw new RuntimeException("not implemented yet");
        }
        public Iterator<Atom> getIterator() {
            throw new RuntimeException("not implemented yet");
        }
        public Properties getMetadata() {
            return metadata;
        }
        public Atom get(long index) {
            throw new RuntimeException("not implemented yet");
        }
        public void set(long index, Atom a) {
            throw new RuntimeException("not implemented yet");
        }
        public int numJigs() {
            return 0;
        }
        public Jig getJig(int index) {
            return null;
        }
        public List<Bond> inferBonds() {
            // atoms are too far apart to be bonded
            return new ArrayList<Bond>();
        }
    }
    private static DatabaseTests instance = null;
    public static DatabaseTests getInstance() {
        if (instance == null)
            instance = new DatabaseTests();
        return instance;
    }

    // @Test
    public void testBasicDbOperations() {
        TestSmallPositionList struc = new TestSmallPositionList(null);
        IStructureDatabase sdb = new TestDatabase();
        TestCase.assertTrue(sdb.store(struc));
        TestCase.assertEquals(sdb.fetch(struc.getUUID()), struc);
        Structure child = struc.clone();
        TestCase.assertNotSame(struc, child);
        TestCase.assertTrue(sdb.store(child));
        TestCase.assertEquals(sdb.fetch(child.getUUID()), child);
    }

    // @Test
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

    public static Test suite() {
        return new TestSuite(DatabaseTests.class);
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
