package adelium.cours.java.business;

import java.util.ArrayList;
import java.util.List;

public class Societe
{
    private int id ;
    private String nom;

//    private List<Personne> Employees = new ArrayList<Personne> ();
//    
//    public void setEmployees(List<Personne> employees) {
//		Employees = employees;
//	}
//
//	public List<Personne> getEmployees() {
//		return Employees;
//	}
    
    
    /**
     * Attention toujours un constructeur par défaut sans parametres pour le service POST
     */
    public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    public Societe(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	

	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

    
    
    
    
    
}
