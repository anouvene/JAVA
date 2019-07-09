package hb.java.struct_switch;

import java.util.Scanner;

public class LaunchSwitch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Saisir un chiffre entre 1 et 10");
		
		// Switch sur un entier
		int nb = Integer.parseInt(sc.nextLine()); // sc.nextInt()	
		switch(nb){
			case 7 :
				System.out.print("Sept");
				break;
			case 0 :
				System.out.print("Zéro");
				break;
			case 10 :
				System.out.print("Dix");
				break;
			case 5 :
				System.out.print("Cinq");
				break;
			default :
				System.out.print("Bye!");
				break;		
		}
		
		// Switch sur un String
		System.out.print("Saisir une couleur");
		
		// Switch sur un entier
		String color = sc.nextLine();
		switch(color){
			case "Noir" :
				System.out.print("Le Rouge et Le Noir de Stendhal");
				break;
			case "Pourpre" :
				System.out.print("La couleur des sentiments");
				break;
			default :
				System.out.print("Bye!");
				break;		
		}
		
		sc.close();
	}
	
	

}
