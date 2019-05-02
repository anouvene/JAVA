package m2i.formation.java.idao;

import java.util.List;

public interface IDAO_Eleve<T> {
	int create(T obj); // retourner un int (nombre d'objet insere)
	
	T retreive(int id); // retourner un obj de type T selon son id
	
	List<T> retreiveAll(); // retourner une collection de type T
	
	int update(T obj); // retourner un int (nombre d'objets mis a jour)
	
	int delete(int id); // retourner un int (nombre d'objet efface)
}
