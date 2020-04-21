package pub.ljh.wcpay.v3;

import java.util.HashMap;
import java.util.Map;

public abstract class Operation {

	protected final Map<String, Object> _request = new HashMap();

	protected final Map<String, Object> _response = new HashMap();

	public abstract <Req extends Operation.Request> Req request();

	public abstract <Resp extends Operation.Response> Resp response();

	protected class Request {
	}

	protected class Response {
	}

	private final String reqUrl;

	private final String method;

	protected Operation(String reqUrl, String method) {
		this.reqUrl = reqUrl;
		this.method = method;
	}

	public String getReqUrl() {
		return reqUrl;
	}

	public String getReqMethod() {
		return method;
	}

	public String getReqBody() {
		return null;
	}
}
