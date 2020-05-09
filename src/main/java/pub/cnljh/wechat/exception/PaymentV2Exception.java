package pub.cnljh.wechat.exception;

import pub.ljh.wcpay.WeChatException;

public class PaymentV2Exception extends WeChatException {

	public PaymentV2Exception() {
	}

	public PaymentV2Exception(String message) {
		super(message);
	}

	public PaymentV2Exception(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentV2Exception(Throwable cause) {
		super(cause);
	}

	public PaymentV2Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
