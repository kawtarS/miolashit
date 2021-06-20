/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;
import BD.CRUD_Emprunt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Emprunt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class Emprunttry2Controller implements Initializable {

    @FXML
    private TextField txt_idClient;

    @FXML
    private TextField txt_idvoiture;

    @FXML
    private TextField txt_dateEm;

    @FXML
    private TextField txt_dateretour;

    @FXML
    private TextField txt_etatemprunt;

    @FXML
    private TextField txt_idEmprunt;

    @FXML
    private TableView<Emprunt> tables_emprunt;

    @FXML
    private TableColumn<Emprunt, Integer> col_empruntId;

    @FXML
    private TableColumn<Emprunt,Integer> col_idclient;

    @FXML
    private TableColumn<Emprunt,Integer> col_voitureId;

    @FXML
    private TableColumn<Emprunt,Date> col_dateE;

    @FXML
    private TableColumn<Emprunt, Date> col_dateR;

    @FXML
    private TableColumn<Emprunt, String> col_etat;
    ObservableList<Emprunt> listM;
    int index=-1;
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst = null;
    

@FXML
    private ImageView back;

    @FXML
    private TextField filterField;

   // ResultSet rs=null;
   //PreparedStatement pst=null;
   PreparedStatement pst1=null;
   @FXML
      public void Add_Emprunts(){//working
    con=CRUD_Emprunt.getConnection();
    String sql="insert into  db_project.emprunts2 (clientId,voitureId,dateEmprunt,dateRetour,etatEmprunt) values(?,?,?,?,?)";
    try{
        pst=con.prepareStatement(sql);
            pst.setString(1,txt_idClient.getText());
        pst.setString(2,txt_idvoiture.getText());
        pst.setString(3,txt_dateEm.getText());
        pst.setString(4,txt_dateretour.getText());
        pst.setString(5,txt_etatemprunt.getText());
        String value11=txt_idvoiture.getText();
        String value12=txt_etatemprunt.getText();   
        pst.execute();
       String sql1="update db_project.voitures set estEmpruntee ='"+value11+"'WHERE voitureId='"+value12 +"' ";
          pst1=con.prepareStatement(sql1);
   
        pst1.execute();
        JOptionPane.showMessageDialog(null, "emprunt add succes");
        
         UpdateTable();
        //search_client();
        
       JOptionPane.showMessageDialog(null, "modife voiture  succes");
       
    }catch(Exception e){ JOptionPane.showMessageDialog(null,e);
    }
    }

    void Delete(ActionEvent event) {

    }

  @FXML
    private void switchback(MouseEvent event) {
    
        try{back.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("Gpanel.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}catch (Exception e){
                }
  
    

} 
    
   public void Delete(){//is working 
    con= CRUD_Emprunt.getConnection();
    String sql="delete from emprunts2 where empruntId=?";
   
       try {
           pst=con.prepareStatement(sql);
           pst.setString(1, txt_idEmprunt.getText());
           pst.execute();
            JOptionPane.showMessageDialog(null, "Delete bien fait");
              UpdateTable();
              //search_client();
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
   
   }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      UpdateTable();
    }

    private void UpdateTable() {
        col_empruntId.setCellValueFactory(new PropertyValueFactory<Emprunt,Integer>("empruntId"));
      col_idclient.setCellValueFactory(new PropertyValueFactory<>("clientId"));
     col_voitureId.setCellValueFactory(new PropertyValueFactory<>("voitureId"));
      col_dateE.setCellValueFactory(new PropertyValueFactory<>("dateEmprunt"));
            col_dateR.setCellValueFactory(new PropertyValueFactory<>("dateRetour"));
              col_etat.setCellValueFactory(new PropertyValueFactory<>("etatEmprunt"));
         listM=  CRUD_Emprunt.getDatausers();
           tables_emprunt.setItems(listM);
    }
    
    @FXML
     void getSelected(MouseEvent event){//working only in empruntid
        index=tables_emprunt.getSelectionModel().getSelectedIndex();
        if(index<= -1){
            return;
        }
       txt_idEmprunt.setText((String)col_empruntId.getCellData(index).toString());
       txt_idClient.setText((String)col_idclient.getCellData(index).toString());
       txt_idvoiture.setText((String)col_voitureId.getCellData(index).toString());
        txt_dateEm.setText((String)col_dateE.getCellData(index).toString());
        txt_dateretour.setText((String)col_dateR.getCellData(index).toString());
        txt_etatemprunt.setText((String)col_etat.getCellData(index).toString());
        
        
    }

    @FXML
    private void DeleteEm(ActionEvent event) {
        con= CRUD_Emprunt.getConnection();
    String sql="delete from emprunts2 where empruntId=?";
   
       try {
           pst=con.prepareStatement(sql);
           pst.setString(1, txt_idEmprunt.getText());
           pst.execute();
            JOptionPane.showMessageDialog(null, "Delete bien fait");
              UpdateTable();
              //search_client();
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
    }

    @FXML
    private void Edit(ActionEvent event) {
    }
}

