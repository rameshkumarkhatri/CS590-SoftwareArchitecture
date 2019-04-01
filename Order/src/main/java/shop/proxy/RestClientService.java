package shop.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import shop.order.service.OrderCustomerDTO;

public class RestClientService {

	@Autowired
	RestTemplate restTemplate;
	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		OrderCustomerDTO customer = restTemplate.getForObject("http://localhost:8080/customer/"+customerNumber, OrderCustomerDTO.class);
		return customer;
	}
	
private static RestClientService service;
	
	public static RestClientService getInstance() {
		if(service == null)
			service = new RestClientService();
		return service;
	}

}
