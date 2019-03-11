package rest.model;




public class Product {
	
	long productNumber;
	String description;
	double price;
	
	
	
	public Product(String description, double price, long productNumber)
	{
		this.description = description;
		this.price = price;
		this.productNumber = productNumber;
	}
	public long getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(long productNumber) {
		this.productNumber = productNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
