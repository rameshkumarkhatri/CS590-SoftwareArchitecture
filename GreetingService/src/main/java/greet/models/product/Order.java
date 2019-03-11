package greet.models.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	
	@Id
	String _id;
	
	Date orderDate;
	
//	double totalPrice;
	
	List<OrderLine> orderDetail = new ArrayList<>();
	
	
	public static Order createOrderFromCart(String id, ShoppingCart cart) {
		Order order = new Order();
		order.orderDate = new Date();
		order._id = id;
		order.orderDetail = cart.orderDetail;
//		Collections.copy(order.orderDetail,  cart.orderDetail);
//		order.totalPrice = order.orderDetail.stream().mapToDouble(x -> (x.quantity)*x.
		return order;
	}
}
