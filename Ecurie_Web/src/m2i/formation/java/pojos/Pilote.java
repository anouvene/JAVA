package m2i.formation.java.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Pilote {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id_pilote;
	
	private String nom;
	private String prenom;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_ecurie", nullable=false)
	private Ecurie ecurie;
	
	public Pilote() {}

	public Pilote(int id_pilote, String nom, String prenom, Ecurie ecurie) {
		super();
		this.id_pilote = id_pilote;
		this.nom = nom;
		this.prenom = prenom;
		this.ecurie = ecurie;
	}

	public int getId_pilote() {
		return id_pilote;
	}

	public void setId_pilote(int id_pilote) {
		this.id_pilote = id_pilote;
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

	public Ecurie getEcurie() {
		return ecurie;
	}

	public void setEcurie(Ecurie ecurie) {
		this.ecurie = ecurie;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pilote [id_pilote=");
		builder.append(id_pilote);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		
		if(ecurie != null) {
			builder.append(", ecurie=");
			builder.append(ecurie.getId_ecurie());
		} else {
			builder.append(", ecurie=");
			builder.append("NA");
		}		
		
		builder.append("]");
		return builder.toString();
	}


	
	
	
	
	
	
	
}
