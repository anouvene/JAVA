package hb.harrypotter.services.impl;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import hb.harrypotter.pojos.Book;
import hb.harrypotter.services.BookService;

public class BookServiceImpl implements BookService {
	private Map<Long, Book> books = new TreeMap<>();

	
	public BookServiceImpl() {
		// Get books from xml file
		
	}

	@Override
	public Collection<Book> getBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBook(String book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Long> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
