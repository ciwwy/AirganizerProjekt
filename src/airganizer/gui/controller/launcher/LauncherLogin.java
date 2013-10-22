package airganizer.gui.controller.launcher;

import airganizer.gui.Launcher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 * Login-Maske
 *
 * @author pat
 */

public class LauncherLogin implements Initializable {

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
    
     
     @FXML
    void keyEnter(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
              System.out.println("Login Button pressed.");
              Launcher.getInstance().loginVersuch(txtUser.getText(), txtPwd.getText());
        }
        
    }
    
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
                        Launcher.getInstance().loginVersuch(txtUser.getText(), txtPwd.getText());
            }
        });
            
    }
}
