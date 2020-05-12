package pub.cnljh.wechat.exception;

import pub.cnljh.wechat.payment.v2.Feedback;

public class PaymentV2Exception extends WeChatRuntimeException {

	public PaymentV2Exception() {
	}

	public PaymentV2Exception(Feedback feedback) {
		super(feedback.toString());
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
