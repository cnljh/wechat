package pub.cnljh.wechat.payment.v2;

public class UnifiedOrder extends GenerateOperation<UnifiedOrder.Request, UnifiedOrder.Response> {

	UnifiedOrder() {
		this.req = new RealRequest();
		this.resp = new RealResponse();
	}

	public interface Request extends GenerateOperation.Request {

		String getBody();

		void setBody(String body);

		String getDetail();

		void setDetail(String detail);

		String getAttach();

		void setAttach(String attach);

		String getOutTradeNo();

		void setOutTradeNo(String outTradeNo);

		String getFeeType();

		void setFeeType(String feeType);

		Integer getTotalFee();

		void setTotalFee(Integer totalFee);

		String getSpbillCreateIp();

		void setSpbillCreateIp(String spbillCreateIp);

		String getTimeStart();

		void setTimeStart(String timeStart);

		String getTimeExpire();

		void setTimeExpire(String timeExpire);

		String getGoodsTag();

		void setGoodsTag(String goodsTag);

		String getNotifyUrl();

		void setNotifyUrl(String notifyUrl);

		TradeType getTradeType();

		void setTradeType(TradeType tradeType);

		String getProductId();

		void setProductId(String productId);

		String getLimitPay();

		void setLimitPay(String limitPay);

		String getSceneInfo();

		void setSceneInfo(String sceneInfo);

		String getOpenid();

		void setOpenid(String openid);

	}

	private class RealRequest extends GenerateOperation.RealRequest implements Request {
	}

	public interface Response extends GenerateOperation.Response {

		TradeType getTradeType();

		String getPrepayId();

		String getCodeUrl();

	}

	private class RealResponse extends GenerateOperation.RealResponse implements Response {

	}

}
