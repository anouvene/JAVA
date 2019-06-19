package m2i.formation.java.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_produit;
	private String intitule;
	private float pj_ht;
	
	private int nb_jours;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "produits", targetEntity = Commande.class) 
	private Set<Commande> commandes = new HashSet<>();
	//private List<Commande> commandes = new ArrayList<Commande>();
	
	public Produit() {}

	public Produit(int id_produit, String intitule, float pj_ht, int nb_jours, Set<Commande> commandes) {
		super();
		this.id_produit = id_produit;
		this.intitule = intitule;
		this.pj_ht = pj_ht;
		this.nb_jours = nb_jours;
		this.commandes = commandes;
	}
	
	public Produit(String intitule, float pj_ht, int nb_jours, Set<Commande> commandes) {
		super();
		this.intitule = intitule;
		this.pj_ht = pj_ht;
		this.nb_jours = nb_jours;
		this.commandes = commandes;
	}

	// GETTERS & SETTERS
	public int getId_produit() {
		return id_produit;
	}
	
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	
	public String getIntitule() {
		return intitule;
	}
	
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public float getPj_ht() {
		return pj_ht;
	}
	
	public void setPj_ht(float pj_ht) {
		this.pj_ht = pj_ht;
	}

	public int getNb_jours() {
		return nb_jours;
	}

	public void setNb_jours(int nb_jours) {
		this.nb_jours = nb_jours;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
}
