/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import model.capteur;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AORUS
 */
public class crud_capteur {
   
    
    private Connection con ;
    private Statement stmt,stmt2;
    private String mac;
    public crud_capteur(){
         try {
			 	String url = "jdbc:mysql://localhost:3306/projet"; 
				Properties info = new Properties(); 
				info.put("user", "root");
				info.put("password", ""); 
				con = DriverManager.getConnection(url, info); 
				stmt = con.createStatement();
                                stmt2 = con.createStatement();
	        } catch (SQLException ex) {
	        	
	        	System.out.println(ex);
	        }
    }
    
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
    public boolean add_cap(String Imm){
        String[] Type={"GPS","vitesse","pression","temperature","movement","lock"};
        
		try {
                    for(String t : Type){
                    String Query = " insert into capteur (Type,Label,Immatriculation,Disponibilte) VALUES ('" +t+ "','" +getSaltString()+"','" +Imm+"','off')";
                    this.stmt.executeUpdate(Query);
                }
 		return true ;
		}catch(Exception e1) {
			
			return false;
		}
    }
    
    public boolean delete_cap(String la){
        	try {
			String Query="delete from capteur where Label='"+la+"' ";
			stmt.executeUpdate(Query);
			return true;	
		}catch(Exception e2) {return false;}
    }
    
    public String getmac(String T){
        
        int t=0;
        
        try {
            String Query1 ="select * from capteur where Disponibilte='off' and Type='"+T+"'  ";
            ResultSet rs = stmt.executeQuery(Query1);
            if(rs.next()){
             mac = rs.getString("Label");
            String Query2="update capteur set Disponibilte='on' where Label='"+mac+"' ";
            stmt2.executeUpdate(Query2);
            return mac;
            }else{
                return "close";
            }
            
        
        } catch (SQLException ex) {
            System.out.println(ex);
            return "close";
        }
       
    }
  
    
    public ArrayList<capteur> affich_cap_list() {
		try {
		ArrayList<capteur> caplist = new ArrayList<>();
		String Query ="select * from capteur";
		ResultSet rs = stmt.executeQuery(Query);
		while(rs.next()) {
                        int id=rs.getInt("idCapteur");
                        String type= rs.getString("Type");
                        String Label = rs.getString("Label");
                        String imm = rs.getString("Immatriculation");
                        String dis = rs.getString("Disponibilte");
			capteur fac= new capteur(id,type,Label,imm,dis);		
			caplist.add(fac);
		}
		return caplist;
		}catch (Exception e3) {
			return null;}
	}
    public capteur affich_cap(int id) {
		try {
		String Query =" select * from capteur where idCapteur='"+id+"' ";
		ResultSet rs = stmt.executeQuery(Query);
		capteur fac = null;
		while(rs.next()) {
			int idd=rs.getInt("idCapteur");
                        String typee= rs.getString("Type");
                        String Labell = rs.getString("Label");
                        String immm = rs.getString("Immatriculation");
                        String diss = rs.getString("Disponibilte");
			fac= new capteur(idd,typee,Labell,immm,diss);
			
			
		}
                
		return fac;
		}catch (Exception e4) {return null;}
	}
    
    
    
}