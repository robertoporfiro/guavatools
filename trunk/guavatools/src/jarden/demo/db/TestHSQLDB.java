package jarden.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestHSQLDB {
    Connection c;
    public static void main(String[] args) throws SQLException {
        TestHSQLDB test = new TestHSQLDB();
        test.launch();
    }

    private void launch() throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbcDriver" );
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
       c = DriverManager.getConnection("jdbc:hsqldb:file:data/db.data", "sa", "");
       System.out.println(c);
       try {
        Thread.sleep(3600000);
    } catch (InterruptedException e) {
     
    }
       c.close();
        
    }
}
