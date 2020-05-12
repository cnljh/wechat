package pub.cnljh.wechat.exception;

public abstract class WeChatRuntimeException extends RuntimeException {

	public WeChatRuntimeException() {
	}

	public WeChatRuntimeException(String message) {
		super(message);
	}

	public WeChatRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeChatRuntimeException(Throwable cause) {
		super(cause);
	}

	public WeChatRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
