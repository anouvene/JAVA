package m2i.java.formation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import m2i.java.formation.business.Carre;
import m2i.java.formation.business.Cercle;
import m2i.java.formation.business.Forme;
import m2i.java.formation.business.Rectangle;
import m2i.java.formation.dao.IDAO_Forme;
import m2i.java.formation.dao.IDAO_Carre;
import m2i.java.formation.dao.IDAO_Cercle;
import m2i.java.formation.dao.IDAO_Rectangle;
import m2i.java.formation.dao.impl.DAO_Carre;
import m2i.java.formation.dao.impl.DAO_Cercle;
import m2i.java.formation.dao.impl.DAO_Forme;
import m2i.java.formation.dao.impl.DAO_Rectangle;

/**
 * Servlet implementation class FormeServlet
 */
@WebServlet("/forme")
public class FormeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IDAO_Forme<Forme> daoForme;
	private IDAO_Cercle<Forme, Float> daoCercle;
	private IDAO_Carre<Forme, Float> daoCarre;
	private IDAO_Rectangle<Forme, Float, Float> daoRectangle;

	private Gson gson;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormeServlet() {
		super();

		daoForme = new DAO_Forme();
		daoCercle = new DAO_Cercle();
		daoCarre = new DAO_Carre();
		daoRectangle = new DAO_Rectangle();

		gson = new GsonBuilder().create();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		switch (request.getParameter("action")) {
		case "READ_FORMES":

			// Recuperer toutes les formes
			List<Forme> formes = daoForme.RetreiveAll();

			// Retourner les formes en JSON au client
			String formesJSON = gson.toJson(formes);
			out.append(formesJSON);

			break;

		case "DESSINER":

			System.out.println("dessiner" + request.getParameter("action"));
			System.out.println("id" + request.getParameter("idForme"));
			System.out.println("nom_forme" + request.getParameter("nomForme"));

			switch (request.getParameter("nomForme").toLowerCase()) {
			case "cercle":
				Cercle cercle = (Cercle) daoCercle.Retreive(Integer.parseInt(request.getParameter("idForme")));
				String cercleJSON = gson.toJson(cercle);
				out.append(cercleJSON);
				
				break;
			case "rectangle":
				Rectangle rectangle = (Rectangle) daoRectangle.Retreive(Integer.parseInt(request.getParameter("idForme")));
				String rectangleJSON = gson.toJson(rectangle);
				out.append(rectangleJSON);
				break;
			case "carre":
				Carre carre = (Carre) daoCarre.Retreive(Integer.parseInt(request.getParameter("idForme")));
				String carreJSON = gson.toJson(carre);
				out.append(carreJSON);
				break;
			}

//			String txtjson = gson.toJson("test");
//			out.append(txtjson);

			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Gson gson = new GsonBuilder().create();

		String formeJSON = request.getParameter("f");
		Forme forme = gson.fromJson(formeJSON, Forme.class);

		// CREER FORME EN PREMIER
		System.out.println(daoForme.Create(forme));

		switch (request.getParameter("action")) {
			case "CREATE_CERCLE":
				System.out.println(daoCercle.Create(forme, Float.parseFloat(request.getParameter("r"))));
				break;
	
			case "CREATE_CARRE":
				System.out.println(daoCarre.Create(forme, Float.parseFloat(request.getParameter("c"))));
				break;
	
			case "CREATE_RECTANGLE":
				System.out.println(daoRectangle.Create(forme, Float.parseFloat(request.getParameter("lo")),
						Float.parseFloat(request.getParameter("la"))));
				break;
		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
