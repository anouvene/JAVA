package hb.java.exceptions.tableau_hashmap_exceptions;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class LaunchTabService {

	public static void main(String[] args)  throws NotValidNumberException {
		// Instance TabService
		TabService ts = new TabService();		
		
		// Saisie un nombre entier et stocker ce nom dans le tableau
		Scanner sc = new Scanner(System.in);
		String saisie;
		
		System.out.println("Veuiller entrer un nombre entre 0 à 9 :");
		saisie = sc.nextLine(); // Clé "saisie" par l'utilisateur : (String)
		
		if(ts.isValidNumber(saisie)){ // Vérifier si la saisie est un nombre
			int indice = ts.getStringTab(Integer.parseInt(saisie)); // Parser en int
			
			// Array
			System.out.println("Valeur correspondante à l'indice[" + indice + "] => " + ts.getTab()[indice]);
			
			// HasMap
			Map<Integer, String> map = ts.getMapTab(); // Récupérer le HashMap
			Set<Entry<Integer, String>> entriesTab = map.entrySet(); // Récupérer les entrées
			Iterator<Entry<Integer, String>> iterTab = entriesTab.iterator(); // Placer un iterator en tete des entrees
			
			// Parcours HashMap avec un Iterator "iterTab" et afficher la valeur correspondant à la clé "saisie" 
			while(iterTab.hasNext()) {
				Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)iterTab.next(); // Recupérer une entree Map				
				if(me.getKey() == ts.getTab()[indice].hashCode()){ // Comparer la clée d'entree avec l'indice saisie
					// Afficher la valeur correspondante à la clé saisie
					System.out.println("Valeur correspondante à la clé saisie Key[" + ts.getTab()[indice].hashCode() + "] : " + ts.getValueMap(ts.getTab()[indice].hashCode()));
				}
			}
			
		}
		
		sc.close();
		
		

	}

}
