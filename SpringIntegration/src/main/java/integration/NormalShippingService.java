package integration;

public class NormalShippingService  extends ShippingService {
	
	@Override
	public Order printShippingOrder(Order order) {
		System.out.println("Normal Shipping ");
		return super.printShippingOrder(order);
	}

}
