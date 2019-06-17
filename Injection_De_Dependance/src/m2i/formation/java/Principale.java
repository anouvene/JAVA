package m2i.formation.java;

import m2i.formation.business.Personne;

public class Principale {

	public static void main(String[] args) {
		//Personne p1 = new Personne("NGUYEN", new JSONPersister());		
		//p1.save();
		
		Personne p2 = new Personne("NGUYEN", new XMLPersister());
		p2.save();
		

	}

}
