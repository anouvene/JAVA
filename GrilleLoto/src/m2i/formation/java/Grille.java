package m2i.formation.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Grille {
	private List<Integer> numeros;
	private Random rand;
	private int numeroCompl;
	
	public Grille() {
		this.numeros = new ArrayList<>();
		this.rand = new Random();
		// Generer 5 numeros + 1 complementaire de 1 ... 10
		this.genererNumeros();
		this.numeroCompl = this.rand.nextInt(9) + 1;
	}
	
	/**
	 * Verifier si un numero existe dans la liste
	 * @param num Numero a verifier
	 * @return Boolean Valeur boollenne retournee
	 */
	public boolean nombreExiste(int num) {
//		for(int numero : numeros) {
//			if(numero == num) {
//				return true;
//			}
//		}
		
		if(numeros.contains(num)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Generer 5 numeros de tirage du Loto
	 * @return List<Integer> Liste de 5 numeros type entier 
	 */
	public List<Integer> genererNumeros() {
		for(int i=0; i<5; i++) {
			int nombreAleatoire = rand.nextInt(48) + 1;
			// Appel de la methode de verification
//			if(this.nombreExiste(nombreAleatoire)) {
//				nombreAleatoire = rand.nextInt(48) + 1;
//			}
			// Verifier si pas de doublon dans la liste via le methode contains()
			if(numeros.contains(nombreAleatoire)) {
				nombreAleatoire = rand.nextInt(48) + 1;
			}
			this.numeros.add(nombreAleatoire);
		}			
		return this.numeros;
	}

	// Affichage grille
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nGrille ");
		builder.append(numeros);
		builder.append("[" + this.numeroCompl + "]");
		return builder.toString();
	}
}
