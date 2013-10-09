package airganizer.gui;

import airganizer.gui.controller.LauncherFrame;
import airganizer.gui.controller.LauncherLogin;
import airganizer.gui.controller.LauncherMaskSwitcher;
import airganizer.logic.model.Benutzer;
import airganizer.dba.select.LoginCheck;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
    
    // Deklaration der Variablen
    private Stage stage;
    private Benutzer benutzer;
    private static Launcher instance;
    
    //// Deklaration der Konstanten ////
    // Pfad der FXML-Dateien
    private final String FXML_PATH = "/airganizer/gui/fxml/";
    
    // Launcher FXML-Dateien
    private final String LAUNCHER_FRAME = "LauncherFrame.fxml";
    
    // Flugbuchen FXML-Dateien
    private final String MAIN_MENU = "Hauptmenue.fxml";
    
    
    // Weitere FXML-Dateien...
    // private final String VERWALTEN_FLUGANLEGEN = "xxx.fxml";
    
    // Eigenschaften des Fensters
    final String WINDOW_TITLE_LAUNCHER = "Airganizer v.0.1 - Launcher";
    final String WINDOW_TITLE_BUCHEN = "Airganizer v.0.1 - Flug buchen";
    final String WINDOW_TITLE_VERWALTEN = "Airganizer v.0.1 - Flüge verwalten";
    final String WINDOW_TITLE_ADMIN = "Airganizer v.0.1 - Benutzer administrieren";
    
    
    //// Instanz erstellen und Zugriff ermöglichen ////

    // Konstruktor 
    public Launcher(){
        instance = this;
    }
    
    // Instanz weitergeben
    public static Launcher getInstance(){
        return instance;
    }
    
    
    //// Startmethode - Erstellt das Fenster ////
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        
        // PrimaryStage-Instanz speichern
        stage = primaryStage;
        
        // Startet Launcher mit Loginmaske
        anmelden();
        
        // Erstellt das Fenster
        primaryStage.show();
        
    }
    
    
    //// Methode erzeugt ein Parent-Objekt durch FXML ////
    
    private Parent szeneWechseln (String fxml, String title) throws Exception{
        
        Scene scene = stage.getScene();
        Parent p_main;
        
        System.out.println(fxml);
        ///// FXML-Dateien laden /////
        
        
        // -- Launcher-Maske (BorderPane, Center leer)
        
        // FXMLLoader erzeugen
        FXMLLoader floader = new FXMLLoader();
        
        // Location setzen
        URL location = getClass().getResource(fxml);
        
        floader.setLocation(location);
              
        // Parent element erzeugen
        p_main = (Parent) floader.load(getClass().getResource(fxml).openStream());
   
        
        ///// Fenster erzeugen /////
        if(scene == null){
            // Scene erzeugen
            scene = new Scene(p_main);

            // Scene in Stage einbetten
            stage.setTitle(title);
            stage.setScene(scene);
            
            
            
        } else {
            stage.getScene().setRoot(p_main);
            stage.setTitle(title);
        }
        
        
        stage.sizeToScene();
        
        // Erste subMask einsetzen
        LauncherFrame.getInstance().setLoginMask();
        
        return p_main;
    }
    
    
    private void anmelden(){
        try {
            
            // LauncherFrame laden
            szeneWechseln(FXML_PATH + LAUNCHER_FRAME, WINDOW_TITLE_LAUNCHER);
            
        } catch (Exception e){
            System.err.println(e);
        }
       
    }
    
    private void flugbuchen(){
        try {
            
            // MainMenu laden
            szeneWechseln(FXML_PATH + MAIN_MENU, WINDOW_TITLE_BUCHEN);
             
        } catch (Exception e){
            
            System.err.println(e);
            System.err.println("FEHLER bei Flugbuchen...");

            
        }
    }
    
    
    // Benutzerauthetifizierung
    public boolean loginVersuch(String uid, String pwd){
        
        LoginCheck login = new LoginCheck();
        List l = login.start(uid, pwd);
        
        if(l != null){
            benutzer = new Benutzer (l.get(1).toString(), l.get(2).toString(), l.get(3).toString());
            
            
            System.out.println("Login daten erhalten");
            // Szenenwechel bei erfolg
            flugbuchen();
            
            return true;
            
        }
        
        System.out.println("Das war nix...");
        return false;
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
