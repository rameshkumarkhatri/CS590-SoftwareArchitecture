package integration.service;

import integration.model.Order;

public class PaymentService {

	
	public Order processPayment(Order order) {
		System.out.println("In the payment Service");
		return order;
	}
}
