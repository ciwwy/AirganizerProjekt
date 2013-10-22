package airganizer.gui.controller;

import airganizer.gui.Launcher;
import airganizer.logic.models.Benutzer;
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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 * Main Frame
 *
 * @author pat, kaiwen
 */

public class MainFrame implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_FlugBuchen;

    @FXML
    private Button btn_FlugVerwalten;
    
    @FXML
    private Button backtoMain;
    
    @FXML
    private BorderPane mainBorderPane ;
    
    @FXML
    private Text text_BenutzerInfo;
    
     
    private static MainFrame instance;
     
    // Instanz speichern (Klassenvariable)
    public MainFrame(){
        instance = this;
    }
    
    
    // Instanz weitergeben
    public static MainFrame getInstance(){
       return instance;
    }
        
    //// Deklaration der Variablen ////
    private Parent subMaskBuchenMenue;
    private Parent subMaskFlugSuche;
    private Parent subMaskKundenDaten;
    private Parent subMaskExtras;
    private Parent subMaskBestaetigung;
    private Parent subMaskSitzplatz;
    
        
        
    //// Deklaration der Konstanten ////
    // Pfad der FXML-Dateien
    private final String FXML_PATH = "/airganizer/gui/fxml/buchen/";
      
    // Name der FXML-Dateien
    private final String BUCHEN_MENUE = "BuchenMenue.fxml";
    private final String BUCHEN_FLUGSUCHE = "FlugSuchen.fxml";
    private final String BUCHEN_KUNDENDATEN = "KundenDaten.fxml";
    private final String BUCHEN_EXTRAS = "Extras.fxml";
    private final String BUCHEN_BESTAETIGUNG = "Bestaetigung.fxml";
    private final String BUCHEN_SITZPLATZ = "Sitzplatz.fxml";  
    
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btn_FlugBuchen != null : "fx:id=\"btn_FlugBuchen\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
        assert btn_FlugVerwalten != null : "fx:id=\"btn_FlugVerwalten\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
        assert text_BenutzerInfo != null : "fx:id=\"text_BenutzerInfo\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
        assert backtoMain != null : "fx:id=\"backtoMain\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
       
        // BenutzerInfo laden
        
        Benutzer ben = Launcher.getInstance().getUser();
        
        String username = ben.getName();
        String usertype = ben.getType();
        String vorname = ben.getVorname();
        String nachname = ben.getNachname();
        
        text_BenutzerInfo.setText("Angemeldet als: "+ username +" (" + nachname + ", " + vorname + ") - Berechtigungslevel: " + usertype);
        
        
        //// CENTER-Elemente laden ////
        subMaskBuchenMenue = loadFXML(FXML_PATH + BUCHEN_MENUE);
        subMaskFlugSuche = loadFXML(FXML_PATH + BUCHEN_FLUGSUCHE);
        subMaskKundenDaten = loadFXML(FXML_PATH + BUCHEN_KUNDENDATEN);
        subMaskExtras = loadFXML(FXML_PATH + BUCHEN_EXTRAS);
        subMaskBestaetigung = loadFXML(FXML_PATH + BUCHEN_BESTAETIGUNG);
        subMaskSitzplatz = loadFXML(FXML_PATH + BUCHEN_SITZPLATZ);
        
        
        // Start subMask setzen - Abhängig von Usertyp
        
        setBuchenMenue();
        
        // Button Listener

        btn_FlugBuchen.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent e) {
                setFlugsuche();
                System.out.println("FLUGSUCHE BUTTON GEDRÜCKT.");
            }          
        });
        
        backtoMain.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent e) {
                
                Launcher.getInstance().getflugBuchen();
            }          
        });

     }
    
     //// CENTER-Elemente wechseln 
    
     // Menü starten        
     public void setBuchenMenue() {
                
                mainBorderPane.setCenter(subMaskBuchenMenue);
     }
    
    
     // Flugsuche starten        
     public void setFlugsuche() {
                
                mainBorderPane.setCenter(subMaskFlugSuche);
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
