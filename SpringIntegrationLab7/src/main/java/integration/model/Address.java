package integration.model;

public class Address {
	private String country;
	private String city;
	private String address;
	
	public Address() {}
	public Address(String country, String city, String address) {
		super();
		this.country = country;
		this.city = city;
		this.address = address;
	}
	
	public boolean isInternation() {
		if(country.equalsIgnoreCase("usa"))
			return false;
		else return true;
	}
}
