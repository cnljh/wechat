package pub.cnljh.wechat.sns;

import java.util.Map;

public class Code2SessionResp {

	private final Map<String, Object> resp;

	private static final String openid = "openid";
	private static final String sessionKey = "session_key";
	private static final String unionid = "unionid";
	private static final String errcode = "errcode";
	private static final String errmsg = "errmsg";

	public Code2SessionResp(Map<String, Object> resp) {
		this.resp = resp;
	}

	public String getOpenid() {
		return (String) resp.get(openid);
	}

	public String getSessionKey() {
		return (String) resp.get(sessionKey);
	}

	public String getUnionid() {
		return (String) resp.get(unionid);
	}

	public Integer getErrcode() {
		return (Integer) resp.get(errcode);
	}

	public String getErrmsg() {
		return (String) resp.get(errmsg);
	}

}
