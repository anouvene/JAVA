package m2i.java.formation.dao;

import java.util.List;

public interface IDAO_Forme <T>
{
    int Create(T obj);
    T Retreive(int id);
    List<T> RetreiveAll();
    int Update(T obj);
    int Delete(int id);    
}
