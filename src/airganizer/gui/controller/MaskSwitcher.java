/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package airganizer.gui.controller;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Parent;

/**
 *
 * @author KaiwenLaptop
 */
public class MaskSwitcher {
    
    private static Map<String, Parent> allViews = new HashMap<String, Parent>();
    
    public static  void addView(String name, Parent p){
        allViews.put(name, p);
    }
    
    public static Parent getView (String name) {
        return allViews.get(name);
    }
}
