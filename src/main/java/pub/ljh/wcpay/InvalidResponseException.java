package pub.ljh.wcpay;

public class InvalidResponseException extends PaymentV2Exception {

	public InvalidResponseException() {
	}

	public InvalidResponseException(String message) {
		super(message);
	}

	public InvalidResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidResponseException(Throwable cause) {
		super(cause);
	}

	public InvalidResponseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
