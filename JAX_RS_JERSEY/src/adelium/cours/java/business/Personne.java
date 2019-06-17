package adelium.cours.java.business;

public class Personne {
	private String nom;
	private String prenom;
	
	private String message;
	
	public Personne(String nom, String prenom, String message) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void set_ID_Societe(int _ID_Societe) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
