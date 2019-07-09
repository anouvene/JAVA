package hb.java.structures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//import java.util.*;


public class StructData {

	/**
	 * Retourner la position d'un element dans un tableau
	 * @param tab int[]
	 * @param valueToFind int
	 * @return int position d'un element du tableau
	 */
	public int findValueInSortedTab(int[] tab, int valueToFind){
		int [] myInts = tab;
		Arrays.sort(myInts);// trier ordre croissant
		int index = Arrays.binarySearch(myInts, valueToFind); // position de valueToFind	
		return index;
	}
	
	/**
	 * Ecrire la méthode resizeTab qui permet de redimensionner un tableau. 
	 * La méthode retourne le tableau redimensionné.
	 *
	 * @param myTab Tableau type int
	 * @param addSize int
	 * @return int[] 
	 */
	public int[] resizeTab(int[] myTab, int addSize){
		int[] temp = new int[myTab.length + addSize];
		System.arraycopy(myTab, 0, temp, 0, 3); // Copier myTab dans temp
		
		myTab = temp;
		return myTab;	
	}
	
	/**
	 * Manipulation d'une liste avac for
	 * @param listToPrint void
	 */
	public void printListWithFor(List<String> listToPrint){
		System.out.println("\nAffichage d'une liste a l'aide d'une boucle for :");
		for(String item: listToPrint){
			System.out.println(item);
		}
	}
	
	/**
	 * Manipulation d'une liste avec while
	 * @param listToPrint List
	 */
	public void printListWithWhile(List<String> listToPrint){
		System.out.println("\nAffichage d'une liste a l'aide d'une boucle while :");
		Iterator<String> i = listToPrint.iterator(); // retourne une file de Strings
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	/**
	 * Indiquer si une clé est présente dans le dictionnaire
	 * @param map Map
	 * @param key String
	 * @return boolean
	 */
	public boolean isKeyInMap(Map<String, String> map, String key){
		return map.containsKey(key);
	}
	
	/**
	 * Indiquer si une valeur est présente dans le dictionnaire
	 * @param map Map
	 * @param value String
	 * @return boolean
	 */
	public boolean isValueInMap(Map<String, String> map, String value){
		return map.containsValue(value);
	}
	
	/**
	 * Display users List
	 * @param users List
	 */
	public void printListUser(List<User> users){
		for(User user: users){
			System.out.println("User[ user" 
								+ user.getIdUser() 
								+ ", "
								+ user.getLastName()
								+ ", "
								+ user.getFirstName()
								+ " ]");			
		}
		System.out.println("\n");
	}
	
	
}
