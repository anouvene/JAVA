package m2i.formation.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Classe implements Moyennable {
	private String id_salle;

	private List<Eleve> eleves;

	public Classe(String id_salle) {
		this.id_salle = id_salle;
		this.eleves = new ArrayList<>();
	}

	// Getters & Setters
	public String getId_salle() {
		return id_salle;
	}

	public void setId_salle(String id_salle) {
		this.id_salle = id_salle;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	/**
	 * Ajouter un Eleve
	 * 
	 * @param e Eleve
	 */
	public void addEleve(Eleve e) {
		this.eleves.add(e);
	}

	/**
	 * Retourne la moyenne generale de la classe
	 */
	@Override
	public float moyenne() {
		if (this.eleves.isEmpty()) {
			return -1;
		}
		float result = 0;
		for (Eleve e : this.eleves) {
			result += e.moyenne();
		}
		result /= eleves.size();
		return result;
	}

	/**
	 * Retourne la moyenne de la classe dans la matiere m
	 */
	@Override
	public float moyenneParMatiere(Matiere m) {
		if (this.eleves.isEmpty()) {
			return -1;
		}
		float result = 0;
		for (Eleve e : this.eleves) {
			result += e.moyenneParMatiere(m);
		}
		result /= eleves.size();
		return result;
	}

	/**
	 * Moyenne selon filtre
	 * @param filter
	 * @return float Moyenne
	 */
	public float moyenne(NoteFilter<Note> filter) {
		int compteur = 0;
		
		if (this.eleves.isEmpty()) {
			return -1;
		}
		float result = 0;
		for (Eleve e : this.eleves) {
			if(e.moyenne(filter) >= 0) {
				result += e.moyenne(filter);
				compteur++;
			}			
		}
		
		if(compteur !=0) {
			result /= compteur;
		} else {
			result = -1;
		}
		
		return result;
	}

	/**
	 * Classement des eleves et sauvegarde en memoire ce classement dans une liste
	 * @param comp Comparator
	 * @return ArrayList Liste d eleves classes
	 */
	public Classement classement(Comparator<Eleve> comp) {
		// trie l'attribut eleves
		eleves.sort(comp);

		// copie la liste
		List<Eleve> result = new ArrayList<>();
		result.addAll(eleves);

		// retourne la liste
		return new Classement(result, (Note note) -> true);
	}

	/**
	 * Classer les eleves par moyenne generale et renvoit le classement a cet instant
	 * 
	 * @return
	 */
	public Classement classementGeneral() {
		// trie l'attribut eleves
		eleves.sort(new ComparateurGeneral());

		// copie la liste
		List<Eleve> result = new ArrayList<>();
		result.addAll(eleves);

		// retourne la liste
		return new Classement(result, new Moyenator() {

			@Override
			public float calculer(Eleve e) {
				return e.moyenne();
			}
		});
	}

	/**
	 * classe les eleves par moyenne generale et renvoit le classement a cet instant
	 * 
	 * @return
	 */
	public Classement classementParMatiere(Matiere m) {
		// trie l'attribut eleves
		eleves.sort(new Comparator<Eleve>() {

			@Override
			public int compare(Eleve e1, Eleve e2) {
				return ((Float) e1.moyenneParMatiere(m)).compareTo(e2.moyenneParMatiere(m));
			}

		});

		// copie la liste
		List<Eleve> result = new ArrayList<>();
		result.addAll(eleves);

		// retourne la liste
		return new Classement(result, new Moyenator() {

			@Override
			public float calculer(Eleve e) {
				return e.moyenneParMatiere(m);
			}

		});
	}
	
	/**
	 * Classement selon un NoteFilter
	 * @param filter NoteFilter le filtre
	 * @return
	 */
	public Classement classementFiltre(NoteFilter<Note> filter) {
		// trier l'attribut eleves
		eleves.sort((Eleve e1, Eleve e2)->((Float)e1.moyenne(filter)).compareTo(e2.moyenne(filter)));

		// copier la liste
		List<Eleve> result = new ArrayList<>();
		result.addAll(eleves);

		// retourne la liste
		return new Classement(result, (Note note) -> true);
	}
	
	// Affichage
	@Override
	public String toString() {
		return "\nClasse\n    id_salle = " + id_salle + "\n    eleves = " + eleves + "\n";
	}


}
