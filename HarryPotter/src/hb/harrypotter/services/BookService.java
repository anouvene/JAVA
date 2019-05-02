package hb.harrypotter.services;

import java.util.Collection;

import hb.harrypotter.pojos.Book;

public interface BookService {

	Collection<Book> getBooks();
	Book findBook(String book);
	Collection<Long> getKeys();

}
