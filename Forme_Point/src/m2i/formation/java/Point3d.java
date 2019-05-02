package m2i.formation.java;

public class Point3d extends Point {
	private int z;
	
	public Point3d(int x, int y, int z) {
		super(x, y) ;
		this.z = z ;  
	}
	/**
	 * Surcharge de la methode 
	 * Initialise de la classe point (meme nom mais signature dif)
	 * @param dx
	 * @param dy
	 * @param dz
	 */
	public void Initialise(int dx, int dy, int dz) {
		System.out.println("point 3d");
		super.initialise(dx, dy); //super appel le initialise la classe point => met dx et dy dans x et y
		this.z =dz;
	}
	
	/**
	 * Redefinition de la methode affiche et 
	 * non une surcharge car meme nom et meme signature
	 */
	@Override
	public String affiche() {
		return "(" + x + "," + y + "," + z + ")";
	}

	@Override
	public double module() {
		return Math.sqrt(x*x + y*y + z*z);
	}

	@Override
	public String toString() {
		return "(x= " + x + ", y= " + y + ", z= " + z + ")";
	}
}
