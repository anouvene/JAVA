package m2i.formation.java;

public class Principale {
	public static void main(String[] args) {
		Point p1 = new Point(1, 5);
		Point p2 = new Point3d(1, 5, 10);
		Point p3 = new Point(1, 10);
		Point p4 = new Point3d(1, -20, 20);
		Point p5 = new Point3d(-10, 30, 40);
		
		Forme f1 = new Forme();
		f1.addPoint(p5);		
		f1.addPoint(p2);
		f1.addPoint(p1);
		f1.addPoint(p4);
		f1.addPoint(p3);
				
		System.out.println("================> Liste avant tri:");
		System.out.println(f1);

		System.out.println("\n==============> Point avec le plus petit module dans la liste:");
		System.out.println(f1.mini());
		
		System.out.println("\n==============> l'index du Point ayant le plus petit module dans la liste et à partir de la positon 3 inclue");
		System.out.println(f1.indiceMin(3));

		System.out.println("================> Liste aprs tri:");
		f1.trier();
		System.out.println(f1);
	}

}
