package pub.cnljh.wechat.payment.v2;

public enum TradeState {
	SUCCESS("支付成功"),
	REFUND("转入退款"),
	NOTPAY("未支付"),
	CLOSED("已关闭"),
	REVOKED("已撤销"),
	USERPAYING("用户支付中"),
	PAYERROR("支付失败");

	private final String desc;

	private TradeState(String desc) {
		this.desc = desc;
	}

	public String desc() {
		return this.desc;
	}

}
