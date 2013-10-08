/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airganizer.launcher.controller;

import airganizer.mysql.request.LoginCheck;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author pat
 */
public class LoginMaskController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPwd;

    @FXML
    private TextField txtUser;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'LoginMask.fxml'.";
        assert txtPwd != null : "fx:id=\"txtPwd\" was not injected: check your FXML file 'LoginMask.fxml'.";
        assert txtUser != null : "fx:id=\"txtUser\" was not injected: check your FXML file 'LoginMask.fxml'.";

        

        //Login Button
        btnLogin.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                                               
                        System.out.println("Login Button pressed.");
                        LoginCheck l = new LoginCheck();
                        List user = l.start(txtUser.getText(), txtPwd.getText());
                        
                        System.out.println("LoginMask: " + " UserID: " + user.get(1) + " Username: " + user.get(2) + " Usertype: " + user.get(3));
                                       
            }
        });
    }    
}
