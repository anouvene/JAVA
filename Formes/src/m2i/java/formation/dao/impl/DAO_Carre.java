package m2i.java.formation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import m2i.java.formation.business.Carre;
import m2i.java.formation.business.Forme;
import m2i.java.formation.dao.IDAO_Forme;
import m2i.java.formation.dao.IDAO_Carre;
import m2i.java.formation.utils.Connexion;


public class DAO_Carre implements IDAO_Carre<Forme, Float> {
	
	private Connection _cnn = Connexion.getConnexion("jdbc:mysql://localhost:3306/formes?serverTimezone=UTC", "root", "");

	private IDAO_Forme<Forme> daoForme;
	private int rep;
	
	public DAO_Carre() {
		daoForme = new DAO_Forme();
		rep = -1;
	}	
	
	@Override
	public int Create(Forme forme, Float cote) {
		// Recuperer le dernier enregistrement de Forme qui a ete cree juste avant
		Forme f = daoForme.Retreive(forme.getId_forme());
		
		try {
			// Prepare les donnees pour le Cercle
			String chSql = "INSERT INTO carre VALUES (?, ?)";
			PreparedStatement ps = _cnn.prepareStatement(chSql);			
			ps.setInt(1, f.getId_forme());
			ps.setFloat(2, cote);
									
			// Create Carre dans la BDD
			rep = ps.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rep;
	}

	@Override
	public Carre Retreive(int id) {
		
		Carre carre = null;
		
		// Faire une jointure avec la table forme
		String chSql = "SELECT * FROM carre INNER JOIN forme ON carre.id_forme = forme.id_forme";		
		
		try {
			Statement st = _cnn.createStatement();				
			
			ResultSet rs =  st.executeQuery(chSql);				
			while (rs.next()) {
				if(rs.getInt("id_forme") == id) {
					int id_forme = rs.getInt("id_forme");
					String nom = rs.getString("nom_forme");
					Float x = rs.getFloat("x");
					Float y = rs.getFloat("y");
					Float cote = rs.getFloat("cote");
					
					// String nom_forme, float x, float y, float cote
					carre = new Carre(nom, x, y, cote);					
					carre.setId_forme(id_forme);
					carre.calculerPerimetre();
					carre.calculerSurface();
					
					break;
				}
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		
		return carre;
	}

	@Override
	public List<Forme> RetreiveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Update(Forme obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
