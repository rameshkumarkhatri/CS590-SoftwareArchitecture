package integration;

public class ShippingService {
	
	public Order printShippingOrder(Order order) {
		 order.print();
		 return order;
	}
}
