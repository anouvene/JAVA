package m2i.formation.java.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_client;
	
	private String nom;
	private String prenom;
	private String ref_client;
	
	@OneToMany (mappedBy="client")
	private List<Commande> commandes = new ArrayList<Commande>();
	
	public Client() {}
	
	public Client(String nom, String prenom, String ref_client) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.ref_client = ref_client;
	}
		
	public Client(int id_client, String nom, String prenom, String ref_client, List<Commande> commandes) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.ref_client = ref_client;
		this.commandes = commandes;
	}
	
	public int getId_client() {
		return id_client;
	}
	
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getRef_client() {
		return ref_client;
	}
	
	public void setRef_client(String ref_client) {
		this.ref_client = ref_client;
	}
	
	public List<Commande> getCommandes() {
		return commandes;
	}
	
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
}
