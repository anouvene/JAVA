package m2i.formation.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Societe implements IDAO_Societe<Societe, Personne> {

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
	public int create(Societe s) {
		String queryInsert = "INSERT INTO Societe VALUES(?, ?, ?, ?)";
		
		try { 
			// Préparer la requete et setter les valeurs aux attributs
			this.ps = _cnn.prepareStatement(queryInsert);
			this.ps.setInt(1, s.getIdSociete());
			this.ps.setString(2, s.getNom());
			this.ps.setFloat(3, s.getCa());
			this.ps.setString(4, s.getActivite());
			
			// Metre à jour la nouvelle Societe crée dans la base
			this.rep = ps.executeUpdate();
			
			// Lister ces personnes travaillant pour la Societe et les stocker dans une liste
			System.out.println("Les personnes travaillant pour la société: " + this.retreivePersons(s));							
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.rep;
	}

	/**
	 * Récupérer une Societe à partir de son id
	 */
	@Override
	public Societe retreive(int id) {
		String querySelect = "SELECT * FROM Societe WHERE id_societe=?";
		
		Societe s = null;		
		String nom = "";
		float ca = 0;
		String activite = "";
		
		try {
			this.ps = _cnn.prepareStatement(querySelect);
			this.ps.setInt(1, id);
			
			this.rs = this.ps.executeQuery();
			
			if(rs.next()) {
				nom = rs.getString("nom");
				ca = rs.getFloat("ca");
				activite = rs.getString("activite");
				
				s = new Societe(id, nom, ca, activite);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public List<Societe> retreiveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Societe s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Lister les de personnes appartenant à la Societe
	 * @param societe
	 * @param personnes
	 * @return List<Personne> Liste de personnes
	 */
	@Override
	public List<Personne> retreivePersons(Societe societe) {
		// Appeller les services DAO de Personne
		DAO_Personne dp = new DAO_Personne();
		
		List<Personne> lstPersonnesSociete = new ArrayList<>();
		
		// Récupérer la liste des personnes qui existent dans la base
		List<Personne> personnes = dp.retreiveAll();
		// System.out.println("Personnes issues de la base: " + personnes);
		if(!personnes.isEmpty()) {
			
			for(Personne p : personnes) {
				// Vérifier si idSociete de Personne correspond à celui de Societe
				if(p.get_idSociete() == societe.getIdSociete()) { 
					// Si ok, ajouter cette Personne dans la list de personnes
					societe.ajouterPersonne(p);
				}
			}
			lstPersonnesSociete = societe.getLstPersonne();
		}
		
		return lstPersonnesSociete;
	}

	

	
	

}
