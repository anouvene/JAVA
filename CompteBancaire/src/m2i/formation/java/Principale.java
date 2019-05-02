package m2i.formation.java;

import java.text.DecimalFormat;

public class Principale {

	public static void main(String[] args) {
		Compte c1 = new Compte(1, "Nguyen", "Tuan", 1000.00f, 20);
		// ====================================================
		// ======== Test débit bancaire =======================
		// ====================================================
		//c1.debiter(500.00f);
		// Nouveau solde disponible: 500.0 €
		
		//c1.debiter(1000.00f);
		// Nouveau solde disponible: 0.0 €
		
		//c1.debiter(1200.00f);
		// Nouveau solde disponible: -200.0 €
		// Attention vous êtes débiteur, la banque peut vous prélever les intérêts !!!
		
		c1.debiter(1500.00f);
		// Nouveau solde disponible: -500.0 €
		// Attention vous êtes débiteur et vous avez atteint la limite du découvert autorisé(500.0 €)
		
		// =====================================================
		// ======== Intérêt bancaire compte débiteur ===========
		// =====================================================
		DecimalFormat df = new DecimalFormat("##.00");
		System.out.println("Votre montant de pénalité de découvert est de : " +df.format(c1.calculerInteret()) +" €");
		// Le montant de pénalité de découvert est de : 21.92 €
		
		//c1.debiter(1550.00f);
		// Retrait non autorisé car -550.0 € dépasse le montant de découvert autorisé(500.0 €)
	}

}
