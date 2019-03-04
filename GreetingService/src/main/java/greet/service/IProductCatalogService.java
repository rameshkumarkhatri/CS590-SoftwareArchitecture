package greet.service;

import greet.models.product.Product;

public interface IProductCatalogService {
	
	void addProduct(long productnumber, String description, double price);
	Product getProduct(long productnumber);
	void setStock(long productNumber, int quantity, long locationcode); 

}
