package hb.java.cast;

import java.util.ArrayList;
import java.util.List;

public class LaunchCast {

	public static void main(String[] args) {
		List<Object> names = new ArrayList<Object>();
		
		// Cast Object to String
		names.add("toto");
		String name = (String) names.get(0);
		System.out.println(name);
		
		// Cast Object to int
		names.add(6);
		int number = (int) names.get(1);
		System.out.println(number + 2);
		
		// Cast Node en element (voir exemple lecture xml)
		

	}

}
