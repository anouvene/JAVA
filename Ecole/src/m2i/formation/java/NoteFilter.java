package m2i.formation.java;

public interface NoteFilter<T> {
	/**
	 * Filtre sur les attributs de Note
	 * @param t Objet Note
	 * @return true whether note passes filter
	 */
	boolean filter(T t);
}
