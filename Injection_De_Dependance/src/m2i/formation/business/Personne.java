package m2i.formation.business;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import m2i.formation.java.IPersister;

@XmlRootElement
public class Personne {
	@Expose
	private String nom;
	
	@Expose(serialize=false)
	private IPersister persister;
	
	public Personne() {
		
	}
	
	public Personne(String nom, IPersister p) { // Injection de dependance par constructeur
				
		this.nom = nom;
		// Couplage fort
		//this.persister = new JSONPersister();
		
		// Pour éviter ce couplage fort
		this.persister = p;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public void setPersister(IPersister p) { // Injection de dependance par setter
		this.persister = p;
	}
	
	/**
	 * Methode persist de la classe JSONPersister
	 */
	public void save() {
		persister.persist(this, this.getClass());
	}
	
	
	
}
