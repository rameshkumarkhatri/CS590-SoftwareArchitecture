package greet.service;

import java.util.List;

import greet.models.Book;

public interface IBookService {
	public Book addBook(Book book);
	public boolean deleteBook(String isbn);
	public List<Book> getAllBooks();
	public Book getBook(String isbn);

}
