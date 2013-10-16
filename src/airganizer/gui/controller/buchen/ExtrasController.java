package airganizer.gui.controller.buchen;

import airganizer.gui.controller.MainFrame;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class ExtrasController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Weiter;

    @FXML
    private Button btn_Zurueck;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btn_Weiter != null : "fx:id=\"btn_Weiter\" was not injected: check your FXML file 'Extras.fxml'.";
        assert btn_Zurueck != null : "fx:id=\"btn_Zurueck\" was not injected: check your FXML file 'Extras.fxml'.";

        btn_Weiter.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  MainFrame.getInstance().setBestaetigung();
            }          
        });
        
        btn_Zurueck.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  MainFrame.getInstance().setSitzplatz();
            }          
        });

    }

}
