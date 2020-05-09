package pub.cnljh.wechat.payment.v2;

import java.util.Map;

public abstract class Operation<Req extends Operation.Request, Resp extends Operation.Response> {

	protected Map<String, Object> reqMap;
	protected Map<String, Object> respMap;

	protected String url;
	protected String method;

	protected Req req;
	protected Resp resp;

	public Req request() {
		return this.req;
	}

	public Resp response() {
		return this.resp;
	}

	@Override
	public String toString() {
		return String.format("%s(url=%s,method=%s,request=%s,response=%s)", this.getClass().getSimpleName(), url, method, reqMap, respMap);
	}

	protected abstract class Request {

		@Override
		public String toString() {
			Class clazz = this.getClass();
			return String.format("%s.%s%s", clazz.getDeclaringClass().getSimpleName(), clazz.getSimpleName(), reqMap);
		}

		public static final String appid = "appid";
		public static final String mchId = "mch_id";
		public static final String nonceStr = "nonce_str";
		public static final String sign = "sign";
		public static final String signType = "sign_type";

		public String getAppid() {
			return (String) reqMap.get(appid);
		}

		public void setAppid(String appid) {
			reqMap.put(Request.appid, appid);
		}

		public String getMchId() {
			return (String) reqMap.get(mchId);
		}

		public void setMchId(String mchId) {
			reqMap.put(Request.mchId, mchId);
		}

		public String getNonceStr() {
			return (String) reqMap.get(nonceStr);
		}

		public void setNonceStr(String nonceStr) {
			reqMap.put(Request.nonceStr, nonceStr);
		}

		public String getSign() {
			return (String) reqMap.get(sign);
		}

		public void setSign(String sign) {
			reqMap.put(Request.sign, sign);
		}

		public String getSignType() {
			return (String) reqMap.get(signType);
		}

		public void setSignType(String signType) {
			reqMap.put(Request.signType, signType);
		}

	}

	protected abstract class Response {

		@Override
		public String toString() {
			Class clazz = this.getClass();
			return String.format("%s.%s%s", clazz.getDeclaringClass().getSimpleName(), clazz.getSimpleName(), respMap);
		}

		public static final String returnCode = "return_code";
		public static final String returnMsg = "return_msg";
		public static final String appid = "appid";
		public static final String mchId = "mch_id";
		public static final String nonceStr = "nonce_str";
		public static final String sign = "sign";
		public static final String resultCode = "result_code";
		public static final String errCode = "err_code";
		public static final String errCodeDes = "err_code_des";

		public String getReturnCode() {
			return (String) respMap.get(returnCode);
		}

		public String getReturnMsg() {
			return (String) respMap.get(returnMsg);
		}

		public String getAppid() {
			return (String) respMap.get(appid);
		}

		public String getMchId() {
			return (String) respMap.get(mchId);
		}

		public String getNonceStr() {
			return (String) respMap.get(nonceStr);
		}

		public String getSign() {
			return (String) respMap.get(sign);
		}

		public String getResultCode() {
			return (String) respMap.get(resultCode);
		}

		public String getErrCode() {
			return (String) respMap.get(errCode);
		}

		public String getErrCodeDes() {
			return (String) respMap.get(errCodeDes);
		}

	}
}
