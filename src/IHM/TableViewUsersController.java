/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import BD.CRUD_Client;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Clients;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class TableViewUsersController implements Initializable {

    
    @FXML
    private TableView<Clients> table_users;

    @FXML
    private TableColumn<Clients, Integer> col_id;

    @FXML
    private TableColumn<Clients, String> col_nom;

    @FXML
    private TableColumn<Clients, String> col_prenom;

    @FXML
    private TableColumn<Clients, String> col_adresse;

    @FXML
    private TableColumn<Clients, String> col_email;

    @FXML
    private TableColumn<Clients, Integer> col_tel;

    @FXML
    private TableColumn<Clients, Date> col_date;
      @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_tel;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_adresse;

    @FXML
    private TextField txt_date;

    @FXML
    private TextField txt_id;
    @FXML
    private TextField filterField;
      @FXML
    private ImageView back;
   ObservableList<Clients> listM;
   ObservableList<Clients> dataList;
   int index = -1;
   Connection con=null;
   ResultSet rs=null;
   PreparedStatement pst=null;
   
   
    @FXML
    private AnchorPane parent;
     void search_client(){
         col_id.setCellValueFactory(new PropertyValueFactory<Clients,Integer>("clientId"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Clients,String>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<Clients,String>("prenom"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<Clients,String>("adresse"));
        col_email.setCellValueFactory(new PropertyValueFactory<Clients,String>("email"));
        col_tel.setCellValueFactory(new PropertyValueFactory<Clients,Integer>("tel"));
        col_date.setCellValueFactory(new PropertyValueFactory<Clients,Date>("dateAjout"));
        dataList=CRUD_Client.getDatausers();
        table_users.setItems(dataList);
        FilteredList<Clients> filtredData=new FilteredList<>(dataList,b->true);
        filterField.textProperty().addListener((observation,oldValue,newValue)->{
           filtredData.setPredicate(person->{
              if(newValue==null|| newValue.isEmpty()){
                  return true;
              }
              String lowerCaseFilter=newValue.toLowerCase();
              if(person.getNom().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                  return true;//filter matches name
              }else if(person.getPrenom().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                  return true;//filter matches prenom
              }else if(person.getEmail().toLowerCase().indexOf(lowerCaseFilter)!=-1){
              return true;//filter matches email
              }
              else return false;//doesnot match
              
                  
              
           });
        });
        SortedList<Clients> sortedData =new SortedList<>(filtredData);
        sortedData.comparatorProperty().bind(table_users.comparatorProperty());
        table_users.setItems(sortedData);
      }
    @FXML
    public void Add_users(){
    con=CRUD_Client.getConnection();
    String sql="insert into clients (tel,email,adresse,dateAjout,nom,prenom) values(?,?,?,?,?,?)";
    try{
        pst=con.prepareStatement(sql);
        pst.setString(1,txt_tel.getText());
        pst.setString(2,txt_email.getText());
        pst.setString(3,txt_adresse.getText());
        pst.setString(4,txt_date.getText());
        pst.setString(5,txt_nom.getText());
        pst.setString(6,txt_prenom.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null, "clients add succes");
        UpdateTable();
        search_client();
    }catch(Exception e){ JOptionPane.showMessageDialog(null,e);
    }
    }
    
    //// methode select clients////
     @FXML
    void getSelected(MouseEvent event ){
        index=table_users.getSelectionModel().getSelectedIndex();
        if(index<= -1){
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_nom.setText(col_nom.getCellData(index).toString());
        txt_prenom.setText(col_prenom.getCellData(index).toString());
        txt_tel.setText(col_tel.getCellData(index).toString());
        txt_email.setText(col_email.getCellData(index).toString());
        txt_adresse.setText(col_adresse.getCellData(index).toString());
        txt_date.setText(col_date.getCellData(index).toString());
        
    }
    @FXML
    public void Edit(){
        try {
            con=CRUD_Client.getConnection();
            String value1=txt_id.getText();
            String value2=txt_nom.getText();
            String value3=txt_prenom.getText();
            String value4=txt_tel.getText();
            String value5=txt_email.getText();
            String value6=txt_adresse.getText();
            String value7=txt_date.getText();
      String sql="update clients set clientId='"+value1+"',nom='"+value2+"',prenom='"+
              value3+"',tel='"+value4+"',email='"+value5+"',adresse='"+value6+"',dateAjout='"
              +value7+"'where clientId='"+value1+"'"  ;    
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update est bien fait");
            UpdateTable();
            search_client();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @FXML
   public void Delete(){
    con=CRUD_Client.getConnection();
    String sql="delete from db_project.clients where clientId=?";
       try {
           pst=con.prepareStatement(sql);
           pst.setString(1, txt_id.getText());
           pst.execute();
            JOptionPane.showMessageDialog(null, "Delete bien fait");
              UpdateTable();
              search_client();
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
   
   }
    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Clients,Integer>("clientId"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Clients,String>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<Clients,String>("prenom"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<Clients,String>("adresse"));
        col_email.setCellValueFactory(new PropertyValueFactory<Clients,String>("email"));
        col_tel.setCellValueFactory(new PropertyValueFactory<Clients,Integer>("tel"));
        col_date.setCellValueFactory(new PropertyValueFactory<Clients,Date>("dateAjout"));
        listM=  CRUD_Client.getDatausers();
        table_users.setItems(listM);
    }
     @FXML
    private void switchback(MouseEvent event) {
    
        try{back.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("Gpanel.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}catch (Exception e){
                }}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       UpdateTable();
       search_client();
    }    

   
    
    
}
