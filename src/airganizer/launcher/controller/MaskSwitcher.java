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
    
    
    private static Map<String, Parent> allViews
            = new HashMap<String, Parent>();
    
    private static LauncherMaskController LMCont;
    
    public static void addLMC (LauncherMaskController LMC){
        LMCont = LMC;
    }
    
    public static LauncherMaskController getLMC(){
        return LMCont;
    }
    
    public static void addView(String name, Parent p) {
        allViews.put(name, p);
    }
    
    public static Parent getView(String name) {
        
        return(allViews.get(name));
    }
    
}
