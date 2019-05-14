package adelium.cours.java;

import java.sql.Connection;

public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/dp_formation?serverTimezone=UTC" ;
		String user = "root";
		String pwd = "";

		Connection _Cnn = Connexion.getInstance(url, user, pwd);
		
		System.out.println(_Cnn);
		
//		IDAO<Personne> daoPersonne = new DAO_Personne();
//    	daoPersonne.Create(new Personne(4, "TOTO", "Tuan", 70.0f, 1.70f, Genre.MASCULIN, 4));

	}

}
