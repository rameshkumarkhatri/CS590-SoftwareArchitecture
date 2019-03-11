package greet.service;

import greet.models.product.Product;
import greet.models.product.ShoppingCart;

public interface IShoppingService {
	
	void addToCart(long productnumber, int quantity);
	ShoppingCart getCart(String cartID); 
	public void addToCart(String id, long productnumber, int quantity);
	
//	void checkOut(String cartID);
}
