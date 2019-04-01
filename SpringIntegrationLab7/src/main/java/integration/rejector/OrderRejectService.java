package integration.rejector;

import integration.model.Order;

public class OrderRejectService {

	public Order reject(Order order) {
		System.out.println("Order rejected because of less than dollar");
		return order;
	}
}
