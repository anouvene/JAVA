package m2i.formation.java;

import java.util.ArrayList;
import java.util.List;

public class CollectionGrille {

	private List<Grille> grilles = new ArrayList<>();
	
	public CollectionGrille() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Generer les grilles
	 * @param nombre Nombre de grilles voulues
	 */
	public void genererGrilles(int nombre) {
		for(int i=0; i<nombre; i++) {
			this.grilles.add(new Grille());
		}
	}

	// Affichage
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(!grilles.isEmpty()) {
			builder.append("\n========= Grilles: ========= \n");
			for(Grille grille : grilles) {
				builder.append(grille + "\n");
			}
		} else {
			builder.append("\n========= Grilles: ========= \n");
			builder.append("Au revoir !!!");
		}
		
		return builder.toString();
	}
}
