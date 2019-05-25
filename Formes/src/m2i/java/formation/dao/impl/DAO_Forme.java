package m2i.java.formation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m2i.java.formation.business.Carre;
import m2i.java.formation.business.Cercle;
import m2i.java.formation.business.Forme;
import m2i.java.formation.business.Rectangle;
import m2i.java.formation.dao.IDAO_Forme;
//import m2i.java.formation.dao.IDAO_Carre;
//import m2i.java.formation.dao.IDAO_Cercle;
//import m2i.java.formation.dao.IDAO_Rectangle;
import m2i.java.formation.utils.Connexion;

public class DAO_Forme implements IDAO_Forme<Forme> {

	Connection _cnn = Connexion.getConnexion("jdbc:mysql://localhost:3306/formes?serverTimezone=UTC", "root", "");

	@Override
	public int Create(Forme f) {
		int rep = -1; // Reponse
		
		// Preparer la requerte
		try {
			String chSql = "INSERT INTO forme VALUES (?,?,?,?)";
			PreparedStatement ps = _cnn.prepareStatement(chSql);
			ps.setInt(1, f.getId_forme());
			ps.setString(2, f.getNom_forme());
			ps.setFloat(3, f.getX());
			ps.setFloat(4, f.getY());

			// CREATE
			rep = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rep;
	}

	@Override
	public Forme Retreive(int id) {
		Forme forme = null;

		String chSql = "SELECT * FROM forme WHERE id_forme=LAST_INSERT_ID();";

		try {
			PreparedStatement ps = _cnn.prepareStatement(chSql);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id_forme = rs.getInt("id_forme");
				String nom = rs.getString("nom_forme");
				float x = rs.getFloat("x");
				float y = rs.getFloat("y");

				forme = new Forme(nom, x, y);
				forme.setId_forme(id_forme);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forme;
	}

	@Override
	public List<Forme> RetreiveAll() {

		List<Forme> formes = new ArrayList<>();

		// Prepare lea jointure tables forme et tables enfants
		String chSql = "SELECT f.id_forme, c.rayon, ca.cote, r.longueur, r.largeur, x, y, nom_forme FROM forme f "
				+ "LEFT JOIN cercle c ON c.id_forme = f.id_forme " 
				+ "LEFT JOIN rectangle r ON r.id_forme = f.id_forme "
				+ "LEFT JOIN carre ca ON ca.id_forme = f.id_forme";
		try {
			Statement st = _cnn.createStatement();
			ResultSet rs = st.executeQuery(chSql);

			while (rs.next()) {

				if (rs.getString("nom_forme").equalsIgnoreCase("carre")) {
					Carre carre = new Carre(rs.getString("nom_forme"), rs.getFloat("x"), rs.getFloat("y"),
							rs.getFloat("cote"));
					carre.setId_forme(rs.getInt("id_forme"));
					carre.calculerPerimetre();
					carre.calculerSurface();
					formes.add(carre);
				} else if (rs.getString("nom_forme").equalsIgnoreCase("cercle")) {
					Cercle cercle = new Cercle(rs.getString("nom_forme"), rs.getFloat("x"), rs.getFloat("y"),
							rs.getFloat("rayon"));
					cercle.setId_forme(rs.getInt("id_forme"));
					cercle.calculerPerimetre();
					cercle.calculerSurface();
					formes.add(cercle);
				} else if (rs.getString("nom_forme").equalsIgnoreCase("rectangle")) {
					Rectangle rectangle = new Rectangle(rs.getString("nom_forme"), rs.getFloat("x"), rs.getFloat("y"),
							rs.getFloat("longueur"), rs.getFloat("largeur"));
					rectangle.setId_forme(rs.getInt("id_forme"));
					rectangle.calculerPerimetre();
					rectangle.calculerSurface();
					formes.add(rectangle);
				} else {

					return formes;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return formes;

	}

	@Override
	public int Update(Forme obj) {
		return 0;
	}

	@Override
	public int Delete(int id) {
		return 0;
	}

}
