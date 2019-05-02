package m2i.formation.java;

import java.util.ArrayList;
import java.util.List;

public class Eleve extends Personne implements Moyennable {
	private List<Note> notes;
	private List<Matiere> matieres;

	public Eleve(String nom, String prenom) {
		super(nom, prenom);
		this.notes = new ArrayList<>();
		this.matieres = new ArrayList<>();
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	/**
	 * Ajouter une Matiere
	 * 
	 * @param m
	 */
	public void addMatiere(Matiere m) {
		this.matieres.add(m);
	}

	/**
	 * Ajouter une Note
	 * 
	 * @param n
	 */
	public void addNote(Note n) {
		/**
		 * Ajouter une note et vérifier si la matiere notee est dans la tables des matieres
		 * sinon ajouter la matiere notee manquante dans la liste des matieres
		 */
		this.notes.add(n);
		if(!matieres.contains(n.getMatiere())) {
			matieres.add(n.getMatiere());
		}
	}

	/**
	 * Moyenne generale
	 */
	@Override
	public float moyenne() {
		float result = 0;
		for (Note note : notes) {
			result = result + note.getValeur();
		}

		result = result / notes.size();
		// TODO Auto-generated method stub
		return result;
	}
	
	/**
	 * Moyenne par matiere
	 */
	@Override
	public float moyenneParMatiere(Matiere m) {
		// TODO Auto-generated method stub
		float result = 0;
		int compteur = 0;
		for (Note note : notes) {
			if (note.getMatiere() == m) {
				result += note.getValeur();
				compteur++;
			}
		}
		if(compteur != 0)
			result = result/compteur;
		else
			return -1;
		return result;
	}
	
	/**
	 * Moyenne selon un filtre
	 * @param filter
	 * @return
	 */
	public float moyenne(NoteFilter<Note> filter) {
		float result = 0;
		int compteur = 0;
		for (Note note : notes) {
			if (filter.filter(note)) {
				result += note.getValeur();
				compteur++;
			}
		}
		if(compteur != 0)
			result = result/compteur;
		else
			return -1;
		return result;
	}

	// Affichage
	@Override
	public String toString() {
		return "\n      " + super.toString() 
				+ "\n      notes = " + notes 
				+ "\n      matieres = " + matieres +"\n    ";
	}


}
