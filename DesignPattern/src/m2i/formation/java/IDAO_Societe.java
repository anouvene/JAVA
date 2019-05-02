package m2i.formation.java;

import java.util.List;

public interface IDAO_Societe<S, P> {
	int create(S obj); // retourner un int (nombre d'objet ins�r�)
	
	
	S retreive(int id); // retourner un obj de type T selon son id
	
	List<S> retreiveAll(); // retourner une collection de type T
	List<P> retreivePersons(S societe); // Ajouter et retourner une collection de Personnes appartenant à la Societe
	
	int update(S obj); // retourner un int (nombre d'objet mise � jour)
	
	int delete(int id); // retourner un int (nombre d'objet efface selon un id)

}
