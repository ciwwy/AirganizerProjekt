package airganizer.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class BestaetigungController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Buchen;

    @FXML
    private Button btn_Zurueck;


    @FXML
    void initialize() {
        assert btn_Buchen != null : "fx:id=\"btn_Buchen\" was not injected: check your FXML file 'Bestaetigung.fxml'.";
        assert btn_Zurueck != null : "fx:id=\"btn_Zurueck\" was not injected: check your FXML file 'Bestaetigung.fxml'.";

        btn_Buchen.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  HauptmenueController.switchMask("m_Menue");
            }          
        });
        
        btn_Zurueck.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  HauptmenueController.switchMask("m_Extras");
            }          
        });

    }

}
