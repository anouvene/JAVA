package m2i.formation.java.service;

import javax.persistence.EntityManager;

import m2i.formation.java.model.Commande;

public class CommandeService {

	private EntityManager em;

	public CommandeService(EntityManager em) {
		this.em = em;
	}
	
	public void create(Commande commande) {		
		em.persist(commande);	
	}
}
