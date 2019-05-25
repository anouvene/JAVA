package m2i.java.formation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static Connection _cnn = null;

	private Connexion() {}
	
	public static Connection getConnexion(String url, String user, String password){
		if(_cnn == null) {
			synchronized(Connexion.class) {
				try {		
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					_cnn = DriverManager.getConnection(url, user, password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return _cnn;
	}

}
