package m2i.formation.java.service;

import javax.persistence.EntityManager;

import m2i.formation.java.pojos.Pilote;


public class PiloteService {
	private EntityManager em;

	public PiloteService(EntityManager em) {
		this.em = em;
	}
	
	public void create(Pilote pilote) {
		// Persister Pilote
		em.persist(pilote);

		
	}
	
	
	public Pilote retreive(int id_pilote) {
		Pilote pilote = em.find(Pilote.class, id_pilote);		
		return pilote;
	}
}
