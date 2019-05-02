package m2i.formation.java.utilities;

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
					_cnn = DriverManager.getConnection(url, user, password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return _cnn;
	}

}
