package greet.models.product;

import java.util.List;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShoppingCart {
	

	public ShoppingCart() {

	}
	public ShoppingCart(String id) {
		this.id = id;
	}
	public ShoppingCart(long productnumber, int quantity) {
		// TODO Auto-generated constructor stub
		orderDetail.add(new OrderLine(productnumber, quantity));
	}

	@Id
	String id;
	
	List<OrderLine> orderDetail = new ArrayList<>();
	
	public void addProduct(long productnumber, int quantity) {
		// TODO Auto-generated constructor stub
		orderDetail.add(new OrderLine(productnumber, quantity));
	}
}
