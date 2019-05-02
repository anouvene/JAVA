package m2i.formation.java;

import java.util.Comparator;

public class ComparateurGeneral implements Comparator<Eleve> {
	/**
	 * Methode compare de 2 moyenne
	 */
	@Override
	public int compare(Eleve e1, Eleve e2) {

		return ((Float) e1.moyenne()).compareTo(e2.moyenne());

	}

}
