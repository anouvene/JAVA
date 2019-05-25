package m2i.java.formation.dao;

import java.util.List;

public interface IDAO_Rectangle<T, L, l> {

	int Create(T forme, L longueur, l largeur);
    T Retreive(int id);
    List<T> RetreiveAll();
    int Update(T obj);
    int Delete(int id);
}
