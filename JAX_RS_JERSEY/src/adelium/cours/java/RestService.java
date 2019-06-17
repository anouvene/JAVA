package adelium.cours.java;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adelium.cours.java.business.Personne;

@Path("/adelium")
public class RestService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String SalutationText() {
		return "Bienvenue à la formation Services Web Rest";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String SalutationXML() {
		String rep = "<?xml version = '1.0' encoding = 'UTF-8' ?>";
		rep += "<salutation>Bienvenue à la formation Services Web Rest</salutation>";
		return rep;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String SalutationHTML() {
		return "<h1 style='color:blue'>Bienvenue à la formation Services Web Rest</h1>";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String SalutationJSON() {
		Gson gson = new GsonBuilder().create();
		Personne p1 = new Personne("NGUYEN", "Tuan", "Un bonjour de la part de Tuan");

		return gson.toJson(p1);
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String AjoutEntite() {
		return " Entité ajoutée avec succès";
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String ModifieEntite() {
		return "Entité modifiée avec succès";
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String SupprimeEntite() {
		return "Entité suprimée avec succès";
	}

}
