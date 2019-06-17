package m2i.formation.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import m2i.formation.java.pojos.Ecurie;
import m2i.formation.java.service.EcurieService;

/**
 * Servlet implementation class EcurieSerlet
 */
@WebServlet("/ecurie")
public class EcurieSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdeliumService"); // <persistence-unit name="AdeliumService" transaction-type="RESOURCE_LOCAL">	
	private EntityManager em = emf.createEntityManager();

	private EcurieService es;
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EcurieSerlet() {
    		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		es = new EcurieService(em);   
		
		em.getTransaction().begin();
			es.retreiveAll();
		em.getTransaction().commit();
		
		// Retourner la liste des ecuries
		List<Ecurie> ecuries = es.retreiveAll();
		System.out.println(ecuries);
		gson = new GsonBuilder().create();
		gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); // Ne serialiser que id et nom
		String ecuriesJSON = gson.toJson(ecuries);
		System.out.println("Ecuries retournees: " + ecuriesJSON);
		out.append(ecuriesJSON);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		System.out.println("Servlet doPost en action : " + request.getParameter("ecurie"));
		gson = new GsonBuilder().create();
		Ecurie ecurie = gson.fromJson(request.getParameter("ecurie"), Ecurie.class);
		System.out.println("Ecurie objet: " + ecurie);
		
		es = new EcurieService(em);   
		em.getTransaction().begin();
			es.create(ecurie);
		em.getTransaction().commit();
		
		// Retourner la liste des ecuries
		List<Ecurie> ecuries = es.retreiveAll();
		System.out.println(ecuries);
		gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); // Ne serialiser que id et nom
		String ecuriesJSON = gson.toJson(ecuries);
		System.out.println("Ecuries retournees: " + ecuriesJSON);
		out.append(ecuriesJSON);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
