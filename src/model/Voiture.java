/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Voiture {
    private int voitureId ,vitesse;
    private String marque,matricule,model;
    private String typeCarburant,estEmpruntee="false"; 
    public Voiture(int voitureId, int vitesse, String marque, String matricule, String model, String typeCarburant,
				String estEmpruntee) {
			super();
			this.voitureId = voitureId;
			this.vitesse = vitesse;
			this.marque = marque;
			this.matricule = matricule;
			this.model = model;
			this.typeCarburant = typeCarburant;
			this.estEmpruntee = estEmpruntee;
		}
		public Voiture() {
			super();
		}
		public int getVoitureId() {
			return voitureId;
		}
		public void setVoitureId(int voitureId) {
			this.voitureId = voitureId;
		}
		public int getVitesse() {
			return vitesse;
		}
		public void setVitesse(int vitesse) {
			this.vitesse = vitesse;
		}
		public String getMarque() {
			return marque;
		}
		public void setMarque(String marque) {
			this.marque = marque;
		}
		public String getMatricule() {
			return matricule;
		}
		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getTypeCarburant() {
			return typeCarburant;
		}
		public void setTypeCarburant(String typeCarburant) {
			this.typeCarburant = typeCarburant;
		}
		public String getEstEmpruntee() {
			return estEmpruntee;
		}
		public void setEstEmpruntee(String estEmpruntee) {
			this.estEmpruntee = estEmpruntee;
		}
		@Override
		public String toString() {
			return "Voiture [voitureId=" + voitureId + ", vitesse=" + vitesse + ", marque=" + marque + ", matricule="
					+ matricule + ", model=" + model + ", typeCarburant=" + typeCarburant + ", estEmpruntee="
					+ estEmpruntee + "]";
		} 
    
}
