package rest.model;

import java.util.List;
import java.util.ArrayList;



public class ShoppingCart {
	
	public ShoppingCart(long productnumber, int quantity) {
		// TODO Auto-generated constructor stub
		orderDetail.add(new OrderLine(productnumber, quantity));
	}
	List<OrderLine> orderDetail = new ArrayList<>();
	
	public void addProduct(long productnumber, int quantity) {
		// TODO Auto-generated constructor stub
		orderDetail.add(new OrderLine(productnumber, quantity));
	}
}
