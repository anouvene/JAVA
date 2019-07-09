package hb.java.testHashmap;

import java.util.Arrays;

public class School {
	private int id;
	private String name;
	private String desc;
	private String[] keywords;
	
	/**
	 * @param id
	 * @param name
	 * @param desc
	 * @param keywords
	 */
	public School(int id, String name, String desc, String[] keywords) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.keywords = keywords;
	}

	/*
	 * =============================
	 * GETTRES AND SETTERS
	 * =============================
	 */
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	/*
	 * ==============================================
	 * Display : id, name, desc, keywords
	 * ==============================================
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("School [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", keywords=");
		builder.append(Arrays.toString(keywords));
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
