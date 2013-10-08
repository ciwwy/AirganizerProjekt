package airganizer.launcher;

import airganizer.launcher.controller.LauncherMaskController;
import airganizer.launcher.controller.LoginMaskController;
import airganizer.launcher.controller.MaskSwitcher;
import airganizer.model.Benutzer;
import airganizer.mysql.request.LoginCheck;
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
    
    private Stage stage;
    private Benutzer benutzer;
    private static Launcher instance;
    
    // Deklaration der Konstanten
    final String FXML_PATH = "/airganizer/launcher/fxml/";
    final String WINDOW_TITLE = "Airganizer v.0.1 - Launcher";
    final int WINDOW_WIDTH = 600;
    final int WINDOW_HEIGHT = 400;
    
    
    // Instanz speichern (Klassenvariable)
    public Launcher(){
        instance = this;
    }
    
    
    // Instanz weitergeben
    public static Launcher getInstance(){
        return instance;
    }
    
    
    // Startmethode
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        
        
        
        // Primary Stage
        stage = primaryStage;
        
        launcher();
        //flugbuchen();
        
        primaryStage.show();
        
    }
    
    
    private Parent szeneWechseln (String fxml) throws Exception{
        
        Scene scene = stage.getScene();
        
        ///// FXML-Dateien laden /////
        
        // -- Launcher-Maske (BorderPane, Center leer)
        
        // FXMLLoader erzeugen
        FXMLLoader floader = new FXMLLoader();
        
        // Location setzen
        URL location = getClass().getResource(fxml);
        System.out.println(FXML_PATH+fxml);
        floader.setLocation(location);
              
        // Parent element erzeugen
        Parent p_main = (Parent) floader.load(getClass().getResource(fxml).openStream());
        
        // Controller-Objekt erhalten mit getController()
        //LauncherMaskController LMC = (LauncherMaskController) floader.getController();
        
        // Objektadresse in MaskSwitcher speichern
        //MaskSwitcher.setReference(LMC);
        
        
        // -- Untermasken (BorderPane, nur Center)
        //Parent subMaskLogin = (Parent) floader2 FXMLLoader.load(getClass().getResource(FXML_PATH + "LoginMask.fxml"));  
        
        // FXMLLoader erzeugen
        FXMLLoader floader2 = new FXMLLoader();
        URL location2 = getClass().getResource(FXML_PATH + "LoginMask.fxml");
        System.out.println(FXML_PATH+fxml);
        floader2.setLocation(location2);
              
        // Parent element erzeugen
        Parent subMaskLogin = (Parent) floader2.load(getClass().getResource(FXML_PATH + "LoginMask.fxml").openStream());
        
        // Controller-Objekt erhalten mit getController()
        LoginMaskController LoMC = floader2.getController();
        LoMC.setApp(this);
        
        Parent subMaskConfig = FXMLLoader.load(getClass().getResource(FXML_PATH + "ConfigMask.fxml"));
        Parent subMaskLayout = FXMLLoader.load(getClass().getResource(FXML_PATH + "LayoutMask.fxml"));
        
        // Elemente in Hashmap speichern        
        MaskSwitcher.addView("login", subMaskLogin);
        MaskSwitcher.addView("config", subMaskConfig);
        MaskSwitcher.addView("layout", subMaskLayout);
        
        
        ///// Fenster erzeugen /////
        if(scene == null){
            // Scene erzeugen
            scene = new Scene(p_main);
                    //,WINDOW_WIDTH, WINDOW_HEIGHT);
        
            // Scene in Stage einbetten
            stage.setTitle(WINDOW_TITLE);
            stage.setScene(scene);
            
            
            
        } else {
            stage.getScene().setRoot(p_main);
        }
        
        
        stage.sizeToScene();
        
        // Erste subMask einsetzen
        LauncherMaskController.getInstance().switchMask("login");
        
        return p_main;
    }
    
    
    private void launcher(){
        try {
             szeneWechseln("/airganizer/launcher/fxml/LauncherMask.fxml");
        } catch (Exception e){
            System.err.println(e);
        }
       
    }
    
    private void flugbuchen(){
        try {
             szeneWechseln("/airganizer/gui/fxml/Hauptmenue.fxml");
             System.out.println("FLUGBUCHEN!! :D:D:D...");
        } catch (Exception e){
            System.err.println(e);
            System.err.println("FEHLER bei Flugbuchen...");

            
        }
    }
    
    
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
