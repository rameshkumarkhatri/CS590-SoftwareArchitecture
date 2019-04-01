package integration;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	@Autowired
	private GreetingGateway gateway;

	@Autowired
	private WareHouseGateway wGateway;
	
	@RequestMapping("/greeting/{name}")
	public String getGreeting(@PathVariable("name") String name) {
		Message<String> helloMessage =  MessageBuilder.withPayload(name.toUpperCase()).build();

		String result = gateway.handleRequest(helloMessage);
		return result;
	}
	
	@RequestMapping("/order/simple/{ordernumber}/{amount}")
	public String order(@PathVariable("ordernumber") long ordernumber, @PathVariable("amount") long amount) {
		Message<Order> order = MessageBuilder.withPayload(new Order(ordernumber, amount)).build();
		Order result = wGateway.handleRequest(order);
		return result.toString();
	}
	
	@RequestMapping("/order/{ordernumber}/{amount}")
	public String orderPriority(@PathVariable("ordernumber") long ordernumber, @PathVariable("amount") long amount) {
		Message<Order> order = null;
		Order o = null;
		if(amount> 175)
			o = new LargeOrder(ordernumber, amount);
		else o =new Order(ordernumber, amount);
		order = MessageBuilder.withPayload(o).build();
		Order result = wGateway.handleRequest(order);
		return result.toString();
	}
}
