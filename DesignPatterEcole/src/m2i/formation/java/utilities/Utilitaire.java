package m2i.formation.java.utilities;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Utilitaire {
	
	/**
	 * Recuperer la liste des champs d'une classe
	 * @param NomComplet Chaine composant le nom d une classe
	 * @return Field Liste des attributs
	 * @throws ClassNotFoundException Exception de Class
	 */
	public static Field[] ListeDesChamps(String NomComplet) throws ClassNotFoundException {
		
		Class<?> maClasse = Class.forName(NomComplet); // Charger une classse a chaud en memoire
		Field[] fields = maClasse.getDeclaredFields(); // Attributs de la classe
		
		// Si heritage
		if(maClasse.getSuperclass() != null) 
		{
			// Recuperer les attributs de la super classe		
			Field[] superFields =  maClasse.getSuperclass().getDeclaredFields();
		
			// Fusionner fields et superFields
			Field[] fusion = new Field[fields.length + superFields.length];			
			System.arraycopy(fields, 0, fusion, 0, fields.length);
			fields = fusion;
		}
				
		return fields;
		
	}
	
	/**
	 * Dictionnaire  de requetes (nom_requete/chaine_de_requequete) 
	 * @param NomComplet Nom de classe
	 * @return Map Dictionnaire (nom_requete/chaine_de_requequete)
	 * @throws ClassNotFoundException Levee d Exception
	 */
	public static Map<String, String> ListeDesRequetes(String NomComplet) throws ClassNotFoundException {

		// Extraire nom Table
		String[] parties = NomComplet.split("\\.");
		String nomTable = parties[parties.length-1]; // exemple nom de la clase Eleve		
		// System.out.println(nomTable); 
		 
		// Map de requetes
		Map<String, String> requetes = new HashMap<>();
		
		// create
		String createSql = "INSERT INTO " + nomTable + "(";

		// retreiveAll
		String retreiveAllSql = "SELECT * FROM " + nomTable;
		
		// retreive
		String retreiveSql = "SELECT * FROM " + nomTable + " WHERE ";
		
		// update
		String updateSql = "UPDATE " + nomTable + " SET ";
		
		// delete
		String deleteSql = "DELETE FROM " + nomTable + " WHERE ";
		
		// Attributs de la classe
		Field[] attributs = Utilitaire.ListeDesChamps(NomComplet);		
		
		String cle = "" ; // id_de_la_classe
		StringBuilder champsToCreate = new StringBuilder(); // Champs a creer
		StringBuilder valeursToCreate = new StringBuilder(); // Valeurs a creer
		StringBuilder champsToUpdate = new StringBuilder(); // Champs a updater
		
		// Parcourir tous les attributs de la liste
		for(Field f : attributs) {
			// Obtenir la cle
			String debutNomAttribut = f.getName().toLowerCase().substring(0,2) ; // Extraire les 2 premiers caracteres
			if (debutNomAttribut.length() >= 2 && debutNomAttribut.equals("id")) { // Si debutNomAttribut contient au moins 2 caracteres ET contenant la chaine "id"		
				cle = f.getName() ; // Cle à obtenir
			} else {
				// Concatener tous les champs pour le UPDATE
				champsToUpdate.append(f.getName() + "=?,"); // avec ajout de "=?," sur chaque champs => Ex: "nom=?,"				
			}
			
			// Concatener tous les champs et valeurs pour le INSERT
			champsToCreate.append(f.getName() + ","); // avec ajout de "," sur chaque champs => Ex: "nom,"
			valeursToCreate.append("?,");
		}
		
		// idEleve,nom,prenom,notes,
		// System.out.println(champsToCreate.toString());
		// =?, =?, =?, =?,
		// System.out.println(valeursToCreate.toString());
		
		// idEleve=?,nom=?,prenom=?,notes=?,
		// System.out.println(champsToUpdate.toString());
		
		// ==================================================================
		// INSERT INTO Eleve(idEleve, nom, prenom, notes) VALUES(?, ?, ?, ?)
		// ==================================================================
		createSql = createSql + champsToCreate.substring(0, champsToCreate.length()-1) + ") VALUES(" + valeursToCreate.toString().substring(0, valeursToCreate.toString().length()-1) + ")";	
		// System.out.println(createSql);
		
		// ==================================================================
		// SELECT * FROM Eleve WHERE idEleve=?
		// ==================================================================
		retreiveSql = retreiveSql + cle + "=?";
		// System.out.println(retreiveSql);
				
		// ==================================================================
		// UPDATE Eleve SET nom=?,prenom=?,notes=? WHERE idEleve=?
		// ==================================================================
		// champsToUpdate => "nom=?,prenom=?,notes=?,"		
		// Extraire "nom=?,prenom=?,notes=?" dans champsToUpdate
		updateSql = updateSql 
				+ champsToUpdate.toString().substring(0, champsToUpdate.toString().length()-1) 
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
		requetes.put("create", createSql);
		requetes.put("retreiveAll", retreiveAllSql);
		requetes.put("retreive", retreiveSql);
		requetes.put("update", updateSql);
		requetes.put("delete", deleteSql);		
		
		// Retourner la Map des requetes
		return requetes;	
	}

	/**
	 * Dictionnaire  de requetes (nom_requete/chaine_de_requequete) 
	 * @param NomComplet Nom de classe
	 * @return Map Dictionnaire (nom_requete/chaine_de_requequete)
	 * @throws ClassNotFoundException Levee d Exception
	 */
	public static Map<String, String> ListeDesRequetesBis(String NomComplet) throws ClassNotFoundException {

		// Extraire nom Table
		String[] parties = NomComplet.split("\\.");
		String nomTable = parties[parties.length-1]; // exemple nom de la clase Eleve		
		// System.out.println(nomTable); 
		 
		// Map de requetes
		Map<String, String> requetes = new HashMap<>();
		
		// create
		String createSql = Utilitaire.genererCreateSql(NomComplet);
		
		// retreiveAll
		String retreiveAllSql = Utilitaire.genererRetreiveAllSql(NomComplet);
		
		// retreive
		String retreiveSql = Utilitaire.genererRetreiveSql(NomComplet);
				
		// update
		String updateSql = Utilitaire.genererUpdateSql(NomComplet);
		
		// delete
		String deleteSql = Utilitaire.genererDeleteSql(NomComplet);
		
		// ==================================================================
		// Ajouter les Requetes formees dans un Map
		// ==================================================================
		requetes.put("create", createSql);
		requetes.put("retreiveAll", retreiveAllSql);
		requetes.put("retreive", retreiveSql);
		requetes.put("update", updateSql);
		requetes.put("delete", deleteSql);		
		
		// Retourner la Map des requetes
		return requetes;	
	}

	/**
	 * Generer INSERT INTO Eleve(idEleve, nom, prenom, notes) VALUES(?,?,?,?)
	 * @param NomComplet Nom de la classe
	 * @return String Requete a retourner
	 * @throws ClassNotFoundException Levee d exception de Class
	 */
	public static String genererCreateSql(String NomComplet) throws ClassNotFoundException {
		// Extraire nom Table
		String[] parties = NomComplet.split("\\.");
		String nomTable = parties[parties.length-1]; // exemple nom de la clase Eleve		
		// System.out.println(nomTable); 
		
		// create
		String createSql = "INSERT INTO " + nomTable + "(";
		
		// Attributs de la classe
		Field[] attributs = Utilitaire.ListeDesChamps(NomComplet);		
		
		StringBuilder champsToCreate = new StringBuilder(); // Champs a creer
		StringBuilder valeursToCreate = new StringBuilder(); // Valeurs a creer
		
		// Parcourir tous les attributs de la liste
		for(Field f : attributs) {			
			// Concatener tous les champs et valeurs pour le INSERT
			champsToCreate.append(f.getName() + ","); // avec ajout de "," sur chaque champs => Ex: "nom,"
			valeursToCreate.append("?,");
		}
		
		// ==================================================================
		// INSERT INTO Eleve(idEleve, nom, prenom, notes) VALUES(?, ?, ?, ?)
		// ==================================================================
		createSql = createSql + champsToCreate.substring(0, champsToCreate.length()-1) + ") VALUES(" + valeursToCreate.toString().substring(0, valeursToCreate.toString().length()-1) + ")";	
		// System.out.println(createSql);	
		
		// Retourner la Map des requetes
		return createSql;
	}
	
	/**
	 * Generer SELECT * FROM Eleve
	 * @param NomComplet Nom de classe a fournir
	 * @return String Requete a retourner
	 */
	public static String genererRetreiveAllSql(String NomComplet) {
		String[] parties = NomComplet.split("\\.");
		String nomtable = parties[parties.length -1];	

		return "SELECT * FROM " + nomtable ;
	}
		
	/**
	 * Generer SELECT * FROM Eleve WHERE idEleve=?
	 * @param NomComplet Nom de classe a fournir
	 * @return String Requete a retourner
	 * @throws ClassNotFoundException 
	 */
	public static String genererRetreiveSql(String NomComplet) throws ClassNotFoundException {
		// Extraire nom Table
		String[] parties = NomComplet.split("\\.");
		String nomTable = parties[parties.length-1]; // exemple nom de la clase Eleve		
		// System.out.println(nomTable); 
		 				
		// Retreive
		String retreiveSql = "SELECT * FROM " + nomTable + " WHERE ";
				
		// Attributs de la classe
		Field[] attributs = Utilitaire.ListeDesChamps(NomComplet);		
		
		String cle = "" ; // id_de_la_class
		
		// Parcourir tous les attributs de la liste
		for(Field f : attributs) {
			// Obtenir la cle
			String debutNomAttribut = f.getName().toLowerCase().substring(0,2) ; // Extraire les 2 premiers caracteres
			if (debutNomAttribut.length() >= 2 && debutNomAttribut.equals("id")) // Si debutNomAttribut contient au moins 2 caracteres ET contenant la chaine "id"
			{
				cle = f.getName() ; // Cle à obtenir
			}			
		}		
		
		// ==================================================================
		// SELECT * FROM Eleve WHERE idEleve=?
		// ==================================================================
		retreiveSql = retreiveSql + cle + "=?";
		
		
		// Retourner la requete		
		return retreiveSql;
		
	}

	/**
	 * Requete UPDATE Eleve SET nom=?,prenom=?,notes=? WHERE idEleve=?
	 * @param NomComplet Nom de la classe
	 * @return requete Requete UPDATE a retourner
	 * @throws ClassNotFoundException Levee Exception
	 */
	public static String genererUpdateSql(String NomComplet) throws ClassNotFoundException {
		// Extraire nom Table
		String[] parties = NomComplet.split("\\.");
		String nomTable = parties[parties.length-1]; // exemple nom de la clase Eleve		
		// System.out.println(nomTable); 		 
		
		// Update
		String updateSql = "UPDATE " + nomTable + " SET ";
				
		// Attributs de la classe
		Field[] attributs = Utilitaire.ListeDesChamps(NomComplet);		
		
		String cle = "" ; // id_de_la_classe
		StringBuilder champsToUpdate = new StringBuilder(); // Champs a updater
		
		// Parcourir tous les attributs de la liste
		for(Field f : attributs) {
			// Obtenir la cle
			String debutNomAttribut = f.getName().toLowerCase().substring(0,2) ; // Extraire les 2 premiers caracteres
			if (debutNomAttribut.length() >= 2 && debutNomAttribut.equals("id")) { // Si debutNomAttribut contient au moins 2 caracteres ET contenant la chaine "id"		
				cle = f.getName() ; // Cle à obtenir
			} else {
				// Concatener tous les champs pour le UPDATE
				champsToUpdate.append(f.getName() + "=?,"); // avec ajout de "=?," sur chaque champs => Ex: "nom=?,"				
			}
		}
				
		// ==================================================================
		// UPDATE Eleve SET nom=?,prenom=?,notes=? WHERE idEleve=?
		// ==================================================================
		// champsToUpdate => "nom=?,prenom=?,notes=?,"		
		// Extraire "nom=?,prenom=?,notes=?" dans champsToUpdate
		updateSql = updateSql 
				+ champsToUpdate.toString().substring(0, champsToUpdate.toString().length()-1) 
				+ " WHERE " + cle + "=?";
		
		// System.out.println(updateSql);
				
		// Retourner la requete
		return updateSql;
	}

	/**
	 * Requete DELETE FROM Eleve WHERE idEleve=?
	 * @param NomComplet Nom de la classe
	 * @return Requete Requete DELETE a retourner
	 * @throws ClassNotFoundException 
	 */
	public static String genererDeleteSql(String NomComplet) throws ClassNotFoundException {
		// Extraire nom Table
		String[] parties = NomComplet.split("\\.");
		String nomTable = parties[parties.length-1]; // exemple nom de la clase Eleve		
		// System.out.println(nomTable); 
		 		
		// Delete
		String deleteSql = "DELETE FROM " + nomTable + " WHERE ";
		
		// Attributs de la classe
		Field[] attributs = Utilitaire.ListeDesChamps(NomComplet);		
		
		String cle = "" ; // id_de_la_classe
		
		// Parcourir tous les attributs de la liste
		for(Field f : attributs) {
			// Obtenir la cle
			String debutNomAttribut = f.getName().toLowerCase().substring(0,2) ; // Extraire les 2 premiers caracteres
			if (debutNomAttribut.length() >= 2 && debutNomAttribut.equals("id")) { // Si debutNomAttribut contient au moins 2 caracteres ET contenant la chaine "id"		
				cle = f.getName() ; // Cle à obtenir
			}
		}
		
		// ==================================================================
		// DELETE FROM Eleve WHERE idEleve=?
		// ==================================================================
		deleteSql = deleteSql + cle + "=?";
		// System.out.println(deleteSql);	
		
		// Retourner la requete
		return deleteSql;
	}

}