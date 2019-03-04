package greet.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greet.models.Book;
import greet.repository.IBookRepository;
import greet.service.IBookService;;

@Service
public class BookService implements IBookService {
	
	@Autowired
	IBookRepository bookRepo;
	
	@Override
	public Book addBook(Book book) {
	
		bookRepo.save(book);
		return book;
	}

	@Override
	public boolean deleteBook(String isbn) {
//		bookRepo.deleteByIsbn(isbn);
		return true;
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepo.findAll();
	}

	@Override
	public Book getBook(String isbn) {
//		Book book = bookRepo.findByIsbn(isbn);
//		
//		return book;
		return null;
	}

}
