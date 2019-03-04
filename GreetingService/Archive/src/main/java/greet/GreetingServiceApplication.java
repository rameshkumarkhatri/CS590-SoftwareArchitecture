package greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import greet.models.Book;
import greet.repository.IBookRepository;

@SpringBootApplication
public class GreetingServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceApplication.class, args);
	}
	
	@Autowired 
	IBookRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		repo.save(new Book("1", "Ramesh", "Bewafai", 10));
//
//		repo.save(new Book("2", "Kumar", "Bewafai2", 100));
		}

}
