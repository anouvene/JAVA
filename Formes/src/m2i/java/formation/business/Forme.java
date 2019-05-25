package m2i.java.formation.business;

public class Forme {

	protected int id_forme;
	protected String nom_forme;

	// Position dans le canvas
	protected float x;
	protected float y;

	public Forme(String nom_forme, float x, float y) {
		super();
		this.nom_forme = nom_forme;
		this.x = x;
		this.y = y;
	}

	public int getId_forme() {
		return id_forme;
	}

	public void setId_forme(int id_forme) {
		this.id_forme = id_forme;
	}

	public String getNom_forme() {
		return nom_forme;
	}

	public void setNom_forme(String nom_forme) {
		this.nom_forme = nom_forme;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Forme [id_forme=");
		builder.append(id_forme);
		builder.append(", nom_forme=");
		builder.append(nom_forme);
		builder.append(", x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}

	

	
		

}