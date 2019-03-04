package greet.serviceImp;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greet.models.product.Product;
import greet.models.product.ShoppingCart;
import greet.repository.IShoppingCartRepository;
import greet.service.IShoppingService;


@Service
public class ShoppingService implements IShoppingService{
	
	@Autowired
	IShoppingCartRepository repo;
	
	public void addToCart(long productnumber, int quantity) {
		
	}
	public ShoppingCart getCart(String cartID) {
//		List<ShoppingCart> list = repo.findById(new ObjectId(cartID));
//		if(list.isEmpty())
//			return null;
//		return list.get(0);
		return repo.findById(new ObjectId(cartID)).get();
	}

}
