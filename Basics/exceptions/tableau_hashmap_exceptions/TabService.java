package hb.java.exceptions.tableau_hashmap_exceptions;

import java.util.HashMap;
import java.util.Map;

public class TabService {
	
	private String[] tab;
	private Map<Integer, String> mapTab;
	
	
	public TabService(){
		// Initialiser Array
		tab = new String[]{"Zero", "Un", "Deux", "trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf"};
		
		// Initialiser un HashMap
		this.mapTab = new HashMap<Integer, String>();
		
		// Remplir HashMap avec les élements du tableau "tab" et crypter les clés avec hashCode()
		for(int i=0; i<tab.length; i++){
			this.mapTab.put(tab[i].hashCode(), tab[i]);
		}
	}

	// Getter and Setter
	public String[] getTab() {
		return tab;
	}

	public void setTab(String[] tab) {
		this.tab = tab;
	}
	
	// Get & Set Map
	public Map<Integer, String> getMapTab() {
		return mapTab;
	}

	public void setMapTab(Map<Integer, String> mapTab) {
		this.mapTab = mapTab;
	}
	

	/**
	 * Vérifier si la saisie est un nombre
	 * Lever une exception avec NumberFormatException
	 * @param s String number
	 * @return boolean
	 */
	public boolean isValidNumber(String s){
		try{
			Integer.parseInt(s);
			return true;
		} catch(NumberFormatException nfe){
			nfe.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Retourner le bon indice du tableau de string
	 * @param indice
	 * @return int
	 * @throws NotValidNumberException
	 */
	public int getStringTab(int indice) throws NotValidNumberException {
		if(indice < 0 || indice > this.tab.length - 1){ // Exception si indice hors plage[0 ... 9]
			throw new NotValidNumberException("Aucune valeur ne correspond à la clé saisie!");
		} else {
			return indice;
		}		
	}
	
	/**
	 * Get corresponding value with hashCode
	 * @param hashCode int
	 * @return String associated value with hash code
	 */
	public String getValueMap(int hashCode){
		return mapTab.get(hashCode);
	}

}
