package pub.cnljh.wechat.payment.v2;

public class CloseOrder extends Operation<CloseOrder.Request, CloseOrder.Response> {

	public CloseOrder() {
		req = new Request();
		resp = new Response();
	}

	public class Request extends Operation.Request {

		public static final String outTradeNo = "out_trade_no";

		public String getOutTradeNo() {
			return (String) reqMap.get(outTradeNo);
		}

		public void setOutTradeNo(String outTradeNo) {
			reqMap.put(Request.outTradeNo, outTradeNo);
		}

	}

	public class Response extends Operation.Response {
	}

}
