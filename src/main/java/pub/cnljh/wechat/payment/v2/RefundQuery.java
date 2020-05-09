package pub.cnljh.wechat.payment.v2;

public class RefundQuery extends Operation<RefundQuery.Request, RefundQuery.Response> {

	public RefundQuery() {
		this.req = new Request();
		this.resp = new Response();
	}

	public class Request extends Operation.Request {

		public static final String transactionId = "transaction_id";
		public static final String outTradeNo = "out_trade_no";
		public static final String outRefundNo = "out_refund_no";
		public static final String refundId = "refund_id";
		public static final String offset = "offset";

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

		public String getOutRefundNo() {
			return (String) reqMap.get(outRefundNo);
		}

		public void setOutRefundNo(String outRefundNo) {
			reqMap.put(Request.outRefundNo, outRefundNo);
		}

		public String getRefundId() {
			return (String) reqMap.get(refundId);
		}

		public void setRefundId(String refundId) {
			reqMap.put(Request.refundId, refundId);
		}

		public Integer getOffset() {
			return (Integer) reqMap.get(offset);
		}

		public void setOffset(Integer offset) {
			reqMap.put(Request.offset, offset);
		}

	}

	public class Response extends Operation.Response {

		public static final String transactionId = "transaction_id";
		public static final String outTradeNo = "out_trade_no";
		public static final String totalRefundCount = "total_refund_count";
		public static final String totalFee = "total_fee";
		public static final String feeType = "fee_type";
		public static final String cashFee = "cash_fee";
		public static final String cashFeeType = "cash_fee_type";
		public static final String settlementTotalFee = "settlement_total_fee";
		public static final String refundCount = "refund_count";

		public static final String outRefundNo$n = "out_refund_no_$n";
		public static final String refundId$n = "refund_id_$n";
		public static final String refundChanne$n = "refund_channel_$n";
		public static final String refundFee$n = "refund_fee_$n";

		public static final String couponRefundFee$n = "coupon_refund_fee_$n";
		public static final String couponRefundCount$n = "coupon_refund_count_$n";
		public static final String couponRefundId$n$m = "coupon_refund_id_$n_$m";
		public static final String couponType$n$m = "coupon_type_$n_$m";
		public static final String couponRefundFee$n$m = "coupon_refund_fee_$n_$m";

		public static final String refundStatus$n = "refund_status_$n";
		public static final String refundAccount$n = "refund_account_$n";
		public static final String refundRecvAccount$n = "refund_recv_accout_$n";
		public static final String refundSuccessTime$n = "refund_success_time_$n";

		public String getTransactionId() {
			return (String) respMap.get(transactionId);
		}

		public String getOutTradeNo() {
			return (String) respMap.get(outTradeNo);
		}

		public Integer getTotalRefundCount() {
			return (Integer) respMap.get(totalRefundCount);
		}

		public Integer getTotalFee() {
			return (Integer) respMap.get(totalFee);
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

		public Integer getSettlementTotalFee() {
			return (Integer) respMap.get(settlementTotalFee);
		}

		public Integer getRefundCount() {
			return (Integer) respMap.get(refundCount);
		}

		public String getOutRefundNo$n(int idx) {
			return (String) respMap.get(outRefundNo$n.replace("$n", String.valueOf(idx)));
		}

		public String getRefundId$n(int idx) {
			return (String) respMap.get(refundId$n.replace("$n", String.valueOf(idx)));
		}

		public String getRefundChanne$n(int idx) {
			return (String) respMap.get(refundChanne$n.replace("$n", String.valueOf(idx)));
		}

		public Integer getRefundFee$n(int idx) {
			return (Integer) respMap.get(refundFee$n.replace("$n", String.valueOf(idx)));
		}

		public Integer getCouponRefundFee$n(int idx) {
			return (Integer) respMap.get(couponRefundFee$n.replace("$n", String.valueOf(idx)));
		}

		public Integer getCouponRefundCount$n(int idx) {
			return (Integer) respMap.get(couponRefundCount$n.replace("$n", String.valueOf(idx)));
		}

		public String getCouponRefundId$n$m(int idx, int idx_) {
			return (String) respMap.get(couponRefundId$n$m.replace("$n", String.valueOf(idx)).replace("$m", String.valueOf(idx_)));
		}

		public String getCouponType$n$m(int idx, int idx_) {
			return (String) respMap.get(couponType$n$m.replace("$n", String.valueOf(idx)).replace("$m", String.valueOf(idx_)));
		}

		public Integer getCouponRefundFee$n$m(int idx, int idx_) {
			return (Integer) respMap.get(couponRefundFee$n$m.replace("$n", String.valueOf(idx)).replace("$m", String.valueOf(idx_)));
		}

		public String getRefundStatus$n(int idx) {
			return (String) respMap.get(refundStatus$n.replace("$n", String.valueOf(idx)));
		}

		public String getRefundAccount$n(int idx) {
			return (String) respMap.get(refundAccount$n.replace("$n", String.valueOf(idx)));
		}

		public String getRefundRecvAccount$n(int idx) {
			return (String) respMap.get(refundRecvAccount$n.replace("$n", String.valueOf(idx)));
		}

		public String getRefundSuccessTime$n(int idx) {
			return (String) respMap.get(refundSuccessTime$n.replace("$n", String.valueOf(idx)));
		}

	}

}
