package m2i.formation.java.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import m2i.formation.java.pojos.Ecurie;
import m2i.formation.java.pojos.Pilote;
import m2i.formation.java.service.EcurieService;
import m2i.formation.java.service.PiloteService;

public class Principale {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdeliumService"); // <persistence-unit name="AdeliumService" transaction-type="RESOURCE_LOCAL">	
		EntityManager em = emf.createEntityManager();
		
		// Transaction
		em.getTransaction().begin();

			// Services
			EcurieService es = new EcurieService(em);
			PiloteService ps = new PiloteService(em);
			
			// Liste de pilotes
			List<Pilote> pilotes =  new ArrayList<>();
			
			// Instancier Ecurie
			Ecurie e1 = new Ecurie();
			e1.setNationnalite("France");
			e1.setNom("Renault");
			
			Ecurie e2 = new Ecurie();
			e2.setNationnalite("Italy");
			e2.setNom("Ferrari");
			
			// Instancier Pilote
			Pilote p1 = new Pilote();
			p1.setNom("Prost");
			p1.setPrenom("Alain");
			p1.setEcurie(e1); // Affecter Ecurie
			
			Pilote p2 = new Pilote();
			p2.setNom("Schumarer");
			p2.setPrenom("Michael");			
			p2.setEcurie(e2); // Affecter Ecurie
			
			// Affectation pilotes aux ecuries
			pilotes.add(p1);
			pilotes.add(p2);
			
			e1.addPilote(p1);		
			e2.addPilote(p2);
			
			// Persister Pilote
//			ps.create(p1);
//			ps.create(p2);
			
			// Persister Ecurie
			es.create(e1);


		em.getTransaction().commit();
		
		// Vérifier la creation Pilote
		em.clear();
		Pilote p = ps.retreive(p1.getId_pilote());
		// em.refresh(p);

		System.out.println("Création ecurie ");
		System.out.println("Id ecuerie -- " + p.getId_pilote());
		System.out.println("nom " + p.getNom());
		
		// Vérifier la creation Ecurie
		em.clear();
		Ecurie e = es.retreive(e1.getId_ecurie());
		// em.refresh(e);

		System.out.println("Création ecurie ");
		System.out.println("Id ecuerie -- " + e.getId_ecurie());
		System.out.println("nom " + e.getNom());


	}

}
