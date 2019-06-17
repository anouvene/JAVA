package m2i.formation.java.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

@Entity
public class Ecurie {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private int id_ecurie;
	
	@Expose
	private String nom;
	
	private String nationnalite;
		
	@OneToMany(mappedBy="ecurie")
	private List<Pilote> pilotes = new ArrayList<Pilote>();
	
	public Ecurie() {}	

	public Ecurie(int id_ecurie, String nom, String nationnalite, List<Pilote> pilotes) {
		super();
		this.id_ecurie = id_ecurie;
		this.nom = nom;
		this.nationnalite = nationnalite;
		this.pilotes = pilotes;
	}


	public int getId_ecurie() {
		return id_ecurie;
	}

	public void setId_ecurie(int id_ecurie) {
		this.id_ecurie = id_ecurie;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Pilote> getPilotes() {
		return pilotes;
	}

	public void setPilotes(List<Pilote> pilotes) {
		this.pilotes = pilotes;
	}
	
	public void addPilote(Pilote p) {
		this.pilotes.add(p);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ecurie [id_ecurie=");
		builder.append(id_ecurie);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", nationnalite=");
		builder.append(nationnalite);
		
		if(pilotes != null) {
			builder.append(", pilotes=");
			builder.append(pilotes);
		} else {
			builder.append("NA");
		}
		
		builder.append("]");
		return builder.toString();
	}

	
	
}
