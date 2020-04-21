package pub.ljh.wcpay;

import java.util.HashMap;
import java.util.Map;

public abstract class Operation<Req extends Operation.Request, Resp extends Operation.Response> {

	protected String url;
	protected String method;
	protected Req req;
	protected Resp resp;

	public String method() {
		return this.method;
	}

	public String url() {
		return url;
	}

	public Req request() {
		return this.req;
	}

	public Resp response() {
		return this.resp;
	}

	protected abstract class Request {

		private final Map<String, Object> internalStore = new HashMap();

		public final static String APPID = "appid";
		public final static String MCH_ID = "mch_id";
		public final static String NONCE_STR = "nonce_str";
		public final static String SIGN = "sign";
		public final static String SIGN_TYPE = "sign_type";

		Map<String, Object> getStore() {
			return internalStore;
		}

		public Object get(String key) {
			return internalStore.get(key);
		}

		public void set(String key, Object value) {
			internalStore.put(key, value);
		}

	}

	protected abstract class Response {

		public final static String APPID = "appid";
		public final static String MCH_ID = "mch_id";
		public final static String NONCE_STR = "nonce_str";
		public final static String SIGN = "sign";
		public final static String RESULT_CODE = "result_code";
		public final static String ERR_CODE = "err_code";
		public final static String ERR_CODE_DES = "err_code_des";

		private Map<String, Object> internalStore;

		void setStore(Map<String, Object> store) {
			this.internalStore = store;
		}

		public Object get(String key) {
			return internalStore.get(key);
		}

		public void set(String key, Object value) {
			internalStore.put(key, value);
		}
	}

}
