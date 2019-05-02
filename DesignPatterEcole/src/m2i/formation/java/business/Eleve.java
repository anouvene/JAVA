package m2i.formation.java.business;

import java.util.ArrayList;
import java.util.List;

public class Eleve {
	private int idEleve;
	private String nom;
	private String prenom;
	
	// Un Eleve a plusieurs Notes
	private List<Note> notes = new ArrayList<>();
	
	public Eleve(int idEleve, String nom, String prenom) {
		this.idEleve = idEleve;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
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

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	/**
	 * Ajouter une note
	 * @param n Note a ajouter
	 */
	public void ajouterNote(Note n) {
		this.notes.add(n);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Eleve [idEleve=");
		builder.append(idEleve);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", notes=");
		builder.append(notes);
		builder.append("]");
		return builder.toString();
	}
	
	

	

	
}
