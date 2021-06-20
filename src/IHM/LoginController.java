/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class LoginController implements Initializable {
@FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_passwd;

    @FXML
    private ComboBox<?> type;

    @FXML
    private Button btn_login;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_login_up;

    @FXML
    private TextField txt_mdp_up;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_tel;

    @FXML
    private TextField txt_nom;

    @FXML
    private ComboBox<?> type_up;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
