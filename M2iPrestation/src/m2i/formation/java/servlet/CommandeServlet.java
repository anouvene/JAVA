package m2i.formation.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import m2i.formation.java.model.Produit;
import m2i.formation.java.service.ProduitService;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet("/commande")
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdeliumService");	
	private EntityManager em = emf.createEntityManager();
	
	private List<Produit> produits = new ArrayList<Produit>();
	
	private Gson gson =  new GsonBuilder().create();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		
		ProduitService ps = new ProduitService(em);
		
		em.getTransaction().begin();
		produits = ps.retreiveAll();
		em.getTransaction().commit();
		
		System.out.println("Notre liste de produits : "+ produits);
	
		
		
		
		out.append(gson.toJson(produits));
		//request.getRequestDispatcher(path).forward(request, response);
		//dans request on n'a nos donn�es et on peut rajouter d'autres donn�es
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPost() en action ...");
		
		
		
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
