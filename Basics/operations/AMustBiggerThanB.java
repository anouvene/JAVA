package hb.java.operations;

public class AMustBiggerThanB extends Exception {
	
	private static final long serialVersionUID = 8164328083802472691L;

	private String message;
	
	public AMustBiggerThanB (String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
