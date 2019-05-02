package m2i.formation.java;

public class Point 
{
	protected int x;
	protected int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void initialise(int dx, int dy) {
		System.out.println("point 2d");
		this.x=dx;
		this.y=dy;
	}
	
	public String affiche() {
		return "(" + this.x + "," + this.y + ")" ;
	}
	
	public double module() {
		return Math.sqrt(x*x + y*y);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(")");
		return builder.toString();
	}
	
	
}
