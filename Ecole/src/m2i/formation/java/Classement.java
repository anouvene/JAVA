package m2i.formation.java;

import java.util.ArrayList;
import java.util.List;

public class Classement {
	protected List<Eleve> classement;
	protected List<Float> moyennes;

	public List<Eleve> getClassement() {
		return classement;
	}

	public void setClassement(List<Eleve> classement) {
		this.classement = classement;
	}

	public List<Float> getMoyennes() {
		return moyennes;
	}

	public void setMoyennes(List<Float> moyennes) {
		this.moyennes = moyennes;
	}

	/**
	 * Classement basé sur la moyenne generale de Eleve
	 * @param classement
	 * @param moy
	 */
	public Classement(List<Eleve> classement, Moyenator moy) {
		this.classement = classement;
		enregistrerMoyennes(moy);
	}

	/**
	 * Classement selon un filtre
	 * @param classement
	 * @param filter
	 */
	public Classement(List<Eleve> classement, NoteFilter<Note> filter) {
		this.classement = classement;
		enregistrerMoyennes((Eleve e)->e.moyenne(filter));
	}

	/**
	 * Faire la moyenne de chaque eleve et stocker dans un ArrayList
	 * @param moy
	 */
	public void enregistrerMoyennes(Moyenator moy) {
		this.moyennes = new ArrayList<Float>();
		for (Eleve e : classement)
			moyennes.add(moy.calculer(e)); // TODO : Ou se trouve l'implementation de la methode calculer ???
	}

	// Afficher un classement a partir d'une liste supposee ordonnee
	public String toString() {
		String str = "Classement\n";
		for (int i = 0; i < classement.size(); i++) {
			str += classement.get(i).getNom() + " " + classement.get(i).getPrenom() + " " + this.moyennes.get(i)
					+ "\n";
		}
		return str;
	}
}
