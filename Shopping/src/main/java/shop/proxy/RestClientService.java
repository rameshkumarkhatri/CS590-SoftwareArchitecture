package shop.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import shop.shopping.service.ProductDTO;
import shop.shopping.service.ShoppingCartDTO;

public class RestClientService {

	@Autowired
	RestTemplate restTemplate;
	
	
	private static RestClientService service;
	
	public static RestClientService getInstance() {
		if(service == null)
			service = new RestClientService();
		return service;
	}

	public ProductDTO getProduct(String productnumber) {
		ProductDTO productDTO = restTemplate.getForObject("http://localhost:8082/product/"+productnumber, ProductDTO.class);
		return productDTO;
	}

	public void createOrder(ShoppingCartDTO shoppingCartDTO) {
		ShoppingCartDTO	orderDTO = restTemplate.postForObject("http://localhost:8081/order/setCustomer/1/101", shoppingCartDTO, ShoppingCartDTO.class);

	}

}
