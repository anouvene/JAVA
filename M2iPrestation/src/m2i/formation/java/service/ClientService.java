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
	
	public Client retreive(int id_client) {
		Client client = em.find(Client.class, id_client);		
		return client;
	}

}
