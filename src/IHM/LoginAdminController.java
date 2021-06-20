/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import BD.CRUD_Admin;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class LoginAdminController implements Initializable {
@FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_passwd;

    @FXML
    private ComboBox type;

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
    private Button btn_sign;


    @FXML
    private ComboBox type_up;
    Connection con=null;
     ResultSet rs=null;
   PreparedStatement pst=null;
    
    public void LoginpaneShow(){
        pane_login.setVisible(true);
        pane_signup.setVisible(false);
        
    }
    public void SingnuppaneShow(){
     pane_login.setVisible(false);
     pane_signup.setVisible(true);
    }
    
    @FXML
    private void Login(ActionEvent event ) throws Exception{
        con=CRUD_Admin.getConnection();
        String sql="select * from administration where login=? and mdp=? and userType=? ";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1,txt_username.getText());
            pst.setString(2,txt_passwd.getText());
             pst.setString(3,type.getValue().toString());
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Username And Password are correct");
                btn_login.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("Gpanel.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
            }else  JOptionPane.showMessageDialog(null,"Invalide Username or password");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void add(ActionEvent event){
        con=CRUD_Admin.getConnection();
    String sql="insert into administration (nom,PRENOM,login,mdp,email,tel,userType) values(?,?,?,?,?,?,?)";
    try{
        pst=con.prepareStatement(sql);
        pst.setString(1,txt_nom.getText());
        pst.setString(2,txt_prenom.getText());
        pst.setString(3,txt_login_up.getText());
        pst.setString(4,txt_mdp_up.getText());
        pst.setString(5,txt_email.getText());
        pst.setString(6,txt_tel.getText());
        pst.setString(7,type_up.getValue().toString());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Administration staff add succes");
       btn_sign.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("LoginAdmin.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }catch(Exception e){ 
        JOptionPane.showMessageDialog(null,e);
    }
    }
    
    
    
   
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type_up.getItems().addAll("Admin","Gerant");
        type.getItems().addAll("Admin","Gerant");
    }    
    
}
