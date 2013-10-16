package airganizer.logic.models;

/**
 *
 * @author pat
 */
public class Benutzer {
    
    private Integer UserID;
    private String Username;
    private String Usertype;
    private String Vorname;
    private String Nachname;
    
    
    // UserID setzen
    public void setUserID(Integer userid){
        UserID = userid;
    }
    
    // Username setzen
    public void setUsername(String username){
        Username = username;
    }
    
    // Usertype setzen
    public void setUsertype(String usertype){
        Usertype = usertype;
    }
    
    // Vorname setzen
    public void setVorname(String vorname){
        Vorname = vorname;
    }
    
    // Nachname setzen
    public void setNachname(String nachname){
        Nachname = nachname;
    }
    
    
    // UserID zurückgeben
    public Integer getID(){
        return UserID;
    }
    
    //Benutzername zurückgeben
    public String getName(){
        return Username;
    }
    
    // Benutzertyp zurückgeben
    public String getType(){
        return Usertype;
    }
    
    // Vornamen zurückgeben
    public String getVorname(){
        return Vorname;
    }
    
    // Nachnamen zurückgeben
    public String getNachname(){
        return Nachname;
    }
    
}
