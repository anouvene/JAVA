package m2i.formation.java;

/**
 * 
 * @author antoinenouvene
 *
 */
public class Compte {
	private int idCompte;
	private String nom, prenom;
	private float solde;
	private final float decouvertAutorise = 500.00f;
	private int dureeDecouvert; // Durée découvert(en nombre de jours) non geree
	private final float limiteDureeDecouvert = 20; // Durée limite(en nombre de jours) de découvert à partir de laquelle une pénalité est appliquable
	private final float tauxAgios = 0.80f;
	
	
	/**
	 * Initialisation
	 * @param idCompte Identifiant commpte
	 * @param nom Nom détenteur
	 * @param prenom Prénom détenteur
	 * @param solde Solde en cours
	 * @param dureeDecouvert Durée de découvert en nombre de jours
	 */
	public Compte(int idCompte, String nom, String prenom, float solde, int dureeDecouvert) {
		super();
		this.idCompte = idCompte;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
		this.dureeDecouvert = dureeDecouvert;
	}
	
	// Getters & Setters
	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public int getDureeDecouvert() {
		return dureeDecouvert;
	}

	public void setDureeDecouvert(int dureeDecouvert) {
		this.dureeDecouvert = dureeDecouvert;
	}

	public float getDecouvertAutorise() {
		return decouvertAutorise;
	}
	
	/**
	 * Créditer le solde
	 * @param credit Montant crédité
	 */
	public void crediter(float credit) {
		this.solde += solde;
	}
	
	/**
	 * Débiter le solde
	 * @param debit Montant débité
	 */
	public void debiter(float debit) {
		// Ressource totale disponible inclus découvert autorisé
		float totalDispo = (solde + decouvertAutorise) - debit;
		
		// Solde réel disponible en cours 
		this.solde -= debit;
				
		if(totalDispo >= 0) { // Retrait accordé car Ressource totale positive
			System.out.println("Nouveau solde disponible: " + solde + " €");
			if(solde < 0) { // Solde débiteur
				if(Math.abs(solde) == decouvertAutorise) { // Débiteur et limite découvert atteint
					System.out.println("Attention vous êtes débiteur et vous avez atteint la limite du découvert autorisé(" +decouvertAutorise +" €)");
				} else { // Débiteur
					System.out.println("Attention vous êtes débiteur, la banque peut vous prélever les intérêts !!!\n");				
				}
			}
		} else { // Retrait refusé car découvert dépassé
			System.out.println("Retrait non autorisé car " +solde +" € dépasse le montant de découvert autorisé(" +decouvertAutorise +" €)");
		}	
	}
	
	/**
	 * Cacul intérêt bancaire sur un compte débiteur dépassant la limite légale de découvert
	 * @return float Intérêt bancaire
	 */
	public float calculerInteret() {
		float interetBancaire = 0.00f;
		
		if(solde < 0 && dureeDecouvert >= limiteDureeDecouvert && solde < 0) {
			interetBancaire =  Math.abs((solde * dureeDecouvert * tauxAgios) / 365);
		}
		
		return interetBancaire;
	}

	@Override
	public String toString() {
		return "Compte ["
				+ "idCompte=" + idCompte 
				+ ", nom=" + nom 
				+ ", prenom=" + prenom 
				+ ", solde=" + solde
				+ ", decouvertAutorise=" + decouvertAutorise 
				+ ", dureeDecouvert=" + dureeDecouvert + "]";
	}
}
