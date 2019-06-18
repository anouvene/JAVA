package m2i.formation.java.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(LigneDeCommandePK.class) // Classe qui encapsule la clé primaire composée(id_produit + id_commande)
@Table(name="ligne_commande")
public class LigneDeCommande implements Serializable {
	
	private static final long serialVersionUID = -8165337350702018840L;

	/**
	 * Il est nécessaire de marquer chacune des propriétés de l'entité qui compose la clé primaire  avec l'annotation @Id. 
	 * Ces propriétés doivent avoir le même nom dans l'entité et dans la classe qui encapsule la clé primaire.
	 */
	@Id
	@Column(name="id_produit", insertable=false, updatable=false)
	private int id_produit;

	@Id
	@Column(name ="id_commande", insertable=false, updatable=false)
	private int id_commande;
	
	@ManyToOne
	@JoinColumn(name="id_produit", insertable=false, updatable=false)
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name="id_commande", insertable=false, updatable=false)
	private Commande commande;
	
	@Column(name="quantite", unique=false, nullable=false)
	private int quantite;

	public LigneDeCommande() {}

	// GETTERS & SETTERS
	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
