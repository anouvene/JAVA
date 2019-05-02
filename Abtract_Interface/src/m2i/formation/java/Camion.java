package m2i.formation.java;

public class Camion implements IMouvement {

	private String marque, model;

	public Camion(String marque, String model) {
		super();
		this.marque = marque;
		this.model = model;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public void freiner() {
		System.out.println("Camion freine");

	}

	@Override
	public void accelerer() {
		System.out.println("Camion accélère");

	}

	@Override
	public String toString() {
		return "Camion [marque=" + marque + ", model=" + model + "]";
	}
	
	

}
