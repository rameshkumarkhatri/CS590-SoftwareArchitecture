package greet.models;

public class CustomError {
	private String message;

	public CustomError(String errorMessage) {
		// TODO Auto-generated constructor stub
		this.message = errorMessage;
	}

	public String getErrorMessage() {
		return message;
	}

	public void setErrorMessage(String errorMessage) {
		this.message = errorMessage;
	}

}
