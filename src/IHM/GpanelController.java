/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class GpanelController implements Initializable {

    @FXML
    private ImageView btn_client;
    @FXML
    private ImageView btn_voiture;
    @FXML
    private ImageView btn_Alerts;
    @FXML
    private ImageView btn_Emp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchclient(MouseEvent event) {
         try{btn_client.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("TableViewUsers.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}catch (Exception e){
                }}
    

    @FXML
    private void switchvoiture(MouseEvent event) {
try{btn_voiture.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("voitures.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}catch (Exception e){
                }}
    

    @FXML
    private void switchEmprunt(MouseEvent event) {
 try{btn_Emp.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("Emprunttry2.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}catch (Exception e){
                }}
    }
    

