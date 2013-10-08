/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airganizer.mysql.request;

/**
 *
 * @author pat
 */
public class UserInfo {
    
    int userid;
    String username;
    String usertype;
    
    
    public UserInfo(int userid, String username, String usertype){
        
        this.userid = userid;
        this.username = username;
        this.usertype = usertype;
    }
    
    
    public int getUserID(){
        return userid;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getUsertype(){
        return usertype;
    }
    
    
}
