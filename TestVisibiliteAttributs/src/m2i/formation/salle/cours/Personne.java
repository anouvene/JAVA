package m2i.formation.salle.cours;

public class Personne {
	// Visibilités du plus au moins strictes
	private String nom;
	int age; // default package
	protected String prenom;	
	public String email;
	
	public Personne(String nom, String prenom, int age, String email) {
		this.nom = nom;
		this.age = age;
		this.prenom = prenom;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	
}
