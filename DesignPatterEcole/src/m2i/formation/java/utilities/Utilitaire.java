package m2i.formation.java.utilities;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Utilitaire {
	
	/**
	 * Recuperer la liste des champs
	 * @param NomComplet
	 * @return Field Liste des champs
	 * @throws ClassNotFoundException
	 */
	public static Field[] ListeDesChamps(String NomComplet) throws ClassNotFoundException {
		
		Class<?> maClasse = Class.forName(NomComplet); // Charger une classse � chaud en m�moire
		return maClasse.getDeclaredFields();
		
	}
	
	
	public static Map<String, String> ListeDesRequetes(String NomComplet) throws ClassNotFoundException {

		// Extraire nom Table
		String[] parties = NomComplet.split("\\.");
		String nomTable = parties[parties.length-1];		
		System.out.println(nomTable); // Eleve
		 
		// Map de requetes
		Map<String, String> requetes = new HashMap<>();
		
		// RetreiveAll
		String retreiveAllSql = "SELECT * FROM " + nomTable;
		
		// Retreive
		String retreiveSql = "SELECT * FROM " + nomTable + " WHERE ";
		
		// Update
		String updateSql = "UPDATE " + nomTable + " SET "; 
		
		// Attributs
		Field[] attributs = Utilitaire.ListeDesChamps(NomComplet);		
		
		String cle = "" ;
		String champs = "";
		StringBuilder sb = new StringBuilder();
		for(Field f : attributs) {			
			String valeur = f.getName().toLowerCase().substring(0,2) ;
			if (valeur.length() >= 2 && valeur.equals("id"))
			{
				cle = f.getName() ;
			}
			
			sb.append(f.getName() + "=?,");
			
			
		}
		
		// idEleve=?,nom=?,prenom=?,notes=?,
		System.out.println(sb.toString());
		
		// SELECT * FROM Eleve WHERE idEleve=? 
		retreiveSql = retreiveSql + cle + "=?";
		System.out.println(retreiveSql);
		
		// UPDATE Eleve SET nom=?, prenom=? WHERE idEleve = ?
		String[] attribs = sb.toString().split("=?,");
		
		champs = attribs[1] + ", " + attribs[2] + " "; // nom et prenom
		updateSql = updateSql + champs + "WHERE " + cle + "=?";	
		System.out.println(updateSql);
		
		
		// Ajouter les Requetes formees dans un Map
		requetes.put("retreiveAll", retreiveAllSql);
		requetes.put("retreive", retreiveSql);
		requetes.put("update", updateSql);
		
		
		
		return requetes;
		
	}

}