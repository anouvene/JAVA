package m2i.formation.java;

import java.util.Scanner;

public class Principale {
	private static String saisie = "";
	private static int nombreGrille = 0;
	
	public static void main(String[] args) {
	
		// Une grille
		Grille grille = new Grille();	
		System.out.println(grille);
		
		// 5 grilles
		Scanner sc = new Scanner(System.in);
		CollectionGrille cg = new CollectionGrille();
		
		// Saisir un nombre		
		System.out.println("Nombre de grille ?: ");
		saisie = sc.nextLine();
		while(!saisie.equalsIgnoreCase("y")) {										
			try {					
				nombreGrille = Integer.parseInt(saisie);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Pas bon, veuiller saisir un nombre:");
				saisie = sc.next();	
			}			
		}
		
		// Generer les grilles
		cg.genererGrilles(nombreGrille);
		
		// Affichage
		System.out.println(cg);
		
		// Close scanner
		sc.close();

	}

}
