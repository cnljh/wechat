package pub.cnljh.wechat.payment.v2;

public class Refund extends Operation<Refund.Request, Refund.Response> {

	public Refund() {
		req = new Request();
		resp = new Response();
	}

	public class Request extends Operation.Request {

		public static final String outTradeNo = "out_trade_no";
		public static final String transactionId = "transaction_id";
		public static final String outRefundNo = "out_refund_no";
		public static final String totalFee = "total_fee";
		public static final String refundFee = "refund_fee";
		public static final String refundFeeType = "refund_fee_type";
		public static final String refundDesc = "refund_desc";
		public static final String refundAccount = "refund_account";
		public static final String notifyUrl = "notify_url";

		public String getOutTradeNo() {
			return (String) reqMap.get(outTradeNo);
		}

		public void setOutTradeNo(String outTradeNo) {
			reqMap.put(Request.outTradeNo, outTradeNo);
		}

		public String getTransactionId() {
			return (String) reqMap.get(transactionId);
		}

		public void setTransactionId(String transactionId) {
			reqMap.put(Request.transactionId, transactionId);
		}

		public String getOutRefundNo() {
			return (String) reqMap.get(outRefundNo);
		}

		public void setOutRefundNo(String outRefundNo) {
			reqMap.put(Request.outRefundNo, outRefundNo);
		}

		public Integer getTotalFee() {
			return (Integer) reqMap.get(totalFee);
		}

		public void setTotalFee(Integer totalFee) {
			reqMap.put(Request.totalFee, totalFee);
		}

		public Integer getRefundFee() {
			return (Integer) reqMap.get(refundFee);
		}

		public void setRefundFee(Integer refundFee) {
			reqMap.put(Request.refundFee, refundFee);
		}

		public String getRefundFeeType() {
			return (String) reqMap.get(refundFeeType);
		}

		public void setRefundFeeType(String refundFeeType) {
			reqMap.put(Request.refundFeeType, refundFeeType);
		}

		public String getRefundDesc() {
			return (String) reqMap.get(refundDesc);
		}

		public void setRefundDesc(String refundDesc) {
			reqMap.put(Request.refundDesc, refundDesc);
		}

		public String getRefundAccount() {
			return (String) reqMap.get(refundAccount);
		}

		public void setRefundAccount(String refundAccount) {
			reqMap.put(Request.refundAccount, refundAccount);
		}

		public String getNotifyUrl() {
			return (String) reqMap.get(notifyUrl);
		}

		public void setNotifyUrl(String notifyUrl) {
			reqMap.put(Request.notifyUrl, notifyUrl);
		}

	}

	public class Response extends Operation.Response {

		public static final String outTradeNo = "out_trade_no";
		public static final String transactionId = "transaction_id";
		public static final String outRefundNo = "out_refund_no";
		public static final String refundId = "refund_id";
		public static final String refundFee = "refund_fee";
		public static final String settlementRefundFee = "settlement_refund_fee";
		public static final String totalFee = "total_fee";
		public static final String settlementTotalFee = "settlement_total_fee";
		public static final String feeType = "fee_type";
		public static final String cashFee = "cash_fee";
		public static final String cashFeeType = "cash_fee_type";
		public static final String cashRefundFee = "cash_refund_fee";
		public static final String couponType$n = "coupon_type_$n";
		public static final String couponRefundFee = "coupon_refund_fee";
		public static final String couponRefundFee$n = "coupon_refund_fee_$n";
		public static final String couponRefundCount = "coupon_refund_count";
		public static final String couponRefundId$n = "coupon_refund_id_$n";

		public String getOutTradeNo() {
			return (String) reqMap.get(outTradeNo);
		}

		public String getTransactionId() {
			return (String) reqMap.get(transactionId);
		}

		public String getOutRefundNo() {
			return (String) reqMap.get(outRefundNo);
		}

		public String getRefundId() {
			return (String) reqMap.get(refundId);
		}

		public Integer getRefundFee() {
			return (Integer) reqMap.get(refundFee);
		}

		public Integer getSettlementRefundFee() {
			return (Integer) reqMap.get(settlementRefundFee);
		}

		public Integer getTotalFee() {
			return (Integer) reqMap.get(totalFee);
		}

		public Integer getSettlementTotalFee() {
			return (Integer) reqMap.get(settlementTotalFee);
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

		public Integer getCashRefundFee() {
			return (Integer) reqMap.get(cashRefundFee);
		}

		public String getCouponType$n(int idx) {
			return (String) reqMap.get(couponType$n.replace("$n", String.valueOf(idx)));
		}

		public Integer getCouponRefundFee() {
			return (Integer) reqMap.get(couponRefundFee);
		}

		public Integer getCouponRefundFee$n(int idx) {
			return (Integer) reqMap.get(couponRefundFee$n.replace("$n", String.valueOf(idx)));
		}

		public Integer getCouponRefundCount() {
			return (Integer) reqMap.get(couponRefundCount);
		}

		public String getCouponRefundId$n(int idx) {
			return (String) reqMap.get(couponRefundId$n.replace("$n", String.valueOf(idx)));
		}

	}

}
