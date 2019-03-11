package greet.serviceImp;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greet.models.product.Order;
import greet.models.product.ShoppingCart;
import greet.repository.IOrderRepository;
import greet.service.IOrderService;

@Service
public class OrderService implements IOrderService {


	@Autowired
	IOrderRepository repoOrder;
	
	@Override
	public void createOrder(String orderId, ShoppingCart shoppingCart) {
		
		repoOrder.save(Order.createOrderFromCart(orderId, shoppingCart));
	}

	@Override
	public Order getOrder(String orderId) {
		
		return repoOrder.findById(orderId).get();
	}

}
