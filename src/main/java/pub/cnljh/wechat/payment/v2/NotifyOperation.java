package pub.cnljh.wechat.payment.v2;

import java.util.HashMap;
import java.util.Map;
import pub.cnljh.wechat.tools.XmlTools;

public abstract class NotifyOperation< Resp> extends Operation< Resp> {

	protected String content;

	public void content(String content) {
		this.content = content;
	}

	public String toback(Boolean success) {
		return toback(success, null);
	}

	public String toback(Boolean success, String msg) {
		Map rtn = new HashMap();
		rtn.put(Dictionary.returnCode, success ? Dictionary.success : Dictionary.fail);
		if (msg != null) {
			rtn.put(Dictionary.returnMsg, msg);
		}
		return XmlTools.parse(rtn).asXML();
	}

}
