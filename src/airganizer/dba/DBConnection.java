package airganizer.dba;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author pat
 */

public class DBConnection {
        
    
    // Verbindungskonfigurationen
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String PATH = "jdbc:mysql://";
    private static String ADDRESS;
    private static String DBNAME;
    private static String DBUSER;
    private static String DBPWD;
    
    // Allgemeine Variablen
    private static final String CONFIG_PROP= "mysqlconfig.properties";
       
    
    // Generiert eine Verbindung zur DB
    // Lädt die Treiber
    
    public static Connection connect(){
                      
        try {
            
            Connection con;
            
            // MySQL-Treiber laden
            Class.forName(DRIVER).newInstance();
            
            // Verbindung zur Datenbank aufbauen
            con = DriverManager.getConnection(PATH + ADDRESS + "/"+ DBNAME, DBUSER, DBPWD);
            
            System.out.println("Connection connected...");
            
            return con;

        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {

            System.err.println("SQLException: " + e.getMessage());
            
            return null;

        }
        
     }
    
    
    public static void disconnect(Connection con){
                 
            // Verbindung beenden
            if (con != null){
                
                try {
                        con.close();
                        System.out.println("Connection disconnected"); 
                        
                } catch (Exception e){
                
                }
            }
    }
    

     // Properties-Datei auslesen 
     // (Klassenmethode)
     
     public static boolean loadProperties(){
         
         Properties mysqlprop = new Properties();
         
         try {
            
            // Properties-Datei laden
            mysqlprop.load(DBConnection.class.getResourceAsStream(CONFIG_PROP));
                    
           
            // Werte auslesen
            ADDRESS = mysqlprop.getProperty("ADDRESS");
            DBNAME = mysqlprop.getProperty("DBNAME");
            DBUSER = mysqlprop.getProperty("DBUSER");
            DBPWD = mysqlprop.getProperty("DBPWD");
                       
        
        } catch (IOException ex){
            System.err.println(ex);
            return false;
        }
         
         
         return true;
     }
     
     
     // Properties-Datei aktualisieren 
     // (Klassenmethode)
     
     public static boolean setProperties(String address, String dbname, String dbuser, String dbpwd){
         
         Properties mysqlprop = new Properties();
         
         try {
       
            // Werte setzen
            mysqlprop.setProperty("ADDRESS", address);
            mysqlprop.setProperty("DBNAME", dbname);
            mysqlprop.setProperty("DBUSER", dbuser);
            mysqlprop.setProperty("DBPWD", dbpwd);
            
            
            // Werte speichern
            mysqlprop.store(new FileOutputStream(CONFIG_PROP), null);
            
            
         } catch (IOException ex) {
             System.err.println(ex);
             return false;
         }
         
         
         return true;
     }
     
     
     
     // Properties-Datei auslesen 
     // (Klassenmethode)
     
     public static Map<String,String> getProperties(){
         
         Properties mysqlprop = new Properties();
         Map<String, String> configMap = new HashMap<>();
         
         try {
            
            // Properties-Datei laden
            mysqlprop.load(DBConnection.class.getResourceAsStream(CONFIG_PROP));
                    
            // Werte auslesen
            configMap.put("Adresse", mysqlprop.getProperty("ADDRESS"));
            configMap.put("Name", mysqlprop.getProperty("DBNAME"));
            configMap.put("User", mysqlprop.getProperty("DBUSER"));
            configMap.put("Passwort", mysqlprop.getProperty("DBPWD"));
                       
        
        } catch (IOException ex){
            System.err.println(ex);
            return null;
        }
         
         
         return configMap;
     }    
         
}
