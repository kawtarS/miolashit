/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import model.Voiture;
public class CRUD_Voiture {
    public static Connection getConnection() {
		Connection con=null;;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/db_project";
		con = DriverManager.getConnection(url,"root","");
                //JOptionPane.showMessageDialog(null,"connectionEstablised");
		}catch(ClassNotFoundException | SQLException e) {
			  JOptionPane.showMessageDialog(null,e);
		}
		return con;
	}
    public static ObservableList<Voiture> getDatausers(){
            ObservableList<Voiture> list =FXCollections.observableArrayList();
            try{
                Connection con =CRUD_Voiture.getConnection();
                PreparedStatement ps=con.prepareStatement("select * from voitures ");
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    
                    Voiture k=new Voiture();
                     k.setVoitureId(rs.getInt("voitureId"));
                    k.setMarque(rs.getString("marque"));
                    k.setModel(rs.getString("model"));
                    k.setMatricule(rs.getString("matricule"));
                    k.setVitesse(rs.getInt("vitesse"));
                    k.setTypeCarburant(rs.getString("typeCarburant"));
                    k.setEstEmpruntee(rs.getString("estEmpruntee"));
                   
                     list.add(k);
                            
                }
            }catch(Exception e){
            }
            return list;
            
        }
}
