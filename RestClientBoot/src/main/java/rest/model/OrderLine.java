package rest.model;


public class OrderLine { //extends Product{

	int quantity;
	
	public OrderLine(long productnumber2, int quantity2) {
		this.quantity = quantity2;
		this.productNumber = productnumber2;
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
