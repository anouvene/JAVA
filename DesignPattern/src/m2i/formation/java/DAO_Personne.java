package m2i.formation.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Personne implements IDAO<Personne> {

	final static String url = "jdbc:mysql://localhost:3306/dp_formation?serverTimezone=UTC";
	final static String user = "root";
	final static String password = "";
	
	private static Connection _cnn = Connexion.getConnexion(url, user, password);
	
	
	// PreparedStatement
	private PreparedStatement ps = null;
	
	// ResultSet
	private ResultSet rs = null;
	
	// Reponse de requete
	private int rep = -1;
	
	
	@Override
	public int create(Personne p) {
		String queryInsert = "INSERT INTO Personne VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			// Prepare statement
			this.ps = _cnn.prepareStatement(queryInsert);
			this.ps.setInt(1, p.get_idPersonne());
			this.ps.setString(2, p.get_nom());
			this.ps.setString(3, p.get_prenom());
			this.ps.setFloat(4, p.get_poids());
			this.ps.setFloat(5, p.get_taille());
			this.ps.setString(6, p.get_sexe().name());
			this.ps.setInt(7, p.get_idSociete());
			
			// Insert into data base
			this.rep = ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.rep;
	}
	
	@Override
	public int createBis(Personne p) {
		String queryInsert = "INSERT INTO Personne VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			this.ps = _cnn.prepareStatement(queryInsert);
			this.ps.setInt(1, p.get_idPersonne());
			this.ps.setString(2, p.get_nom());
			this.ps.setString(3, p.get_prenom());
			this.ps.setFloat(4, p.get_poids());
			this.ps.setFloat(5, p.get_taille());
			this.ps.setString(6, p.get_sexe().name());
			this.ps.setInt(7, p.get_idSociete());
			
			this.rep = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.rep;
	}

	@Override
	public Personne retreive(int id) {
		String querySelect = "SELECT * FROM personne WHERE id_personne=?";
		Personne p = null;
		

		String nom = "";
		String prenom = "";
		float poids = 0;
		float taille = 0;
		String sexe = "";
		
		try {
			this.ps = _cnn.prepareStatement(querySelect);
			this.ps.setInt(1, id);
			
			this.rs = this.ps.executeQuery();
			
			if(rs.next()) {
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				poids = rs.getFloat("poids");
				taille = rs.getFloat("taille");
				sexe = rs.getString("sexe");
				
				p = new Personne(id, nom, prenom, poids, taille, Genre.valueOf(sexe));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Personne> retreiveAll() {
		String querySelectAll = "SELECT * FROM personne";
		Personne p = null;
		List<Personne> lstPersonne = new ArrayList<>();	

		int idPersonne = 0;
		String nom = "";
		String prenom = "";
		float poids = 0;
		float taille = 0;
		String sexe = "";
		int idSociete = 0;
		
		try {
			this.ps = _cnn.prepareStatement(querySelectAll);			
			
			this.rs = this.ps.executeQuery();
			
			while(rs.next()) {
				idPersonne = rs.getInt("id_personne");
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				poids = rs.getFloat("poids");
				taille = rs.getFloat("taille");
				sexe = rs.getString("sexe");
				idSociete = rs.getInt("id_societe");
				
				p = new Personne(idPersonne, nom, prenom, poids, taille, Genre.valueOf(sexe), idSociete);
				
				// Add Personne p to a liste
				lstPersonne.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lstPersonne;
	}

	@Override
	public int update(Personne p) {
		String queryUpdate = "UPDATE personne SET nom=?, prenom=?, poids=?, taille=?, sexe=? WHERE id_personne=?";
		
		if(p == null) return this.rep = -1 ;
		
		try {
			this.ps = _cnn.prepareStatement(queryUpdate);
			this.ps.setString(1, p.get_nom());
			this.ps.setString(2, p.get_prenom());
			this.ps.setFloat(3, p.get_poids());
			this.ps.setFloat(4, p.get_taille());
			this.ps.setString(5, p.get_sexe().name());
			this.ps.setFloat(6, p.get_idPersonne());
			
			// Update
			this.rep = this.ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.rep;
	}

	@Override
	public int delete(int id) {
		String queryDelete = "DELETE FROM personne WHERE id_personne=?";
		try {
			this.ps = _cnn.prepareStatement(queryDelete);
			this.ps.setInt(1, id);
			
			// Delete
			this.rep = this.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.rep;
	}

}
