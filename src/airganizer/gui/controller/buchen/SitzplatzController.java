package airganizer.gui.controller.buchen;

import airganizer.gui.controller.MainFrame;
import airganizer.logic.Sitzplan;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class SitzplatzController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane SitzplatzBorderpane;

    @FXML
    private Button btn_Extras;

    @FXML
    private Button btn_FlugSuchen;

    @FXML
    private Button btn_KundenDaten;

    @FXML
    private Button btn_Sitzplatz;

    @FXML
    private Button btn_Weiter;

    @FXML
    private Button btn_Zurueck;

    @FXML
    private ImageView img_businessClass;

    @FXML
    private ImageView img_economyClass1;

    @FXML
    private ImageView img_economyClass2;

    @FXML
    private ImageView img_firstClass;
    
    @FXML
    private Button btn_reset;
    
    
    private static SitzplatzController instance;
    
    public SitzplatzController(){
        instance = this;
    }
    
    public static SitzplatzController getInstance(){
        return instance;
    }
    
    // Sitzplatz check test
    Sitzplan sp = new Sitzplan();
    
    //// Deklaration der Variablen ////
    private Parent subMaskSitzBusiness;
    private Parent subMaskSitzEconomy1;
    private Parent subMaskSitzEconomy2;
    private Parent subMaskSitzFirstClass;
    
    private Image sitzrot;
    private Image sitzgruen;
    private Image sitzblau;
    
    
    //// Deklaration der Konstanten ////
    // Pfad der FXML-Dateien
    private final String FXML_PATH = "/airganizer/gui/fxml/buchen/";
    
    private final String BUCHEN_SITZPLATZ_BUSINESS = "SitzBusinessClass.fxml";
    private final String BUCHEN_SITZPLATZ_ECONOMY1 = "SitzEconomyClass1.fxml";
    private final String BUCHEN_SITZPLATZ_ECONOMY2 = "SitzEconomyClass2.fxml";
    private final String BUCHEN_SITZPLATZ_FIRSTCLASS = "SitzFirstClass.fxml";
    
    // Deklaration der Konstanten
    private final String IMAGE_PATH = "/airganizer/gui/images/";
    private final String IMAGE_SITZ_ROT = "Sitz_rot.jpg";
    private final String IMAGE_SITZ_GRUEN = "Sitz_gruen.jpg";
    private final String IMAGE_SITZ_BLAU = "Sitz_blau.jpg";


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert SitzplatzBorderpane != null : "fx:id=\"SitzplatzBorderpane\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert btn_Extras != null : "fx:id=\"btn_Extras\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert btn_FlugSuchen != null : "fx:id=\"btn_FlugSuchen\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert btn_KundenDaten != null : "fx:id=\"btn_KundenDaten\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert btn_Sitzplatz != null : "fx:id=\"btn_Sitzplatz\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert btn_Weiter != null : "fx:id=\"btn_Weiter\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert btn_Zurueck != null : "fx:id=\"btn_Zurueck\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert img_businessClass != null : "fx:id=\"img_businessClass\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert img_economyClass1 != null : "fx:id=\"img_economyClass1\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert img_economyClass2 != null : "fx:id=\"img_economyClass2\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert img_firstClass != null : "fx:id=\"img_firstClass\" was not injected: check your FXML file 'Sitzplatz.fxml'.";
        assert btn_reset != null : "fx:id=\"btn_reset\" was not injected: check your FXML file 'Sitzplatz.fxml'.";

         //Parent  p = MaskSwitcher.getView("m_SitzFirstClass"); 
         //SitzplatzBorderpane.setCenter(p);
        
        
        
        // Sitzplan für FlugNr 25 laden 
        // Später FlugNr je nach auswahl
        
        sp.load(25);
        
               
        
        //Bild aus Quelle laden
        sitzrot = new Image(getClass().getResourceAsStream(IMAGE_PATH + IMAGE_SITZ_ROT));
        sitzgruen = new Image(getClass().getResourceAsStream(IMAGE_PATH + IMAGE_SITZ_GRUEN));
        sitzblau = new Image(getClass().getResourceAsStream(IMAGE_PATH + IMAGE_SITZ_BLAU));
        
        
        subMaskSitzBusiness = loadFXML(FXML_PATH + BUCHEN_SITZPLATZ_BUSINESS);
        subMaskSitzEconomy1 = loadFXML(FXML_PATH + BUCHEN_SITZPLATZ_ECONOMY1);
        subMaskSitzEconomy2 = loadFXML(FXML_PATH + BUCHEN_SITZPLATZ_ECONOMY2);
        subMaskSitzFirstClass = loadFXML(FXML_PATH + BUCHEN_SITZPLATZ_FIRSTCLASS);
        
        //Flugzeugbild anzeigen
        setSitzFirstClass();
        img_firstClass.setOpacity(1);
        img_businessClass.setOpacity(0.5);
        img_economyClass1.setOpacity(0.5);
        img_economyClass2.setOpacity(0.5);
 

        //Per Klick auf Bilder entsprechende MAsken mit Belegung anzeigen
         img_firstClass.setOnMouseClicked(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent e) 
             {
               
               setSitzFirstClass();
               img_firstClass.setOpacity(1);
               img_businessClass.setOpacity(0.5);
               img_economyClass1.setOpacity(0.5);
               img_economyClass2.setOpacity(0.5);
             }
         });
         
         img_businessClass.setOnMouseClicked(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent e) 
             {             
                setSitzBusiness();
                img_firstClass.setOpacity(0.5);
                img_businessClass.setOpacity(1);
                img_economyClass1.setOpacity(0.5);
                img_economyClass2.setOpacity(0.5);
             }
         });
          
         img_economyClass1.setOnMouseClicked(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent e) 
             {
                setSitzEconomy1();
                img_firstClass.setOpacity(0.5);
                img_businessClass.setOpacity(0.5);
                img_economyClass1.setOpacity(1);
                img_economyClass2.setOpacity(0.5);
             }
         });
           
         img_economyClass2.setOnMouseClicked(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent e) 
             {
               
                setSitzEconomy2();
                img_firstClass.setOpacity(0.5);
                img_businessClass.setOpacity(0.5);
                img_economyClass1.setOpacity(0.5);
                img_economyClass2.setOpacity(1);
             }
         });
         
        //Buttons
        btn_Weiter.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  
                  MainFrame.getInstance().setExtras();
            }          
        });
        
        btn_Zurueck.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                MainFrame.getInstance().setKundenDaten();
            }          
        });
        
        btn_reset.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                // TODO... 
            }          
        });
    }
    
    // Sitzplatz auswahl
     public void setSitzBusiness() {
                
                SitzplatzBorderpane.setCenter(subMaskSitzBusiness);
     }
     
     
     // Sitzplatz auswahl
     public void setSitzEconomy1() {
                
                SitzplatzBorderpane.setCenter(subMaskSitzEconomy1);
     }
     
     // Sitzplatz auswahl
     public void setSitzEconomy2() {
                
                SitzplatzBorderpane.setCenter(subMaskSitzEconomy2);
     }
     
     // Sitzplatz auswahl
     public void setSitzFirstClass() {
                
                SitzplatzBorderpane.setCenter(subMaskSitzFirstClass);
     }
     
    
     
     
     // get Image Methoden
     
     public Image getSitzrot(){
         return sitzrot;
     }
     
     public Image getSitzgruen(){
         return sitzgruen;
     }
     
     public Image getSitzblau(){
         return sitzblau;
     }
     
     
     // get Methode für Sitzplan-Objekt
     
     public Sitzplan getSitzplan(){
         return sp;
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
     
     //Sitzplätze generieren
     public void sitzplatzGeneration(GridPane gridpane, int spalten, int zeilen){ 
         
         
         Integer counter = 0;
         
         
            for( int i=0; i< spalten; i++){
            
                for (int j = 0; j < zeilen; j++) {
                    if (j!=2 && j!=5) 
                    {
                        //erzeugt das Bild
                        final ImageView sitz = new ImageView();
                        sitz.setFitWidth(40);
                        sitz.setPreserveRatio(true);
                        sitz.setSmooth(true);
                        sitz.setCache(true);
                        
                        // Zählt counter hoch
                        counter++;
                        
                        //zeigt SitzBelegung an      
                        if(sp.isBelegt(counter))
                      sitz.setImage(sitzrot);  
                        else
                            sitz.setImage(sitzgruen); 
                     

                          gridpane.add(sitz,i,j);
                          sitz.setId(counter+"");

                          //Belegung ändern
                          sitz.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) 
                                  {       
                                      
                                          // anstatt der FXML-ID, evtl neue Klasse (extends ImageView) 
                                          // mit get/set Methode für Sitzplatznummer + Belegtstatus?
                                      
                                          Integer sitzid = Integer.parseInt(sitz.getId());
                                          
                                          if(sp.isBelegt(sitzid)==false){
                                              sitz.setImage(sitzblau); 
                                          }
                                          
                                          System.out.println(sitz.getId());
                                  }
                            });
                     }             
                   }
            }
            
     }

}
