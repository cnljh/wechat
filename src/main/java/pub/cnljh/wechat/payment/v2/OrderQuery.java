package pub.cnljh.wechat.payment.v2;

public class OrderQuery extends GenerateOperation<OrderQuery.Request, OrderQuery.Response> {

	 OrderQuery() {
		req = new RealRequest();
		resp = new RealResponse();
	}

	public interface Request extends GenerateOperation.Request {

		String getTransactionId();

		void setTransactionId(String transactionId);

		String getOutTradeNo();

		void setOutTradeNo(String outTradeNo);

	}

	private class RealRequest extends GenerateOperation.RealRequest implements Request {
	}

	public interface Response extends GenerateOperation.Response {

		String getDeviceInfo();

		String getOpenid();

		Boolean isSubscribe();

		TradeType getTradeType();

		TradeState getTradeState();

		String getBankType();

		Integer getTotalFee();

		String getFeeType();

		Integer getCashFee();

		String getCashFeeType();

		Integer getSettlementTotalFee();

		Integer getCouponFee();

		Integer getCouponCount();

		String getCouponId$n(int idx);

		String getCouponType$n(int idx);

		Integer getCouponFee$n(int idx);

		String getTransactionId();

		String getOutTradeNo();

		String getAttach();

		String getTimeEnd();

		String getTradeStateDesc();

	}

	private class RealResponse extends GenerateOperation.RealResponse implements Response {
	}

}
