package pub.cnljh.wechat.payment.v2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public abstract class Operation<Resp> {

	protected Map<String, Object> respMap;

	protected Resp resp;

	public Resp response() {
		return this.resp;
	}

	public interface Response {

		String getAppid();

		String getErrCode();

		String getErrCodeDes();

		String getMchId();

		String getNonceStr();

		String getReturnCode();

		String getReturnMsg();

		String getSign();

	}

	protected abstract class RealResponse {

		@Override
		public String toString() {
			Class clazz = this.getClass();
			return String.format("%s.%s%s", clazz.getDeclaringClass().getSimpleName(), clazz.getSimpleName(), respMap);
		}

		public String getReturnCode() {
			return (String) respMap.get(Dictionary.returnCode);
		}

		public String getReturnMsg() {
			return (String) respMap.get(Dictionary.returnMsg);
		}

		public String getAppid() {
			return (String) respMap.get(Dictionary.appid);
		}

		public String getMchId() {
			return (String) respMap.get(Dictionary.mchId);
		}

		public String getNonceStr() {
			return (String) respMap.get(Dictionary.nonceStr);
		}

		public String getSign() {
			return (String) respMap.get(Dictionary.sign);
		}

		public String getResultCode() {
			return (String) respMap.get(Dictionary.resultCode);
		}

		public String getErrCode() {
			return (String) respMap.get(Dictionary.errCode);
		}

		public String getErrCodeDes() {
			return (String) respMap.get(Dictionary.errCodeDes);
		}

		public String getDeviceInfo() {
			return (String) respMap.get(Dictionary.deviceInfo);
		}

		public String getOpenid() {
			return (String) respMap.get(Dictionary.openid);
		}

		public Boolean isSubscribe() {
			return "Y".equals(respMap.get(Dictionary.isSubscribe));
		}

		public TradeType getTradeType() {
			return TradeType.valueOf((String) respMap.get(Dictionary.tradeType));
		}

		public TradeState getTradeState() {
			return TradeState.valueOf((String) respMap.get(Dictionary.tradeState));
		}

		public String getBankType() {
			return (String) respMap.get(Dictionary.bankType);
		}

		public Integer getTotalFee() {
			return Integer.valueOf((String) respMap.get(Dictionary.totalFee));
		}

		public String getFeeType() {
			return (String) respMap.get(Dictionary.feeType);
		}

		public Integer getCashFee() {
			return Integer.valueOf((String) respMap.get(Dictionary.cashFee));
		}

		public String getCashFeeType() {
			return (String) respMap.get(Dictionary.cashFeeType);
		}

		public Integer getSettlementTotalFee() {
			return Integer.valueOf((String) respMap.get(Dictionary.settlementTotalFee));
		}

		public Integer getCouponFee() {
			return Integer.valueOf((String) respMap.get(Dictionary.couponFee));
		}

		public Integer getCouponCount() {
			return Integer.valueOf((String) respMap.get(Dictionary.couponCount));
		}

		public String getCouponId$n(int n) {
			return (String) respMap.get(Dictionary.couponId$n.replace("$n", String.valueOf(n)));
		}

		public String getCouponType$n(int n) {
			return (String) respMap.get(Dictionary.couponType$n.replace("$n", String.valueOf(n)));
		}

		public Integer getCouponFee$n(int n) {
			return Integer.valueOf((String) respMap.get(Dictionary.couponFee$n.replace("$n", String.valueOf(n))));
		}

		public String getTransactionId() {
			return (String) respMap.get(Dictionary.transactionId);
		}

		public String getOutTradeNo() {
			return (String) respMap.get(Dictionary.outTradeNo);
		}

		public String getAttach() {
			return (String) respMap.get(Dictionary.attach);
		}

		public String getTimeEnd() {
			return (String) respMap.get(Dictionary.timeEnd);
		}

		public String getTradeStateDesc() {
			return (String) respMap.get(Dictionary.tradeStateDesc);
		}

		public Boolean getIsSubscribe() {
			return "Y".equals((String) respMap.get(Dictionary.isSubscribe));
		}

		public String getOutRefundNo() {
			return (String) respMap.get(Dictionary.outRefundNo);
		}

		public String getRefundId() {
			return (String) respMap.get(Dictionary.refundId);
		}

		public Integer getRefundFee() {
			return Integer.valueOf((String) respMap.get(Dictionary.refundFee));
		}

		public Integer getSettlementRefundFee() {
			return Integer.valueOf((String) respMap.get(Dictionary.settlementRefundFee));
		}

		public Integer getCashRefundFee() {
			return Integer.valueOf((String) respMap.get(Dictionary.cashRefundFee));
		}

		public Integer getCouponRefundFee() {
			return Integer.valueOf((String) respMap.get(Dictionary.couponRefundFee));
		}

		public Integer getCouponRefundFee$n(int n) {
			return Integer.valueOf((String) respMap.get(Dictionary.couponRefundFee$n.replace("$n", String.valueOf(n))));
		}

		public Integer getCouponRefundCount() {
			return Integer.valueOf((String) respMap.get(Dictionary.couponRefundCount));
		}

		public String getCouponRefundId$n(int n) {
			return (String) respMap.get(Dictionary.couponRefundId$n.replace("$n", String.valueOf(n)));
		}

		public String getPrepayId() {
			return (String) respMap.get(Dictionary.prepayId);
		}

		public String getCodeUrl() {
			return (String) respMap.get(Dictionary.codeUrl);
		}

		public Integer getTotalRefundCount() {
			return Integer.valueOf((String) respMap.get(Dictionary.totalRefundCount));
		}

		public Integer getRefundCount() {
			return Integer.valueOf((String) respMap.get(Dictionary.refundCount));
		}

		public String getOutRefundNo$n(int n) {
			return (String) respMap.get(Dictionary.outRefundNo$n.replace("$n", String.valueOf(n)));
		}

		public String getRefundId$n(int n) {
			return (String) respMap.get(Dictionary.refundId$n.replace("$n", String.valueOf(n)));
		}

		public String getRefundChanne$n(int n) {
			return (String) respMap.get(Dictionary.refundChanne$n.replace("$n", String.valueOf(n)));
		}

		public Integer getRefundFee$n(int n) {
			return Integer.valueOf((String) respMap.get(Dictionary.refundFee$n.replace("$n", String.valueOf(n))));
		}

		public Integer getCouponRefundCount$n(int n) {
			return Integer.valueOf((String) respMap.get(Dictionary.couponRefundCount$n.replace("$n", String.valueOf(n))));
		}

		public String getCouponRefundId$n$m(int n, int m) {
			return (String) respMap.get(Dictionary.couponRefundId$n$m.replace("$n", String.valueOf(n)).replace("$m", String.valueOf(m)));
		}

		public String getCouponType$n$m(int n, int m) {
			return (String) respMap.get(Dictionary.couponType$n$m.replace("$n", String.valueOf(n)).replace("$m", String.valueOf(m)));
		}

		public Integer getCouponRefundFee$n$m(int n, int m) {
			return Integer.valueOf((String) respMap.get(Dictionary.couponRefundFee$n$m.replace("$n", String.valueOf(n)).replace("$m", String.valueOf(m))));
		}

		public String getRefundStatus$n(int n) {
			return (String) respMap.get(Dictionary.refundStatus$n.replace("$n", String.valueOf(n)));
		}

		public String getRefundAccount$n(int n) {
			return (String) respMap.get(Dictionary.refundAccount$n.replace("$n", String.valueOf(n)));
		}

		public String getRefundRecvAccount$n(int n) {
			return (String) respMap.get(Dictionary.refundRecvAccount$n.replace("$n", String.valueOf(n)));
		}

		public String getRefundSuccessTime$n(int n) {
			return (String) respMap.get(Dictionary.refundSuccessTime$n.replace("$n", String.valueOf(n)));
		}

		public String getRefundStatus() {
			return (String) respMap.get(Dictionary.refundStatus);
		}

		public LocalDateTime getSuccessTime() {
			return LocalDateTime.parse((String) respMap.get(Dictionary.successTime), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}

		public String getRefundRecvAccout() {
			return (String) respMap.get(Dictionary.refundRecvAccout);
		}

		public String getRefundAccount() {
			return (String) respMap.get(Dictionary.refundAccount);
		}

		public String getRefundRequestSource() {
			return (String) respMap.get(Dictionary.refundRequestSource);
		}
	}

}
