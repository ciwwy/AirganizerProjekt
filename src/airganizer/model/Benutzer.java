package airganizer.model;

/**
 *
 * @author pat
 */
public class Benutzer {
    
    private String UserID;
    private String Username;
    private String Usertype;
    
    
    // Konstruktor
    public Benutzer (String uid, String name, String type){
        this.UserID = uid;
        this.Username = name;
        this.Usertype = type;
    }
    
    // UserID zurückgeben
    public String getID(){
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
    
}
