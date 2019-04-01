package integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integration.gateway.AmountGateway;
import integration.model.Order;

@RestController
public class MainController {
	
	@Autowired
	AmountGateway amountGateway;
	
	@RequestMapping("/order/{ordernumber}/{amount}")
	public String order(@PathVariable("ordernumber") long ordernumber, @PathVariable("amount") String amount) {
		Message<Order> order = MessageBuilder.withPayload(new Order(ordernumber, Double.parseDouble(amount))).build();
		Order result = amountGateway.handle(order);
		return result.toString();
	}
	
	
	@PostMapping("/order")
	public String orderCreate(@RequestBody Order order1) {
		System.out.println("Input data "+order1.toString());
		Message<Order> order = MessageBuilder.withPayload(order1).build();
		Order result = amountGateway.handle(order);
		return result.toString();
	}

}
