package jarden.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestHSQLDB {
    Connection c;

    public static void main(String[] args) throws SQLException {
        TestHSQLDB test = new TestHSQLDB();
        test.launch();
    }

    private void launch() throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            c = DriverManager.getConnection("jdbc:hsqldb:file:data/db.data", "sa", "");
            System.out.println(c);
            PreparedStatement ps = c.prepareStatement("select * from PUBLIC.speaker");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name")+" "+rs.getString("surname"));
            }
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        }
        finally{
            issueShutdownCommand();
            c.close();
        }
       
        
//        try {
//            Thread.sleep(3600000);
//        } catch (InterruptedException e) {
//
//        }
        

    }
    
    private void issueShutdownCommand() throws SQLException{
        PreparedStatement ps = c.prepareStatement("SHUTDOWN");
        ps.execute();
    }
}
