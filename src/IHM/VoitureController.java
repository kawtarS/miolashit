/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import BD.CRUD_Voiture;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Voiture;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class  VoitureController implements Initializable {

  
 @FXML
    private TableView<Voiture > table_voitures;



    

    @FXML
    private TextField txt_marque;

    @FXML
    private TextField txt_matricule;

    @FXML
    private TextField txt_model;

    @FXML
    private TextField txt_vitesse;

    @FXML
    private TextField txt_carb;

    @FXML
    private TextField txt_emp;

    @FXML
    private TextField txt_id;

   

    @FXML
    private TableColumn<Voiture ,Integer> col_id;

    @FXML
    private TableColumn<Voiture,String> col_marque;

    @FXML
    private TableColumn<Voiture, String> col_matricule;

    @FXML
    private TableColumn<Voiture, String> col_model;

    @FXML
    private TableColumn<Voiture,Integer> col_vitesse;

    @FXML
    private TableColumn<Voiture,String> col_type;

    @FXML
    private TableColumn<Voiture,String> col_emp;

    @FXML
    private TextField filterField;
    
    ObservableList<Voiture> listM;
   ObservableList<Voiture> dataList;
   int index = -1;
   Connection con=null;
   ResultSet rs=null;
   PreparedStatement pst=null;
    @FXML
    private ImageView back;

    @FXML
    public void Add_voiture(){
    con=CRUD_Voiture.getConnection();
    String sql="insert into voitures (marque,matricule,model,vitesse,typeCarburant,estEmpruntee) values(?,?,?,?,?,?)";
    try{
        pst=con.prepareStatement(sql);
        pst.setString(1,txt_marque.getText());
        pst.setString(2,txt_matricule.getText());
        pst.setString(3,txt_model.getText());
        pst.setString(4,txt_vitesse.getText());
        pst.setString(5,txt_carb.getText());
        pst.setString(6,txt_emp.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null, "voitures add succes");
        UpdateTable();
      //search_voiture();
    }catch(Exception e){ JOptionPane.showMessageDialog(null,e);
    }
    }

    @FXML
    void Delete(ActionEvent event) {
    con=CRUD_Voiture.getConnection();
    String sql="delete from voitures where voitureId=?";
       try {
           pst=con.prepareStatement(sql);
           pst.setString(1, txt_id.getText());
           pst.execute();
            JOptionPane.showMessageDialog(null, "Delete bien fait");
           UpdateTable();
          // search_voiture();
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
   
    }
   public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Voiture,Integer>("voitureId"));
        col_marque.setCellValueFactory(new PropertyValueFactory<Voiture,String>("marque"));
        col_matricule.setCellValueFactory(new PropertyValueFactory<Voiture,String>("matricule"));
        col_model.setCellValueFactory(new PropertyValueFactory<Voiture,String>("model"));
        col_vitesse.setCellValueFactory(new PropertyValueFactory<Voiture,Integer>("vitesse"));
        col_type.setCellValueFactory(new PropertyValueFactory<Voiture,String>("typeCarburant"));
        col_emp.setCellValueFactory(new PropertyValueFactory<Voiture,String>("estEmpruntee"));
        listM=  CRUD_Voiture.getDatausers();
        table_voitures.setItems(listM);
    }
    

    @FXML
    public void Edit(){
        try {
            con=CRUD_Voiture.getConnection();
            String value1=txt_id.getText();
            String value2=txt_marque.getText();
            String value3=txt_matricule.getText();
            String value4=txt_model.getText();
            String value5=txt_vitesse.getText();
            String value6=txt_carb.getText();
            String value7=txt_emp.getText();
      String sql="update voitures set voitureId ='"+value1+"',marque='"+value2+"',matricule='"+
              value3+"',model='"+value4+"',vitesse='"+value5+"',typeCarburant='"+value6+"',estEmpruntee='"
              +value7+"'where voitureId='"+value1+"'"  ;    
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update est bien fait");
           UpdateTable();
        //search_voiture();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
 @FXML
    private AnchorPane parent;
    void search_voiture(){
         col_id.setCellValueFactory(new PropertyValueFactory<Voiture,Integer>("txt_id"));
        col_marque.setCellValueFactory(new PropertyValueFactory<Voiture,String>("txt_marque"));
        col_matricule.setCellValueFactory(new PropertyValueFactory<Voiture,String>("txt_matricule"));
        col_model.setCellValueFactory(new PropertyValueFactory<Voiture,String>("txt_model"));
        col_vitesse.setCellValueFactory(new PropertyValueFactory<Voiture,Integer>("txt_vitesse"));
        col_type.setCellValueFactory(new PropertyValueFactory<Voiture,String>("txt_carb"));
        col_emp.setCellValueFactory(new PropertyValueFactory<Voiture,String>("txt_emp"));
        dataList=CRUD_Voiture.getDatausers();
        table_voitures.setItems(dataList);
        FilteredList<Voiture> filtredData=new FilteredList<>(dataList,b->true);
        filterField.textProperty().addListener((observation,oldValue,newValue)->{
           filtredData.setPredicate(car->{
              if(newValue==null|| newValue.isEmpty()){
                  return true;
              }
              String lowerCaseFilter=newValue.toLowerCase();
              if(car.getMarque().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                  return true;//filter matches marque
              }else if(car.getMatricule().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                  return true;//filter matches matricule
              }else if(car.getModel().toLowerCase().indexOf(lowerCaseFilter)!=-1){
              return true;//filter matches model
              }
              else return false;//doesnot match
              
                  
              
           });
        });
        SortedList<Voiture> sortedData =new SortedList<>(filtredData);
        sortedData.comparatorProperty().bind(table_voitures.comparatorProperty());
        table_voitures.setItems(sortedData);
      }
    
   //// methode select voiture////
     @FXML
    void getSelected(MouseEvent event ){
        index=table_voitures.getSelectionModel().getSelectedIndex();
        if(index<= -1){
            return;
        }
        txt_id.setText(col_id.getCellData(index).toString());
        txt_marque.setText(col_marque.getCellData(index).toString());
        txt_matricule.setText(col_matricule.getCellData(index).toString());
        txt_model.setText(col_model.getCellData(index).toString());
        txt_vitesse.setText(col_vitesse.getCellData(index).toString());
        txt_carb.setText(col_type.getCellData(index).toString());
        txt_emp.setText(col_emp.getCellData(index).toString());
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
      //search_voiture();

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
    
   
}
