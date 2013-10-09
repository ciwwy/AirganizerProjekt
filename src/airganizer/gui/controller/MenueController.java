package airganizer.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class MenueController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_FlugBuchen;

    @FXML
    private Button btn_FlugVerwalten;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btn_FlugBuchen != null : "fx:id=\"btn_FlugBuchen\" was not injected: check your FXML file 'Menue.fxml'.";
        assert btn_FlugVerwalten != null : "fx:id=\"btn_FlugVerwalten\" was not injected: check your FXML file 'Menue.fxml'.";

          btn_FlugBuchen.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  HauptmenueController.getInstance().setFlugsuche();
            }          
        });

    }

}
