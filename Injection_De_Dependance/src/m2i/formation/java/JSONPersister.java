package m2i.formation.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONPersister implements IPersister {
	
	@Override
	public void persist(Object o, Class<?> to) {
		System.out.println("Sauvegarde au format JSON");
		
		GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
		final Gson gson = builder.create();

		gson.fromJson((String) o, to.getClass());	
		
	}
}
