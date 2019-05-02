package m2i.formation.java;

public class Note {
	private Matiere matiere;
	private float valeur;
	private Devoirs devoir;

	public Note(Matiere matiere, float valeur, Devoirs devoir) {
		this.matiere = matiere;
		this.devoir = devoir;
		this.valeur = valeur;
	}

	// Getters & Setters
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	public Devoirs getDevoir() {
		return devoir;
	}

	public void setDevoir(Devoirs devoir) {
		this.devoir = devoir;
	}

	// Affichage
	@Override
	public String toString() {
		return matiere + ": " + valeur;
	}

}
