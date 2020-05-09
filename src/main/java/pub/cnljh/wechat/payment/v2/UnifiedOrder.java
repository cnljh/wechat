package pub.cnljh.wechat.payment.v2;

public class UnifiedOrder extends Operation<UnifiedOrder.Request, UnifiedOrder.Response> {

	public UnifiedOrder() {
		this.req = new Request();
		this.resp = new Response();
	}

	public class Request extends Operation.Request {

		public static final String body = "body";
		public static final String detail = "detail";
		public static final String attach = "attach";
		public static final String outTradeNo = "out_trade_no";
		public static final String feeType = "fee_type";
		public static final String totalFee = "total_fee";
		public static final String spbillCreateIp = "spbill_create_ip";
		public static final String timeStart = "time_start";
		public static final String timeExpire = "time_expire";
		public static final String goodsTag = "goods_tag";
		public static final String notifyUrl = "notify_url";
		public static final String tradeType = "trade_type";
		public static final String productId = "product_id";
		public static final String limitPay = "limit_pay";
		public static final String sceneInfo = "scene_info";
		public static final String openid = "openid";

		public String getBody() {
			return (String) reqMap.get(body);
		}

		public void setBody(String body) {
			reqMap.put(Request.body, body);
		}

		public String getDetail() {
			return (String) reqMap.get(detail);
		}

		public void setDetail(String detail) {
			reqMap.put(Request.detail, detail);
		}

		public String getAttach() {
			return (String) reqMap.get(attach);
		}

		public void setAttach(String attach) {
			reqMap.put(Request.attach, attach);
		}

		public String getOutTradeNo() {
			return (String) reqMap.get(outTradeNo);
		}

		public void setOutTradeNo(String outTradeNo) {
			reqMap.put(Request.outTradeNo, outTradeNo);
		}

		public String getFeeType() {
			return (String) reqMap.get(feeType);
		}

		public void setFeeType(String feeType) {
			reqMap.put(Request.feeType, feeType);
		}

		public Integer getTotalFee() {
			return (Integer) reqMap.get(totalFee);
		}

		public void setTotalFee(Integer totalFee) {
			reqMap.put(Request.totalFee, totalFee);
		}

		public String getSpbillCreateIp() {
			return (String) reqMap.get(spbillCreateIp);
		}

		public void setSpbillCreateIp(String spbillCreateIp) {
			reqMap.put(Request.spbillCreateIp, spbillCreateIp);
		}

		public String getTimeStart() {
			return (String) reqMap.get(timeStart);
		}

		public void setTimeStart(String timeStart) {
			reqMap.put(Request.timeStart, timeStart);
		}

		public String getTimeExpire() {
			return (String) reqMap.get(timeExpire);
		}

		public void setTimeExpire(String timeExpire) {
			reqMap.put(Request.timeExpire, timeExpire);
		}

		public String getGoodsTag() {
			return (String) reqMap.get(goodsTag);
		}

		public void setGoodsTag(String goodsTag) {
			reqMap.put(Request.goodsTag, goodsTag);
		}

		public String getNotifyUrl() {
			return (String) reqMap.get(notifyUrl);
		}

		public void setNotifyUrl(String notifyUrl) {
			reqMap.put(Request.notifyUrl, notifyUrl);
		}

		public String getTradeType() {
			return (String) reqMap.get(tradeType);
		}

		public void setTradeType(TradeType tradeType) {
			reqMap.put(Request.tradeType, tradeType.name());
		}

		public String getProductId() {
			return (String) reqMap.get(productId);
		}

		public void setProductId(String productId) {
			reqMap.put(Request.productId, productId);
		}

		public String getLimitPay() {
			return (String) reqMap.get(limitPay);
		}

		public void setLimitPay(String limitPay) {
			reqMap.put(Request.limitPay, limitPay);
		}

		public String getSceneInfo() {
			return (String) reqMap.get(sceneInfo);
		}

		public void setSceneInfo(String sceneInfo) {
			reqMap.put(Request.sceneInfo, sceneInfo);
		}

		public String getOpenid() {
			return (String) reqMap.get(openid);
		}

		public void setOpenid(String openid) {
			reqMap.put(Request.openid, openid);
		}

	}

	public class Response extends Operation.Response {

		public static final String tradeType = "trade_type";
		public static final String prepayId = "prepay_id";
		public static final String codeUrl = "code_url";

		public String getTradeType() {
			return (String) respMap.get(Response.tradeType);
		}

		public String getPrepayId() {
			return (String) respMap.get(Response.prepayId);
		}

		public String getCodeUrl() {
			return (String) respMap.get(Response.codeUrl);
		}

	}

}
