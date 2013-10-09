package airganizer.dba;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author pat
 */

public class DBConnection {
        
    
    // Verbindungskonfigurationen
    protected static String DRIVER = "com.mysql.jdbc.Driver";
    protected static String PATH = "jdbc:mysql://";
    protected static String ADDRESS;
    protected static String DBNAME;
    protected static String DBUSER;
    protected static String DBPWD;
    
    // Allgemeine Variablen
    protected static final String CONFIG_PROP= "mysqlconfig.properties";
    protected Connection con = null;
    protected Statement sta = null;
    protected List queryResultSet = new LinkedList();
       
    
    public DBConnection(){
                
        // SQL-Treiber laden
        
        try {

          Class.forName(DRIVER).newInstance();
          System.out.println("LOAD SUCCESSFUL!");

        }
        catch(Exception e) {

          System.err.println("SQLException: " + e.getMessage());

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
     
     
     // SQL-Verbindung aufbauen + Abfrage ausführen
     // Privat, aber vererbbar (protected)
     
     protected List executeQuery(String statement){
         
                          
         try {
            
            // Verbindung zur Datenbank
            con = DriverManager.getConnection(PATH + ADDRESS + "/"+ DBNAME, DBUSER, DBPWD);
            
            // Statement
            sta = con.createStatement();
            
            // Ausführen und zurückgeben
                     
            ResultSet result;
            result = sta.executeQuery(statement);
            
           
            if(result!=null) {
                
                //Spaltenüberschriften (Metadaten)
                
                ResultSetMetaData rsmd = result.getMetaData();
                
                //Abfrageergebnisse ausgeben
                
                //result.beforeFirst();
                
                while(result.next()) {
                     
                    for(int column=1; column<=rsmd.getColumnCount(); column++) {
                        queryResultSet.add(result.getObject(column));                     

                    } 

                }
               
                    result.close();
                }
            

        return queryResultSet;
            
            
        } catch(SQLException e)
        
        { 
            System.err.println("SQLException: " + e.getMessage());
            return null;
            
        } finally {
            
            // Abfrage beenden
            if(sta!=null){
                try {sta.close();} catch(Exception e) {}
            }
            
            // Verbindung beenden
            if (con != null){
                try{
                        con.close();
                        System.out.println("Connection disconnected"); 
                        
                } catch (Exception e){}
            }
            
             
        }
        
        
       
     } 
         
     
     
     
    
}