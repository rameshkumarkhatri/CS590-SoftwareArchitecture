package integration.service;

import integration.model.Order;

public class OrderToSupplierService {

	
	public Order orderToSupplier(Order order) {
		System.out.println("Product has been ordered to Supplier");
		return order;
	}
}
