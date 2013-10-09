package airganizer.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class HauptmenueController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_FlugBuchen;

    @FXML
    private Button btn_FlugVerwalten;
    
    @FXML
    private BorderPane mainBorderPane ;
    
     
    private static HauptmenueController instance;
     
    // Instanz speichern (Klassenvariable)
    public HauptmenueController(){
        instance = this;
    }
    
    // Instanz weitergeben
    public static HauptmenueController getInstance(){
       return instance;
    }
        
    //// Deklaration der Variablen ////
    private Parent subMaskFlugSuche;
    private Parent subMaskKundenDaten;
    private Parent subMaskExtras;
    private Parent subMaskBestaetigung;
    private Parent subMaskSitzplatz;
        
        
    //// Deklaration der Konstanten ////
    // Pfad der FXML-Dateien
    private final String FXML_PATH = "/airganizer/gui/fxml/";
      
    // Name der FXML-Dateien
    private final String BUCHEN_FLUGSUCHE = "FlugSuchen.fxml";
    private final String BUCHEN_KUNDENDATEN = "KundenDaten.fxml";
    private final String BUCHEN_EXTRAS = "Extras.fxml";
    private final String BUCHEN_BESTAETIGUNG = "Bestaetigung.fxml";
    private final String BUCHEN_SITZPLATZ = "Sitzplatz.fxml";  
     
   

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        assert btn_FlugBuchen != null : "fx:id=\"btn_FlugBuchen\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
        assert btn_FlugVerwalten != null : "fx:id=\"btn_FlugVerwalten\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
        
        
        //// CENTER-Elemente laden ////
        subMaskFlugSuche = loadFXML(FXML_PATH + BUCHEN_FLUGSUCHE);
        subMaskKundenDaten = loadFXML(FXML_PATH + BUCHEN_KUNDENDATEN);
        subMaskExtras = loadFXML(FXML_PATH + BUCHEN_EXTRAS);
        subMaskBestaetigung = loadFXML(FXML_PATH + BUCHEN_BESTAETIGUNG);
        subMaskSitzplatz = loadFXML(FXML_PATH + BUCHEN_SITZPLATZ);
        

        btn_FlugBuchen.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent e) {
                setFlugsuche();
                System.out.println("FLUGSUCHE BUTTON GEDRÜCKT.");
            }          
        });

     }
    
     //// CENTER-Elemente wechseln 
    
     // Flugsuche starten        
     public void setFlugsuche() {
                
                mainBorderPane.setCenter(subMaskFlugSuche);
                System.out.println("FLUGSUCHE  GESTARTET "+subMaskFlugSuche);
     }
     
     // Kundendaten eingeben
     public void setKundenDaten() {
                
                mainBorderPane.setCenter(subMaskKundenDaten);
     }
     
     // Extras eingeben
     public void setExtras() {
                
                mainBorderPane.setCenter(subMaskExtras);
     }
     
     // Bestätigung anzeigen
     public void setBestaetigung() {
                
                mainBorderPane.setCenter(subMaskBestaetigung);
     }
     
     // Sitzplatz auswahl
     public void setSitzplatz() {
                
                mainBorderPane.setCenter(subMaskSitzplatz);
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
              
              return subMask;
                         
        } catch (Exception e) {
            System.err.println(fxml + " --> Konnte nicht geladen werden... sorry...");
            return null;
        }
     }
    
}
