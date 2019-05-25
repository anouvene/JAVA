package m2i.java.formation.dao;

import java.util.List;


public interface IDAO_Carre<T,F> {

	int Create(T forme, F cote);
    T Retreive(int id);
    List<T> RetreiveAll();
    int Update(T obj);
    int Delete(int id);


}
