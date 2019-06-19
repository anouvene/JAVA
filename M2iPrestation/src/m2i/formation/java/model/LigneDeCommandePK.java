package m2i.formation.java.model;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * Le modèle de base de données relationnelle permet la définition d'une clé primaire composée de plusieurs colonnes. 
 * Ici, la clé primaire de notre Entity est composée de 2 clés: id_produit et id_commande
 * 
 * L'API Java Persistence propose deux façons de gérer ce cas de figure :
 * L'annotation @javax.persistence.IdClass
 * L'annotation @javax.persistence.EmbeddedId
 * 
 * L'annotation @IdClass s'utilise avec une classe qui va encapsuler les propriétés qui composent la clé primaire. 
 * Cette classe doit obligatoirement :
 * 
 * Être sérialisable
 * Posséder un constructeur sans argument
 * Fournir une implémentation dédiée des méthodes equals() et hashCode()
 * 
 * @author antoinenouvene
 *
 */
public class LigneDeCommandePK implements Serializable {

	private static final long serialVersionUID = 6494674018776321487L;
	
	private int id_produit;
	private int id_commande;
	
	public LigneDeCommandePK() {}

	public LigneDeCommandePK(int id_produit, int id_commande) {
		this.id_produit = id_produit;
		this.id_commande = id_commande;
	}

	// GETTERS & SETTERS
	
	@Column(name = "id_produit")
	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	@Column(name = "id_commande")
	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	
	@Override
    public int hashCode() {
        return id_produit + id_commande;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LigneDeCommandePK){
        	LigneDeCommandePK ligneDeCommandePk = (LigneDeCommandePK) obj;
            return ligneDeCommandePk.id_produit == id_produit && ligneDeCommandePk.id_commande == id_commande;
        }

        return false;
    }
}
