package m2i.formation.java;

public class Cycliste implements IMouvement {

	private String nom, prenom, equipe;
	
	
	public Cycliste(String nom, String prenom, String equipe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.equipe = equipe;
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


	public String getEquipe() {
		return equipe;
	}


	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}


	@Override
	public void freiner() {
		System.out.println("Cycliste freine");

	}

	@Override
	public void accelerer() {
		System.out.println("Cycliste accélère");

	}

	@Override
	public String toString() {
		return "Cycliste ["
				+ "nom=" + nom 
				+ ", prenom=" + prenom 
				+ ", equipe=" + equipe 
				+ "]";
	}
	
	
	

}
