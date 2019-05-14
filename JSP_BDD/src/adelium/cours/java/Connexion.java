package adelium.cours.java;

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
							_instance = DriverManager.getConnection(url, user, pwd);
						} catch (SQLException e) {				
							System.out.println(e.getMessage());;
						}
					}
			}		
		}		
		
		return _instance;
		
	}
	
}
