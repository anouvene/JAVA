package hb.java.services;

import java.util.Collection;

import hb.java.testHashmap.Book;

public interface BookService {
	/**
	 * To retrieve a list of Book
	 * @return Collection of Book
	 */
	public Collection<Book> getBooks();
	
	/**
	 * To find Book by title
	 * @return Book
	 */
	public Book findBook(String title);
	
	/**
	 * To retrieve a list of Key
	 * @return Collection of Key
	 */
	public Collection<Long> getKeys();
	
}
