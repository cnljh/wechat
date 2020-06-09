package pub.cnljh.wechat.exception;

public class WeChatRuntimeException extends RuntimeException {

	public WeChatRuntimeException() {
	}

	public WeChatRuntimeException(int code, String msg) {
		super(String.format("code: %s, msg: %s", code, msg));
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
