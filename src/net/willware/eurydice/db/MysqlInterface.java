package net.willware.eurydice.db;

import java.sql.ResultSet;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.AtomMutable;
import net.willware.eurydice.core.Jig;
import net.willware.eurydice.core.JigMutable;
import net.willware.eurydice.core.JigMutableImpl;
import net.willware.eurydice.core.StructureMutableImpl;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.core.UniqueId;
import net.willware.eurydice.core.UniqueIdSettableImpl;
import net.willware.eurydice.elements.ElementFactory;
import net.willware.eurydice.library.StructureLibrary;
import net.willware.eurydice.math.Region;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.serialization.XyzFile;

/**
 * MysqlInterface is an interface between the Java code and a MySQL database.
 */
public class MysqlInterface implements StructureDatabase {

    /** The driver. */
    private static Object driver = null;

    /** The connect string. */
    private String connectString;

    /**
     * Constructor.
     *
     * @param host the host
     * @param user the user
     * @param pw the pw
     * @param name the name
     */
    public MysqlInterface(String host, String user, String pw, String name) {
        connectString = "jdbc:mysql://" + host + "/" + name + "?user=" + user + "&password=" + pw;
        if (driver == null) {
            try {
                // The newInstance() call is a work around for some broken Java implementations
                // I think we just instantiate it and forget it, only need to do that once
                // It's a bad idea to do imports of com.mysql.jdbc things for some reason
                driver = Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * A convenient way to build closures to handle results from
     * SQL queries and updates.
     */
    private interface ResultSetHandler {
        /**
         * Handle one row of the result from a SQL query or update.
         *
         * @param rs the ResultSet providing rows
         * @throws SQLException if anything goes wrong
         */
        public void handleResult(ResultSet rs) throws SQLException;
    }

    /**
     * Perform an SQL query or update.
     *
     * @param queryString the SQL query string
     * @param handler the handler
     * @param ignoreSqlError the ignore sql error
     */
    private void sqlQuery(String queryString, ResultSetHandler handler, boolean ignoreSqlError) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(connectString);
            stmt = conn.createStatement();
            if (stmt.execute(queryString)) {
                rs = stmt.getResultSet();
            }
            if (rs != null && handler != null) {
                boolean firstTime = true;
                try {
                    while (rs.next()) {
                        handler.handleResult(rs);
                    }
                } catch (SQLException ex) {
                    if (firstTime && !ignoreSqlError) {
                        System.out.println("QUERY STRING: " + queryString);
                        System.out.println("SQLException: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("VendorError: " + ex.getErrorCode());
                    }
                    firstTime = false;
                }
            }
        } catch (SQLException ex) {
            if (!ignoreSqlError) {
                System.out.println("QUERY STRING: " + queryString);
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) { }
                conn = null;
            }
        }
    }

    /**
     * AddAtomHandler handles the addition of atoms to a structure as they are read out of the database.
     */
    private class AddAtomHandler implements ResultSetHandler {

        /** The struc. */
        private StructureMutableImpl struc;

        /**
         * Constructor.
         *
         * @param struc the structure to which atoms will be added
         */
        public AddAtomHandler(StructureMutableImpl struc) {
            this.struc = struc;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.db.MysqlInterface.ResultSetHandler#handleResult(java.sql.ResultSet)
         */
        public void handleResult(ResultSet rs) throws SQLException {
            Atom a = ElementFactory.getInstance().get(rs.getString("element"));
            String hyb = rs.getString("hybridization");
            if      ("NONE".equals(hyb)) a.setHybridization(Atom.NONE);
            else if ("SP".equals(hyb))   a.setHybridization(Atom.SP);
            else if ("SP2".equals(hyb))  a.setHybridization(Atom.SP2);
            else                         a.setHybridization(Atom.SP3);
            a.setPosition(new Vector(rs.getDouble("x"),
                                     rs.getDouble("y"),
                                     rs.getDouble("z")));
            // TODO: fix dependency injection here
            ((AtomMutable)a).setUniqueId(new UniqueIdSettableImpl((int) rs.getLong("id")));
            struc.addAtom(a);
        }
    }

    /**
     * AddJigHandler handles the addition of jigs to a structure as they are read out of the database.
     */
    private class AddJigHandler implements ResultSetHandler {

        /** The struc. */
        private StructureMutableImpl struc;

        /**
         * Constructor.
         *
         * @param struc the structure to which jigs will be added
         */
        public AddJigHandler(StructureMutableImpl struc) {
            this.struc = struc;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.db.MysqlInterface.ResultSetHandler#handleResult(java.sql.ResultSet)
         */
        public void handleResult(ResultSet rs) throws SQLException {
            JigMutable j = JigMutableImpl.getJig(struc, rs.getString("jigtype"));
            j.loadProperties(rs.getString("properties"));
            struc.addJig(j);
        }
    }

    /**
     * AddJigHandler handles the addition of jigs to a structure as they are read out of the database.
     */
    private class StructureIdFetchHandler implements ResultSetHandler {

        /** The id. */
        private long id;

        /**
         * Gets the id.
         *
         * @return the id
         */
        public long getId() {
            return id;
        }

        /* (non-Javadoc)
         * @see net.willware.eurydice.db.MysqlInterface.ResultSetHandler#handleResult(java.sql.ResultSet)
         */
        public void handleResult(ResultSet rs) throws SQLException {
            id = rs.getLong("id");
        }
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.db.StructureDatabase#fetch(net.willware.eurydice.core.UniqueId)
     */
    @Override
    public Structure fetch(UniqueId id) {
        // if you're calling fetch(), you expect the whole structure to fit in RAM
        // so that would be a SmallStructure
        StructureMutableImpl struc = new StructureMutableImpl();
        struc.setParentUniqueId(id);
        StructureIdFetchHandler fetcher = new StructureIdFetchHandler();
        sqlQuery("SELECT * FROM structures WHERE uid=\"" + id.toInteger() + "\"",
                 fetcher, false);
        long strucId = fetcher.getId();
        sqlQuery("SELECT * FROM atoms WHERE structureId=" + strucId,
                 new AddAtomHandler(struc), false);
        sqlQuery("SELECT * FROM jigs WHERE structureId=" + strucId,
                 new AddJigHandler(struc), false);
        return struc;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.db.StructureDatabase#fetchByRegion(net.willware.eurydice.core.UniqueId, net.willware.eurydice.core.Region)
     */
    @Override
    public Structure fetchByRegion(UniqueId id, Region r) {
        Vector vmin = r.getMinCorner();
        Vector vmax = r.getMaxCorner();
        StructureMutableImpl struc = new StructureMutableImpl();
        struc.setParentUniqueId(id);
        StructureIdFetchHandler fetcher = new StructureIdFetchHandler();
        sqlQuery("SELECT * FROM structures WHERE uid=" + id.toInteger(), fetcher, false);
        long strucId = fetcher.getId();
        sqlQuery("SELECT * FROM atoms WHERE structureId=" + strucId +
                 " AND x >= " + vmin.getX() + " AND x < " + vmax.getX() +
                 " AND y >= " + vmin.getY() + " AND y < " + vmax.getY() +
                 " AND z >= " + vmin.getZ() + " AND z < " + vmax.getZ(),
                 new AddAtomHandler(struc), false);
        sqlQuery("SELECT * FROM jigs WHERE structureId=" + strucId,
                 new AddJigHandler(struc), false);
        return struc;
    }

    /* (non-Javadoc)
     * @see net.willware.eurydice.db.StructureDatabase#store(net.willware.eurydice.core.Structure)
     */
    @Override
    public boolean store(Structure s) {
        // create this structure if it doesn't already exist, ignore error if it does
        UniqueId pid = s.getParentUniqueId();
        String idString = "\"" + s.getUniqueId().toInteger() + "\"";
        String metadataString = "\"" + s.getMetadata() + "\"";
        if (pid != null) {
            String parentIdString = "\"" + pid + "\"";
            sqlQuery("INSERT INTO structures (id,parentId,metadata) VALUES (" +
                     idString + "," + parentIdString + "," + metadataString + ")",
                     null, true);
        } else {
            sqlQuery("INSERT INTO structures (id,metadata) VALUES (" +
                     idString + "," + metadataString + ")", null, true);
        }
        // get the mysql-assigned ID (distinct from user-assigned unique ID) for the structure
        StructureIdFetchHandler fetcher = new StructureIdFetchHandler();
        sqlQuery("SELECT * FROM structures WHERE uid=" + idString, fetcher, false);
        long strucId = fetcher.getId();
        // store atoms, deleting any previous versions of them first
        Iterator<Atom> atomiter = s.getIterator();
        while (atomiter.hasNext()) {
            Atom a = atomiter.next();
            sqlQuery("DELETE FROM atoms WHERE structureId=" + strucId +
                     " AND id=" + a.getUniqueId(), null, false);
            Vector p = a.getPosition();
            sqlQuery("INSERT INTO atoms (id,structureId,element,hybridization,x,y,z) VALUES (" +
                     a.getUniqueId() + "," + strucId + ",\"" + a.getSymbol() + "\"," +
                     "\"" + a.getHybridizationString() + "\"," +
                     p.getX() + "," + p.getY() + "," + p.getZ() + ")", null, false);
        }
        // delete any jigs with the same IDs of these jigs, then store jigs
        int numJigs = s.numJigs();
        for (int i = 0; i < numJigs; i++) {
            Jig j = s.getJig(i);
            sqlQuery("DELETE FROM jigs WHERE structureId=" + strucId +
                     " AND id=" + i, null, false);
            sqlQuery("INSERT INTO jigs (id,structureId,jigtype,properties) VALUES (" +
                     i + "," + strucId + ",\"" + j.getClass() + "\"," +
                     "\"" + j.getProperties() + "\")", null, false);
        }
        return true;
    }

    /**
     * The main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        MysqlInterface mysql = new MysqlInterface(
            "localhost", "root", "", "eurydice");
        Structure s = StructureLibrary.get("Propane");
        XyzFile.print(s);
        mysql.store(s);
        mysql.store(s);
        Structure s2 = mysql.fetch(s.getUniqueId());
        XyzFile.print(s2);
    }
}
