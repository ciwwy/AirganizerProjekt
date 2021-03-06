package airganizer.gui.controller.buchen;

import airganizer.gui.controller.MainFrame;
import airganizer.logic.FlugSuchen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class FlugSuchenController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Extras;

    @FXML
    private Button btn_FlugSuchen;

    @FXML
    private Button btn_KundenDaten;

    @FXML
    private Button btn_Sitzplatz;

    @FXML
    private Button btn_Suchen;

    @FXML
    private Button btn_Weiter;

    @FXML
    private ComboBox<?> cbx_anzPers;

    @FXML
    private ComboBox<?> cbx_startflghf;

    @FXML
    private ComboBox<?> cbx_zielflghf;

    @FXML
    private AnchorPane flugSuchenBorderPane;

    @FXML
    private TextField txt_Datum;
    
    @FXML
    private TableView table_results = new TableView();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btn_Extras != null : "fx:id=\"btn_Extras\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert btn_FlugSuchen != null : "fx:id=\"btn_FlugSuchen\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert btn_KundenDaten != null : "fx:id=\"btn_KundenDaten\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert btn_Sitzplatz != null : "fx:id=\"btn_Sitzplatz\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert btn_Suchen != null : "fx:id=\"btn_Suchen\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert btn_Weiter != null : "fx:id=\"btn_Weiter\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert cbx_anzPers != null : "fx:id=\"cbx_anzPers\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert cbx_startflghf != null : "fx:id=\"cbx_startflghf\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert cbx_zielflghf != null : "fx:id=\"cbx_zielflghf\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert flugSuchenBorderPane != null : "fx:id=\"flugSuchenBorderPane\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert txt_Datum != null : "fx:id=\"txt_Datum\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
        assert table_results != null : "fx:id=\"table_results\" was not injected: check your FXML file 'FlugSuchen.fxml'.";
       
        
        
        
       btn_Suchen.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
                FlugSuchen.load(table_results);
            }
        });
        
       btn_Weiter.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  MainFrame.getInstance().setKundenDaten();
            }          
        });
       
     

}
    
}
