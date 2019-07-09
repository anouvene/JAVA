package hb.java.birthday;

import java.util.Calendar;

public class LaunchBirthDay {
	
	public static void main(String[] args){
		Calendar c = Calendar.getInstance();
		c.set(1971,03,27); // Init Calendar instance with Birth date 
		// c.set(2019,03,27);
		// Instance Person
		Person p = new Person("Toto", c.getTime()); // Calendar converted to Date
		
		System.out.println(p); // Person.toString()
	}

	
}
