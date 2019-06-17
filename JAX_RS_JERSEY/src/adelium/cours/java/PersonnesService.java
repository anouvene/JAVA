package adelium.cours.java;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/personnes")
public class PersonnesService {

	// Utilisation des PathParam(s)
	@GET
	@Path("{poids}/{taille}")
	public float IMC(@PathParam("poids") float poids, @PathParam("taille") float taille) {
		return poids / (taille * taille);
	}

	@GET
	public float PoidsMin(@QueryParam("taille") float taille) {
		return (19 * taille * taille);
	}

}
