package hb.java.env;

import java.util.*;

/**
 * Classe permettant d'intéragir avec l'environnement Java
 * @author Antoine
 *
 */
public class Environnement {
	/**
	 * Méthode pour récupérer la valeur de la varable d'environnement PATH
	 * @return String contenu de la variable
	 */
	public String getPath() {
		return System.getenv("PATH");
	}
	
	/**
	 * Méthode pour afficher les properties
	 */
	public void printProperties() {
		Properties props = System.getProperties();
		Enumeration<?> propertyNames = props.propertyNames();
		String key = "";
		
		while(propertyNames.hasMoreElements()){
			key = (String) propertyNames.nextElement();
			System.out.println(key + "= " + props.getProperty(key));
		}
		
	}
	
	/**
	 * Méthode pour ajouter une propriété
	 * @param property property
	 * @param value value
	 */
	public void setProperty(String property, String value) {
		System.setProperty(property, value);
	}
	
	/**
	 * Méthode pour récupérer une valeur de propriété
	 * @param property property
	 * @return String
	 */
	public String getProperty(String property) {
		return System.getProperty(property);
	}
	
	
}
