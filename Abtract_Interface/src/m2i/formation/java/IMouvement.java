package m2i.formation.java;

public interface IMouvement {
	final static int vitesseLimite = 120;
	
	public abstract void freiner();
	void accelerer();
}
