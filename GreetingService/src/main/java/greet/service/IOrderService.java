package greet.service;

import greet.models.product.Order;
import greet.models.product.ShoppingCart;


public interface IOrderService {
	void createOrder(String orderId, ShoppingCart shoppingCart);
	Order getOrder(String orderId);

}
