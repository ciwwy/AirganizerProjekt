package airganizer.gui.controller;

import airganizer.dba.DBConnection;
import airganizer.dba.DBTest;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


/**
 * FXML Controller class
 * Config-Maske
 *
 * @author pat
 */

public class LauncherConfig implements Initializable {

               
        @FXML
        private URL location;
        
        @FXML
        private BorderPane myBorderPane;
        
        @FXML
        private TextField txtAddress;

        @FXML
        private TextField txtDBName;

        @FXML
        private PasswordField txtPwd;

        @FXML
        private TextField txtUsername;
        
        @FXML
        private Button btnBack;

        @FXML
        private Button btnConnect;
        
        @FXML
        private AnchorPane myAnchorPane;

        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        assert myBorderPane != null : "fx:id=\"myBorderPane\" was not injected: check your FXML file 'LoginMask.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'ConfigMask.fxml'.";
        assert txtDBName != null : "fx:id=\"txtDBName\" was not injected: check your FXML file 'ConfigMask.fxml'.";
        assert txtPwd != null : "fx:id=\"txtPwd\" was not injected: check your FXML file 'ConfigMask.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'ConfigMask.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'ConfigMask.fxml'.";
        assert btnConnect != null : "fx:id=\"btnConnect\" was not injected: check your FXML file 'ConfigMask.fxml'.";
        assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'ConfigMask.fxml'.";
        
        
        // Aktuelle Konfigurationsdaten laden
        Map configList = DBConnection.getProperties();
        
        // Textfelder belegen       
        txtAddress.setText((String) configList.get("Adresse"));
        txtDBName.setText((String) configList.get("Name"));
        txtUsername.setText((String) configList.get("User"));
        txtPwd.setText((String) configList.get("Passwort"));
        
        
        
        //// Button onAction Listeners ////
        
        //Connect Button
        btnConnect.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                
                String address = txtAddress.getText();
                String dbname = txtDBName.getText();
                String dbuser = txtUsername.getText();
                String dbpwd = txtPwd.getText();
                
                // Testobjekt erzeugen
                DBTest dbtest = new DBTest();
                
                // Verbindung mit neuen Werten testen
                Boolean connected = dbtest.test(address, dbname, dbuser, dbpwd);
                
                // Ergebnis anzeigen
                LauncherFrame.getInstance().connectionStatus(connected);
                
                // Bei Erfolg, neue Werte in Properties-Datei speichern
                if(connected){
                    DBConnection.setProperties(address, dbname, dbuser, dbpwd);
                }
 
                 
            }
        });
        

        //Back Button
        btnBack.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                
                LauncherFrame.getInstance().setLoginMask();
                System.out.println("BACK BUTTON PRESSED");
                
                
            }
        });
        
            
    
    }
        
  
}
