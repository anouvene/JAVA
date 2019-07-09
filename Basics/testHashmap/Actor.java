package hb.java.testHashmap;

public class Actor extends Identity {
	private Identity identity;
	private String film;
	private String role;
	/**
	 * @param identity
	 * @param role
	 */
	public Actor(Identity identity, String film, String role){
		//super();
		super(identity.getLastName(), identity.getFirstName(), identity.getBirthDate(), identity.getNationality());
		this.identity = identity;
		this.film = film;
		this.role = role;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Actor [");
		builder.append(this.identity.toString());
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}
	
	
}
