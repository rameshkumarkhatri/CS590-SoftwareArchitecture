package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import rest.domain.*;
@SpringBootApplication
public class RestClientLab6Application implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientLab6Application.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		//create customer
		CustomerDTO customerDto = new CustomerDTO("101","Frank","Brown","fBrown@Hotmail.com","123456");
		AddressDTO addressDTO = new AddressDTO("1000 N main Street", "Fairfield","52557","USA");
		customerDto.setAddress(addressDTO);
		//todo: call the customer component to add the customer
		restTemplate.postForObject("http://localhost:8080/customer/",customerDto ,CustomerDTO.class);
		// get customer
		//todo: call the customer component to get the customer with id 101 and print the result
		CustomerDTO cDTO = restTemplate.getForObject("http://localhost:8080/customer/101", CustomerDTO.class);
		System.out.println(cDTO);
		//create products		
		//todo: call the product component to create the first product 
//		restTemplate.postForObject("http://localhost:8082/product/1/This is product 1/11", null,Product.class);
//		//todo: call the product component to create the second product 
//		restTemplate.postForObject("http://localhost:8082/product/2/This is product 2/21", null,Product.class);
//		//set stock	
//		//todo: call the product component to set the stock for the first product
//		restTemplate.postForObject("http://localhost:8082/product/stock/1/33/A1", null,Product.class);
//		//get a product
//		//todo: call the product component to get the the first product and print the result
//		
//		ProductDTO pDTO = restTemplate.getForObject("http://localhost:8082/product/1", ProductDTO.class);
//		pDTO.print();
		// add products to the shoppingcart
		//todo: call the shopping component to add the first product to the cart
		ShoppingCartDTO shoppingDTO = restTemplate.postForObject("http://localhost:8084/cart/1/1/2", null,ShoppingCartDTO.class);
		
		//todo: call the shopping component to add the second product to the cart

		shoppingDTO = restTemplate.postForObject("http://localhost:8084/cart/1/2/2", null,ShoppingCartDTO.class);

		//get the shoppingcart
		//todo: call the shopping component to get the cart and print the result
		ShoppingCartDTO shCartDTO = restTemplate.getForObject("http://localhost:8084/cart/1", ShoppingCartDTO.class);
		shCartDTO.print();
		//checkout the cart		
		//todo: call the shopping component to checkout the cart 
		 shCartDTO = restTemplate.postForObject("http://localhost:8084/cart/checkout/1", null, ShoppingCartDTO.class);
		//get the order
		//todo: call the order component to get the order and print the result 
		OrderDTO orderDTO = restTemplate.getForObject("http://localhost:8081/order/1", OrderDTO.class);
		orderDTO.print();

		//add customer to order
		//todo: call the order component to add a customer to the order
		orderDTO = restTemplate.postForObject("http://localhost:8081/order/setCustomer/1/101", null, OrderDTO.class);
		//confirm the order
		//todo: call the order component to confirm the order
		orderDTO = restTemplate.postForObject("http://localhost:8081/order/confirm/1", null, OrderDTO.class);
		//get the order
		//todo: call the order component to get the order and print the result
		orderDTO  = restTemplate.getForObject("http://localhost:8081/order/1", OrderDTO.class);
		
		if(orderDTO != null) orderDTO.print();
		
	}
	
}
