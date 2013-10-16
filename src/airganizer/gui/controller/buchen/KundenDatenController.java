package airganizer.gui.controller.buchen;

import airganizer.gui.controller.MainFrame;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class KundenDatenController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_weiter;

    @FXML
    private Button btn_zurueck;

    @FXML
    private TextField txtfld_email;

    @FXML
    private TextField txtfld_name;

    @FXML
    private TextField txtfld_nummer;

    @FXML
    private TextField txtfld_personr;

    @FXML
    private TextField txtfld_plz;

    @FXML
    private TextField txtfld_stadt;

    @FXML
    private TextField txtfld_strasse;

    @FXML
    private TextField txtfld_telefon;

    @FXML
    private TextField txtfld_vorname;
    
    @FXML
    private Label lb_msg;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btn_weiter != null : "fx:id=\"btn_weiter\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert btn_zurueck != null : "fx:id=\"btn_zurueck\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert txtfld_email != null : "fx:id=\"txtfld_email\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert txtfld_name != null : "fx:id=\"txtfld_name\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert txtfld_nummer != null : "fx:id=\"txtfld_nummer\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert txtfld_personr != null : "fx:id=\"txtfld_personr\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert txtfld_plz != null : "fx:id=\"txtfld_plz\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert txtfld_stadt != null : "fx:id=\"txtfld_stadt\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert txtfld_strasse != null : "fx:id=\"txtfld_strasse\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert txtfld_telefon != null : "fx:id=\"txtfld_telefon\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert txtfld_vorname != null : "fx:id=\"txtfld_vorname\" was not injected: check your FXML file 'KundenDaten.fxml'.";
        assert lb_msg != null : "fx:id=\"lb_msg\" was not injected: check your FXML file 'KundenDaten.fxml'.";


        //Buttons
        
        btn_weiter.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
               if(checkText())
                  MainFrame.getInstance().setSitzplatz();
            }          
        });

        
        btn_zurueck.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                  MainFrame.getInstance().setFlugsuche();
            }          
        });
    }
     
    private boolean checkText(){
       /* if (txtfld_name.getText().isEmpty() || txtfld_vorname.getText().isEmpty() || txtfld_strasse.getText().isEmpty() ||
                txtfld_nummer.getText().isEmpty() || txtfld_plz.getText().isEmpty() || txtfld_stadt.getText().isEmpty() ||
                txtfld_telefon.getText().isEmpty() || txtfld_personr.getText().isEmpty() )
        {
        lb_msg.setText("Bitte alle Felder vollständig ausfüllen.");
        return false;
        }
        else */      
            return true;
    }

}
