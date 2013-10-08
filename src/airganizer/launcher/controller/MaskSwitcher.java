/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airganizer.launcher.controller;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Parent;

/**
 *
 * @author pat
 */
public class MaskSwitcher {
    
    // Neue Hashmap erzeugen
    private static Map<String, Parent> allViews
            = new HashMap<>();
    
    // Adresse des Controller-Objekts
    private static LauncherMaskController LMC;
    
    
    public static void setReference (LauncherMaskController LMContr){
        LMC = LMContr;
    }
    
    public static LauncherMaskController getReference(){
        return LMC;
    }
    
    // Werte in Hashmap speichern
    public static void addView(String name, Parent p) {
        allViews.put(name, p);
    }
    
    
    //Werte aus Hashmap laden
    public static Parent getView(String name) {
        
        return(allViews.get(name));
    }
    
}
