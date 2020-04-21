package pub.ljh.wcpay.payment.v2;

import pub.ljh.wcpay.Operation;

public class RefundQuery extends Operation<RefundQuery.Request, RefundQuery.Response> {

	public RefundQuery() {
		this.req = new Request();
		this.resp = new Response();
	}

	public class Request extends Operation.Request {

		public final static String TRANSACTION_ID = "transaction_id";
		public final static String OUT_TRADE_NO = "out_trade_no";
		public final static String TOTAL_REFUND_COUNT = "totalRefundCount";
		public final static String TOTAL_FEE = "total_fee";
		public final static String FEE_TYPE = "fee_type";
		public final static String CASH_FEE = "cash_fee";
		public final static String CASH_FEE_TYPE = "cash_fee_type";
		public final static String SETTLEMENT_TOTAL_FEE = "settlement_total_fee";
		public final static String REFUND_COUNT="refund_count";
		public final static List<Of> of;

		public final static final static String BODY = "body";
		public final static final static String DETAIL = "detail";
		public final static final static String ATTACH = "attach";
		public final static final static String OUT_TRADE_NO = "out_trade_no";
		public final static final static String FEE_TYPE = "fee_type";
		public final static final static String TOTAL_FEE = "total_fee";
		public final static final static String SPBILL_CREATE_IP = "spbill_create_ip";
		public final static final static String TIME_START = "time_start";
		public final static final static String TIME_EXPIRE = "time_expire";
		public final static final static String GOODS_TAG = "goods_tag";
		public final static final static String NOTIFY_URL = "notify_url";
		public final static final static String TRADE_TYPE = "trade_type";
		public final static final static String PRODUCT_ID = "product_id";
		public final static final static String LIMIT_PAY = "limit_pay";
		public final static final static String SCENE_INFO = "scene_info";
		public final static final static String OPENID = "openid";
	}

	public class Response extends Operation.Response {

		public final static final static String TRADE_TYPE = "trade_type";
		public final static final static String PREPAY_ID = "prepay_id";
		public final static final static String CODE_URL = "code_url";
	}

}
