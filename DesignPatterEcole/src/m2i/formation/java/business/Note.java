package m2i.formation.java.business;

import java.util.Date;

public class Note {
	private int idNote;
	private float valeur;
	private float coef;
	private Date date;
	private Matiere matiere;
	
	// Une note appartient a un seul Eleve
	private Eleve eleve;
	private int idEleve;

	public Note(int idNote, float valeur, float coef, Date date, Matiere matiere, int idEleve) {
		this.idNote = idNote;
		this.valeur = valeur;
		this.coef = coef;
		this.date = date;
		this.matiere = matiere;
		this.idEleve = idEleve;
	}
	
	public Note(int idNote, float valeur, float coef, Date date, Matiere matiere, Eleve eleve) {
		this.idNote = idNote;
		this.valeur = valeur;
		this.coef = coef;
		this.date = date;
		this.matiere = matiere;
		this.eleve = eleve;
	}

	public int getIdNote() {
		return idNote;
	}

	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	public float getCoef() {
		return coef;
	}

	public void setCoef(float coef) {
		this.coef = coef;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public int getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Note [idNote=");
		builder.append(idNote);
		builder.append(", valeur=");
		builder.append(valeur);
		builder.append(", coef=");
		builder.append(coef);
		builder.append(", date=");
		builder.append(date);
		builder.append(", matiere=");
		builder.append(matiere);
		builder.append(", idEleve=");
		builder.append(idEleve);
		builder.append("]");
		return builder.toString();
	}
	

	
	
	

	
}
