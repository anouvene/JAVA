package hb.java.exceptions;

public class SchoolNotExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SchoolNotExistsException(String message) {
		super(message); // Surcharge du constructeur Exception(String msg)
	}

}
