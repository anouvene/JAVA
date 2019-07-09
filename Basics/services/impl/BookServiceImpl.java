package hb.java.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import hb.java.services.BookService;
import hb.java.testHashmap.Book;

public class BookServiceImpl implements BookService {
	private Map<Long, Book> books;
	
	public BookServiceImpl() {
		books = new TreeMap<Long, Book>();
	}

	/**
	 * To retrieve a list of Book
	 * @return Collection of Book
	 */
	public Collection<Book> getBooks() {
		// List of books
		Collection<Book> the_books = new ArrayList<Book>();
		for(Book book:books.values()) {
			the_books.add(book);
		}
		return the_books;
	}
	
	/**
	 * Add a book to books TreeMap
	 * @param b book to add to Collection
	 */
	public void addBook(Book b) {
		this.books.put(b.getId(), b);
	}



	/**
	 * To find Book by title
	 * @return Book
	 */
	public Book findBook(String title) {
		Book b = null;
		for(Book book:books.values()) {
			if(book.getTitle().equalsIgnoreCase(title)) {
				b = book;
				break;
			}
		}
		return b;
	}

	/**
	 * To retrieve a list of Key
	 * @return Collection of Key
	 */
	public Collection<Long> getKeys() {
		// List of key
		Collection<Long> the_keys = new ArrayList<Long>();
		for(Long key:books.keySet()) {
			the_keys.add(key);
		}
		return the_keys;
	}
	
}
