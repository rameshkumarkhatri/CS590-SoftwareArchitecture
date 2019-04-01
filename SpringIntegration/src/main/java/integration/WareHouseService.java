package integration;

public class WareHouseService {
	
	public Order printOrder(Order order) {
		order.print();
		return order;
	}
}
