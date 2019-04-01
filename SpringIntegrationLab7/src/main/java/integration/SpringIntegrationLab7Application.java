package integration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import integration.model.Address;
import integration.model.Order;
import integration.model.OrderLine;
import integration.model.Product;

@SpringBootApplication
@ImportResource("classpath:integration.xml")
public class SpringIntegrationLab7Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationLab7Application.class, args);
	}
	
	@Autowired
	private RestOperations  restTemplate;


	

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}
	

	@Override
	public void run(String... args) throws Exception {
//		Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting/Hello new greeting", Greeting.class);
//		System.out.println("Receiving message:" + greeting.getContent());
//		
//	
//		OrderLine ol1 = new OrderLine(3,new Product(11, 10, "Product 1"));
//		ArrayList<OrderLine> list = new ArrayList<>();
//		list.add(ol1);
//		Address add = new Address("USA", "Fairfield","here");
//		Order order = new Order(11,100, list, add);
//		ResponseEntity<Order> c = restTemplate.postForEntity("http://localhost:8090/order", order, Order.class);
//		System.out.println("Product create Receiving message:" + c.getBody());
//		
	}

}
