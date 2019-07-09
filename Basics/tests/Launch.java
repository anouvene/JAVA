package hb.java.tests;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Launch {

	public static void main(String[] args) {
		// StringTokenizer
		StringTokenizer stok = new StringTokenizer("Anticonstitutionnellement je ne le suis pas");
		System.out.println(stok.countTokens()); // 6
		
		StringBuilder sb = new StringBuilder();
		while (stok.hasMoreTokens()) {
			sb.append(stok.nextToken());
			sb.append("-");
		}
		
		System.out.println(sb.toString().substring(0, sb.toString().length()-1));
		
		// delete(int start, int end) : deletes the subsequence from start to end-1
		String str = sb.toString().substring(0, sb.toString().length()-1);
		StringBuilder sb2 = new StringBuilder(str);
		sb2.delete(sb2.length()-1, sb2.length());
		System.out.println(sb2.toString());
		
		// deleteCharAt() the character located at index.
		System.out.println(sb2.deleteCharAt(0).toString());
		
		// insert()
		System.out.println(sb2.insert(0, 'A').toString());
		
		// reverse()
		System.out.println(sb2.reverse().toString());
		
		// replace()
		System.out.println(sb2.replace(0, 3, "HELLO-").toString());
		
		// setCharAt()
		char c = 'h';
		sb2.setCharAt(0, c);
		System.out.println(sb2.toString());
		
		System.out.println(
			"=========================================\n"
			+ "*Tableau\n"
			+ "========================================="
		);
		String [] tabString = {"Hello", "Toto", "Moi"};

		// Trier ordre croissant
		Arrays.sort(tabString); 

		// Position d'un élem dans un tableau 
		int index = Arrays.binarySearch(tabString, "Toto");
		System.out.println("Position de Toto : " + index + "\n");
		
		// Copier un tableau dans un autre
		int [] tabInt1 = {120, 965, 45};
		int [] tabInt2 = {120, 965, 45, 42, 88};
		int[] tmp1 = new int[tabInt1.length + tabInt2.length];
		int[] tmp2 = tmp1;
		
		System.out.println("Fusion de 2 tableaux méthode classique avec 2 boucles for :");
		// Copy tabInt1
		for(int i=0; i<tabInt1.length; i++) {
			tmp1[i] = tabInt1[i];	
		}
		
		// Copy tabInt2
		for(int i=0; i<tabInt2.length; i++) {
			tmp1[i+tabInt1.length] = tabInt2[i];	
		}
		// Affichage
		for(int i=0; i<tmp1.length; i++) {
			System.out.println(tmp1[i]);
		}
		
		System.out.println("\nFusion de 2 tableaux avec System.arrycopy() :");
		// Copy tabInt1
		System.arraycopy(tabInt1, 0, tmp2, 0, tabInt1.length);
		// Copy tabInt2
		System.arraycopy(tabInt2, 0, tmp2, tabInt1.length, tabInt2.length);
		// Affichage
		for(int i=0; i<tmp2.length; i++) {
			System.out.println(tmp2[i]);
		}
		
		System.out.println(
			"=========================================\n"
			+ "*Calendar\n"
			+ "========================================="
		);
		
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTimeInMillis(date.getTime());
		System.out.println("Date now en ms : " + date.getTime());
		
		
		
	}

}
