/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airganizer.launcher.controller;

import airganizer.mysql.DBTest;
import airganizer.mysql.DBConnection;
import airganizer.mysql.request.UserInfo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author pat
 */

public class LauncherMaskController implements Initializable {
    
        UserInfo ui;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private MenuItem mnuConfig;

        @FXML
        private Menu mnuHelp;

        @FXML
        private MenuItem mnuLayout;

        @FXML
        private BorderPane myBorderPane;

        @FXML
        private Text textDBStatus;
       
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert mnuConfig != null : "fx:id=\"mnuConfig\" was not injected: check your FXML file 'LauncherMask.fxml'.";
        assert mnuHelp != null : "fx:id=\"mnuHelp\" was not injected: check your FXML file 'LauncherMask.fxml'.";
        assert mnuLayout != null : "fx:id=\"mnuLayout\" was not injected: check your FXML file 'LauncherMask.fxml'.";
        assert myBorderPane != null : "fx:id=\"myBorderPane\" was not injected: check your FXML file 'LauncherMask.fxml'.";
        assert textDBStatus != null : "fx:id=\"textDBStatus\" was not injected: check your FXML file 'LauncherMask.fxml'.";


        System.out.println("Launcher Initialized");
        
        // Konfigurationen laden
        if(DBConnection.getProperties()){System.out.println("Properties loaded");}
        
        // Objektadresse speichern
        MaskSwitcher.addLMC(this);
        
        
        ///// onAction Listeners /////
        
        //MenuItem MySQL Konfiguration
        mnuConfig.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
            
                System.out.println("Test... Config Button Worked.");
                Parent p_config = MaskSwitcher.getView("config");
                myBorderPane.setCenter(p_config);
            
            }
        });  
       
        //MenuItem Vorlage wechseln
        mnuLayout.setOnAction(new EventHandler<ActionEvent>(){
            
           @Override
           public void handle(ActionEvent e){
               
               System.out.println("Test... Layout Button Worked.");
                  
               Parent p_layout = MaskSwitcher.getView("login");
                myBorderPane.setCenter(p_layout);
               
               
           } 
        });
        
        
        //MenuItem Hilfe
        
        mnuHelp.setOnAction(new EventHandler<ActionEvent>(){ 
            
            @Override
            public void handle(ActionEvent e){
                
                // Erste Untermaskte anzeigen (Login)
                 Parent p_login = MaskSwitcher.getView("login");
                 myBorderPane.setCenter(p_login);
                System.out.println("Test... Help Button Worked.");
                
            }
        });
        
        
          
        
        //Verbindung zur DB Überprüfen
        DBTest dbtest = new DBTest();
        if(dbtest.test()){
            textDBStatus.setText("Erfolgreich");
            textDBStatus.setFill(Color.GREEN);
        } else {
         
            textDBStatus.setText("Fehlerhaft");
            textDBStatus.setFill(Color.RED);
        }
            
    
    }
    
     public void startmask(Parent p) {
         myBorderPane.setCenter(p);
     }
        
  
}
