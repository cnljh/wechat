package pub.cnljh.wechat.payment.v2;

public class RefundQuery extends GenerateOperation<RefundQuery.Request, RefundQuery.Response> {

	RefundQuery() {
		this.req = new RealRequest();
		this.resp = new RealResponse();
	}

	public interface Request extends GenerateOperation.Request {

		String getTransactionId();

		void setTransactionId(String transactionId);

		String getOutTradeNo();

		void setOutTradeNo(String outTradeNo);

		String getOutRefundNo();

		void setOutRefundNo(String outRefundNo);

		String getRefundId();

		void setRefundId(String refundId);

		Integer getOffset();

		void setOffset(Integer offset);

	}

	private class RealRequest extends GenerateOperation.RealRequest implements Request {
	}

	public interface Response extends GenerateOperation.Response {

		String getTransactionId();

		String getOutTradeNo();

		Integer getTotalRefundCount();

		Integer getTotalFee();

		String getFeeType();

		Integer getCashFee();

		String getCashFeeType();

		Integer getSettlementTotalFee();

		Integer getRefundCount();

		String getOutRefundNo$n(int n);

		String getRefundId$n(int n);

		String getRefundChanne$n(int n);

		Integer getRefundFee$n(int n);

		Integer getCouponRefundFee$n(int n);

		Integer getCouponRefundCount$n(int n);

		String getCouponRefundId$n$m(int n, int m);

		String getCouponType$n$m(int n, int m);

		Integer getCouponRefundFee$n$m(int n, int m);

		String getRefundStatus$n(int n);

		String getRefundAccount$n(int n);

		String getRefundRecvAccount$n(int n);

		String getRefundSuccessTime$n(int n);

	}

	private class RealResponse extends GenerateOperation.RealResponse implements Response {
	}

}
