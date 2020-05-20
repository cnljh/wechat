package pub.cnljh.wechat.payment.v2;

import java.util.Map;

public abstract class GenerateOperation<Req, Resp> extends Operation<Resp> {

	protected String url;
	protected String method;

	protected Map<String, Object> reqMap;

	protected Req req;

	public Req request() {
		return this.req;
	}

	@Override
	public String toString() {
		return String.format("%s(url=%s,method=%s,request=%s,response=%s)", this.getClass().getSimpleName(), url, method, reqMap, respMap);
	}

	public interface Request {

		String getAppid();

		String getMchId();

		String getNonceStr();

		String getSign();

		String getSignType();

		void setAppid(String appid);

		void setMchId(String mchId);

		void setNonceStr(String nonceStr);

		void setSign(String sign);

		void setSignType(String signType);
	}

	protected abstract class RealRequest {

		@Override
		public String toString() {
			Class clazz = this.getClass();
			return String.format("%s.%s%s", clazz.getDeclaringClass().getSimpleName(), clazz.getSimpleName(), reqMap);
		}

		public String getAppid() {
			return (String) reqMap.get(Dictionary.appid);
		}

		public void setAppid(String appid) {
			reqMap.put(Dictionary.appid, appid);
		}

		public String getMchId() {
			return (String) reqMap.get(Dictionary.mchId);
		}

		public void setMchId(String mchId) {
			reqMap.put(Dictionary.mchId, mchId);
		}

		public String getNonceStr() {
			return (String) reqMap.get(Dictionary.nonceStr);
		}

		public void setNonceStr(String nonceStr) {
			reqMap.put(Dictionary.nonceStr, nonceStr);
		}

		public String getSign() {
			return (String) reqMap.get(Dictionary.sign);
		}

		public void setSign(String sign) {
			reqMap.put(Dictionary.sign, sign);
		}

		public String getSignType() {
			return (String) reqMap.get(Dictionary.signType);
		}

		public void setSignType(String signType) {
			reqMap.put(Dictionary.signType, signType);
		}

		public String getTransactionId() {
			return (String) reqMap.get(Dictionary.transactionId);
		}

		public void setTransactionId(String transactionId) {
			reqMap.put(Dictionary.transactionId, transactionId);
		}

		public String getOutTradeNo() {
			return (String) reqMap.get(Dictionary.outTradeNo);
		}

		public void setOutTradeNo(String outTradeNo) {
			reqMap.put(Dictionary.outTradeNo, outTradeNo);
		}

		public String getOutRefundNo() {
			return (String) reqMap.get(Dictionary.outRefundNo);
		}

		public void setOutRefundNo(String outRefundNo) {
			reqMap.put(Dictionary.outRefundNo, outRefundNo);
		}

		public Integer getTotalFee() {
			return (Integer) reqMap.get(Dictionary.totalFee);
		}

		public void setTotalFee(Integer totalFee) {
			reqMap.put(Dictionary.totalFee, totalFee);
		}

		public Integer getRefundFee() {
			return (Integer) reqMap.get(Dictionary.refundFee);
		}

		public void setRefundFee(Integer refundFee) {
			reqMap.put(Dictionary.refundFee, refundFee);
		}

		public String getRefundFeeType() {
			return (String) reqMap.get(Dictionary.refundFeeType);
		}

		public void setRefundFeeType(String refundFeeType) {
			reqMap.put(Dictionary.refundFeeType, refundFeeType);
		}

		public String getRefundDesc() {
			return (String) reqMap.get(Dictionary.refundDesc);
		}

		public void setRefundDesc(String refundDesc) {
			reqMap.put(Dictionary.refundDesc, refundDesc);
		}

		public String getRefundAccount() {
			return (String) reqMap.get(Dictionary.refundAccount);
		}

		public void setRefundAccount(String refundAccount) {
			reqMap.put(Dictionary.refundAccount, refundAccount);
		}

		public String getNotifyUrl() {
			return (String) reqMap.get(Dictionary.notifyUrl);
		}

		public void setNotifyUrl(String notifyUrl) {
			reqMap.put(Dictionary.notifyUrl, notifyUrl);
		}

		public String getBody() {
			return (String) reqMap.get(Dictionary.body);
		}

		public void setBody(String body) {
			reqMap.put(Dictionary.body, body);
		}

		public String getDetail() {
			return (String) reqMap.get(Dictionary.detail);
		}

		public void setDetail(String detail) {
			reqMap.put(Dictionary.detail, detail);
		}

		public String getAttach() {
			return (String) reqMap.get(Dictionary.attach);
		}

		public void setAttach(String attach) {
			reqMap.put(Dictionary.attach, attach);
		}

		public String getFeeType() {
			return (String) reqMap.get(Dictionary.feeType);
		}

		public void setFeeType(String feeType) {
			reqMap.put(Dictionary.feeType, feeType);
		}

		public String getSpbillCreateIp() {
			return (String) reqMap.get(Dictionary.spbillCreateIp);
		}

		public void setSpbillCreateIp(String spbillCreateIp) {
			reqMap.put(Dictionary.spbillCreateIp, spbillCreateIp);
		}

		public String getTimeStart() {
			return (String) reqMap.get(Dictionary.timeStart);
		}

		public void setTimeStart(String timeStart) {
			reqMap.put(Dictionary.timeStart, timeStart);
		}

		public String getTimeExpire() {
			return (String) reqMap.get(Dictionary.timeExpire);
		}

		public void setTimeExpire(String timeExpire) {
			reqMap.put(Dictionary.timeExpire, timeExpire);
		}

		public String getGoodsTag() {
			return (String) reqMap.get(Dictionary.goodsTag);
		}

		public void setGoodsTag(String goodsTag) {
			reqMap.put(Dictionary.goodsTag, goodsTag);
		}

		public TradeType getTradeType() {
			return TradeType.valueOf((String) reqMap.get(Dictionary.tradeType));
		}

		public void setTradeType(TradeType tradeType) {
			reqMap.put(Dictionary.tradeType, tradeType.name());
		}

		public String getProductId() {
			return (String) reqMap.get(Dictionary.productId);
		}

		public void setProductId(String productId) {
			reqMap.put(Dictionary.productId, productId);
		}

		public String getLimitPay() {
			return (String) reqMap.get(Dictionary.limitPay);
		}

		public void setLimitPay(String limitPay) {
			reqMap.put(Dictionary.limitPay, limitPay);
		}

		public String getSceneInfo() {
			return (String) reqMap.get(Dictionary.sceneInfo);
		}

		public void setSceneInfo(String sceneInfo) {
			reqMap.put(Dictionary.sceneInfo, sceneInfo);
		}

		public String getOpenid() {
			return (String) reqMap.get(Dictionary.openid);
		}

		public void setOpenid(String openid) {
			reqMap.put(Dictionary.openid, openid);
		}

		public String getRefundId() {
			return (String) reqMap.get(Dictionary.refundId);
		}

		public void setRefundId(String refundId) {
			reqMap.put(Dictionary.refundId, refundId);
		}

		public Integer getOffset() {
			return (Integer) reqMap.get(Dictionary.offset);
		}

		public void setOffset(Integer offset) {
			reqMap.put(Dictionary.offset, offset);
		}

	}

}
