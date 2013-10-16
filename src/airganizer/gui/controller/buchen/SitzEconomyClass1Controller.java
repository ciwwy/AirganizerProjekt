package airganizer.gui.controller.buchen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class SitzEconomyClass1Controller implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridpane;
    
    
    private Image sitzrot;
    private Image sitzgruen;
    private Image sitzblau;
   

    // Test, später löschen
 public static boolean Belegung(){
        int i ;
        i=(int) (Math.random()*2);
        if (i==0)
            return true;
        else return false;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert gridpane != null : "fx:id=\"gridpane\" was not injected: check your FXML file 'SitzFirstClass.fxml'.";
        
        // Image-Objekte erzeugen
        sitzrot = SitzplatzController.getInstance().getSitzrot();
        sitzgruen = SitzplatzController.getInstance().getSitzgruen();
        sitzblau = SitzplatzController.getInstance().getSitzblau();
    
            //Sitzplätze generieren
            for( int i=0; i< 5; i++){
            
                for (int j = 0; j < 8; j++) {
                    if (j!=2 && j!=5) 
                    {
                        //erzeugt das Bild
                        final ImageView sitz = new ImageView();
                        sitz.setFitWidth(40);
                        sitz.setPreserveRatio(true);
                        sitz.setSmooth(true);
                        sitz.setCache(true);
                        
                        //zeigt SitzBelegung an      
                        if(Belegung())
                      sitz.setImage(sitzrot);  
                        else
                            sitz.setImage(sitzgruen); 
                     

                          gridpane.add(sitz,i,j);
                          sitz.setId("Sitz"+i+j);

                          //Belegung ändern
                          sitz.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) 
                                  {
                                          sitz.setImage(sitzblau); 
                                          System.out.println(sitz.getId());
                                  }
                            });
                     }             
                   }
            }
    }
}
