package rest.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Order {
	
	
	String _id;
	
	Date orderDate;
	
//	double totalPrice;
	
	List<OrderLine> orderDetail = new ArrayList<>();
	
	
	public static Order createOrderFromCart(String id, ShoppingCart cart) {
		Order order = new Order();
		order.orderDate = new Date();
		order._id = id;
		Collections.copy(cart.orderDetail,  order.orderDetail);
//		order.totalPrice = order.orderDetail.stream().mapToDouble(x -> (x.quantity)*x.
		return order;
	}
}
