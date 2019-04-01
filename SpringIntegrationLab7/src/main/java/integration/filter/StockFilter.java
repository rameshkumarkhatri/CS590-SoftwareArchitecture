package integration.filter;

import integration.model.Order;
import integration.model.OrderLine;

public class StockFilter {
	
	
public boolean filter(Order order)
	{
		for(OrderLine orderLine : order.getOrderLine())
			if(orderLine.getQuantity() > 2) {
				return false;
			}
		return true;
	}	
	

}
