package m2i.formation.java.utilities;

import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generer les requetes SQL avec les les noms de colonnes tables recuperes de la BDD
 * @author Antoine Nouvene
 */
public class UtilitaireBis {
			
	/**
	 * Recuperer les colonnes d une table
	 * @param nomTable Nom de table a fournir
	 * @return List liste de noms de colonnes
	 */
	public static List<String> listeDesColonnes(String nomTable) {
		Connection _cnn = Connexion.getConnexion("jdbc:mysql://localhost:3306/dp_ecole?serverTimezone=UTC", "root", "");

		List<String> resultat = new ArrayList<>();
		
		try {
//			Statement stmt = _cnn.createStatement();
//			rs = stmt.executeQuery("SELECT * FROM Eleve");		
//			ResultSetMetaData  rsmd = rs.getMetaData();
						
			ResultSetMetaData  rsmd = _cnn.prepareStatement("SELECT * FROM " + nomTable).getMetaData();
			
//			int numberOfColumns = rsmd.getColumnCount();			
//			boolean b = rsmd.isSearchable(1);			
//			System.out.println("Nombre de colonnes : " + numberOfColumns );
//			System.out.println("isSearchable ? " + b );
			
			for(int i=1; i<=rsmd.getColumnCount(); i++) {
				resultat.add(rsmd.getColumnName(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultat;
		
	}
	
	/**
	 * Generer INSERT INTO Eleve(idEleve, nom, prenom) VALUES(?,?,?)
	 * @param NomComplet Nom de la classe
	 * @return String Requete a retourner
	 */
	public static String genererCreateSql(String nomTable) {
		List<String> colonnes = new ArrayList<>();		
		colonnes = listeDesColonnes(nomTable);
		
		String CreateSql = "INSERT INTO " + nomTable ;
		
//		String[] colonnesTxt = {};
//		colonnesTxt = colonnes.toArray(colonnesTxt); // List to Array
//		System.out.println(Arrays.toString(colonnesTxt).join(", ", colonnesTxt)); // id_eleve, nom, prenom
		
		String colonnesTxt = "";
		String valeursTxt = "";
		for(String c : colonnes) {
			colonnesTxt += c + ",";
			valeursTxt += "?,";
		}
		
		String colonnesToInsert = "(" + colonnesTxt.substring(0, colonnesTxt.length()-1)+ ") ";	
		String valeursToInsert  = "VALUES(" + valeursTxt.substring(0, valeursTxt.length()-1) + ")";

		CreateSql += colonnesToInsert + valeursToInsert ;
		
		return CreateSql;
	}

	/**
	 * Generer SELECT * FROM Eleve
	 * @param nomTable Nom de classe a fournir
	 * @return String Requete a retourner
	 */
	public static String genererRetreiveAllSql(String nomTable) {
		return "SELECT * FROM " + nomTable ;
	}
	
	/**
	 * Generer SELECT * FROM Eleve WHERE id_eleve=?
	 * @param nomTable Nom de classe a fournir
	 * @return String Requete a retourner
	 */
	public static String genererRetreiveSql(String nomTable) {
		List<String> colonnes = listeDesColonnes(nomTable);
		
		// Retreive
		String retreiveSql = "SELECT * FROM " + nomTable + " WHERE ";
						
		String cle = "" ; // id_de_la_class
		
		// Parcourir toutes les colonnes
		for(String c : colonnes) {
			// Obtenir la cle
			String debutNomColonne = c.toLowerCase().substring(0,2) ; // Extraire les 2 premiers caracteres
			if (debutNomColonne.substring(0,2).length() >= 2 && debutNomColonne.substring(0,2).equalsIgnoreCase("id")) { // Si debutNomColonne contient au moins 2 caracteres ET contenant la chaine "id"						
				String idChaine = c.substring(3,c.length()); // Extraire la sous-chaine relative à nomTable
				if(idChaine.equalsIgnoreCase(nomTable)) {
					cle = c; // Cle à obtenir
				}
			}		
		}		
		
		retreiveSql = retreiveSql + cle + "=?";
		
		// Retourner la requete		
		return retreiveSql;
		
	}
	
	/**
	 * Requete UPDATE Eleve SET nom=?,prenom=?  WHERE id_eleve=?
	 * @param nomTable Nom de la classe
	 * @return requete Requete UPDATE a retourner
	 */
	public static String genererUpdateSql(String nomTable) {
		List<String> colonnes = listeDesColonnes(nomTable);
		
		String[] str = {};
		// System.out.println("ICI" + Arrays.toString(colonnes.toArray(str)));
		
		// Update
		String updateSql = "UPDATE " + nomTable + " SET ";					
		
		String cle = "" ; // id_de_la_classe
		StringBuilder champsToUpdate = new StringBuilder(); // Champs a updater
		
		// Parcourir toutes les colonnes
		for(String c : colonnes) {
			// Obtenir la cle
			String debutNomColonne = c.toLowerCase().substring(0,2) ; // Extraire les 2 premiers caracteres			
			if (debutNomColonne.substring(0,2).length() >= 2 && debutNomColonne.substring(0,2).equalsIgnoreCase("id")) { // Si debutNomColonne contient au moins 2 caracteres ET contenant la chaine "id"						
				String idChaine = c.substring(3,c.length()); // Extraire la sous-chaine relative à nomTable
				if(idChaine.equalsIgnoreCase(nomTable)) {
					cle = c; // Cle à obtenir
				}
			} else {
				// Concatener tous les champs pour le UPDATE
				champsToUpdate.append(c + "=?,"); // avec ajout de "=?," sur chaque champs => Ex: "nom=?,"				
			}
		}
				
		// ==================================================================
		// UPDATE Eleve SET nom=?,prenom=?,notes=? WHERE idEleve=?
		// ==================================================================
		// champsToUpdate => "nom=?,prenom=?,"		
		// Extraire "nom=?,prenom=?" dans champsToUpdate
		updateSql = updateSql 
				+ champsToUpdate.toString().substring(0, champsToUpdate.toString().length()-1) 
				+ " WHERE " + cle + "=?";
		
		// System.out.println(updateSql);
				
		// Retourner la requete
		return updateSql;
	}

	/**
	 * Requete DELETE FROM Eleve WHERE id_eleve=?
	 * @param nomTable Nom de la classe
	 * @return Requete Requete DELETE a retourner
	 */
	public static String genererDeleteSql(String nomTable) {
		List<String> colonnes = listeDesColonnes(nomTable);
		
		// Delete
		String deleteSql = "DELETE FROM " + nomTable + " WHERE ";
				
		String cle = "" ; // id_de_la_classe
		
		// Parcourir toutes les colonnes
		for(String c : colonnes) {
			// Obtenir la cle
			String debutNomColonne = c.toLowerCase().substring(0,2) ; // Extraire les 2 premiers caracteres
			if (debutNomColonne.substring(0,2).length() >= 2 && debutNomColonne.substring(0,2).equalsIgnoreCase("id")) { // Si debutNomColonne contient au moins 2 caracteres ET contenant la chaine "id"						
				String idChaine = c.substring(3,c.length()); // Extraire la sous-chaine relative à nomTable
				if(idChaine.equalsIgnoreCase(nomTable)) {
					cle = c; // Cle à obtenir
				}
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

	
	/**
	 * Dictionnaire de requetes (nom_requete/chaine_de_requequete) 
	 * @param nomTable Nom de classe
	 * @return Map Dictionnaire (nom_requete/chaine_de_requequete)
	 */
	public static Map<String, String> ListeDesRequetesBis(String nomTable) {
		 
		// Map de requetes
		Map<String, String> requetes = new HashMap<>();
		
		// create
		String createSql = genererCreateSql(nomTable);
		
		// retreiveAll
		String retreiveAllSql = genererRetreiveAllSql(nomTable);
		
		// retreive
		String retreiveSql = genererRetreiveSql(nomTable);
				
		// update
		String updateSql = genererUpdateSql(nomTable);
		
		// delete
		String deleteSql = genererDeleteSql(nomTable);
		
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

}
