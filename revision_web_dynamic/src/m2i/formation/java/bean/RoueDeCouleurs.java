package m2i.formation.java.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import m2i.formation.java.dao.IDAOCouleur;
import m2i.formation.java.dao.impl.DAOCouleur;

@ManagedBean(name="roue")
public class RoueDeCouleurs {
	
	private IDAOCouleur<Couleur> daoCouleur;
	
	private Couleur couleur;
	
	private String choix;
	
	private List<Couleur> couleurs;
	
	public RoueDeCouleurs() {
		choix = "Texte";
		
		daoCouleur = new DAOCouleur();
		couleurs = new ArrayList<>();
		
		couleurs = daoCouleur.retreiveAll();
	}


	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public String getChoix() {
		return choix;
	}

	public void setChoix(String choix) {
		this.choix = choix;
	}

	public List<Couleur> getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(List<Couleur> couleurs) {
		this.couleurs = couleurs;
	}
	
	
	
	
}
