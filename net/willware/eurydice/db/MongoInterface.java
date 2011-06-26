package net.willware.eurydice.db;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Properties;
import java.util.UUID;

import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.Jig;
import net.willware.eurydice.core.Region;
import net.willware.eurydice.core.SmallStructure;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.serialization.XyzFile;

/**
 * A database interface for MongoDB. You'll need a MongoDB driver for Java,
 * <a href="https://github.com/mongodb/mongo-java-driver/downloads">available here</a>, which
 * must match the version of MongoDB you're using. On Ubuntu 10.04, the official MongoDB package
 * is version 1.2, so I'm using the <tt>mongo-1.2.jar</tt> driver.
 * @see <a href="http://www.mongodb.org/display/DOCS/Java+Tutorial">MongoDB Java tutorial</a>
 */
public class MongoInterface implements IStructureDatabase {

    private Mongo mongo;
    private DB db;

    /**
     * Constructor.
     *
     * @param host the mongo server hostname
     * @param port the mongo server port number
     */
    public MongoInterface(String host, int port) {
        db = null;
        try {
            mongo = new Mongo(host, port);
            db = mongo.getDB("eurydice");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    private DBCursor query(String table, BasicDBObject q) {
        return db.getCollection(table).find(q);
    }

    private void insert(String table, DBObject obj) {
        db.getCollection(table).insert(obj);
    }

    private void remove(String table, DBObject obj) {
        db.getCollection(table).remove(obj);
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.db.IStructureDatabase#fetch(java.util.UUID)
     */
    @Override
    public Structure fetch(UUID uuid) {
        // if you're calling fetch(), you expect the whole structure to fit in RAM
        // so that would be a SmallStructure
        try {
            BasicDBObject query;
            DBObject obj = null;
            DBCursor cur;
            query = new BasicDBObject();
            query.put("uuid", uuid.toString());
            cur = query("structures", query);
            while (cur.hasNext()) {
                obj = cur.next();
            }
            if (obj == null)
                return null;
            SmallStructure struc = new SmallStructure((UUID) obj.get("parentUuid"));
            struc.setUUID(uuid);
            query = new BasicDBObject();
            query.put("strucUuid", uuid.toString());
            cur = query("atoms", query);
            while (cur.hasNext()) {
                obj = cur.next();
                Atom a = Atom.getElement((String) obj.get("element"));    // C, H, O, N, etc
                a.setId((Long) obj.get("id"));
                String hyb = (String) obj.get("hybridization");
                if      ("NONE".equals(hyb)) a.setHybridization(Atom.NONE);
                else if ("SP".equals(hyb))   a.setHybridization(Atom.SP);
                else if ("SP2".equals(hyb))  a.setHybridization(Atom.SP2);
                else                         a.setHybridization(Atom.SP3);
                a.setPosition(new Vector(
                                  (Double) obj.get("x"),
                                  (Double) obj.get("y"),
                                  (Double) obj.get("z")));
                struc.addAtom(a);
            }
            struc.setUUID(uuid);
            query = new BasicDBObject();
            query.put("strucUuid", uuid.toString());
            cur = query("jigs", query);
            while (cur.hasNext()) {
                obj = cur.next();
                Jig j = Jig.getJig(struc, (String) obj.get("jigtype"));
                j.setProperties((Properties) obj.get("properties"));
                struc.addJig(j);
            }
            return struc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.db.IStructureDatabase#fetchByRegion(java.util.UUID, net.willware.eurydice.core.Region)
     */
    @Override
    public Structure fetchByRegion(UUID uuid, Region r) {
        // TODO IMPLEMENT ME!
        return null;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.db.IStructureDatabase#store(net.willware.eurydice.core.Structure)
     */
    @Override
    public boolean store(Structure s) {
        try {
            BasicDBObject query, doc;
            DBCursor cur;
            // create this structure if it doesn't already exist
            UUID uuid = s.getUUID();
            UUID pid = s.getParentUUID();
            query = new BasicDBObject();
            query.put("uuid", uuid.toString());
            cur = query("structures", query);
            boolean strucExistsAlready = false;
            while (cur.hasNext()) {
                strucExistsAlready = true;
                cur.next();
            }
            if (!strucExistsAlready) {
                doc = new BasicDBObject();
                doc.put("uuid", uuid.toString());
                if (pid != null)
                    doc.put("parentUuid", pid);
                doc.put("metadata", s.getMetadata());
                insert("structures", doc);
            }
            // MongoDB doesn't assign a separate ID to the structure, we use UUID everywhere
            // store atoms, deleting any previous versions of them first
            Iterator<Atom> atomiter = s.getIterator();
            while (atomiter.hasNext()) {
                Atom a = atomiter.next();
                // delete any earlier instance of the atom
                query = new BasicDBObject();
                query.put("strucUuid", uuid.toString());
                query.put("id", a.getId());
                cur = query("atoms", query);
                while (cur.hasNext()) {
                    remove("atoms", cur.next());
                }
                // store the atom
                doc = new BasicDBObject();
                doc.put("strucUuid", uuid.toString());
                doc.put("id", a.getId());
                doc.put("element", a.symbol());
                doc.put("hybridization", a.getHybridizationString());
                Vector p = a.getPosition();
                doc.put("x", p.getX());
                doc.put("y", p.getY());
                doc.put("z", p.getZ());
                insert("atoms", doc);
            }
            // delete any jigs with the same IDs of these jigs, then store jigs
            int numJigs = s.numJigs();
            for (int i = 0; i < numJigs; i++) {
                Jig j = s.getJig(i);
                // delete any earlier instance of the jig
                query = new BasicDBObject();
                query.put("strucUuid", uuid.toString());
                query.put("id", i);
                cur = query("jigs", query);
                while (cur.hasNext()) {
                    remove("jigs", cur.next());
                }
                // store the atom
                doc = new BasicDBObject();
                doc.put("strucUuid", uuid.toString());
                doc.put("id", i);
                doc.put("jigtype", j.getClass());
                doc.put("properties", j.getProperties());
                insert("jigs", doc);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * The main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Structure s = new net.willware.eurydice.library.Propane();
        XyzFile.print(s);
        // DO NOT USE "localhost" here! It will incorrectly choose "127.0.1.1"
        // Why?? Don't know.
        MongoInterface mongo = new MongoInterface("127.0.0.1", 27017);
        if (!mongo.store(s))
            System.out.println("ouch");
        if (!mongo.store(s))
            System.out.println("ouch");
        Structure s2 = mongo.fetch(s.getUUID());
        XyzFile.print(s2);
        if (!s.equals(s2))
            System.out.println("ouch");
    }
}
