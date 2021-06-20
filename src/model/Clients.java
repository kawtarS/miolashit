/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;


public class Clients {
    private int  clientId;
    private String nom,prenom,email,adresse;
    private int tel;
    private Date dateAjout;
    
	public Clients() {
		super();
	}

    public Clients(Clients client) {
       this.clientId = client.getClientId();
		this.nom = client.getNom();
		this.prenom = client.getPrenom();
		this.tel = client.getTel();
		this.email = client.getEmail();
		this.adresse = client.getAdresse();
		this.dateAjout = client.getDateAjout();
    }
	@Override
	public String toString() {
		return "Clinets [clientId=" + clientId + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", email="
				+ email + ", adresse=" + adresse + ", dateAjout=" + dateAjout + "]";
	}
	public Clients(int clientId, String nom, String prenom, int tel, String email, String adresse, Date dateAjout) {
		super();
		this.clientId = clientId;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.adresse = adresse;
		this.dateAjout = dateAjout;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

    public void setTel(String tel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDateAjout(String dateAjout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
