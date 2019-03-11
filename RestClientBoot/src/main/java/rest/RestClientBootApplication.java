package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import rest.model.CustomSuccess;
import rest.model.OrderLine;
import rest.model.Product;

@SpringBootApplication
public class RestClientBootApplication implements CommandLineRunner {

		@Autowired
		private RestOperations  restTemplate;


		public static void main(String[] args) {
			SpringApplication.run(RestClientBootApplication.class, args);
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
			Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting/Hello new greeting", Greeting.class);
			System.out.println("Receiving message:" + greeting.getContent());
//			
//			
			CustomSuccess c = restTemplate.postForObject("http://localhost:8080/product", new Product("Product 1", 10, 1), CustomSuccess.class);
			System.out.println("Product create Receiving message:" + c.getMessage());

			c = restTemplate.postForObject("http://localhost:8080/product", new Product("Product 2", 21, 2), CustomSuccess.class);
			System.out.println("Product create Receiving message:" + c.getMessage());
			

			c = restTemplate.postForObject("http://localhost:8080/cart/addproduct/1", new OrderLine(1, 3), CustomSuccess.class);
			System.out.println("Cart product added Receiving message:" + c.getMessage());

			c = restTemplate.postForObject("http://localhost:8080/cart/addproduct/1", new OrderLine(2, 2), CustomSuccess.class);
			System.out.println("Cart product added Receiving message:" + c.getMessage());
			
			try{
				c = restTemplate.postForObject("http://localhost:8080/cart/checkout/1", "", CustomSuccess.class);
				System.out.println("Checkout :" + c.getMessage());
				}catch(Exception e) {
				e.printStackTrace();

				
			}

		}
}
