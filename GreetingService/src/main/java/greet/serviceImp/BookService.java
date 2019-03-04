package greet.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import greet.models.Book;
import greet.service.IBookService;;

@Service
public class BookService implements IBookService {

	HashMap<String, Book> map = new HashMap<>();
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		map.put(book.getIsbn(), book);
		return book;
	}

	@Override
	public boolean deleteBook(String isbn) {
		// TODO Auto-generated method stub
		if(map.containsKey(isbn))
		{
			map.remove(isbn);
			return true;
		}else
			return false;
		
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return map.values().stream().collect(Collectors.toList());
	}

	@Override
	public Book getBook(String isbn) {
		// TODO Auto-generated method stub
		if(map.containsKey(isbn))
			return map.get(isbn);
		return null;
	}

}
