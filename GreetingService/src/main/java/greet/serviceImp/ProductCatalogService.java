package greet.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greet.models.product.Product;
import greet.models.product.Stock;
import greet.repository.IProductCatalogRepository;
import greet.service.IProductCatalogService;;


@Service
public class ProductCatalogService implements IProductCatalogService {

	@Autowired 
	IProductCatalogRepository repo;
	@Override
	public void addProduct(long productnumber, String description, double price) {
		
		Product product = new Product();
		product.setDescription(description);
		product.setPrice(price);
		product.setProductNumber(productnumber);
		repo.save(product);
		
	}

	@Override
	public Product getProduct(long productnumber) {
		
		return repo.findByProductNumber(productnumber);
	}

	@Override
	public void setStock(long productNumber, int quantity, long locationcode) {
		Product p = repo.findByProductNumber(productNumber);
		p.setStock(new Stock(quantity, locationcode));
		repo.save(p);
//		repo.setStock(new Stock(quantity, locationcode));
		
	}

}
