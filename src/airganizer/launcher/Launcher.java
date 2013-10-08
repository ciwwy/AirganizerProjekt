package airganizer.launcher;

import airganizer.launcher.controller.MaskSwitcher;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Airganizer Launcher 2013
 * @author Patrick Hummel
 * @version 0.1
 * 
 */


public class Launcher extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        
        // Deklaration der Konstanten
        final String FXML_PATH = "/airganizer/launcher/fxml/";
        final String WINDOW_TITLE = "Airganizer v.0.1 - Launcher";
        final int WINDOW_WIDTH = 600;
        final int WINDOW_HEIGHT = 400;
             
        
        ///// FXML-Dateien laden /////
        
        // Hauptmaske (BorderPane, Center leer)
        Parent main = FXMLLoader.load(getClass().getResource(FXML_PATH +"LauncherMask.fxml"));
        
        // Untermasken (BorderPane, nur Center)
        Parent subMaskLogin = FXMLLoader.load(getClass().getResource(FXML_PATH + "LoginMask.fxml"));
        Parent subMaskConfig = FXMLLoader.load(getClass().getResource(FXML_PATH + "ConfigMask.fxml"));
        Parent subMaskLayout = FXMLLoader.load(getClass().getResource(FXML_PATH + "LayoutMask.fxml"));
        
        // Elemente in Hashmap speichern        
        MaskSwitcher.addView("login", subMaskLogin);
        MaskSwitcher.addView("config", subMaskConfig);
        MaskSwitcher.addView("layout", subMaskLayout);
        
        
        ///// Fenster erzeugen /////
        
        // Scene erzeugen
        Scene scene = new Scene(main, WINDOW_WIDTH, WINDOW_HEIGHT);
        
        // Scene in Stage einbetten
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        // Test
        MaskSwitcher.getLMC().startmask(subMaskLogin);
        
       
        
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
