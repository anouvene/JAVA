package hb.java.testHashmap;

import java.util.Date;
import java.util.Random;

import hb.utils.DateUtil;

public class Book {
	private String author;
	private long id;
	private String title;
	private String description;
	private int numberOfPages;
	private int numberOfChapters;
	private Date dateOfPublication;
	
	public Book(String title, String author, int numberOfPages, int numberOfChapters, Date dateOfPublication) {
		Random rand = new Random();
		
		this.id = Math.abs(rand.nextLong());
		this.title = title;
		this.author = author;
		this.numberOfPages = numberOfPages;
		this.numberOfChapters = numberOfChapters;
		this.dateOfPublication = dateOfPublication;
	}

	// GETTERS and SETTERS
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		StringBuilder sb = new StringBuilder(description);
		// 5 premiers caractères de la description
		char[] descAlias = new char[5];
		sb.getChars(0, 5, descAlias, 0);
		this.description = String.valueOf(descAlias);
	}

	/**
	 * @return the numberOfPages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	/**
	 * @return the numberOfChapters
	 */
	public int getNumberOfChapters() {
		return numberOfChapters;
	}

	/**
	 * @param numberOfChapters the numberOfChapters to set
	 */
	public void setNumberOfChapters(int numberOfChapters) {
		this.numberOfChapters = numberOfChapters;
	}

	/**
	 * @return the dateOfPublication
	 */
	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	/**
	 * @param dateOfPublication the dateOfPublication to set
	 */
	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String datePub = new DateUtil().dateToString(dateOfPublication);
		return "Book [" 
				+ "id=" + id 
				+ ", title=" + title 
				+ ", author=" + author 
				+ ", description=" + description
				+ ", numberOfPages=" + numberOfPages 
				+ ", numberOfChapters=" + numberOfChapters 
				+ ", dateOfPublication=" + datePub 
				+ "]";
	}
}
