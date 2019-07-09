package hb.java.testHashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MyMap {
	private Map<String, String> fruits;
	
	public MyMap() {
		fruits = new HashMap<String, String>();
	}

	/**
	 * @return the fruits
	 */
	public Map<String, String> getFruits() {
		return fruits;
	}

	/**
	 * @param fruits the fruits to set
	 */
	public void setFruits(Map<String, String> fruits) {
		this.fruits = fruits;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode(String key) {
		return key.hashCode();
	}
	
	/**
	 * Encode keys of fruits map
	 * @param fruits Map<String, String)
	 * @return Map<Integer, String)
	 */
	public Map<Integer, String> getfruitsEncode(Map<String, String> fruits) {
		Map<Integer, String> fruitsEncode = new TreeMap<Integer, String>();
		Iterator<Entry<String, String>> iterFruits = fruits.entrySet().iterator();
		while(iterFruits.hasNext()) {
			Map.Entry<String, String> me = (Entry<String, String>)iterFruits.next();
			fruitsEncode.put(me.getKey().hashCode(), me.getValue());
		}
		
		return fruitsEncode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyMap other = (MyMap) obj;
		if (fruits == null) {
			if (other.fruits != null)
				return false;
		} else if (!fruits.equals(other.fruits))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyMap [fruits=" + fruits + ", getFruitsEncode(fruits)=" + getfruitsEncode(this.fruits) + "]";
	}

	
	
	
	
	
	
}
