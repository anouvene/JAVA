package hb.java.date;

import java.util.Calendar;
import java.util.Date;

import hb.java.structures.User;

public class LaunchDate {

	public static void main(String[] args) {
		// Dates instance
		Dates dates = new Dates();
		
		// Calendar
		Calendar calendar = Calendar.getInstance();
		
		// Date now
		Date dNow = new Date();
		System.out.print("Date du jour : " + dNow + "\n");
		
		// Calendar	to Date
		System.out.print("Calendar to Date : ");
		calendar.set(1984, 10, 5);	
		Date d = dates.convertCalendarToDate(calendar);
		System.out.print(d);
		
		// Date to Calendar
		System.out.print("\nDate to Calendar : ");
		// Date dNow = new Date();
		calendar = dates.convertDateToCalendar(dNow);
		System.out.print("" + calendar);
			
		// Date to SQL Date
		System.out.print("\nDate to SQL Date : ");
		Date sqlDate = dates.convertUtilDateToSqlDate(dNow);
		System.out.print(sqlDate);
		
		// SQL Date to Date
		System.out.print("\nSQL Date to Date : ");
		calendar.set(1999, 0, 10);
		Date utilDate = dates.convertSqlDateToUtilDate(new java.sql.Date(calendar.getTimeInMillis()));
		System.out.print(utilDate);
		
		
		// Date to String
		System.out.print("\n\nDate to String date : ");
		String stringDate = dates.formatDate(utilDate);
		System.out.print(stringDate);
		
		// String date to Date	
		System.out.print("\nString date to Date : ");
		utilDate = dates.getDateFromString("10/01/1999");
		System.out.print(utilDate);
		
		// Difference en ms entre deux dates
		System.out.print("\n\nDifference en ms entre 2 dates : ");
		long diffInMs = dates.getDifferenceBetweenTwodates(new Date(), utilDate);
		System.out.print(diffInMs);
		
		// Comparer 2 dates
		System.out.print("\nComparer 2 dates : ");
		calendar.set(1985, 11, 12);
		Date dateToCompare1 = calendar.getTime();
		
		calendar.set(1984, 11, 12);
		Date dateToCompare2 = calendar.getTime();
		
		if(dates.compareTwoDates(dateToCompare1, dateToCompare2) == 1){
			System.out.print(dateToCompare1 + " est apres " + dateToCompare2);
		}
		
		/**
		 * ============================
		 * Test user birth date
		 * ============================
		 */
		System.out.print("\nUser and his BirthDate  : ");
		
		// Instancier un User
		User user = new User(112, "DURAND", "Pierre");
		user.setLogin("dp");
		
		// Mettre en forme Date
		calendar.set(1984, 11, 12);
		Date dateBirth = calendar.getTime();
		
		// Setter BirthDate pour user
		user.setBirthDate(dateBirth);
		
		// Affichage user
		System.out.print(user);
		

	}

}
