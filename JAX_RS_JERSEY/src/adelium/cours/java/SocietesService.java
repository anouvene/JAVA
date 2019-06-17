package adelium.cours.java;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import adelium.cours.java.business.Societe;
// import adelium.cours.java.business.Societe;

@Path("/societes")
public class SocietesService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String retreiveAllJSON() {
		// Gson gson = new GsonBuilder().create();
		// Personne p1 = new Personne("NGUYEN", "Tuan", "Un bonjour de la part de
		// Tuan");

		return "{\"message\":\"Liste de toutes les soiétés\"}";

	}

	// Utilisation des PathParam(s)
	@GET
	@Path("{idSociete}")
	public String retreiveOneJSON(@PathParam("idSociete") float idSociete) {
		return "{\"message\":\"Sociéte " + idSociete + " récupérée avec succès\"}";
	}

	// Utilisation des PathParam(s)
	@GET
	@Path("{idSociete}/personnes")
	public String retreiveAllSocietePersonneJSON(@PathParam("idSociete") float idSociete) {
		return "{\"message\":\"Liste des personnes de la soiété " + idSociete + "\"}";
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Societe ajoutSociete(Societe s) {
		s.setId(1);
		s.setNom("GFI");
		return s;
	}

	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Societe updateSociete(Societe s) {
		//s.setId(2);
		//s.setNom("SNCF");
		return s;
	}
	
	@DELETE
	@Path("{idSociete}")
	public String deleteSociete(@PathParam("idSociete") float idSociete) {
		return "{\"message\":\"Sociéte " + idSociete + " supprimée avec succès\"}";
	}

}
