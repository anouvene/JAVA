package adelium.cours.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adelium.cours.java.DAO_Personne;
import adelium.cours.java.DAO_Societe;
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
		
		
		DAO_Societe daos = new DAO_Societe();
		int idSociete = Integer.parseInt(request.getParameter("idSociete"));
		Societe societe = daos.Retreive(idSociete);
		
		List<Personne> personnes = societe.getEmployees();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		// response.getWriter().append("Prise en charge par la methode doPost");
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("action").equals("DELETE_SOCIETE")) {
			doDelete(request, response);
		}
	}

	/**
	 * Delete Societe et Personne(s)
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doDelete(req, resp);
		
		PrintWriter out = resp.getWriter();
		
		// Supprimer les personne ayant idSociete
		DAO_Personne daoPersonne = new DAO_Personne();
		int idSociete = Integer.parseInt(req.getParameter("idSociete"));
		int rep = daoPersonne.supprimeTousLesEmployesDuneSociete(idSociete);
		
		// Supprimer ensuite la societe en question
		IDAO<Societe> daoSociete = new DAO_Societe();
		int rep2 = daoSociete.Delete(idSociete);
		
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

	
	

}
