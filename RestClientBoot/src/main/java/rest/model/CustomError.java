package rest.model;

public class CustomError {
	private String errorMessage;

	public CustomError() {}
	public CustomError(String errorMessage) {
		// TODO Auto-generated constructor stub
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
