package exception;

public class InvalidInputException extends RuntimeException {

	String message;

	public InvalidInputException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
