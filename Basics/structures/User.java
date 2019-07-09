package hb.java.structures;

import java.util.Comparator;
import java.util.Date;

import hb.java.date.Dates;


public class User implements Comparator<User>{

	private int idUser;
	private String lastName;
	private String firstName;
	private String login;
	private Date birthDate;
	
	public User(){};
	public User(int id, String ln, String fn){
		this.idUser = id;
		this.lastName = ln;
		this.firstName = fn;
	}	
	public User(int id, String ln, String fn, String log){
		this.idUser = id;
		this.lastName = ln;
		this.firstName = fn;
		this.login = log;
	}
		
	// Getters and Setters
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	// Getter and Setter for BirthDate
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {	
		this.birthDate = birthDate;
	}
	/**
	 * Compare Users
	 */
	@Override
	public int compare(User user1, User user2) {
		// Users identifiant
		int idUser1 = user1.getIdUser();
		int idUser2 = user2.getIdUser();
		
		if(idUser1 < idUser2){
			return -1;
		} else if(idUser1 == idUser2){
			return 0;
		} else if(idUser1 > idUser2){
			return 1;
		} else {
			return 2;
		}		
	}
	
	
	@Override
	public String toString() {
		
		// Dates instance
		// Dates dates = new Dates();
				
		// Invoke formatDateBirth : Format Date to String
		String bd = new Dates().formatDateBirth(this.birthDate);
		if(bd != "") {
			return "User [idUser=" 
					+ idUser 
					+ ", lastName=" + lastName 
					+ ", firstName=" + firstName 
					+ ", login=" + login
					+ ", birthDate=" + bd
					+ "]";
		} else {
			return "User [idUser=" 
					+ idUser 
					+ ", lastName=" + lastName 
					+ ", firstName=" + firstName 
					+ ", login=" + login
					+ "]";
		}
	}	
}
