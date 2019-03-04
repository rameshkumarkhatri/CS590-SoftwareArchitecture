package greet.models.product;

public class Stock {
	int quantity;
	long locationcode;
	
	public Stock(int quantity2, long locationcode2) {
		// TODO Auto-generated constructor stub
		this.quantity = quantity2;
		this.locationcode= locationcode2;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getLocationcode() {
		return locationcode;
	}
	public void setLocationcode(long locationcode) {
		this.locationcode = locationcode;
	}
}
