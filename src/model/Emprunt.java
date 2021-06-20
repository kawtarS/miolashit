/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author hp
 */
public class Emprunt {
   private Date dateEmprunt,dateRetour;
    private int voitureId;
    private int empruntId;
    private int clientId;
    private String etatEmprunt;
    
	public Emprunt(Date dateEmprunt, Date dateRetour,int voiture, int client, int empruntId,String etatEmprunt) {
//		super();
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.voitureId = voiture;
		this.clientId = client;
		this.empruntId = empruntId;
                this.etatEmprunt = etatEmprunt;
	}
	public Emprunt() {
		super();
	}
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	public int getidVoiture() {
		return voitureId;
	}
	public void setVoiture(int voitureId) {
		this.voitureId = voitureId;
	}
	public int getClients() {
		return clientId;
	}
	public void setClients(int clientId) {
		this.clientId = clientId;
	}
	public int getEmpruntId() {
		return empruntId;
	}
        public String getEtatemprunt() {
		return etatEmprunt;
	}
        public void setEtatemprunt(String e) {
		this.etatEmprunt=e;
	}
	public void setEmpruntId(int empruntId) {
		this.empruntId = empruntId;
	}
	@Override
	public String toString() {
		return "Emprunt [dateEmprunt=" + dateEmprunt + ", dateRetour=" + dateRetour + ", voitureId=" + voitureId
				+ ", clients=" + clientId + ", empruntId=" + empruntId + ", etatemprunt=" + etatEmprunt + "]";
	}

    public int getClientId() {
        return clientId;
    }

    public int getVoitureId() {
        return voitureId;
    }

    public String getEtatEmprunt() {
        return etatEmprunt;
    }
    
   
}
