package pub.ljh.wcpay.payment.v2;

import pub.ljh.wcpay.Operation;

public class UnifiedOrder extends Operation<UnifiedOrder.Request, UnifiedOrder.Response> {

	public UnifiedOrder() {
		this.req = new Request();
		this.resp = new Response();
	}

	public class Request extends Operation.Request {

		public final static String BODY = "body";
		public final static String DETAIL = "detail";
		public final static String ATTACH = "attach";
		public final static String OUT_TRADE_NO = "out_trade_no";
		public final static String FEE_TYPE = "fee_type";
		public final static String TOTAL_FEE = "total_fee";
		public final static String SPBILL_CREATE_IP = "spbill_create_ip";
		public final static String TIME_START = "time_start";
		public final static String TIME_EXPIRE = "time_expire";
		public final static String GOODS_TAG = "goods_tag";
		public final static String NOTIFY_URL = "notify_url";
		public final static String TRADE_TYPE = "trade_type";
		public final static String PRODUCT_ID = "product_id";
		public final static String LIMIT_PAY = "limit_pay";
		public final static String SCENE_INFO = "scene_info";
		public final static String OPENID = "openid";
	}

	public class Response extends Operation.Response {

		public final static String TRADE_TYPE = "trade_type";
		public final static String PREPAY_ID = "prepay_id";
		public final static String CODE_URL = "code_url";
	}

}
