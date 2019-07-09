package hb.java.env;

import java.util.*;

/**
 * Classe permettant d'int�ragir avec l'environnement Java
 * @author Antoine
 *
 */
public class Environnement {
	/**
	 * M�thode pour r�cup�rer la valeur de la varable d'environnement PATH
	 * @return String contenu de la variable
	 */
	public String getPath() {
		return System.getenv("PATH");
	}
	
	/**
	 * M�thode pour afficher les properties
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
	 * M�thode pour ajouter une propri�t�
	 * @param property property
	 * @param value value
	 */
	public void setProperty(String property, String value) {
		System.setProperty(property, value);
	}
	
	/**
	 * M�thode pour r�cup�rer une valeur de propri�t�
	 * @param property property
	 * @return String
	 */
	public String getProperty(String property) {
		return System.getProperty(property);
	}
	
	
}
