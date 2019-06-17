package m2i.formation.java.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m2i.formation.java.bean.Couleur;
import m2i.formation.java.dao.IDAOCouleur;
import m2i.formation.java.dao.utils.Connexion;

public class DAOCouleur implements IDAOCouleur<Couleur> {

	final static String url = "jdbc:mysql://localhost:3306/roue?serverTimezone=UTC" ;
	final static String user = "root";
	final static String pwd = "";	
	
	private static Connection _cnn = Connexion.getInstance(url, user, pwd);
	
	@Override
	public List<Couleur> retreiveAll() {
		
		String sql = "SELECT * FROM couleur";
		List<Couleur> couleurs = new ArrayList<>();
		try {
			Statement st = _cnn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Couleur c = new Couleur(rs.getString("nom"));
				c.setId_couleur(rs.getInt("id_couleur"));
				c.setHexa(rs.getString("hexa"));
				couleurs.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		return couleurs;
	}

}
