package airganizer.logic;

import airganizer.dba.DBConnection;
import airganizer.logic.models.Benutzer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pat
 */
public class LoginAuthentification {
    
       
    
    public static Benutzer getUser(String username, String userpwd){
        
        Connection con = null;
        Statement sta = null;
        ResultSet result = null;
        
        
        try{
            
            // Verbindung aufbauen, Statement erzeugen
            con = DBConnection.connect();
            sta = con.createStatement();
            
            // Query abschicken, Ergebnis auswerten
            result = sta.executeQuery("SELECT UserID, pwd, type, MitarbeiterID FROM users WHERE Username='"+username+"';");
            
            if(result!=null){
                
                while(result.next()){
                    
                    System.out.println(result.getString("pwd"));
                
                    if(result.getString("pwd").equals(userpwd)){
                       System.out.println("Passwort in Ordnung...");
                       
                       Benutzer ben = new Benutzer();
                       ben.setUserID(result.getInt("UserID"));
                       ben.setUsername(username);
                       ben.setUsertype(result.getString("type"));
                       
                       // Vorname, Nachname holen
                       getName(ben, result.getInt("UserID"));
                       
                        System.out.println("Benutzer erzeugt!");

                    return ben;

                    } else {

                        System.out.println("NOTHING FOUND...");

                    return null;

                    }
            
                }
                
            } else {
                System.out.println("QUERY IS SHIT...");
            }
            
            
            return null;
            
            
        } catch (Exception e){
            
            return null;
            
        } finally {
            
            // Abfrage beenden
            if(sta!=null){
                
                try {sta.close();} catch(Exception e) {}
                
            }
            
            DBConnection.disconnect(con);
        }
        
              
        
        
    }
    
    
    
    private static void getName(Benutzer ben, Integer mitarbeiterid){
        
        Connection con = null;
        Statement sta = null;
        ResultSet result = null;
        
        
        try{
            
            // Verbindung aufbauen, Statement erzeugen
            con = DBConnection.connect();
            sta = con.createStatement();
            
            // Query abschicken, Ergebnis auswerten
            result = sta.executeQuery("SELECT Vorname, Nachname FROM Mitarbeiter WHERE MitarbeiterID='"+mitarbeiterid+"';");
            
            if(result!=null){
                    
                    while(result.next()){
                                        
                        ben.setVorname(result.getString("Vorname"));
                        ben.setNachname(result.getString("Nachname"));
                        
                    }
                    
                
            } else {
                
                System.err.println("Kein Mitarbeiter gefunden...");
                
            }
            
            
            
        } catch (Exception e){
            
            System.err.println("Konnte Verbindung zu Mitarbeiter Tabelle nicht herstellen");
            
        } finally {
            
            // Abfrage beenden
            if(sta!=null){
                
                try {sta.close();} catch(Exception e) {}
                
            }
            

            DBConnection.disconnect(con);
        }
        
              
        
        
    }
    
}
