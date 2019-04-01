package integration.model;

public class OrderLine {
	private int quantity;
	private Product product;
	
	public OrderLine() {}
	public OrderLine(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	@Override
	public String toString() {
		return "quantity:"+quantity+", product: "+product.toString();
	}
	
}
