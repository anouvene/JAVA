package hb.java.env;

public class LaunchEnv {

	public static void main(String[] args) {
		// Path env
		Environnement env = new Environnement();
		String path = env.getPath();		
		System.out.println("Path : " + path);
		
		// Propri�t�s syst�mes
		System.out.println("Toutes les propri�t�s de la classe Envronnement : \n");
		env.printProperties();
		
		// Setter et getter sur une propri�t�
		env.setProperty("fruit1", "Pomme");
		String valueOfproperty = env.getProperty("fruit1");
		System.out.println("Valeur de la propri�t� fruit1 : " + valueOfproperty);
		
		// R�cup�rer les arguments du main
		String arg1 = args[0];
		String arg2 = args[1];
		
		// Les afficher
		System.out.println("\nArgument1 : " + arg1 + "\n");
		System.out.println("Argument2 : " + arg2 + "\n");
		
		

	}

}
