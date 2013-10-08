package airganizer.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ExtrasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Weiter;

    @FXML
    private Button btn_Zurueck;


    @FXML
    void initialize() {
        assert btn_Weiter != null : "fx:id=\"btn_Weiter\" was not injected: check your FXML file 'Extras.fxml'.";
        assert btn_Zurueck != null : "fx:id=\"btn_Zurueck\" was not injected: check your FXML file 'Extras.fxml'.";

        btn_Weiter.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  HauptmenueController.switchMask("m_Bestaetigung");
            }          
        });
        
        btn_Zurueck.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  HauptmenueController.switchMask("m_Sitzplatz");
            }          
        });

    }

}
