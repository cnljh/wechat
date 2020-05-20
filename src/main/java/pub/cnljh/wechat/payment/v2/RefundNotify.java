package pub.cnljh.wechat.payment.v2;

import java.time.LocalDateTime;

public class RefundNotify extends NotifyOperation<RefundNotify.Response> {

	RefundNotify() {
		this.resp = new RealResponse();
	}

	public interface Response {

		String getAppid();

		String getMchId();

		String getNonceStr();

		String getReturnCode();

		String getReturnMsg();

		String getTransactionId();

		String getOutTradeNo();

		String getRefundId();

		String getOutRefundNo();

		Integer getTotalFee();

		Integer getSettlementTotalFee();

		Integer getRefundFee();

		Integer getSettlementRefundFee();

		String getRefundStatus();

		LocalDateTime getSuccessTime();

		String getRefundRecvAccout();

		String getRefundAccount();

		String getRefundRequestSource();

	}

	public class RealResponse extends GenerateOperation.RealResponse implements Response {

	}

}
