package airganizer.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class HauptmenueController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_FlugBuchen;

    @FXML
    private Button btn_FlugVerwalten;
    
     @FXML
    private  static BorderPane mainBorderPane ;
     
   

    @FXML
    public void initialize() {
        assert btn_FlugBuchen != null : "fx:id=\"btn_FlugBuchen\" was not injected: check your FXML file 'Hauptmenue.fxml'.";
        assert btn_FlugVerwalten != null : "fx:id=\"btn_FlugVerwalten\" was not injected: check your FXML file 'Hauptmenue.fxml'.";

  btn_FlugBuchen.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                switchMask("m_FlugSuchen");                      
            }          
        });

    }

            
     public  static void switchMask(String mask) {
                Parent  p = MaskSwitcher.getView(mask); 
                mainBorderPane.setCenter(p);
            }      
    
}
