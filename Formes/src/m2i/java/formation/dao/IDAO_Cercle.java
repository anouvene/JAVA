package m2i.java.formation.dao;

import java.util.List;

public interface IDAO_Cercle<T, F> {
	int Create(T obj, F rayon);
    T Retreive(int id);
    List<T> RetreiveAll();
    int Update(T obj);
    int Delete(int id);
}
