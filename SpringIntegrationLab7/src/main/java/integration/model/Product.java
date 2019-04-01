package integration.model;

public class Product {
	private long id;
	private double price;
	private String name;
	
	public Product(long id,	double price,	String name) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
