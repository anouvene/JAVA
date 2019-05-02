package m2i.formation.java;

import java.util.ArrayList;

public class Principale {

	public static void main(String[] args) {
		Personne p1;
		p1 = new Stagiaire("Nguyen", "Tuan", "DUT Informatique");	
		System.out.println(p1);
		
//		IMouvement camion1 = new Camion("Peugeot", "P012L");
//		System.out.println(camion1);
//		camion1.accelerer();
//		camion1.freiner();
		
//		IMouvement cycliste1 = new Cycliste("Renault", "012L", "RRRRR");
//		System.out.println(cycliste1);
//		cycliste1.accelerer();
//		cycliste1.freiner();
		
//		IMouvement i1;
//		i1 = new Camion("Peugeot", "P012L");
//		i1.accelerer();
		
//		i1 = new Cycliste("Peugeot", "P012L", "DDDD");
//		i1.accelerer();
		
		// Appels methode "traitement"
		// Les classes Camion et Cycliste sont des methodes concretes de type interface IMouvement
		traitement(new Camion("Peugeot", "P012L"));
		traitement(new Cycliste("Peugeot", "P012L", "DDDD"));
		
		// Stoker des objets differents mais issus d un meme interface IMouvement
		ArrayList<IMouvement> vehicules = new ArrayList<>();
		vehicules.add(new Camion("Renault", "RE012L"));
		vehicules.add(new Cycliste("Virenque", "Richard", "Festina"));
		
		for(IMouvement v : vehicules) {
			System.out.println(v);
		}
	}

	/**
	 * Methode static utilisant IMouvement Interface
	 * @param i1
	 */
	public static void traitement(IMouvement iMouv) {
		// iMouv = Interface d'objets Camion et Cycliste
		iMouv.freiner();
	}
}
