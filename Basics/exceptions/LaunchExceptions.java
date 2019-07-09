package hb.java.exceptions;

//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
// import java.util.Stack;

public class LaunchExceptions {

	public static void main(String[] args) throws ClassNotFoundException/*, SQLException*/, NoMoreTimeAvailable {
		// NullPointerException
		// String str = null;
		// System.out.println(str.contains("Nono"));

		// ArithmeticException
//		int nb1 = 5;
//		int nb2 = 0;
		// int nb3 = nb1/nb2;		
		// System.out.println(nb3);
		
		// ArrayIndexOutBoundsException
		// int[] tab = new int[2];
		// tab[3] = 5;
		
		// NoSuchElementException
		// Stack<String> stack = new Stack<String>();
		// stack.firstElement();
		
		// EmptyStackException
		// stack.pop();
		
		// IllegalArgumentException
		// List<String> names = new ArrayList<String>(-5);
		
		// ClassNotFoundException : Try, Catch, finally
		
//		try {
//			Class.forName("toto");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			System.out.println("Classe inexistante");
//		}
		
		
		// Throws
		Exceptions e = new Exceptions();
		try {
			// e.method(1); // java.lang.ClassNotFoundException: toto
			e.method(5); // java.lang.Object
		} catch(ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		
		// Throw
		System.out.println(e.method(5, 3));
		// System.out.println(e.method(2, 5));
		
		// Exception personnalisée
		Chrono chrono = new Chrono();
		chrono.play();
		chrono.play();
		chrono.play();
		chrono.play();
		chrono.play();
		chrono.play(); // Exception NoMoreTimeAvailable
				
	}

}
