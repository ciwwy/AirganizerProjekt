package airganizer.gui.controller.buchen;

import airganizer.gui.controller.MainFrame;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;


public class BuchenMenueController implements Initializable{

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
    
    @FXML
    private Text text_BenutzerInfo;
    
     
        
    //// Deklaration der Variablen ////

        
    //// Deklaration der Konstanten ////

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btn_FlugBuchen != null : "fx:id=\"btn_FlugBuchen\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
        assert btn_FlugVerwalten != null : "fx:id=\"btn_FlugVerwalten\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
        assert text_BenutzerInfo != null : "fx:id=\"text_BenutzerInfo\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
        
                     
        

        btn_FlugBuchen.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent e) {
                
                // Flugsuche wird gestartet
                MainFrame.getInstance().setFlugsuche();
                
            }          
        });

     }
        
}
