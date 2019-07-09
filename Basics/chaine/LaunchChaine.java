package hb.java.chaine;

import java.util.StringTokenizer;

import hb.utils.User;

public class LaunchChaine {

	public static void main(String[] args) {
		// Egalité de 2 string
		Chaine c1 = new Chaine();
		String s1 = "safinette";
		String s2 = "midinette";
		String s3 = "safinette";
		
		// s1 et s2
		if(c1.testStringEquality(s1, s2)){
			System.out.println(s1 + " et " + s2 + " sont identiques");			
		} else {
			System.out.println(s1 + " et " + s2 + " ne sont pas identiques");
		}
		
		// s1 et s3
		if(c1.testStringEquality(s1, s3)){
			System.out.println(s1 + " et " + s3 + " sont identiques");			
		} else {
			System.out.println(s1 + " et " + s3 + " ne sont pas identiques");
		}
		
		// Ignore case test
		String s4 = "SAFINETTE";
		if(!c1.testStringEquality(s1, s4)){
			System.out.println("Sans ingnore case " + s1 + " et " + s4 + " ne sont pas identiques");			
		}
		
		if(c1.testStringEqualityIgnore(s1, s4)){
			System.out.println("Avec ignore case " + s1 + " et " + s4 + " sont identiques");
		}
		
		// Comparer 2 strings
		int order = c1.getOrderOfStrings(s1, s2);
		
		if(order < 0) {
			System.out.println(s1 + " est avant " + s2 + " dans l'ordre alphabétique");
		} else if(order == 0){
			System.out.println(s1 + " et " + s2 + " sont identiques");
		} else if(order > 0) {
			System.out.println(s1 + " est aprés " + s2 + " dans l'ordre alphabétique");
		}
		
		// Inversion d'une chaine
		String reversedString = c1.reverseStringByLetter(s1);
		System.out.println(s1 + " renversé éa donne : " + reversedString + "\n");

		// Inversion des mots dans une phrase
		String s5 = "Safinette adore le chocolat noir cote d'or";
		String mixedString = c1.reverseStringByWord(s5);
		System.out.println(s5 + " renversé ça donne : \n" + mixedString + "\n");
		
		// UpperCase
		String upperString = c1.getUpperCaseString(s1);
		System.out.println(s1 + " en majuscule ça donne : " + upperString + "\n");
		
		// LowerCase
		String s6 = "CHOCOLAT";
		String lowerString = c1.getLowerCaseString(s6);
		System.out.println(s6 + " en minuscule ça donne : " + lowerString + "\n");
		
		// Trim
		String s7 = " Hello ";
		String stringWithoutSpaces = c1.getStringWithoutSpace(s7);
		System.out.println("Taille de hello avec espaces : " + s7.length() + "\n");
		System.out.println(s7 + " sans espaces : " + stringWithoutSpaces + "\n");
		System.out.println("Taille de " + s7 + " sans espaces : " + stringWithoutSpaces.length() +"\n");
		
		// Split
		String s8 = "pomme,poire,cerise,kiwi,kaki,mangue";
		String[] fruits = c1.parseStringWithSeparator(s8, ",");
		System.out.println("Taille du tableau : " + fruits.length + "\n");
		System.out.println(s8 + " après un split ça donne : \n");
		
		for(String fruit: fruits) {
			System.out.println(fruit);
		}
		
		// Display a string char by char
		System.out.println("\n");
		c1.printStringCharByChar(s1);
		
		// Check char existence into a string
		String s9 = "safinette@hotmail.com";
		if(s9.contains("@")){
			System.out.println("\n" + s9 + " est une adresse mail \n");
		}
				
		// Get a char position
		int index = s9.indexOf("@");
		
		// Substring
		String domain = s9.substring(index+1);
		System.out.println("le domain du mail " + s9 + " est : " + domain + "\n");
		
		// Empty
		String s10 = "";
		if(s10.isEmpty()){
			System.out.println("s10 est une chaine vide \n");
		}
		
		// Print string char by char
		c1.printReverseStringCharByChar("azerty");
		
		// Transform user in String[]
		User u1 = new User("Antoine", "Nouvene");

		System.out.println("\nContenu de User(firstname, lastName) mis dans le tableau :");
		
		for(int i=0; i<c1.transformUser(u1).length; i++){	
			System.out.println("[ " + i + " ] : " + c1.transformUser(u1)[i]);
		}
		
		// Count number of vowel
		System.out.println("\nNombre de voyelle(s): " + c1.countNumberOfVowel("AaaazeeertY") + "\n");
		
		// Count number of occurrence of vowel
		System.out.println("\nNombre d'occurence de chaque voyelle du mot oooDDDeauyYYY : ");
		c1.printNumberOfeachVowel("oooDDDeauyYYY");
		// c1.printNumberOfeachVowel("AaaazeeeErtY");		
		
		// Print cammelCase of string
		System.out.println("\nCamelCase : ");
		System.out.println(c1.transformStringToCamelCase("welcome to my world honey"));
		
		// StringTokenizer
		System.out.println("\nStringTokenizer");
		// StringTokenizer strTok = new StringTokenizer("Hello-World-Welcom-Everyone", "-", true);
		StringTokenizer strTok = new StringTokenizer("Hello-World-Welcom-Everyone", "-");
		StringBuffer strBuf = new StringBuffer();
		while(strTok.hasMoreElements()){
			String str = strTok.nextElement().toString();
			System.out.println("Token with nextElement method : " + str);
			strBuf.append(str);
		}
		System.out.println(strBuf);
		
		// StringTokenizer strTok2 = new StringTokenizer("Hello-World-Welcom-Everyone", "-");
		StringTokenizer strTok2 = new StringTokenizer("Hello-World-Welcom-Everyone");
		while(strTok2.hasMoreTokens()){
			String str2 = strTok2.nextToken("-").toString();
			System.out.println("Token with nextToken method : " + str2);
			// strBuf.append(str);
		}
		
		
		
		
		

	}

}
