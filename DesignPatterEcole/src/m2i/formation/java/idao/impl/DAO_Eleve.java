package m2i.formation.java.idao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import m2i.formation.java.business.Eleve;
import m2i.formation.java.business.Matiere;
import m2i.formation.java.business.Note;
import m2i.formation.java.idao.IDAO_Eleve;
import m2i.formation.java.idao.IDAO_Note;
import m2i.formation.java.utilities.Connexion;
import m2i.formation.java.utilities.Utilitaire;

public class DAO_Eleve implements IDAO_Eleve<Eleve> {
	final static String url = "jdbc:mysql://151.80.59.182:3306/dp_ecole?serverTimezone=UTC";
	final static String user = "m2ig1";
	final static String password = "m2iFormation";	
	private static Connection _cnn = Connexion.getConnexion(url, user, password);
	
	private PreparedStatement ps = null;
	private int rep = -1;
	
	// ResultSet
	private ResultSet rs = null;
	
	// Requetes
	private Map<String, String> requetes = new HashMap<>();
	
	/**
	 * Ajouter un Eleve + ses notes
	 */
	@Override
	public int create(Eleve eleve) {
		IDAO_Note daoN = new DAO_Note(); // Note DAO
		
		// String queryInsert = "INSERT INTO eleve VALUES(?, ?, ?)";
		String queryInsert = "";
		try {
			requetes = Utilitaire.ListeDesRequetes("m2i.formation.java.business.Eleve");
			queryInsert = requetes.get("queryInsert");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try {
			// Prepare query
			ps = _cnn.prepareStatement(queryInsert);
			ps.setInt(1, eleve.getIdEleve());
			ps.setString(2, eleve.getNom());
			ps.setString(3, eleve.getPrenom());
			
			// Execute query
			rep = ps.executeUpdate();
						
			// + Notes
			for(Note note: eleve.getNotes()) {
				daoN.create(note);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rep;
	}

	/**
	 * Rechercher un Eleve dans la base a partir de son id
	 */
	@Override
	public Eleve retreive(int id) {
		String querySelect = "SELECT * FROM eleve WHERE id_eleve=?";
		Eleve eleve = null;
		

		String nom = "";
		String prenom = "";
		
		try {
			ps = _cnn.prepareStatement(querySelect);
			ps.setInt(1, id);
			
			rs = this.ps.executeQuery();
			
			if(rs.next()) {
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				
				eleve = new Eleve(id, nom, prenom);
				
				// Notes
				List<Note> notes = new ArrayList<>();
				notes = retreiveToutesLesNotesDunEleve(id);
				
				if(!notes.isEmpty()) {
					eleve.setNotes(notes);
				}
				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return eleve;
	}

	/**
	 * Lister tous les Eleves de la bases
	 */
	@Override
	public List<Eleve> retreiveAll() {
		String querySelectAll = "SELECT * FROM eleve";
		// Eleves
		List<Eleve> eleves = new ArrayList<>();
		// Notes
		List<Note> notes = new ArrayList<>();
	
		try {
			ps = _cnn.prepareStatement(querySelectAll);						
			rs = this.ps.executeQuery();
			
			while(rs.next()) {
				Eleve eleve = new Eleve(
						rs.getInt("id_eleve"), 
						rs.getString("nom"), 
						rs.getString("prenom"));
				
				// Notes
				eleve.ajouterNote(new DAO_Note().retreive(eleve.getIdEleve()));
				
				// Ajouter chaque Eleve dans lstEleve
				eleves.add(eleve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return eleves;
	}

	/**
	 * Mettre a jour un Eleve a partir de son id
	 */
	@Override
	public int update(Eleve eleve) {
		String queryUpdate = "UPDATE eleve SET nom=?, prenom=? WHERE id_eleve=?";
		
		if(eleve == null) return rep = -1 ; // Pas update car Eleve inexistant
		
		try {
			ps = _cnn.prepareStatement(queryUpdate);
			ps.setString(1, eleve.getNom());
			ps.setString(2, eleve.getPrenom());
			ps.setInt(3, eleve.getIdEleve());
			
			// Supprimer les Notes
			DAO_Note daoN = new DAO_Note();
			rep = daoN.supprimerToutesLesNotesDuneEleve(eleve.getIdEleve());
			System.out.println("Nombre de notes supprimees: " + rep);
			
			// Update Eleve
			rep = this.ps.executeUpdate();
			System.out.println("Mise a jour Eleve : " + rep);
			
			// Retablir ses notes			
			for(Note note : eleve.getNotes()) {
				daoN.create(note);
			}
			System.out.println("Nombre de notes recrees : " + rep);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}

	/**
	 * Supprimer un Eleve a partir de son id
	 */
	@Override
	public int delete(int id) {
		String queryDelete = "DELETE FROM eleve WHERE id_eleve=?";
		String queryDeleteNotes = "DELETE FROM note WHERE id_eleve=?";
		try {
			
			// Supprimer les notes
			PreparedStatement psNote = _cnn.prepareStatement(queryDeleteNotes);
			psNote.setInt(1, id);
			rep = psNote.executeUpdate();
			
			// Supprimer Eleve
			ps = _cnn.prepareStatement(queryDelete);
			ps.setInt(1, id);
			rep = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}
	
	/**
	 * Recuperer toutes les notes d un Eleve
	 * @param idEleve Identifiant
	 * @return List<Note> Liste de notes
	 */
	public List<Note> retreiveToutesLesNotesDunEleve(int idEleve) {
		String querySelect = "select * FROM note WHERE id_eleve=?";
		List<Note> notes = new ArrayList<>();

		
		try {
			ps = _cnn.prepareStatement(querySelect);
			ps.setInt(1, idEleve);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Note note = new Note(
						rs.getInt("id_note"), 
						rs.getFloat("valeur"), 
						rs.getFloat("coef"), 
						rs.getDate("date"), 
						Matiere.valueOf(rs.getString("matiere")), 
						idEleve);
				// Ajouter note dans la liste
				notes.add(note);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notes;
	}

	

}
