package greet.serviceImp;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greet.models.product.Product;
import greet.models.product.ShoppingCart;
import greet.repository.IOrderRepository;
import greet.repository.IShoppingCartRepository;
import greet.service.IShoppingService;


@Service
public class ShoppingService implements IShoppingService{
	
	@Autowired
	IShoppingCartRepository repo;
	
	
	public void addToCart(long productnumber, int quantity) {
		repo.save(new ShoppingCart(productnumber, quantity));
	}
	public ShoppingCart getCart(String cartID) {
//		List<ShoppingCart> list = repo.findById(new ObjectId(cartID));
//		if(list.isEmpty())
//			return null;
//		return list.get(0);
		return repo.findById(cartID).get();
	}
	
	public void addToCart(String id, long productnumber, int quantity) {
		ShoppingCart cart = null;
		try{
			Optional<ShoppingCart> cartI = repo.findById(id);
			if(cartI.isPresent()) cart = cartI.get();
			else cart = new ShoppingCart(id);
		}catch (Exception e) {
			cart = new ShoppingCart(id);
		}
		if(cart != null) {
			cart.addProduct(productnumber, quantity);
			repo.save(cart);
		}
		
	}
	
//	public void checkOut(String id) {
//		ShoppingCart cart = repo.findById(new ObjectId(id)).get();
//		if(cart != null) {
//			orderService.createOrder(id, cart);
//		}
//
//	}	

}
