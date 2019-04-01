package integration.gateway;

import java.util.ArrayList;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import integration.model.Order;
import integration.model.OrderLine;

@MessagingGateway
public interface AmountGateway {
	
	@Gateway(requestChannel="orderreceiveChannel")
	Order handle(Message<Order> message);

	@Gateway(requestChannel="orderRejectedChannel")
	Order orderReject(Message<Order> message);


	@Gateway(requestChannel="ordeLineChannel")
	ArrayList<OrderLine> orderLine(Message<Order> message);
	

	@Gateway(requestChannel="stockChannel")
	Order stockCheck(Message<Order> message);
	

	@Gateway(requestChannel="orderToSupplierChannel")
	Order orderToSupplier(Message<Order> message);
//	
//	@Gateway(requestChannel="checkStockChannel")
//	Order stockCheck(Message<Order> message);
}
