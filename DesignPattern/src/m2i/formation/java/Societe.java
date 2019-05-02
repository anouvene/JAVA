package m2i.formation.java;

import java.util.ArrayList;
import java.util.List;

public class Societe {
	private int idSociete;
	private String nom;
	private float ca;
	private String activite;
	
	private List<Personne> lstPersonne = new ArrayList<>();
	
	public Societe(int idSociete, String nom, float ca, String activite) {
		super();
		this.idSociete = idSociete;
		this.nom = nom;
		this.ca = ca;
		this.activite = activite;
	}
	
	// GETTERS and SETTERS
	public int getIdSociete() {
		return idSociete;
	}



	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public float getCa() {
		return ca;
	}



	public void setCa(float ca) {
		this.ca = ca;
	}



	public String getActivite() {
		return activite;
	}



	public void setActivite(String activite) {
		this.activite = activite;
	}

	public List<Personne> getLstPersonne() {
		return lstPersonne;
	}

	public void setLstPersonne(List<Personne> lstPersonne) {
		this.lstPersonne = lstPersonne;
	}
	
	/**
	 * Ajouter les personnes dans al soci�te
	 * @param p Personne � ajouter
	 */
	public void ajouterPersonne(Personne p) {
		this.lstPersonne.add(p);
	}

	/**
	 * Afficher Societe
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Societe [idSociete=");
		builder.append(idSociete);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", ca=");
		builder.append(ca);
		builder.append(", activite=");
		builder.append(activite);
		builder.append(", lstPersonne=");
		builder.append(lstPersonne);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
