package hb.java.operations;

public class Operation {

	private double result = 0;
	
	public double calculate(char op, double a, double b) throws AMustBiggerThanB{
		if (a < b) {
			throw new AMustBiggerThanB("A doit être plus grand que B !");
		} else {
			switch(op) {
				case '+' :
					result =  a + b;
					break;
				case '-' :
					result = a - b;
					break;
				case '*' :
					result = a * b;
					break;
				case '/' :
					if (b == 0) {
						throw new IllegalArgumentException("DIVISION PAR ZERO !!!");					
					} else {
						result = a / b;
					}						
					break;
				default :
					return a;
			}
		}
		
		return result;
	}

	
	@Override
	public String toString() {
		return "Operation [Resultat de l'opération : " + result + "]";
	}

	
}
