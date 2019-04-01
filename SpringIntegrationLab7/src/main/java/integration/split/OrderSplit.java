package integration.split;

import java.util.ArrayList;

import integration.model.Order;
import integration.model.OrderLine;

public class OrderSplit {

	public ArrayList<OrderLine> split(Order order){
		return order.getOrderLine();
	}
}
