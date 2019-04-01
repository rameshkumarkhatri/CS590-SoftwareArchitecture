package integration.model;

import java.util.ArrayList;

public class Order {
	 long orderNumber;
	 double amount;
	 ArrayList<OrderLine> products;

	 Address shippment;
	
	public Order() {}
	
	public Order(long orderNumber, double amount) {
		super();
		this.orderNumber = orderNumber;
		this.amount = amount;
	}
	
	public Order(long orderNumber, double amount, ArrayList<OrderLine> products, Address shippment) {
		super();
		this.orderNumber = orderNumber;
		this.amount = amount;
		this.products = products;
		this.shippment = shippment;
	}

	public double getAmount() {
		
		return amount;
	}

	public ArrayList<OrderLine> getOrderLine() {
		return products;
	}
	
	@Override
	public String toString() {
		String str = this.orderNumber + ", "+this.amount;
		try {
		for(OrderLine o : this.products)
		{
			str = str +o.toString();
		}
		}catch (Exception e) {
//			e.printStackTrace();
		}
		return str;
	}
}
