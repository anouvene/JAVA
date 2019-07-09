package hb.java.operations;

import java.util.Scanner;

public class LaunchOperation {

	public static void main(String[] args) throws AMustBiggerThanB {
		// Instance
		Operation o = new Operation();
		
		// Menu	

		Scanner sc = new Scanner(System.in); // Scanner
		
		System.out.println("-------- CALCULATOR ----------");
		System.out.println("Addition : +");
		System.out.println("Soustraction : -");
		System.out.println("Multiplication : *");
		System.out.println("Division : /\n");
		
		System.out.println("Votre choix d'opération ?");				
		String op = sc.nextLine();
				
		System.out.println("Entrer le premier nombre :");
		double a = sc.nextDouble();
		System.out.println("Le deuxieme nombre :");
		double b = sc.nextDouble();

		o.calculate(op.charAt(0), a, b);
		
		// Résultat :	
		System.out.println(o);
				
		sc.close();
		
		
	}

}
