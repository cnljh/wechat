package pub.cnljh.wechat.payment.v2;

import java.util.HashMap;
import java.util.Map;

public abstract class NotifyOperation<Resp extends Operation.Response> extends Operation<Operation.Request, Resp> {
	
	protected String content;
	
	public void content(String content) {
		this.content = content;
	}
	
	public Map<String, String> toback(Boolean success) {
		return toback(success, null);
	}
	
	public Map<String, String> toback(Boolean success, String msg) {
		Map rtn = new HashMap();
		rtn.put(Operation.Response.returnCode, success ? "SUCCESS" : "FAIL");
		if (msg != null) {
			rtn.put(Operation.Response.returnMsg, msg);
		}
		return rtn;
	}
	
}
