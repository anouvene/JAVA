package m2i.formation.java.service;

import javax.persistence.EntityManager;

import m2i.formation.java.model.Client;

public class ClientService {
	
	private EntityManager em;

	public ClientService(EntityManager em) {
		this.em = em;
	}
	
	public void create(Client client) {		
		
	}
	
//	public Ecurie update(int id, String nomNew) {
//		Ecurie e = em.find(Ecurie.class, id);
//		if(e != null) {
//			e.setNom(nomNew);
//		}
//		return null;
//	}
	
	public Client retreive(int id_client) {
		Client client = em.find(Client.class, id_client);		
		return client;
	}
	
	
//	
//	public List<Ecurie> retreiveAll() {
//		TypedQuery<Ecurie> sql = em.createQuery("SELECT e FROM Ecurie e", Ecurie.class); // requete bas�e sur les Entites et non pas la table en BDD
//		return sql.getResultList();
//	}
//	
//	public void delete(Ecurie ecurie) {
//		// Find ecurie puis remove
//		em.remove(ecurie);
//		// Enregistrer dans la base
//	}

}
