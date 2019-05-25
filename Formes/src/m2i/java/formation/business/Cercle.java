package m2i.java.formation.business;

public class Cercle extends Forme {

	private float rayon;
	private float perimetre;
	private float surface;

	
	
	public Cercle(String nom_forme, float x, float y, float rayon) {
		super( nom_forme, x, y);
		this.rayon = rayon;
	}

	public float getRayon() {
		return rayon;
	}

	public void setRayon(float rayon) {
		this.rayon = rayon;
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

	public void calculerPerimetre() {
		this.perimetre = (float) (2 * Math.PI + this.rayon);
	}

	public void calculerSurface() {
		this.surface = (float) (Math.PI * this.rayon * this.rayon);
	}

	public void dessiner() {
		System.out.println("Dessiner ce cercle dans un canvas");
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
		
		builder.append(", rayon=");
		builder.append(rayon);
		builder.append(", perimetre=");
		builder.append(perimetre);
		builder.append(", surface=");
		builder.append(surface);

		return builder.toString();
	}

}