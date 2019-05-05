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
	 * @param NomComplet Chaine composant le nom d une classe
	 * @return Field Liste des champs
	 * @throws ClassNotFoundException Exception de Class
	 */
	public static Field[] ListeDesChamps(String NomComplet) throws ClassNotFoundException {
		
		Class<?> maClasse = Class.forName(NomComplet); // Charger une classse a chaud en memoire
		return maClasse.getDeclaredFields();
		
	}
	
	
	public static Map<String, String> ListeDesRequetes(String NomComplet) throws ClassNotFoundException {

		// Extraire nom Table
		String[] parties = NomComplet.split("\\.");
		String nomTable = parties[parties.length-1]; // exemple nom de la clase Eleve		
		// System.out.println(nomTable); 
		 
		// Map de requetes
		Map<String, String> requetes = new HashMap<>();
		
		// RetreiveAll
		String retreiveAllSql = "SELECT * FROM " + nomTable;
		
		// Retreive
		String retreiveSql = "SELECT * FROM " + nomTable + " WHERE ";
		
		// Insert
		String createSql = "INSERT INTO " + nomTable + "(";
		
		// Update
		String updateSql = "UPDATE " + nomTable + " SET ";
		
		// Delete
		String deleteSql = "DELETE FROM " + nomTable + " WHERE ";
		
		// Attributs de la classe
		Field[] attributs = Utilitaire.ListeDesChamps(NomComplet);		
		
		String cle = "" ; // Primary key
		String champs = ""; // Noms des champs de table
		StringBuilder champsToCreate = new StringBuilder(); // Champs a creer
		StringBuilder valeursToCreate = new StringBuilder(); // Valeurs a creer
		StringBuilder champsToUpdate = new StringBuilder(); // Champs a updater
		
		// Parcourir tous les attributs de la liste
		for(Field f : attributs) {
			// Obtenir la cle
			String debutNomAttribut = f.getName().toLowerCase().substring(0,2) ; // Extraire les 2 premiers caracteres
			if (debutNomAttribut.length() >= 2 && debutNomAttribut.equals("id")) // Si debutNomAttribut contient au moins 2 caracteres ET contenant la chaine "id"
			{
				cle = f.getName() ; // Cle à obtenir
			}
			
			// Concatener tous les champs et valeurs pour le INSERT
			champsToCreate.append(f.getName() + ","); // avec ajout de "," sur chaque champs => Ex: "nom,"
			valeursToCreate.append("?,");
			
			// Concatener tous les champs pour le UPDATE
			champsToUpdate.append(f.getName() + "=?,"); // avec ajout de "=?," sur chaque champs => Ex: "nom=?,"
			
		}
		
		// idEleve,nom,prenom,notes,
		// System.out.println(champsToCreate.toString());
		// =?, =?, =?, =?,
		// System.out.println(valeursToCreate.toString());
		
		// idEleve=?,nom=?,prenom=?,notes=?,
		// System.out.println(champsToUpdate.toString());
		
		// ==================================================================
		// SELECT * FROM Eleve WHERE idEleve=?
		// ==================================================================
		retreiveSql = retreiveSql + cle + "=?";
		// System.out.println(retreiveSql);
		
		// ==================================================================
		// INSERT INTO Eleve(idEleve, nom, prenom, notes) VALUES(?, ?, ?, ?)
		// ==================================================================
		createSql = createSql + champsToCreate.substring(0, champsToCreate.length()-1) + ") VALUES(" + valeursToCreate.toString().substring(0, valeursToCreate.toString().length()-1) + ")";	
		// System.out.println(createSql);
		
		// ==================================================================
		// UPDATE Eleve SET nom=?,prenom=?,notes=? WHERE idEleve=?
		// ==================================================================
		// champsToUpdate = "idEleve=?,nom=?,prenom=?,notes=?,"
		// Position de la premiere occurence "," dans la chaine champsToUpdate avance de 1
		// System.out.println(champsToUpdate.toString().indexOf(",") + 1); // 10		
		
		// Extraire "nom=?,prenom=?,notes=?" dans champsToUpdate
		updateSql = updateSql 
				+ champsToUpdate.toString().substring(champsToUpdate.toString().indexOf(",") + 1, champsToUpdate.toString().length()-1) 
				+ " WHERE " + cle + "=?";
		
		// System.out.println(updateSql);
		
		// ==================================================================
		// DELETE FROM Eleve WHERE idEleve=?
		// ==================================================================
		deleteSql = deleteSql + cle + "=?";
		// System.out.println(deleteSql);
		
		
		
		// ==================================================================
		// Ajouter les Requetes formees dans un Map
		// ==================================================================	
		requetes.put("retreiveAll", retreiveAllSql);
		requetes.put("retreive", retreiveSql);
		requetes.put("update", updateSql);
		requetes.put("delete", deleteSql);
		
		
		// Retourner la Map des requetes
		return requetes;
		
	}

}