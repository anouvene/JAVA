package m2i.formation.java;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import m2i.formation.java.model.Client;
import m2i.formation.java.model.Commande;

public class Principale {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdeliumService");
		EntityManager em = emf.createEntityManager();

		// Début Transaction
		em.getTransaction().begin();

			// Instancier les objets
			Client c = new Client("Vettel", "Sebastian", "151fdff");
			Commande p = new Commande(57, new Date(), c);
			c.getCommandes().add(p);
	
			em.persist(c);
			em.persist(p);
		
		// Fin 
		em.getTransaction().commit();

	}

}
