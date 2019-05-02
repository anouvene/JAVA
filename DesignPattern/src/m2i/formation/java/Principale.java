package m2i.formation.java;

// import java.sql.Connection;
import java.util.List;

public class Principale {

	public static void main(String[] args) {
		
//		String url = "jdbc:mysql://localhost:3306/formation?serverTimezone=UTC";
//		String user = "root";
//		String password = "";
		
//		Connection cnn1 = Connexion.getConnexion(url, user, password);
//		System.out.println(cnn1);
//		
//		Connection cnn2 = Connexion.getConnexion(url, user, password);
//		System.out.println(cnn2);
		
		//==================================================================================
		// CREER LES PERSONNES
		//==================================================================================
		
//		Personne p1 = new Personne(1, "NGUYEN", "Minh Tuan", 70f, 1.70f, Genre.MASCULIN, 2);
//		Personne p2 = new Personne(2, "DURAND", "Guillaume", 80f, 1.80f, Genre.MASCULIN, 3);	
//		Personne p3 = new Personne(3, "Nathalie", "Klein", 80f, 1.85f, Genre.FEMININ, 1);
//		
//		DAO_Personne dp = new DAO_Personne();
//		
//		System.out.println(dp.create(p1));
//		System.out.println(dp.create(p2));
//		System.out.println(dp.create(p3));
		
		
		//==================================================================================
		// RETREIVE UNE PERSONNE A PARTIR DE SON ID
		//==================================================================================
//		// R�cup�rer une personne portant l'id = 3
//		System.out.println("================== R�cup�rer une personne portant l'id = 3 =================");
//		System.out.println(dp.retreive(3));
//		
		//==================================================================================
		// LISTE DE PERSONNES
		//==================================================================================
//		List<Personne> lstPersonne = dp.retreiveAll();
//		System.out.println("================== Liste des personnes =================");
//		for(Personne p : lstPersonne) {
//			System.out.println(p);
//		}
		
		//==================================================================================
		// METTRE A JOUR UNE PERSONNE A PARTIR DE SON ID
		//==================================================================================
//		System.out.println("================== Update une personne portant l'id 2 =================");
//		Personne p2 = dp.retreive(2);
		
		// Modifier les attributs de p2
//		p2.set_nom("TOTO");
//		p2.set_prenom("Titi");
//		p2.set_poids(100);
//		p2.set_taille(1.80f);
//		p2.set_sexe(Genre.FEMININ);
		
		// Mettre � jour dans la base
		//System.out.println(dp.update(p2));
		
		//==================================================================================
		// DELETE UNE PERSONNE A PARTIR DE SON ID
		//==================================================================================
//		System.out.println("================== Supprimer une personne portant l'id = 2 =================");
//		System.out.println(dp.delete(2));
//		
//		System.out.println(Genre.valueOf("MASCULIN"));
//		System.out.println(Genre.MASCULIN);
//		System.out.println(Genre.values()[1]);
//		
//		
		//==================================================================================
		// CREER UNE SOCIETE ET AJOUTER LES PERSONNES PORTANT SON ID
		//==================================================================================
		// Créer une Societe
//		Societe s1 = new Societe(1, "SOPRA STERIA", 1000000.00f, "ESN");		
//		Societe s2 = new Societe(2, "SNCF", 1000000.00f, "Transport");
//		Societe s3 = new Societe(3, "EDF", 1000000.00f, "Energie");
//		
//		// Faire appel à DAO Societe et mettre à jour la base
		DAO_Societe ds = new DAO_Societe();
//		System.out.println(ds.create(s1));
//		System.out.println(ds.create(s2));
//		System.out.println(ds.create(s3));
		
		// Afficher les personnes de la Societe s1
		Societe s1 = ds.retreive(1);
		System.out.println(s1);
		
		System.out.println("========== Les personnes travaillant pour s1: ===========");
		List<Personne> personnes = ds.retreivePersons(s1);
		for(Personne p : personnes) {
			System.out.println(p);
		}
		
		
		

	}

}

