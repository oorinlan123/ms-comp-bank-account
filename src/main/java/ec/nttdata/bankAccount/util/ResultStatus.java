package ec.nttdata.bankAccount.util;

public enum ResultStatus {

	CREATED(100, "Created"), 
	NOT_CREATED(101, "Not created"), 
	UPDATED(102, "Updated"), 
	NOT_UPDATED(103, "Not updated"),
	FOUND(104, "Found"), 
	NOT_FOUND(105, "Not found"), 
	DELETED(106, "Deleted"), 
	NOT_DELETED(107, "Not deleted"),
	FAILED(108, "Failed"),
	GENERATED(109, "Generated"),
	NONE(110, "None"),
	PROCESSING(111, "Processing"),
	EXPIRED_TOKEN(123, "Expired Token"),
	UNAUTHORIZED_TOKEN(124, "Unauthorized Token"),
	OK(200, "Ok"),
	ACCEPT(202, "Accept"),
	UNAUTHORIZED(401, "Unauthorized"),
	INTERNAL_SERVER_ERROR(500,"Internal Server Error"),
	TOKEN_REQUIRED(499,"Token Required"),
	INVALID_TOKEN(498,"Invalid Token"),
	BAD_REQUEST(400,"Bad request");

	private final Integer value;
	private final String message;
	
	ResultStatus(Integer value, String message) {
		this.value = value;
		this.message = message;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}
