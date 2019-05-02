package hb.harrypotter.pojos;

import java.util.Date;

public class Actor {
	private Identity identity;
	private Date birthdate;
	private String birthcity;
	private String role;
	
	public Actor(String bc, String r, Date bd, String lstname, String fstname) {
		this.birthcity = bc;
		this.role = r;
		this.birthdate = bd;
		this.identity = new Identity(lstname, fstname);
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthcity() {
		return birthcity;
	}

	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		String bd = new hb.harrypotter.utils.DateUtil().formatDateBirth(birthdate);
		return "Actor ["
				+ "identity=" + identity 
				+ ", birthdate=" + bd 
				+ ", birthcity=" + birthcity 
				+ ", role=" + role + "]";
	}
	
	

}
