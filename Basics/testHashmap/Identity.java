package hb.java.testHashmap;

import java.util.Date;

import hb.utils.DateUtil;

public class Identity implements Comparable<Identity> {
	private String lastName;
	private String firstName;
	private Date birthDate;
	private String nationality;
	
	/**
	 * @param lastName String
	 * @param firstName String
	 * @param birthDate Date
	 * @param nationality String
	 */
	public Identity() {
		// System.out.println("Person constructor with no-args is called");
	}
	
	public Identity(String lastName, String firstName, Date birthDate, String nationality) {
		// System.out.println("Person constructor with-args is called");
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.nationality = nationality;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identity ["
				+ "lastName=" + lastName 
				+ ", firstName=" + firstName 
				+ ", birthDate=" + new DateUtil().dateToString(birthDate)
				+ ", nationality=" + nationality 
				+ "]";
	}

	@Override
	public int compareTo(Identity ident) {
		return this.lastName.compareToIgnoreCase(ident.getLastName());
	}

	
	
}
