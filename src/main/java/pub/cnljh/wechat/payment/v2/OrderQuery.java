package pub.cnljh.wechat.payment.v2;

public class OrderQuery extends Operation<OrderQuery.Request, OrderQuery.Response> {

	public OrderQuery() {
		req = new Request();
		resp = new Response();
	}

	public class Request extends Operation.Request {

		public static final String transactionId = "transaction_id";
		public static final String outTradeNo = "out_trade_no";

		public String getTransactionId() {
			return (String) reqMap.get(transactionId);
		}

		public void setTransactionId(String transactionId) {
			reqMap.put(Request.transactionId, transactionId);
		}

		public String getOutTradeNo() {
			return (String) reqMap.get(outTradeNo);
		}

		public void setOutTradeNo(String outTradeNo) {
			reqMap.put(Request.outTradeNo, outTradeNo);
		}

	}

	public class Response extends Operation.Response {

		public static final String deviceInfo = "device_info";
		public static final String openid = "openid";
		public static final String isSubscribe = "is_subscribe";
		public static final String tradeType = "trade_type";
		public static final String tradeState = "trade_state";
		public static final String bankType = "bank_type";
		public static final String totalFee = "total_fee";
		public static final String feeType = "fee_type";
		public static final String cashFee = "cash_fee";
		public static final String cashFeeType = "cash_fee_type";
		public static final String settlementTotalFee = "settlement_total_fee";
		public static final String couponFee = "coupon_fee";
		public static final String couponCount = "coupon_count";
		public static final String couponId$n = "coupon_id_$n";
		public static final String couponType$n = "coupon_type_$n";
		public static final String couponFee$n = "coupon_fee_$n";
		public static final String transactionId = "transaction_id";
		public static final String outTradeNo = "out_trade_no";
		public static final String attach = "attach";
		public static final String timeEnd = "time_end";
		public static final String tradeStateDesc = "trade_state_desc";

		public String getDeviceInfo() {
			return (String) reqMap.get(deviceInfo);
		}

		public String getOpenid() {
			return (String) reqMap.get(openid);
		}

		public Boolean isSubscribe() {
			return "Y".equals(reqMap.get(isSubscribe));
		}

		public TradeType getTradeType() {
			return TradeType.valueOf((String) reqMap.get(tradeType));
		}

		public String getTradeState() {
			return (String) reqMap.get(tradeState);
		}

		public String getBankType() {
			return (String) reqMap.get(bankType);
		}

		public Integer getTotalFee() {
			return (Integer) reqMap.get(totalFee);
		}

		public String getFeeType() {
			return (String) reqMap.get(feeType);
		}

		public Integer getCashFee() {
			return (Integer) reqMap.get(cashFee);
		}

		public String getCashFeeType() {
			return (String) reqMap.get(cashFeeType);
		}

		public Integer getSettlementTotalFee() {
			return (Integer) reqMap.get(settlementTotalFee);
		}

		public Integer getCouponFee() {
			return (Integer) reqMap.get(couponFee);
		}

		public Integer getCouponCount() {
			return (Integer) reqMap.get(couponCount);
		}

		public String getCouponId$n(int idx) {
			return (String) reqMap.get(couponId$n.replace("$n", String.valueOf(idx)));
		}

		public String getCouponType$n(int idx) {
			return (String) reqMap.get(couponType$n.replace("$n", String.valueOf(idx)));
		}

		public Integer getCouponFee$n(int idx) {
			return (Integer) reqMap.get(couponFee$n.replace("$n", String.valueOf(idx)));
		}

		public String getTransactionId() {
			return (String) reqMap.get(transactionId);
		}

		public String getOutTradeNo() {
			return (String) reqMap.get(outTradeNo);
		}

		public String getAttach() {
			return (String) reqMap.get(attach);
		}

		public String getTimeEnd() {
			return (String) reqMap.get(timeEnd);
		}

		public String getTradeStateDesc() {
			return (String) reqMap.get(tradeStateDesc);
		}

	}

}
