package integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface ShippingGateway {
	
	@Gateway(requestChannel="shippingChannel")
	Order handleRequest(Message<Order> message);
}
