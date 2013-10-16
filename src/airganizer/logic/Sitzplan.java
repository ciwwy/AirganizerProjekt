package airganizer.logic;

import airganizer.dba.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pat
 */
public class Sitzplan {
    
     List<Integer> belegtList = new ArrayList<>();
    
     public void load(Integer flugnr){
        
        Connection con = null;
        Statement sta = null;
        ResultSet result = null;
        
        
        try{
            con = DBConnection.connect();
            sta = con.createStatement();
            result = sta.executeQuery("SELECT * FROM Sitzplatz WHERE FlugNr='"+flugnr+"';");
            
            if(result!=null){
                
                while(result.next()){
                
                    belegtList.add(result.getInt("SitzplatzNr"));
                
                }
                
                
            }
            
            
            
        } catch (Exception e){
            
            
        } finally {
            
            // Abfrage beenden
            if(sta!=null){
                
                try {sta.close();} catch(Exception e) {}
                
            }
            
            DBConnection.disconnect(con);
        }
        
              
        
        
    }
     
     
     
     public Boolean isBelegt(Integer SitzplatzNr){
         
         for(int i = 0; i < belegtList.size(); i++){
             if (SitzplatzNr == belegtList.get(i)){
                 return true;
             }
         }
         
         return false;
     }
    
}
    
