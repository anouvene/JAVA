package adelium.cours.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adelium.cours.java.DAO_Personne;
import adelium.cours.java.DAO_Societe;
import adelium.cours.java.Genre;
import adelium.cours.java.IDAO;
import adelium.cours.java.Personne;
import adelium.cours.java.Societe;

/**
 * Servlet implementation class SocieteServlet
 */
@WebServlet("/SocieteServlet")
public class SocieteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocieteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		response.setContentType("text/html"); // Ceci est un flux html		
//		PrintWriter out = response.getWriter();
//		out.append("Prise en charge par la methode doGet \n");
//		
//		int nb1 = Integer.parseInt(request.getParameter("txtNombre1"));
//		int nb2 = Integer.parseInt(request.getParameter("txtNombre2"));
		
		// Somme
//		String str = String.format("La somme de %d et de %d  = %d", nb1, nb2, nb1+nb2);		
//		String resultat = "<table><tr><th>N1</th><th>N2</th><th>Somme</th></tr>";
//		String tr = "<tr><td>" + nb1 + "</td><td>" + nb2 + "</td><td>" + (nb1+nb2) + "</td></tr></table>";	
//		resultat += tr;	
//		out.append(resultat);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Societe by id
		DAO_Societe daos = new DAO_Societe();
		
		
		DAO_Personne daoPersonne = new DAO_Personne();

		switch(request.getParameter("action")) {
			case "READ_ALL_SOCIETE":
				// Reactualiser affichage des societes
//				IDAO<Societe> daoSociete = new DAO_Societe();
//				String societesTR = "<tr>";
//				List<Societe> societes = daoSociete.RetreiveAll();
//				if(!societes.isEmpty()) {
//					for(Societe s : societes) {
//						societesTR += "<td>" + s.get_ID_Societe() + "</td>"
//								+ "<td>" + s.get_Nom() + "</td>"
//								+ "<td>" + s.get_CA() + "</td>"
//								+ "<td>" + s.get_Activite() + "</td>"
//								+ "<td class='actions'>"
//								+ "<a href='#collapsePersonnes' title='Voir les personnes' class='btn btn-primary btn-voir' data-idsociete='" + s.get_ID_Societe() + "'" 
//								+ "data-toggle='collapse' data-target='#collapsePersonnes'><i class='material-icons md-24'>visibility</i></a> "	
//								+ "<a href='#societe' title='Modifier une societe' class='btn btn-warning btn-edit' data-idsociete='" + s.get_ID_Societe() + "'"	
//								+ "data-toggle='modal' data-target='#editSocieteModal'><i class='material-icons md-24'>edit</i></a> "	  
//								+ "<a href='#societe' title='Supprimer une societe' class='btn btn-danger btn-delete' data-idsociete='" + s.get_ID_Societe() + "'><i class='material-icons md-24'>delete_forever</i></a>"									
//								+ "</td>"
//								+ "</tr>";	
//					}	
//				}
//				
//				out.print(societesTR);
				break;
			case "READ_SOCIETE": // MODAL
				int idSociete = Integer.parseInt(request.getParameter("idSociete"));
				Societe societe = daos.Retreive(idSociete);
				
				String infosSociete = "<div class='row'><div class='col'><input type='text' name='idSociete' class='form-control' value='" + idSociete + "' readonly></div>"	  
						  + "<div class='col'><input type='text' name='nomSocieteTxt' value='" + societe.get_Nom() + "' class='form-control'></div>"
						  + "<div class='col'><input type='text' name='caSocieteTxt' value='" + societe.get_CA() + "' class='form-control'></div>"
						  + "<div class='col'><input type='text' name='activiteSocieteTxt' value='" + societe.get_Activite() + "' class='form-control'></div></div><hr>";
						
				// out.append(infosSociete);
				
				List<Personne> personnesDuneSociete = daoPersonne.ListeDesEmployeesDuneSociete(idSociete);
				
				String personnesDuneSocieteTR = "";
					
				personnesDuneSocieteTR += "<table class='table table-condensed' style='border-collapse: collapse;' data-nbpersonnes='"+ personnesDuneSociete.size() + "'>"
				+ "<thead><tr><th scope='col'>Id personne</th><th scope='col'>Nom</th><th scope='col'>Prenom</th><th scope='col'>Poids</th><th scope='col'>Taille</th><th scope='col' colspan='3'>Sexe</th></tr></thead>"
				+ "<tbody id='personnesModalTbody'>";
				
				if(!personnesDuneSociete.isEmpty()) {
					for(Personne personne: personnesDuneSociete) {
						personnesDuneSocieteTR += "<tr>"
								+ "<td>" + "<input type='text' name='idPersonne' value='" + personne.get_ID_Personne() + "' class='form-control' readonly>" + "</td>"
								+ "<td>" + "<input type='text' name='nom' value='" + personne.get_Nom() +  "' class='form-control' readonly>" + "</td>"
								+ "<td>" + "<input type='text' name='prenom' value='" + personne.get_Prenom() + "' class='form-control' readonly>"+ "</td>"
								+ "<td>" + "<input type=''text' name='poids' value='" + personne.get_Poids() + "' class='form-control' readonly>" +"</td>"
								+ "<td>" + "<input type='text' name='taille' value='" + personne.get_Taille() +"' class='form-control' readonly>" +"</td>"
								+ "<td>" + "<input type='text' name='sexe' value='" + personne.get_Sexe() +"' class='form-control' readonly>" +"</td>"
								+ "<td><a href='#' title='Modifier une personne' class='btn btn-success btn-modal-edit'><i class='material-icons md-24'>edit</i></a></td>"		  
								+ "<td><a href='#' title='Supprimer une personne' class='btn btn-danger btn-modal-delete'><i class='material-icons md-24'>delete_forever</i></a></td>"						
								+ "</tr>";
					}
				}
				
				personnesDuneSocieteTR += "</tbody></table>";
				
				out.append(infosSociete + personnesDuneSocieteTR);
				break;
			
			case "READ_ALL_PERSONNES":
				int idSociete2 = Integer.parseInt(request.getParameter("idSociete"));
				Societe societe2 = daos.Retreive(idSociete2);
				
				List<Personne> personnes = societe2.getEmployees();
				String personnesTR = "<tr>";
				
				if(!personnes.isEmpty()) {
					for(Personne personne: personnes) {
						personnesTR += "<td>" + personne.get_ID_Personne() + "</td>"
								+ "<td>" + personne.get_ID_Societe() + "</td>"
								+ "<td>" + personne.get_Nom() + "</td>"
								+ "<td>" + personne.get_Prenom() + "</td>"
								+ "<td>" + personne.get_Poids() +"</td>"
								+ "<td>" + personne.get_Taille() +"</td>"	
								+ "<td>" + personne.get_Sexe().name() +"</td>"
								+ "</tr>";
					}
					
				}

				out.append(personnesTR);
				break;
			default:
				// Reactualiser affichage des societes
				IDAO<Societe> daoSociete = new DAO_Societe();
				String societesTR = "<tr>";
				List<Societe> societes = daoSociete.RetreiveAll();
				if(!societes.isEmpty()) {
					for(Societe s : societes) {
						societesTR += "<td>" + s.get_ID_Societe() + "</td>"
								+ "<td>" + s.get_Nom() + "</td>"
								+ "<td>" + s.get_CA() + "</td>"
								+ "<td>" + s.get_Activite() + "</td>"
								+ "<td class='actions'>"
								+ "<a href='#collapsePersonnes' title='Voir les personnes' class='btn btn-primary btn-voir' data-idsociete='" + s.get_ID_Societe() + "'" 
								+ "data-toggle='collapse' data-target='#collapsePersonnes'><i class='material-icons md-24'>visibility</i></a> "	
								+ "<a href='#societe' title='Modifier une societe' class='btn btn-warning btn-edit' data-idsociete='" + s.get_ID_Societe() + "'"	
								+ "data-toggle='modal' data-target='#editSocieteModal'><i class='material-icons md-24'>edit</i></a> "	  
								+ "<a href='#societe' title='Supprimer une societe' class='btn btn-danger btn-delete' data-idsociete='" + s.get_ID_Societe() + "'><i class='material-icons md-24'>delete_forever</i></a>"									
								+ "</td>"
								+ "</tr>";	
					}	
				}
				
				out.print(societesTR);
				
		}
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		// response.getWriter().append("Prise en charge par la methode doPost");
		// PrintWriter out = response.getWriter();
		
//		if(request.getParameter("action").equals("DELETE_SOCIETE")) {
//			doDelete(request, response);
//		}
		
		
//		Map<String, String[]> mapParams = request.getParameterMap();
//		String[] paramValues = null;
//		for(Map.Entry<String, String[]> e: mapParams.entrySet()) {
//			if(e.getKey().equals("action")) {
//				 paramValues = e.getValue();
//			
//				 for(int i=0; i<paramValues.length; i++) {
					// switch(paramValues[i]) {
					switch(request.getParameter("action1")) {
						case "CREATE_PERSONNE":
			//				System.out.println(request.getParameter("idPersonne"));
			//				System.out.println(request.getParameter("nom"));
			//				System.out.println(request.getParameter("prenom"));
			//				System.out.println(request.getParameter("poids"));
			//				System.out.println(request.getParameter("taille"));
			//				System.out.println(request.getParameter("sexe"));
							
							DAO_Personne daoPersonne = new DAO_Personne();
							Personne p = new Personne(
									Integer.parseInt(request.getParameter("idPersonne")), 
									request.getParameter("nom"),
									request.getParameter("prenom"),
									Float.parseFloat(request.getParameter("poids")),
									Float.parseFloat(request.getParameter("taille")),
									Genre.valueOf(request.getParameter("sexe")),
									Integer.parseInt(request.getParameter("idSociete")));
							
							daoPersonne.Create(p);
						case "CREATE_SOCIETE":
							
							System.out.println(request.getParameter("idSociete"));
							System.out.println(request.getParameter("nomSociete"));
							System.out.println(request.getParameter("activite"));
							System.out.println(request.getParameter("caSociete"));
							
							DAO_Societe dao = new DAO_Societe();
			
							int id = Integer.parseInt(request.getParameter("idSociete"));
							String nom = request.getParameter("nomSociete");
							String activite = request.getParameter("activite");
							float ca = Float.parseFloat(request.getParameter("caSociete"));
			
							// Inserer Societe dans la base de donnees
							Societe s = new Societe(id, nom, activite, ca);
							dao.Create(s);
							int rep = dao.Create(s);
							
							// Reactaualiser les societes
							doGet(request, response);
							break;						
					}
				}		
//			}						
//		}
//	}

	/**
	 * Delete Societe et Personne(s)
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doDelete(req, resp);
		
		PrintWriter out = resp.getWriter();
		
		
		DAO_Personne daoPersonne = new DAO_Personne();
		
		
		// Supprimer ensuite la societe en question
		IDAO<Societe> daoSociete = new DAO_Societe();
		
		
		switch(req.getParameter("action")) {
			case "DELETE_PERSONNE":
				System.out.println(req.getParameter("idSociete"));
				System.out.println(req.getParameter("idPersonne"));
				
				// Supprimer toutes les personnes liees a la socite
				daoPersonne.Delete(Integer.parseInt(req.getParameter("idPersonne")));
				
				break;
			
			default:
				// Supprimer les personne ayant idSociete
				int idSociete = Integer.parseInt(req.getParameter("idSociete"));
				int rep = daoPersonne.supprimeTousLesEmployesDuneSociete(idSociete);
				
				// Supprimer ensuite la societe en question
				int rep2 = daoSociete.Delete(idSociete);
		}
		
		// Reactualiser affichage des societes
		String societesTR = "<tr>";
		List<Societe> societes = daoSociete.RetreiveAll();
		if(!societes.isEmpty()) {
			for(Societe societe : societes) {
				societesTR += "<td>" + societe.get_ID_Societe() + "</td>"
						+ "<td>" + societe.get_Nom() + "</td>"
						+ "<td>" + societe.get_CA() + "</td>"
						+ "<td>" + societe.get_Activite() + "</td>"
						+ "<td class='actions'>"
						+ "<a href='#collapsePersonnes' title='Voir les personnes' class='btn btn-primary btn-voir' data-idsociete='" + societe.get_ID_Societe() + "'" 
						+ "data-toggle='collapse' data-target='#collapsePersonnes'><i class='material-icons md-24'>visibility</i></a> "	
						+ "<a href='#societe' title='Modifier une societe' class='btn btn-warning btn-edit'"	
						+ "data-toggle='modal' data-target='#editSocieteModal'><i class='material-icons md-24'>edit</i></a> "	  
						+ "<a href='#societe' title='Supprimer une societe' class='btn btn-danger btn-delete' data-idsociete='" + societe.get_ID_Societe() + "'><i class='material-icons md-24'>delete_forever</i></a>"									
						+ "</td>"
						+ "</tr>";	
			}	
		}
		
		out.print(societesTR);
		
		
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String action = req.getParameter("action");
		
		IDAO<Societe> daoSociete = new DAO_Societe();
		IDAO<Personne> daoPersonne = new DAO_Personne();
		
		
		switch(action) {
			case "UPDATE_SOCIETE" :
//				System.out.println(req.getParameter("idSociete"));
//				System.out.println(req.getParameter("nom"));
//				System.out.println(req.getParameter("ca"));
//				System.out.println(req.getParameter("activite"));
				
				int idSociete = Integer.parseInt(req.getParameter("idSociete"));
				String nom = req.getParameter("nom");
				Float ca = Float.parseFloat(req.getParameter("ca"));
				String activite = req.getParameter("activite");
				
				
				
				Societe societe = daoSociete.Retreive(idSociete);
//				System.out.println(societe);
				
				societe.set_Nom(nom);
				societe.set_CA(ca);
				societe.set_Activite(activite);
				
				// Update Societe
				daoSociete.Update(societe);
				doGet(req, resp);
				
				break;
			case "UPDATE_PERSONNE":
//				System.out.println(req.getParameter("idPersonne"));
//				System.out.println(req.getParameter("nom"));
//				System.out.println(req.getParameter("prenom"));
//				System.out.println(req.getParameter("poids"));
//				System.out.println(req.getParameter("taille"));
//				System.out.println(req.getParameter("sexe"));
				
				Personne personne = daoPersonne.Retreive(Integer.parseInt(req.getParameter("idPersonne")));
				personne.set_Nom(req.getParameter("nom"));
				personne.set_Prenom(req.getParameter("prenom"));
				personne.set_Poids(Float.parseFloat(req.getParameter("poids")));
				personne.set_Taille(Float.parseFloat(req.getParameter("taille")));
				personne.set_Sexe(Genre.valueOf(req.getParameter("sexe")));
				
				int rep = daoPersonne.Update(personne);
				
				break;
				
		}
		
		
		
		
		
	}
	
	

	
	

}
