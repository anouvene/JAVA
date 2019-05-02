package hb.harrypotter.pojos;

import java.util.Date;
import java.util.Random;

public class Book {

	private String author;
	private long id;
	private String title;
	private String description;
	private int nomberOfPages;
	private int numberOfChapters;
	private Date dateOfPublication;
	
	public Book(String title, int nomberOfPages, int numberOfChapters, Date dateOfPublication) {
		this.id = new Random().nextLong();
		this.title = title;
		this.nomberOfPages = nomberOfPages;
		this.numberOfChapters = numberOfChapters;
		this.dateOfPublication = dateOfPublication;
	}

	// Getters and setters
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNomberOfPages() {
		return nomberOfPages;
	}

	public void setNomberOfPages(int nomberOfPages) {
		this.nomberOfPages = nomberOfPages;
	}

	public int getNumberOfChapters() {
		return numberOfChapters;
	}

	public void setNumberOfChapters(int numberOfChapters) {
		this.numberOfChapters = numberOfChapters;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	@Override
	public String toString() {
		String dop = new hb.harrypotter.utils.DateUtil().formatDateBirth(dateOfPublication);
		return "Book ["
				+ "id=" + id 
				+ ", title=" + title 
				+ ", description=" + description 
				+ ", nomberOfPages=" + nomberOfPages 
				+ ", numberOfChapters=" + numberOfChapters 
				+ ", dateOfPublication=" + dop
				+ "]";
	}
	
	// Display book
	
	
	

}
