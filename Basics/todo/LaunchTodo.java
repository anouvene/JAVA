package hb.java.todo;

import java.util.Vector;

public class LaunchTodo {

	public static void main(String[] args) {
		// Instance
		Todo t = new Todo();
				
		// Nombre d'occurrences des caracteres dans une chaine
		t.printNbOccurenceOfCharInString("EEEEEnnnnoo");
		
		// Nombre d'occurrences d'un caractere dans une chaine
		String s = "anticonstitutionnellement";
		System.out.println("Nombre d'occurrence du caractere 'n' dans la chaine " + "'" + s + "' : " + t.getNbOccurenceOfCharInString(s, 'n'));

		// Max 
		Vector<Integer> vect = new Vector<Integer>(4);
		vect.addElement(3);
		vect.addElement(11);
		vect.addElement(88);
		vect.addElement(9);
		vect.addElement(20);
		
		System.out.println("Max de " + vect.toString() + " est " + t.getMaxInCollection(vect));
		
		
	}

}
