package m2i.formation.java.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int nb_jours;
	private Date date_commande;

	@ManyToOne 
	@JoinColumn(name="id_client", nullable=false)
	private Client client;	
	
	@ManyToMany(
		targetEntity = Produit.class,
		cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
		@JoinTable(name = "ligne_commande",
		joinColumns = @JoinColumn(name = "id_commande", nullable = false, updatable = false),
		inverseJoinColumns = @JoinColumn(name = "id_produit", nullable = false, updatable = false))
	private Set<Produit> produits= new HashSet<Produit>(0);
	//private List<Produit> produits = new ArrayList<Produit>();
		
	public Commande() {}
	
	public Commande(int nb_jours, Date date_commande, Client client) {
		this.nb_jours = nb_jours;
		this.date_commande = date_commande;
		this.client = client;
	}
	
	public Commande(int id_commande, int nb_jours, Date date_commande, Client client) {
		super();
		this.id = id_commande;
		this.nb_jours = nb_jours;
		this.date_commande = date_commande;
		this.client = client;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id_commande) {
		this.id = id_commande;
	}
	
	public int getNb_jours() {
		return nb_jours;
	}
	
	public void setNb_jours(int nb_jours) {
		this.nb_jours = nb_jours;
	}
	
	public Date getDate_commande() {
		return date_commande;
	}
	
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}
