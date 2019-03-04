package greet.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import greet.models.Book;

//@Repository
public interface IBookRepository extends MongoRepository<Book, String>{

	Book findByIsbn(String isbn);

	void deleteByIsbn(String isbn);
}
