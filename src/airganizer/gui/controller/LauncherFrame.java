package airganizer.gui.controller;

import airganizer.dba.DBTest;
import airganizer.dba.DBConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 * Launcher Frame
 *
 * @author pat
 */

public class LauncherFrame implements Initializable {
    
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private MenuItem mnuConfig;

        @FXML
        private Menu mnuHelp;

        @FXML
        private MenuItem mnuLayout;

        @FXML
        private BorderPane myBorderPane;

        @FXML
        private Text textDBStatus;
        
        
        private static LauncherFrame instance;
        

        // Instanz speichern (Klassenvariable)
        public LauncherFrame(){
            instance = this;
        }
     
        // Instanz weitergeben
        public static LauncherFrame getInstance(){
          return instance;
        }
        
        //// Deklaration der Variablen ////
        private Parent subMaskLogin;
        private Parent subMaskConfig;
        private Parent subMaskLayout;
        
        
        //// Deklaration der Konstanten ////
        // Pfad der FXML-Dateien
        private final String FXML_PATH = "/airganizer/gui/fxml/";
        
        // Name der FXML-Dateien
        private final String LAUNCHER_LOGIN = "LauncherLogin.fxml";
        private final String LAUNCHER_CONFIG = "LauncherConfig.fxml";
        private final String LAUNCHER_LAYOUT = "LauncherLayout.fxml";
       
        
        @Override
        public void initialize(URL url, ResourceBundle rb) {
            assert mnuConfig != null : "fx:id=\"mnuConfig\" was not injected: check your FXML file 'LauncherMask.fxml'.";
            assert mnuHelp != null : "fx:id=\"mnuHelp\" was not injected: check your FXML file 'LauncherMask.fxml'.";
            assert mnuLayout != null : "fx:id=\"mnuLayout\" was not injected: check your FXML file 'LauncherMask.fxml'.";
            assert myBorderPane != null : "fx:id=\"myBorderPane\" was not injected: check your FXML file 'LauncherMask.fxml'.";
            assert textDBStatus != null : "fx:id=\"textDBStatus\" was not injected: check your FXML file 'LauncherMask.fxml'.";


            //// CENTER-Elemente laden ////
            subMaskLogin = loadFXML(FXML_PATH + LAUNCHER_LOGIN);
            subMaskConfig = loadFXML(FXML_PATH + LAUNCHER_CONFIG);
            subMaskLayout = loadFXML(FXML_PATH + LAUNCHER_LAYOUT);        


            System.out.println("Launcher Initialized");


            // Konfigurationen laden
            if(DBConnection.loadProperties()){System.out.println("Properties loaded");}


            ///// Button onAction Listeners /////

            //MenuItem MySQL Konfiguration
            mnuConfig.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent e){

                    System.out.println("Test... Config Button Worked.");
                    myBorderPane.setCenter(subMaskConfig);

                }
            });  

            //MenuItem Vorlage wechseln
            mnuLayout.setOnAction(new EventHandler<ActionEvent>(){

               @Override
               public void handle(ActionEvent e){

                   System.out.println("Test... Layout Button Worked.");

                    myBorderPane.setCenter(subMaskLayout);


               } 
            });


            //MenuItem Hilfe

            mnuHelp.setOnAction(new EventHandler<ActionEvent>(){ 

                @Override
                public void handle(ActionEvent e){

                    // Evtl Untermenüs


                }
            });

            //Verbindung zur DB Überprüfen
            DBTest dbtest = new DBTest();
            connectionStatus(dbtest.test());
           

    }
    
     
     // Wechselt zur Login-Maske
     
     public void setLoginMask(){
         myBorderPane.setCenter(subMaskLogin);
     }
     
     
     // Aktualisiert die Verbindungsinformation
     public void connectionStatus(Boolean b){
         
         if(b){
            textDBStatus.setText("Erfolgreich");
            textDBStatus.setFill(Color.GREEN);
        } else {
         
            textDBStatus.setText("Fehlerhaft");
            textDBStatus.setFill(Color.RED);
        }
         
     }
     
     
     // Methode zum laden von Parent-Objekten aus FXML
     
     private Parent loadFXML(String fxml){
         
         Parent subMask;
         
         // FXMLLoader erzeugen
        FXMLLoader fLoader = new FXMLLoader();

        // Location setzen
        URL loc = getClass().getResource(fxml);
        fLoader.setLocation(loc);
              
        // Parent-Objekt erzeugen
        try {
            
              subMask = (Parent) fLoader.load(getClass().getResource(fxml).openStream());
              
              System.out.println("PARENT WURDE GELADEN - LOGIN AT "+ subMask);
              return subMask;
              
              
              
        } catch (Exception e) {
            System.err.println("Konnte nicht geladen werden... sorry...");
            return null;
        }
     }
        
}
