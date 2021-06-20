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
import model.Clients;

public class CRUD_Client {
	public static Connection getConnection() {
		Connection con=null;
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
        public static ObservableList<Clients> getDatausers(){
            ObservableList<Clients> list =FXCollections.observableArrayList();
            try{
                Connection con =CRUD_Client.getConnection();
                PreparedStatement ps=con.prepareStatement("select * from Clients");
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    
                    Clients k=new Clients();
                    k.setClientId(rs.getInt("clientId"));
                    k.setNom(rs.getString("nom"));
                    k.setPrenom(rs.getString("prenom"));
                    k.setTel(rs.getInt("tel"));
                    k.setEmail(rs.getString("email"));
                    k.setAdresse(rs.getString("adresse"));
                    k.setDateAjout(rs.getDate("dateAjout"));
                     list.add(k);
                            
                }
            }catch(Exception e){
            }
            return list;
            
        }
        
        
         
}