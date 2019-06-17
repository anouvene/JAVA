package m2i.formation.java.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import m2i.formation.java.pojos.Ecurie;
import m2i.formation.java.pojos.Pilote;



public class EcurieService {
	private EntityManager em;

	public EcurieService(EntityManager em) {
		this.em = em;
	}
	
	public void create(Ecurie ecurie) {		
		for(Pilote p : ecurie.getPilotes()) {
			p.setEcurie(ecurie);
			em.persist(p);
			em.persist(ecurie);
		}
	}
	
	public Ecurie update(int id, String nomNew) {
		Ecurie e = em.find(Ecurie.class, id);
		if(e != null) {
			e.setNom(nomNew);
		}
		return null;
	}
	
	public Ecurie retreive(int id_ecurie) {
		Ecurie ecurie = em.find(Ecurie.class, id_ecurie);		
		return ecurie;
	}
	
	public List<Ecurie> retreiveAll() {
		TypedQuery<Ecurie> sql = em.createQuery("SELECT e FROM Ecurie e", Ecurie.class); // requete basée sur les Entites et non pas la table en BDD
		return sql.getResultList();
	}
	
	public void delete(Ecurie ecurie) {
		// Find ecurie puis remove
		em.remove(ecurie);
		// Enregistrer dans la base
	}
	
	
	
	
}
