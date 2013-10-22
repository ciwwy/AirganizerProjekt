/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package airganizer.gui;

/**
 *
 * @author Kaiwen
 */
public class Buchungsdaten {
    String[] flugDaten= new String[3];
    int anzPers;
    
    String name, vorname, strasse, stadt, email;
    int strassenNr, plz, teleNr,persoNr;
    
    String[] sitz = new String[4];
    
    String gepaeck;
    
    
    public void setFlugDaten
        (String startflghf, String zielflghf, String datum, int anzPers){
       
        this.anzPers=anzPers;
    }
        
    public void setKundenDaten
        (String name, String vorname, String strasse, String stadt,String email,int strassenNr,int plz,int teleNr, int persoNr){
        this.name=name;
        this.vorname=vorname;
        this.strasse= strasse;
        this.stadt=stadt;
        this.email=email;
        this.strassenNr=strassenNr;
        this.plz=plz;
        this.teleNr=teleNr;
        this.persoNr=persoNr;
    }
        
    
}
