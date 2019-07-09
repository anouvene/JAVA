package hb.java.birthday;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person {
	private String firstName;
	private Date birthDate;
	private int age;
	
	/**
	 * Constructeur Person
	 * @param fn FirstName
	 * @param date Date of birth
	 */
	public Person(String fn, Date date){
		firstName = fn;
		birthDate = date;
		age = this.calculateAge(birthDate); // Calculate age
	}
	
	/**
	 * Format Date to String
	 * @param d Date to format
	 * @return String of Date
	 */
	public String formatDateToString(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(d);
	}

	/**
	 * Calculate age of Person
	 * @param bd BirthDate
	 * @return int age of Person
	 */
	public int calculateAge(Date bd){
		Calendar currentCalendar = Calendar.getInstance();
		Calendar birthCalendar = Calendar.getInstance();
		birthCalendar.setTime(bd); // Date birthDate to Calendar format
		
		// Extract year from Calendar
		int yearDiff = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
		currentCalendar.add(Calendar.YEAR,-yearDiff);  // Substract yearDiff and add to field YEAR of currentCalendar
		
		if(birthCalendar.after(currentCalendar)){ // return true if the time represented by birthCalendar is after the time represented by currentCalendar; false otherwise
			yearDiff = yearDiff - 1; // retrancher une année 
		}
		
		return yearDiff;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", birthDate=" + this.formatDateToString(birthDate) + ", age=" + age + "]";
	}
	
	
	
}
