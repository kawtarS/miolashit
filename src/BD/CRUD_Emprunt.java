
package BD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
//import model.Clients;
import model.Emprunt;

public class CRUD_Emprunt {
    public static Connection getConnection() {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/db_project";
		con = DriverManager.getConnection(url,"root","");
             // JOptionPane.showMessageDialog(null,"connectionEstablised");
		}catch(ClassNotFoundException | SQLException e) {
			  JOptionPane.showMessageDialog(null,e);
		}
		return con;
}
    public static ObservableList<Emprunt> getDatausers() {
        try {
            Connection con =CRUD_Emprunt.getConnection();
         ObservableList<Emprunt> list =FXCollections.observableArrayList();
       String sql="select * FROM db_project.emprunts2 " ;
        PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();       
                
                while(rs.next()) {
            int id = Integer.parseInt(rs.getString("empruntId"));
           int idclient = Integer.parseInt(rs.getString("clientId"));
          int voitureid =Integer.parseInt(rs.getString("voitureId"));
            Date DE;
                DE = rs.getDate("dateEmprunt");
                  
          Date DR = rs.getDate("dateRetour");
                       String Dispo = rs.getString("etatEmprunt");
                 // vehicule   vi =  new vehicule(id , imm , type , marque , model,Dispo);
              Emprunt K= new Emprunt(DE,DR,voitureid,idclient,id,Dispo);
                    System.out.println("patata :" +K.getClientId());
                    System.out.println("patata :" +K.getClientId());
                    System.out.println("patata :" +K.getClientId());
                    System.out.println("patata :" +K.getClientId());
           list.add(K);
        }
        return list;
        }catch (Exception e3) {
            return null;}
    }
    /* public static void Historique(){
         try {
             Connection con =CRUD_Emprunt.getConnection();
             String sql="select empruntId FROM db_project.emprunts2 where etatEmprunt=non " ;
        PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();       
         } catch (Exception e) {
         }
     */
     }
    


