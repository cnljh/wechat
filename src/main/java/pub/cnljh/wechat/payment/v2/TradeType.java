package pub.cnljh.wechat.payment.v2;

public enum TradeType {
	APP("app支付"),
	JSAPI("SAPI支付（或小程序支付）"),
	NATIVE("Native支付"),
	MWEB("H5支付");

	private final String desc;

	private TradeType(String desc) {
		this.desc = desc;
	}

	public String desc() {
		return this.desc;
	}
}
