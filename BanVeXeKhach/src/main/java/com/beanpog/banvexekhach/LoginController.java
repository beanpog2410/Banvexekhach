package com.beanpog.banvexekhach;

import com.beanpog.banvexekhach.services.UserServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
    
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btLogin;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.btLogin.setOnAction(evt -> login());
    } 
    
    private void login() {
        String username = this.txtUsername.getText().trim();
        String password = this.txtPassword.getText().trim();
        
        try {
            if (UserServices.CheckUser(username, password) == false) {
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Dang nhap that bai !");
                alert.setHeaderText(null);
                alert.showAndWait();
                
            } else {
                try {
                    App.setRoot("manageticket");
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}