package m2i.formation.java.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import m2i.formation.java.model.Produit;

public class ProduitService {
	private EntityManager em;

	public ProduitService(EntityManager em) {
		this.em = em;
	}

	public List<Produit> retreiveAll() {
		TypedQuery<Produit> sql = em.createQuery("SELECT p FROM Produit p", Produit.class);
		System.out.println( "Service"+ sql.getResultList());
		return sql.getResultList();
	}

}
