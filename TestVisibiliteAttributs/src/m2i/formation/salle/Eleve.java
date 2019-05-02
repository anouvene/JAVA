package m2i.formation.salle;

import m2i.formation.salle.cours.Personne;

public class Eleve extends Personne {

	public Eleve(String nom, String prenom, int age, String email) {
		super(nom, prenom, age, email);
	}
	
	public void ecrire() {
		
		Personne p = new Personne(null, null, 0, null);
		// Visibilite attributs Personne
		System.out.println(p.nom);    // private: non
		System.out.println(p.prenom); // protected: non
		System.out.println(p.age);    // private: non
		System.out.println(p.email);  // public: oui
		
		Eleve e = new Eleve("", "", 12, "");	
		// Visibilite attributs Personne <- Eleve
		System.out.println(e.nom);		// private: non
		System.out.println(e.prenom); 	// protected: oui
		System.out.println(e.age);    	// private: non
		System.out.println(e.email); 	// public: oui
		
	}

}
