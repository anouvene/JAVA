package m2i.formation.java.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Relation particuliere OneToOne entre Facture et Commande
 * Liaison unidirectionnelle avec @OneToOne + @MapsId
 * Cela signifie que l'id de facture est a la fois clé primaire et cle etrangere de id commande
 * 
 * Lire explication: https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate
 * 
 * @author antoinenouvene
 *
 */
@Entity
@Table(name="facture")
public class Facture {
	
	@Id
	private int id;
	
	private float total_ht;
	private Date date_facture;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	private Commande commande;
	
	public Facture() {}
	
	public Facture(float total_ht, Date date_facture) {
		super();
		this.total_ht = total_ht;
		this.date_facture = date_facture;
	}
	
	public Facture(int id_facture, float total_ht, Date date_facture, Commande commande) {
		this.id = id_facture;
		this.total_ht = total_ht;
		this.date_facture = date_facture;
		this.commande = commande;
	}

	public int getId_facture() {
		return id;
	}
	
	public void setId_facture(int id_facture) {
		this.id = id_facture;
	}
	
	public float getTotal_ht() {
		return total_ht;
	}
	
	public void setTotal_ht(float total_ht) {
		this.total_ht = total_ht;
	}
	
	public Date getDate_facture() {
		return date_facture;
	}
	
	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}

}
