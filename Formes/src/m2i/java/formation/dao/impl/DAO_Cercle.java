package m2i.java.formation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import m2i.java.formation.business.Cercle;
import m2i.java.formation.business.Forme;
import m2i.java.formation.dao.IDAO_Forme;
import m2i.java.formation.dao.IDAO_Cercle;
import m2i.java.formation.utils.Connexion;

public class DAO_Cercle implements IDAO_Cercle<Forme, Float> {
	private Connection _cnn = Connexion.getConnexion("jdbc:mysql://localhost:3306/formes?serverTimezone=UTC", "root", "");

	private IDAO_Forme<Forme> daoForme;
	private int rep;
	
	public DAO_Cercle() {
		daoForme = new DAO_Forme();
		rep = -1;
	}
	
	@Override
	public int Create(Forme forme, Float rayon) {
		
		// Recuperer le dernier enregistrement de Forme
		Forme f = daoForme.Retreive(forme.getId_forme());

		try {
			// Prepare les donnees pour le Cercle
			String chSql = "INSERT INTO cercle VALUES (?, ?)";
			PreparedStatement ps = _cnn.prepareStatement(chSql);			
			ps.setInt(1, f.getId_forme());
			ps.setFloat(2, rayon);
									
			// Create Cercle dans la BDD
			rep = ps.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rep;
	}


	@Override
	public Cercle Retreive(int id) {
		
		Cercle cercle = null;
		
		String chSql = "SELECT * FROM cercle INNER JOIN forme ON cercle.id_forme = forme.id_forme";		
		
		try {
			PreparedStatement ps = _cnn.prepareStatement(chSql);				
			
			ResultSet rs =  ps.executeQuery();		
			
			while (rs.next()) {
				if(rs.getInt("id_forme") == id) {
					int id_forme = rs.getInt("id_forme");
					String nom = rs.getString("nom_forme");
					Float x = rs.getFloat("x");
					Float y = rs.getFloat("y");
					Float rayon = rs.getFloat("rayon");
					
					// String nom_forme, float x, float y, float rayon
					cercle = new Cercle(nom, x, y, rayon);					
					cercle.setId_forme(id_forme);
					cercle.calculerPerimetre();
					cercle.calculerSurface();
					
					break;
				}
				
				
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return cercle;
	}

	@Override
	public List<Forme> RetreiveAll() {

		List<Forme> cercles = new ArrayList<>();
		
		String chSql = "SELECT * FROM cercle INNER JOIN forme ON cercle.id_forme = forme.id_forme";	
		
		try {
			PreparedStatement ps = _cnn.prepareStatement(chSql);			
						
			ResultSet rs =  ps.executeQuery();		
			
			while (rs.next())
			{
				int id_cercle  = rs.getInt("id_forme");
				String nom = rs.getString("nom_forme");
				float rayon = rs.getFloat("rayon");
				float x = rs.getFloat("x");
				float y = rs.getFloat("y");
				
				// String nom_forme, float x, float y, float rayon
				Cercle cercle = new Cercle(nom, x, y, rayon);
				cercle.setId_forme(id_cercle);
				
				cercles.add(cercle);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cercles;
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
