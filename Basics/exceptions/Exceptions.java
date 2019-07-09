package hb.java.exceptions;

import java.sql.SQLException;

public class Exceptions {
	/**
	 * Throws exceptions
	 * @param num
	 * @throws ClassNotFoundException Exception throwable
	 * @throws SQLException Exception throwable
	 */
	public void method(int num) throws ClassNotFoundException/*, SQLException*/{
		if(num == 1) {
			System.out.println("Nombre trop petit");
			Class.forName("toto");
		} else {
			Class<?> obj = Class.forName("java.lang.Object");
			System.out.println(obj.getCanonicalName());
		}	
	}
	
	/**
	 * Throw exception
	 * @param nb1 int
	 * @param nb2 int
	 * @return int if not exception
	 */
	public int method(int nb1, int nb2){
		if(nb1 < nb2) {
			throw new ArithmeticException();
		} else {
			return nb1 - nb2;
		}		
	}
}
