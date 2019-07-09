package hb.java.numbers;
import static java.lang.Math.*;

import java.util.Random;

public class LaunchTheNumber {

	public static void main(String[] args) {
		// Check if string contains a number
		TheNumber nb = new TheNumber();
		
		if(nb.isValidNumber("99")){
			System.out.println(99 + " is a valid number");
		}
		
		if(!nb.isValidNumber("99 Toto")){
			System.out.println("'99 Toto'" + " is not a valid number");
		}
		
		// Round a float number
		float f1 = 12.89f;
		System.out.print(nb.arround(f1));
		
		// Comparaison de 2 floats
		System.out.print("\nComparer deux floats avec une tolérance :\n");
		float f2 = 1.0f;
		float f3 = 1.01f;
		float f4 = 1.25f;
		float tolerance = 0.01f;
		
		if(nb.compareFloatsWithTolerence(f2, f3, tolerance)){
			System.out.println(f2 + " et " + f3 + " sont egaux avec un tolerance de " + tolerance);
		}
		
		if(!nb.compareFloatsWithTolerence(f2, f4, tolerance)){
			System.out.println(f2 + " et " + f4 + " ne sont pas egaux avec un tolerance de " + tolerance);
		}
		
		// Math : cos, sin, tan, log10, log, random
		int number = 45;
		
		System.out.println("Cosinus de " + number + " est :" + cos(number));
		System.out.println("Sinus de " + number + " est :" + sin(number));
		System.out.println("Tangente de " + number + " est :" + tan(number));
		System.out.println("Log de " + number + " est :" + log(number));
		System.out.println("Random de Math est : " + random());		
	
		// Get a percent of a double
		double doubleNumber = .79;
		System.out.println("Pourcentage de " + doubleNumber + " est : " + nb.getPercentOfDouble(doubleNumber));

		// Conversion Entier en Binaire, Hexadécimal et Octal
		int intToConvert = 2;
		nb.printIntToBinaryHexaOctal(intToConvert);
		
		// Random
		Random rand = new Random();
		// Int random
		System.out.println("\nNombre aleatoire de 0 à 100 : " + nb.getRandomInt(rand, 100));
		System.out.println("Nombre aleatoire de 0 à 100 : " + nb.getRandomInt(rand, 100));
		System.out.println("Nombre aleatoire de 0 à 100 : " + nb.getRandomInt(rand, 100));
	
		// Double random
		System.out.println("Nombre aleatoire (double) : " + nb.getRandomDouble(rand));
		
		// Float random
		System.out.println("Nombre aleatoire (float) : " + nb.getRandomFloat(rand));
		
		// Integer to String
		int intToConvert2 = 55;
		System.out.println("\n" + intToConvert2 + " converti en string donne " + nb.convertIntegerToString(intToConvert2));

		// Double to String
		double doubleToConvert = 55.985;
		System.out.println(doubleToConvert + " converti en string donne " + nb.convertDoubleToString(doubleToConvert));
		
		// String number to int
		String strNb = "99";
		System.out.println("String " + strNb + " converti en int donne " + nb.convertStringToInteger(strNb));
		
		// String number to double
		String strNb2 = "99.875";
		System.out.println("String " + strNb2 + " converti en double donne " + nb.convertStringToDouble(strNb2));
		
		// String to int
		String strToNb = "toto";
		System.out.println("String " + strToNb + " converti en int donne " + nb.convertStringToInteger(strToNb));
		 
		// String to double
		String strToNb2 = "titi";
		System.out.println("String " + strToNb2 + " converti en double donne " + nb.convertStringToDouble(strToNb2));
		
		
	}
}
