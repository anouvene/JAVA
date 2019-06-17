package m2i.formation.java.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion
{

	private Connexion()
	{		
	}
	
	private static Connection _instance = null ;
	
	public static Connection getInstance(String url , String user, String pwd)
	{
		if (_instance == null)
		{
			synchronized(Connexion.class)
			{			
					if (_instance == null)
					{
						try {
							try {
								Class.forName("com.mysql.cj.jdbc.Driver");
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
							_instance = DriverManager.getConnection(url, user, pwd);
						} catch (SQLException e) {				
							System.out.println(e.getMessage());
						}
					}
			}		
		}		
		
		return _instance;
		
	}
	
}
