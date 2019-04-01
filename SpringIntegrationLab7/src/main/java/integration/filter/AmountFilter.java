package integration.filter;

import integration.model.Order;
import integration.model.OrderLine;

public class AmountFilter {
	
	public boolean filter(Order order)
	{
		if(order.getAmount() < 1 ) return false;
		else return true;
	}	
	
	
	public boolean stockFilter(Order order)
	{
		for(OrderLine orderLine : order.getOrderLine())
			if(orderLine.getQuantity() > 2) {
				return false;
			}
		return true;
	}	
	
	

}
