
package model;

public class Administration {
   private int userId,tel;
    private String nom,prenom,email,pwd;
    private String usertype;//0 admin,1 gerant
    public Administration(int userId, int tel, String nom, String prenom, String email, String pwd, String usertype) {
		super();
		this.userId = userId;
		this.tel = tel;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pwd = pwd;
		this.usertype = usertype;
	}
    public Administration() {
		super();
	}
	@Override
	public String toString() {
		return "Administration [userId=" + userId + ", tel=" + tel + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", pwd=" + pwd + ", usertype=" + usertype + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
}
    

