package m2i.java.formation.business;

public class Carre extends Forme {

	private float cote;
	private float perimetre;
	private float surface;

	public Carre(String nom_forme, float x, float y, float cote) {
		super(nom_forme, x, y);
		this.cote = cote;
	}
	
	public float getCote() {
		return cote;
	}

	public void setCote(float cote) {
		this.cote = cote;
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
		return this.perimetre = (this.cote * 4);
	}

	public float calculerSurface() {
		return this.surface = this.cote * this.cote;
	}

	public void dessiner() {
		System.out.println("Dessiner ce carre dans un canvas ");
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
		
		builder.append(", cote=");
		builder.append(cote);
		builder.append(", perimetre=");
		builder.append(perimetre);
		builder.append(", surface=");
		builder.append(surface);
		
		return builder.toString();
	}
	
	
	
	

}