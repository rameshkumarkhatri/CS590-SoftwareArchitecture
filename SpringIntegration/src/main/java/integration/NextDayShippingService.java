package integration;

public class NextDayShippingService extends ShippingService {
	
	@Override
	public Order printShippingOrder(Order order) {
		System.out.println("Next Day Shipping ");
		return super.printShippingOrder(order);
	}

}
