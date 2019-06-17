package m2i.formation.java.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Couleur {
	private int id_couleur;
	private String nom;
	private String hexa;
	
	public Couleur() {
		// TODO Auto-generated constructor stub
	}
	
	public Couleur(String n) {
		this.nom = n;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId_couleur() {
		return id_couleur;
	}

	public void setId_couleur(int id_couleur) {
		this.id_couleur = id_couleur;
	}

	public String getHexa() {
		return hexa;
	}

	public void setHexa(String hexa) {
		this.hexa = hexa;
	}
	
}
