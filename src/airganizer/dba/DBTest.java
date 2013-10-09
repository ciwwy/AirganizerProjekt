/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airganizer.dba;

import java.sql.DriverManager;

/**
 *
 * @author pat
 */
public class DBTest extends DBConnection{
    
    
    public DBTest(){
        
        // Ausgabe von Verbindungsinformationen in der Konsole
        System.out.println("Treiber: " + DRIVER);
        System.out.println("Pfad: " + PATH);
        System.out.println("Address: " + ADDRESS);
        System.out.println("Database: " + DBNAME);
        System.out.println("Username: " + DBUSER);
        System.out.println("Password: " + DBPWD);
        
    }
    
    
    // Methode zum Testen der Verbindung mit eingelesenen Werten
    public boolean test(){
        
        try {
            
            //Verbindung zur Datenbank
            con = DriverManager.getConnection(PATH + ADDRESS + "/"+ DBNAME, DBUSER, DBPWD);
            System.out.println("CONNECTION SUCCESSFUL! :D:D:D");
            
        } catch(Exception e)
        
        { 
            System.err.println("SQLException: " + e.getMessage());
            return(false);
        
        
        } finally {
            
            //Verbindung beenden
            
            if (con != null){
                
                try {
                    
                    con.close();
                    System.out.println("Connection disconnected"); 
                
                } catch (Exception e){}
            }
        }
      
     return(true);
     
     } 
    
    
    
    // Method-Overload (Alternative Testmethode für Konfigurationstests)
    public boolean test(String address, String dbname, String dbuser, String dbpwd){
        
        try {
            
            //Verbindung zur Datenbank
            con = DriverManager.getConnection(PATH + address + "/"+ dbname, dbuser, dbpwd);
            System.out.println("CONNECTION SUCCESSFUL! :D:D:D");
            
        } catch(Exception e)
        
        { 
            System.err.println("SQLException: " + e.getMessage());
            return(false);
        
        
        } finally {
            
            //Verbindung beenden
            
            if (con != null){
                
                try {
                    
                    con.close();
                    System.out.println("Connection disconnected"); 
                
                } catch (Exception e){}
            }
        }
      
     return(true);
     
     }
    
}
