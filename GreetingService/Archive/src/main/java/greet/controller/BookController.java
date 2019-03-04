package greet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greet.models.Book;
import greet.models.CustomError;
import greet.models.CustomSuccess;
import greet.models.Greeting;
import greet.service.IBookService;

@RestController
public class BookController {
	
	@Autowired
	IBookService bookService;
	
	@RequestMapping("/books")
	public ResponseEntity<?> getBooks() {	
		return new ResponseEntity<Collection<Book>>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<?> addBook(@RequestBody Book book) {;
		return new ResponseEntity<Book>(bookService.addBook(book),HttpStatus.OK);
	}
	
	@GetMapping("/book/{isbn}")
	public ResponseEntity<?> getBook(@PathVariable("isbn") String isbn) {
		Book book = bookService.getBook(isbn);
		if(book != null)
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		else return new ResponseEntity<CustomError>(new CustomError("Book has not been found with ISBN "+isbn), HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/book/{isbn}")
	public ResponseEntity<?> deleteBook(@PathVariable("isbn") String isbn) {
		if(bookService.deleteBook(isbn))
		return new ResponseEntity<CustomSuccess>(new CustomSuccess("Book has been deleted with ISBN "+isbn), HttpStatus.OK);
		else return new ResponseEntity<CustomError>(new CustomError("Book has not been deleted with ISBN "+isbn), HttpStatus.NOT_FOUND);
	}

}
