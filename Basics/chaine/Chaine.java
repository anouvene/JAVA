package hb.java.chaine;

import java.util.Stack;
import java.util.StringTokenizer;

// import java.util.*;

import hb.utils.User;

public class Chaine {
	
	public Chaine(){};
	
	/**
	 * To compare 2 strings
	 * @param s1 String
	 * @param s2 String
	 * @return Boolean
	 */
	public boolean testStringEquality(String s1, String s2){
//		if(s1.equals(s2)){
//			return true;
//		} else {
//			return false;
//		}
		
		return s1.equals(s2);

	}
	/**
	 * To compare 2 string with ignore case
	 * @param s1 String
	 * @param s2 String
	 * @return Boolean
	 */
	public boolean testStringEqualityIgnore(String s1, String s2){
		if(s1.equalsIgnoreCase(s2)){
			return true;
		} else {
			return false;
		}
		// return s1.equalsIgnoreCase(s2);
	}	
	
	/**
	 * Comparaison de 2 strings
	 * La méthode renvoie un entier
	 * Si résultat inférieur a  0 : s1 est avant s2
	 * Si résultat égale a   0 : s1 = s2
	 * Si résultat supérieur a  0 : s1 est apres s2
	 * @param s1 String
	 * @param s2 String
	 * @return String
	 */
	public int getOrderOfStrings(String s1, String s2) {
		return s1.compareTo(s2);
	}
	
	/**
	 * Inversion d'un String
	 * @param chaine String
	 * @return String
	 */
	public String reverseStringByLetter(String chaine){
		StringBuilder sb = new StringBuilder(chaine);
		String reverseString = sb.reverse().toString();
		return reverseString;
	}
	
	/**
	 * Méthode permettant d'afficher une chaine caractere par caractere dans l'ordre inverse
	 * @param stringToprocess String
	 */
	public void printReverseStringCharByChar(String stringToprocess){
		StringBuilder sb = new StringBuilder(stringToprocess);
		String reverseString = sb.reverse().toString();
		for(int i=0; i<reverseString.length(); i++){
			System.out.println(reverseString.charAt(i));
		}
	}	
	
	/**
	 * Inversion des mots dans une phrase
	 * @param chaine String
	 * @return String
	 */
	public String reverseStringByWord(String chaine){
		Stack<Object> stack = new Stack<Object>(); // Pile LIFO
		StringTokenizer strTok = new StringTokenizer(chaine); // the string tokenizer class allows an application to break a string into tokens (Type Enum)
		
		// Remplissage pile stack
		while(strTok.hasMoreTokens()){
			stack.push(strTok.nextToken()); // nextElement()
		}
		
		StringBuilder reverseString = new StringBuilder();
		// Dépiler la pile stack
		while(!stack.isEmpty()){
			reverseString.append(stack.pop());
			reverseString.append(" ");
		}
		
		return reverseString.toString();
	}
	
	/**
	 * UpperCase
	 * @param s String
	 * @return String
	 */
	public String getUpperCaseString(String s) {
		return s.toUpperCase();
	}
	
	/**
	 * Lowercase
	 * @param s String
	 * @return String
	 */
	public String getLowerCaseString(String s) {
		return s.toLowerCase();
	}
	
	/** 
	 * Trim
	 * @param s String
	 * @return String
	 */
	public String getStringWithoutSpace(String s) {
		return s.trim();
	}
	
	
	/**
	 * Split a String into an Array
	 * Parse string
	 * @param s String
	 * @param separator String
	 * @return String[]
	 */
	public String[] parseStringWithSeparator(String s, String separator) {
		return s.split(separator);
	}
	
	/**
	 * Print a string char by char
	 * @param s String
	 */
	public void printStringCharByChar(String s){
		for(int i=0; i<s.length(); i++){
			System.out.println(s.charAt(i));
		}
	}
	
	/**
	 * Transformer un user en tableau de strings
	 * @param user User instance
	 * @return String[]
	 */
	public String[] transformUser(User user){
		String fn = user.getFirstName();
		String ln = user.getLastName();
		// Stokage fn et ln dans u
		String[] tabUser = {fn, ln};

		return tabUser;
	}
	
	/**
	 * Compter le nombre de voyelles dans une chaine
	 * @param s String
	 * @return int
	 */
	public int countNumberOfVowel(String s){
		int cpt = 0;
		String strLowerCase = s.toLowerCase();
		
		for(int i=0; i<strLowerCase.length(); i++){
			if (this.isVowel(strLowerCase.charAt(i))){
				cpt += 1;
			}
		}
		
		return cpt;
	}
	
	/**
	 * Afficher les occurences de chaque voyelle dans une chaine
	 * @param s String
	 */
	public void printNumberOfeachVowel(String s){

		String strLowerCase = s.toLowerCase();		
		char data[] = new char[1]; // Caractere temporaire
		String str = ""; // Pour former un nouveau string
		StringBuilder sb = new StringBuilder();
		
		// Former un nouveau string en eliminant les doublons
		for(int i=0; i<strLowerCase.length(); i++){
			// Si str ne contient pas déjà le caractere en cours dans la boucle
			// Alors on ajoute ce caractere dans str
			if( !str.contains(String.valueOf(strLowerCase.charAt(i))) ){
				char c = Character.valueOf(strLowerCase.charAt(i));
                data[0] = c;
                
                str = sb.append(String.valueOf(data)).toString();
			}
		}
		
		// Comparer la nouvelle chaine "str" ainsi formée avec l'originale "strLowerCase"
        int tab[] = new int[str.length()]; // Reserver un tableau de stockage du nombre d'occurrence pour chaque caractere
        
        for(int i=0; i<str.length(); i++){ // Parcourir le nouveau string formé
        	int cpt = 0;
        	// Pour chaque caract de "str", comparer avec celui de "strLowerCase"
        	// Puis ne compter que le nb d'occurrences de chaque voyelle de "str" rencontrée dans "strLowerCase"
            for(int index=0; index<strLowerCase.length(); index++){ 
                if (str.charAt(i)==strLowerCase.charAt(index) && this.isVowel(strLowerCase.charAt(index))){
                    cpt++;
                }
            }
            
            tab[i] = cpt; // Enregistrer le nb d'occurrence correspondant de chaque voyelle de "str" dans un tableau
            if(this.isVowel(str.charAt(i))){ // N'afficher que les voyelles et leurs occurrences
            	System.out.println("Caractere : " + str.charAt(i) + ", nombre d'occurence de :" + tab[i]);
            }
        }
	}
	
	/**
	 * Vérifier si c'est une voyelle
	 * @param c char
	 * @return boolean
	 */
	public boolean isVowel(char c){
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
	}
	
	/**
	 * Transformer dans une chaine, chaque lettre en début de mot en majuscule
	 * @param s String to transform in camelcase
	 * @return String
	 */
	public String transformStringToCamelCase(String s){
		StringTokenizer strTok = new  StringTokenizer(s); // Break "s" string to tokens
		StringBuilder sb = new StringBuilder(); // String(Builder) in camel case
		StringBuilder sbTemp; // StringBuilder for treatment in while loop
		
		while(strTok.hasMoreTokens()){ // Manage each token		  
		  sbTemp = new StringBuilder(strTok.nextToken().toString()); // Store a (String) token into "sbTemp"
		  char c = sbTemp.toString().charAt(0); // Extract first char from "sbTemp"
		  sbTemp.setCharAt(0, Character.toUpperCase(c)); // Set "sbTemp" first char to Uppercase(c)
		  
		  sb.append(sbTemp); // Concat each "sbTemp"	  
		}
				
		return sb.toString(); // CamelCase String 
	}
}
