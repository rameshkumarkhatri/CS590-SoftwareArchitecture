package greet.models;

public class CustomSuccess {
	String message;
	String id;
	public CustomSuccess(String message, String id) {
		// TODO Auto-generated constructor stub
		this.message = message;
		this.id = id;
	}
	public CustomSuccess(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
