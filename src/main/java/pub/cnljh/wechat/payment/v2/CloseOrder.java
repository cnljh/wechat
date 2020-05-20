package pub.cnljh.wechat.payment.v2;

public class CloseOrder extends GenerateOperation<CloseOrder.Request, CloseOrder.Response> {

	CloseOrder() {
		req = new RealRequest();
		resp = new RealResponse();
	}

	public interface Request extends GenerateOperation.Request {

		String getOutTradeNo();

		void setOutTradeNo(String outTradeNo);

	}

	private class RealRequest extends GenerateOperation.RealRequest implements Request {
	}

	public interface Response extends GenerateOperation.Response {
	}

	private class RealResponse extends GenerateOperation.RealResponse implements Response {
	}

}
