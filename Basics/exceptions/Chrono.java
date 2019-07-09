package hb.java.exceptions;

public class Chrono {
	private int counter = 0;
	
	public void play() throws NoMoreTimeAvailable {
		this.counter++;
		if(counter > 5) {
			throw new NoMoreTimeAvailable("Plus de temps !");
		}
	}
}
