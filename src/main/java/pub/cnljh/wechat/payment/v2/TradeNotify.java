package pub.cnljh.wechat.payment.v2;

public class TradeNotify extends NotifyOperation<TradeNotify.Response> {

	TradeNotify() {
		this.resp = new RealResponse();
	}

	public interface Response extends Operation.Response {

		String getOpenid();

		Boolean getIsSubscribe();

		TradeType getTradeType();

		String getBankType();

		Integer getTotalFee();

		Integer getSettlementTotalFee();

		String getFeeType();

		Integer getCashFee();

		String getCashFeeType();

		Integer getCouponFee();

		Integer getCouponCount();

		String getCouponType$n(int idx);

		String getCouponId$n(int idx);

		Integer getCouponFee$n(int idx);

		String getTransactionId();

		String getOutTradeNo();

		String getAttach();

		String getTimeEnd();

	}

	private class RealResponse extends GenerateOperation.RealResponse implements Response {

	}

}
