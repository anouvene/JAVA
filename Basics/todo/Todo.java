package hb.java.todo;

import java.util.Collections;
import java.util.Vector;

import java.lang.reflect.*;

public class Todo {
	
	/**
	 * Compter toutes les occurrences des caracteres dans une chaine
	 * @param s String conteannat les occurrences
	 */
	public void printNbOccurenceOfCharInString(String s) {		
		String str = ""; // Nouvelle chaine à comparer
		StringBuilder sb = new StringBuilder(); // Pour manipuler une chaine
		
		// Boucle pour créer une nouvelle chaine de caracteres sans doublon
		for(int i=0; i<s.length(); i++) {
			if(!str.contains(String.valueOf(s.charAt(i)))) {
				char c = Character.valueOf(s.charAt(i));
				str = sb.append(c).toString();
			}
		}
		
		// Tableau pour stocker le nombre d'occurence de la nouvelle chaine "str" par rapport à "s"
		int[] tab = new int[str.length()]; // stockage nb d'occurrence
				
		for(int i=0; i<str.length(); i++) { // Parcours chaine "str"
			int cpt = 0;
			for(int j=0; j<s.length(); j++) { // Parcours chaine "s"
				if( str.charAt(i) == s.charAt(j) ) { // Comparer chaque caractere de "str" avec "s"
					tab[i] = cpt++; // Comptage nombre d'occurence
				}
			}
			
			System.out.println("Caractere : " + str.charAt(i) + ", nombre d'occurence = " + tab[i]);
		}

	}
	
	/**
	 * Nombre occurrences d'un caractere dans une chaine
	 * @param s Chaine contenant les occurrences
	 * @param c occurrence à trouver
	 * @return int nombre d'occurrences
	 */
	public int getNbOccurenceOfCharInString(String s, char c) {
		int cpt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == c) {
				cpt++;
			}
		}		
		return cpt;
	}
	
	/**
	 * Trouver le nombre max dans un vecteur
	 * @return int
	 */
	int getMaxInCollection(Vector<Integer> vecteur) {
		Collections.sort(vecteur);		
		return vecteur.elementAt(vecteur.size() - 1);
	}
	
	/**
	 * Retourner toutes les méthodes de class
	 * @return String Array
	 */
	@SuppressWarnings("null")
	public String[] getMethodsOfClass() {
		String[] methodes = null;
		try {
            Class<?> c = Class.forName("java.lang.String");
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
            	methodes[i] = m[i].toString();
            	System.out.println(m[i].toString());
            }      
         }
         catch (Throwable e) {
            System.err.println(e);
         }
		return methodes;
	}
	
	/**
	 * Retourner toutes les propriétés de class
	 * @return String Array
	 */
	public String[] getPropertiesOfClass() {
		return null;
	}
}
