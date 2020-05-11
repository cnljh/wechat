package pub.cnljh.wechat.payment.v2;

public class OrderNotify extends NotifyOperation<OrderNotify.Response> {

	public OrderNotify() {
		this.resp = new Response();
	}

	public class Response extends Operation.Response {

		public static final String openid = "openid";
		public static final String isSubscribe = "is_subscribe";
		public static final String tradeType = "trade_type";
		public static final String bankType = "bank_type";
		public static final String totalFee = "total_fee";
		public static final String settlementTotalFee = "settlement_total_fee";
		public static final String feeType = "fee_type";
		public static final String cashFee = "cash_fee";
		public static final String cashFeeType = "cash_fee_type";
		public static final String couponFee = "coupon_fee";
		public static final String couponCount = "coupon_count";
		public static final String couponType$n = "coupon_type_$n	";
		public static final String couponId$n = "coupon_id_$n	";
		public static final String couponFee$n = "coupon_fee_$n";
		public static final String transactionId = "transaction_id";
		public static final String outTradeNo = "out_trade_no";
		public static final String attach = "attach";
		public static final String timeEnd = "time_end";

		public String getOpenid() {
			return (String) respMap.get(openid);
		}

		public Boolean getIsSubscribe() {
			return "Y".equals((String) respMap.get(isSubscribe));
		}

		public String getTradeType() {
			return (String) respMap.get(tradeType);
		}

		public String getBankType() {
			return (String) respMap.get(bankType);
		}

		public Integer getTotalFee() {
			return (Integer) respMap.get(totalFee);
		}

		public Integer getSettlementTotalFee() {
			return (Integer) respMap.get(settlementTotalFee);
		}

		public String getFeeType() {
			return (String) respMap.get(feeType);
		}

		public Integer getCashFee() {
			return (Integer) respMap.get(cashFee);
		}

		public String getCashFeeType() {
			return (String) respMap.get(cashFeeType);
		}

		public Integer getCouponFee() {
			return (Integer) respMap.get(couponFee);
		}

		public Integer getCouponCount() {
			return (Integer) respMap.get(couponCount);
		}

		public String getCouponType$n(int idx) {
			return (String) respMap.get(couponType$n.replace("$n", String.valueOf(idx)));
		}

		public String getCouponId$n(int idx) {
			return (String) respMap.get(couponId$n.replace("$n", String.valueOf(idx)));
		}

		public Integer getCouponFee$n(int idx) {
			return (Integer) respMap.get(couponFee$n.replace("$n", String.valueOf(idx)));
		}

		public String getTransactionId() {
			return (String) respMap.get(transactionId);
		}

		public String getOutTradeNo() {
			return (String) respMap.get(outTradeNo);
		}

		public String getAttach() {
			return (String) respMap.get(attach);
		}

		public String getTimeEnd() {
			return (String) respMap.get(timeEnd);
		}

	}

}
