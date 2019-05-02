package m2i.formation.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static Connection _instance = null;

	private Connexion() {}
	
	public static Connection getConnexion(String url, String user, String password) {
			
		// Synchroniser 
		if(_instance == null) {
			synchronized(Connexion.class) { // le thread en cours va v�rouiller ce portion de codes tant qu'il n'a pas fini son travail
				//if(_instance == null) {		
					try {
						_instance = DriverManager.getConnection(url, user, password);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				//}
				
			}
		}
		
		return _instance;
	}
	
	
	
	
	
	
	
}
