package hb.java.exceptions;

public class NoMoreTimeAvailable extends Exception{

	/**
	 * To keep track of different versions of a class in order to perform valid serialization of objects
	 * The idea is to generate an ID that is unique to a certain version of an class, 
	 * which is then changed when there are new details added to the class, 
	 * such as a new field, which would affect the structure of the serialized object.
	 */
	private static final long serialVersionUID = 7802105716254517246L;
	
	public NoMoreTimeAvailable (String message) {
		super(message); // Surcharge du constructeur Exception(String msg)
	}

	

	

}
