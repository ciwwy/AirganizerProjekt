/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airganizer.launcher.controller;

import java.net.URL;
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

import airganizer.mysql.*;

/**
 * FXML Controller class
 *
 * @author pat
 */

public class ConfigMaskController implements Initializable {

               
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
        
        
        //onAction Listeners
        
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
                MaskSwitcher.getReference().connectionStatus(connected);
                
                // Bei Erfolg, neue Werte in Properties-Datei speichern
                if(true){
                    DBConnection.setProperties(address, dbname, dbuser, dbpwd);
                }
 
                 
            }
        });
        

        //Back Button
        btnBack.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                
                MaskSwitcher.getReference().switchMask("login");
                
                
            }
        });
        
            
    
    }
        
  
}
