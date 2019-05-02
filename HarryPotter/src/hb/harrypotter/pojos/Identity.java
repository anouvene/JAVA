package hb.harrypotter.pojos;

public class Identity implements Comparable<Identity>{

	private String lastname;
	private String firstname;
	
	public Identity(String lstname, String fstname) {
		this.lastname = lstname;
		this.firstname = fstname;
	}	

	// Getters and setters
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return "Identity [lastname = " + lastname + ", firstname = " + firstname + "]";
	}

	@Override
	public int compareTo(Identity o) {
		return this.lastname.compareTo(o.lastname);
	}

}
