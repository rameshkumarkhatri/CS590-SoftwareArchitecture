package greet.models.product;


public class OrderLine { //extends Product{

	int quantity;
	
	public OrderLine() {
		
	}
	
	public OrderLine(long productnumber, int quantity) {
		this.quantity = quantity;
		this.productNumber = productnumber;
	}

	public long getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(long productNumber) {
		this.productNumber = productNumber;
	}

	long productNumber;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
