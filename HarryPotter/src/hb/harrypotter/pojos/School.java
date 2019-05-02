package hb.harrypotter.pojos;

import java.util.Arrays;

public class School {
	private int id;
	private String name;
	private String desc;
	private String[] keywords;
	
	public School(int identifier, String n, String d, String[] k) {
		this.id = identifier;
		this.name = n;
		this.desc = d;
		this.keywords = k;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	
	/**
	 * Les mots clés
	 * @param keys Tableau de keywords
	 * @return String Chaine de mots clés
	 */
	private String transformTabToString(String[] keys) {
		return keys.toString();
	}

	@Override
	public String toString() {
		return "["
				+ "id=" + id
				+ ", name=" + name 
				+ ", desc=" + desc 
				+ ", tab =" + transformTabToString(keywords)
				+ "]";
	}

}
