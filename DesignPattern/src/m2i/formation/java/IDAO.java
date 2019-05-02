package m2i.formation.java;

import java.util.List;

public interface IDAO<T> {
	int create(T obj); // retourner un int (nombre d'objet ins�r�)
	int createBis(Personne p); // Creer personne avec sa soci�te
	
	T retreive(int id); // retourner un obj de type T selon son id
	
	List<T> retreiveAll(); // retourner une collection de type T
	
	int update(T obj); // retourner un int (nombre d'objet mise � jour)
	
	int delete(int id); // retourner un int (nombre d'objet efface selon un id)
}
