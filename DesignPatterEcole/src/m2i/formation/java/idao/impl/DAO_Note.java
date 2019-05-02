package m2i.formation.java.idao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import m2i.formation.java.business.Eleve;
import m2i.formation.java.business.Matiere;
import m2i.formation.java.business.Note;
import m2i.formation.java.idao.IDAO_Eleve;
import m2i.formation.java.idao.IDAO_Note;
import m2i.formation.java.utilities.Connexion;
import m2i.formation.java.utilities.DateUtil;

public class DAO_Note implements IDAO_Note<Note> {
	final static String url = "jdbc:mysql://localhost:3306/dp_ecole?serverTimezone=UTC";
	final static String user = "root";
	final static String password = "";	
	private static Connection _cnn = Connexion.getConnexion(url, user, password);
	
	
	private PreparedStatement ps = null;
	private int rep = -1;

	// ResultSet
	private ResultSet rs = null;
	
	/**
	 * Creer une Note
	 */
	@Override
	public int create(Note note) {
		String queryInsert = "INSERT INTO note VALUES(?, ?, ?, ?, ?, ?);";
		try {
			// Prepare query
			ps = _cnn.prepareStatement(queryInsert);
			ps.setInt(1, note.getIdNote());
			ps.setFloat(2, note.getValeur());
			ps.setFloat(3, note.getCoef());
			ps.setDate(4, new DateUtil().convertUtilDateToSqlDate(note.getDate())); // java.util.Date to java.sql.Date
			ps.setString(5, note.getMatiere().name());
			
			ps.setInt(6, note.getIdEleve()); // Note affectee a un Eleve
									
			// Execute query
			rep = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rep;
	}

	/**
	 * Rechercher une Note a partir de son id
	 */
	@Override
	public Note retreive(int id) {
		String querySelect = "SELECT * FROM note WHERE id_note=?";
		Note note = null; // Note a retourner
		
		int idNote;
		float valeur;
		float coef;
		Date date;
		Matiere matiere;
		
		Eleve eleve = null;
		
		try {
			ps = _cnn.prepareStatement(querySelect);
			ps.setInt(1, id);
			
			rs = this.ps.executeQuery();
			
			if(rs.next()) {
				idNote = rs.getInt("id_note");
				valeur = rs.getFloat("valeur");
				coef = rs.getFloat("coef");
				date = rs.getDate("date");
				matiere = Matiere.valueOf(rs.getString("matiere"));
				// Call Eleve DAO to retreive Eleve by id
				// eleve = new DAO_Eleve().retreive(rs.getInt("id_eleve"));
				
				note = new Note(idNote, valeur, coef, date, matiere, id);
				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return note;
	}

	@Override
	public List<Note> retreiveAll() {
		String querySelectAll = "SELECT * FROM note";
		// Eleves
		List<Note> notes = new ArrayList<>();

	
		try {
			ps = _cnn.prepareStatement(querySelectAll);						
			rs = this.ps.executeQuery();
			
			while(rs.next()) {
				Note note = new Note(
						rs.getInt("id_note"), 
						rs.getFloat("valeur"), 
						rs.getFloat("coef"),
						rs.getDate("date"),
						Matiere.valueOf(rs.getString("matiere")),
						new DAO_Eleve().retreive(rs.getInt("id_eleve")));
				
				// Ajouter chaque Eleve dans lstEleve
				notes.add(note);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notes;
	}

	@Override
	public int update(Note note) {
		String queryUpdate = "UPDATE note SET valeur=?, coef=?, date=?, matiere=?  WHERE id_note=?";
		
		if(note == null) return rep = -1 ; // Pas update car Note inexistant
		
		try {
			ps = _cnn.prepareStatement(queryUpdate);
			ps.setFloat(1, note.getValeur());
			ps.setFloat(2, note.getCoef());
			ps.setDate(3, new DateUtil().convertUtilDateToSqlDate(note.getDate()));
			ps.setString(4, note.getMatiere().name());
			ps.setInt(5, note.getIdNote());
			
			
			
			
			// Update
			rep = this.ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}

	@Override
	public int delete(int id) {
		String queryDelete = "DELETE FROM note WHERE id_note=?";
		try {
			ps = _cnn.prepareStatement(queryDelete);
			ps.setInt(1, id);
			
			// Delete
			this.rep = this.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}

	/**
	 * Supprimer toues les notes d'une Eleve
	 * @param idEleve
	 * @return int Etat 1 ou -1
	 */
	public int supprimerToutesLesNotesDuneEleve(int idEleve) {
		String queryDelete = "DELETE FROM note WHERE id_eleve=?";
		
		try {
			ps = _cnn.prepareStatement(queryDelete);
			ps.setInt(1, idEleve);
			rep = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rep;
	}

}
