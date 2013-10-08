package airganizer.mysql.request;

import airganizer.mysql.DBConnection;
import java.util.List;

/**
 *
 * @author pat
 */

public class LoginCheck extends DBConnection {
    
    // Variablen
    
    
    
    public LoginCheck(){
        System.out.println("Login Check in progress...");
    }
   
    
    public List start(String username, String userpwd){
        
                   
        // Statement String wird an von DBConnection geerbte Methode weitergegeben
         queryResultSet = this.executeQuery("SELECT * FROM users WHERE username='"+username+"'AND pwd='"+userpwd+"';");
     
        
        
        return queryResultSet;
       
    }
    
}
