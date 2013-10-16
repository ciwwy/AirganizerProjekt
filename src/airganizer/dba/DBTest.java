/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airganizer.dba;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pat
 */
public class DBTest{
    
    
     // Verbindungskonfigurationen
     private static String DRIVER = "com.mysql.jdbc.Driver";
     private static String PATH = "jdbc:mysql://";
    
      
     // Erzeugt eine Test-Verbindung
     
     public static Boolean test(){
                      
        try {
            
            Connection con;
            
            // Neue Verbindung
            con = DBConnection.connect();
            
            // Schließt Verbindung
            DBConnection.disconnect(con);
            
            return true;

        }
        catch(Exception e) {

            System.err.println("SQLException: " + e.getMessage());
            
            return false;

        }
        
     }
        // Erzeugt eine Test-Verbindung mit eigenen Verbindungsdaten
     
     public static Boolean test(String address, String dbname, String dbuser, String dbpwd){
                      
        try {
            
            Connection con;
            
            // MySQL-Treiber laden
            Class.forName(DRIVER).newInstance();
            
            // Verbindung zur Datenbank aufbauen
            con = DriverManager.getConnection(PATH + address + "/"+ dbname, dbuser, dbpwd);
            
            DBConnection.disconnect(con);
            
            return true;

        }
        
        catch(Exception e) {

            System.err.println("SQLException: " + e.getMessage());
            
            return false;

        }
        
     }
        
}
