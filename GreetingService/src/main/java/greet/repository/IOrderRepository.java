package greet.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import greet.models.Book;
import greet.models.product.Order;
import greet.models.product.ShoppingCart;

//@Repository
public interface IOrderRepository extends MongoRepository<Order, String>{

}
