package integration;

public class Order {
	private long ordernumber;
	private long amount;
	
	public Order(long ordernumber, long amount) {
		this.ordernumber = ordernumber;
		this.amount = amount;
	}
	
	public String print() {
		String str = "Order number = "+this.ordernumber+" Amount = "+this.amount;
		System.out.println(str);
		return str;
	}
}
