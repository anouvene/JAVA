package m2i.formation.java;

import java.util.ArrayList;
import java.util.List;

public class Forme {
	// Liste de Point
	List<Point> lstPoints = new ArrayList<>();
	
	/**
	 * Ajouter un Point dans lstPoints
	 * @param P Point à ajouter
	 */
	public void addPoint(Point p) {
		this.lstPoints.add(p);
	}
	
	/**
	 * Retourner le Point ayant le plus petit module
	 * @return Point Le Point de la liste
	 */
	public Point mini() {
		int posMin = 0;
		
		try {
			double moduleMin = lstPoints.get(0).module();
			
			for(int i=1; i<lstPoints.size(); i++) {
				if(lstPoints.get(i).module() < moduleMin) {
					moduleMin = lstPoints.get(i).module();
					posMin = i;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			// e.printStackTrace();
			System.out.println("Liste invalide");
			return null;
		}
		
		return lstPoints.get(posMin);
	}
	
	/**
	 * Retourner l'indice du Point ayant le plus petit module et à partir d'une position de début de liste
	 * @param debut Position de départ de la liste de Point
	 * @return int Position de départ de liste
	 */
	public int indiceMin(int debut) {
		int posMin = debut;
		
		try {
			double moduleMin = lstPoints.get(debut).module();
			
			for(int i=debut+1; i<lstPoints.size(); i++) {
				if(lstPoints.get(i).module() < moduleMin) {
					moduleMin = lstPoints.get(i).module();
					posMin = i;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			// e.printStackTrace();
			System.out.println("La position de début de liste est invalide !!!");
			posMin = -1;
		}
		
		return posMin;
	}
	
	/**
	 * Permuter 2 Points en se basant sur leur position dans la liste
	 * @param pos1 Position du premier Point
	 * @param pos2 Position du 2ième Point
	 */
	public void permuter(int pos1, int pos2) {
		try {
			Point pointTmp = lstPoints.get(pos1);
			lstPoints.set(pos1, lstPoints.get(pos2));
			lstPoints.set(pos2, pointTmp);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La position de début de liste est invalide !!!");
		}	
	}
	
	/**
	 * Trier la liste lstPoints dans l'odre croissant
	 * et du plus petit module au plus grand 
	 */
	public void trier() {		
		for(int i=0; i<lstPoints.size()-1; i++) {
			permuter(indiceMin(i), i);
		}
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return "lstPoints=" + lstPoints;
	}
}
