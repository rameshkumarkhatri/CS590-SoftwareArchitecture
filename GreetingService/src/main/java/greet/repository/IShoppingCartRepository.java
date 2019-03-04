package greet.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import greet.models.Book;
import greet.models.product.ShoppingCart;

//@Repository
public interface IShoppingCartRepository extends MongoRepository<ShoppingCart, ObjectId>{

}
