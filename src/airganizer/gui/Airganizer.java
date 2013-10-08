/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package airganizer.gui;

import airganizer.gui.controller.MaskSwitcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kaiwen
 */
public class Airganizer extends Application {
    
    // Deklaration der Konstanten
    final String FXML_PATH = "/airganizer/gui/fxml/";
    final String WINDOW_TITLE = "Airganizer v.0.1";
    final int WINDOW_WIDTH = 600;
    final int WINDOW_HEIGHT = 400;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(FXML_PATH + "Hauptmenue.fxml"));
        
        Parent p_FlugSuchen = FXMLLoader.load(getClass().getResource(FXML_PATH + "FlugSuchen.fxml"));
        Parent p_KundenDaten = FXMLLoader.load(getClass().getResource(FXML_PATH + "KundenDaten.fxml"));
        Parent p_Sitzplatz = FXMLLoader.load(getClass().getResource(FXML_PATH + "Sitzplatz.fxml"));
        Parent p_Extras = FXMLLoader.load(getClass().getResource(FXML_PATH + "Extras.fxml"));
        Parent p_Bestaetigung = FXMLLoader.load(getClass().getResource(FXML_PATH + "Bestaetigung.fxml"));
        Parent p_Menue = FXMLLoader.load(getClass().getResource(FXML_PATH + "Menue.fxml"));

                  
        MaskSwitcher.addView("m_FlugSuchen", p_FlugSuchen);
        MaskSwitcher.addView("m_KundenDaten", p_KundenDaten);
        MaskSwitcher.addView("m_Sitzplatz", p_Sitzplatz);
        MaskSwitcher.addView("m_Extras", p_Extras);
        MaskSwitcher.addView("m_Bestaetigung", p_Bestaetigung);
        MaskSwitcher.addView("m_Menue", p_Menue);
                 
        Scene scene = new Scene(root);
        
        stage.setScene(scene);      
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
