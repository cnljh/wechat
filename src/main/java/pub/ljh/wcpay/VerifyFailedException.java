package pub.ljh.wcpay;

public class VerifyFailedException extends PaymentV2Exception {

	public VerifyFailedException() {
	}

	public VerifyFailedException(String message) {
		super(message);
	}

	public VerifyFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public VerifyFailedException(Throwable cause) {
		super(cause);
	}

	public VerifyFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
