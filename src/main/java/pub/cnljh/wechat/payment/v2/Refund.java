package pub.cnljh.wechat.payment.v2;

public class Refund extends GenerateOperation<Refund.Request, Refund.Response> {

	Refund() {
		req = new RealRequest();
		resp = new RealResponse();
	}

	public interface Request extends GenerateOperation.Request {

		String getOutTradeNo();

		void setOutTradeNo(String outTradeNo);

		String getTransactionId();

		void setTransactionId(String transactionId);

		String getOutRefundNo();

		void setOutRefundNo(String outRefundNo);

		Integer getTotalFee();

		void setTotalFee(Integer totalFee);

		Integer getRefundFee();

		void setRefundFee(Integer refundFee);

		String getRefundFeeType();

		void setRefundFeeType(String refundFeeType);

		String getRefundDesc();

		void setRefundDesc(String refundDesc);

		String getRefundAccount();

		void setRefundAccount(String refundAccount);

		String getNotifyUrl();

		void setNotifyUrl(String notifyUrl);

	}

	private class RealRequest extends GenerateOperation.RealRequest implements Request {
	}

	public interface Response extends GenerateOperation.Response {

		String getOutTradeNo();

		String getTransactionId();

		String getOutRefundNo();

		String getRefundId();

		Integer getRefundFee();

		Integer getSettlementRefundFee();

		Integer getTotalFee();

		Integer getSettlementTotalFee();

		String getFeeType();

		Integer getCashFee();

		String getCashFeeType();

		Integer getCashRefundFee();

		String getCouponType$n(int idx);

		Integer getCouponRefundFee();

		Integer getCouponRefundFee$n(int idx);

		Integer getCouponRefundCount();

		String getCouponRefundId$n(int idx);

	}

	private class RealResponse extends GenerateOperation.RealResponse implements Response {
	}
}
