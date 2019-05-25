package m2i.java.formation.business;

public class Rectangle extends Forme {

	private float longueur;
	private float largeur;
	private float perimetre;
	private float surface;

	public Rectangle(String nom_forme, float x, float y, float longueur, float largeur) {
		super(nom_forme, x, y);
		this.longueur = longueur;
		this.largeur = largeur;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public float getPerimetre() {
		return perimetre;
	}

	public void setPerimetre(float perimetre) {
		this.perimetre = perimetre;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}

	public float calculerPerimetre() {
		return this.perimetre = (this.longueur + this.largeur) * 2;
	}

	public float calculerSurface() {
		return this.surface = this.longueur * this.largeur;
	}

	public void dessiner() {
		System.out.println("Dessiner ce rectangle dans un canvas");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id_forme=");
		builder.append(id_forme);
		builder.append(", nom_forme=");
		builder.append(nom_forme);
		builder.append(", x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		
		builder.append(", longueur=");
		builder.append(longueur);
		builder.append(", largeur=");
		builder.append(largeur);
		builder.append(", perimetre=");
		builder.append(perimetre);
		builder.append(", surface=");
		builder.append(surface);
		
		return builder.toString();
	}

	

}