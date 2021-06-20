/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class CPanelController implements Initializable {

    @FXML
    private Button btn_client;

    @FXML
    private Button btn_voiture;

    @FXML
    private Button btn_Emp;

    @FXML
    private Button btn_Alerts;
    
    @FXML
    void switchclient(ActionEvent event)
    {
        try{btn_client.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("TableViewUsers.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}catch (Exception e){
                }}
@FXML
    void switchvoiture(ActionEvent event) {
   try{btn_voiture.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("voitures.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}catch (Exception e){
                }}
    @FXML
    void switchEmprunt(ActionEvent event) {
   try{btn_Emp.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("emprunts.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}catch (Exception e){
                }}
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
