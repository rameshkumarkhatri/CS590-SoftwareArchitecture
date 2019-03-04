package greet.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import greet.models.Book;
import greet.models.product.Product;

//@Repository
public interface IProductCatalogRepository extends MongoRepository<Product, String>{

	Product findByProductNumber(long productnumber);

	
}
