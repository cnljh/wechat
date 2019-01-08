package pub.ljh.wcpay;

import pub.ljh.wcpay.utils.XmlUtils;
import pub.ljh.wcpay.model.UnifiedOrderResp;
import pub.ljh.wcpay.model.UnifiedOrderReq;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.dom4j.DocumentException;
import pub.ljh.wcpay.client.HttpClient;
import pub.ljh.wcpay.client.HttpsClient;
import pub.ljh.wcpay.client.Method;
import pub.ljh.wcpay.exception.WeChatException;
import pub.ljh.wcpay.exception.WeChatSignalException;
import pub.ljh.wcpay.exception.WeChatTradeException;
import pub.ljh.wcpay.exception.WeChatVerifyException;
import pub.ljh.wcpay.model.CloseOrderReq;
import pub.ljh.wcpay.model.OrderNotify;
import pub.ljh.wcpay.model.OrderQueryReq;
import pub.ljh.wcpay.model.OrderQueryResp;
import pub.ljh.wcpay.model.RefundNotify;
import pub.ljh.wcpay.model.RefundReq;
import pub.ljh.wcpay.model.RefundResp;
import pub.ljh.wcpay.utils.MD5Utils;
import pub.ljh.wcpay.utils.Transcoder;

public class Pay {

	private final static boolean DEBUG = false;
	private final static String SANDBOXNEW;
	private final static String GET_SIGN_NEW = "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";

	static {
		SANDBOXNEW = DEBUG ? "/sandboxnew" : "";
	}

	private final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com" + SANDBOXNEW + "/pay/unifiedorder";
	private final static String ORDER_QUERY_URL = "https://api.mch.weixin.qq.com" + SANDBOXNEW + "/pay/orderquery";
	private final static String CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com" + SANDBOXNEW + "/pay/closeorder";
	private final static String REFUND_URL = "https://api.mch.weixin.qq.com" + SANDBOXNEW + "/secapi/pay/refund";
	private final static String REFUND_QUERY_URL = "https://api.mch.weixin.qq.com" + SANDBOXNEW + "/pay/refundquery";

	private final static SerializeConfig JSON_CONFIG = new SerializeConfig() {
		{
			this.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
		}
	};

	private final HttpClient client;

	public final String appid;
	public final String mchId;
	public String key;

	Pay(HttpClient client, String appid, String mchId, String key) {
		this.appid = appid;
		this.mchId = mchId;
		this.key = key;
		this.client = client;

		if (DEBUG) {
			HashMap<String, Object> map = new HashMap();
			map.put("mch_id", mchId);
			map.put("nonce_str", createNonceStr());
			map.put("sign", createSign("MD5", map));
			String req = XmlUtils.parse(map).asXML();
			String resp = null;
			try {
				resp = client.send(GET_SIGN_NEW, null, req, Method.POST);
				this.key = XmlUtils.toJSON(resp).getString("sandbox_signkey");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public UnifiedOrderResp unifiedOrder(UnifiedOrderReq req) throws IOException, WeChatException {
		String params = beforeSend(req);
		String response = client.send(UNIFIED_ORDER_URL, null, params, Method.POST);
		return handleResp(UnifiedOrderResp.class, response);
	}

	public OrderQueryResp orderQuery(OrderQueryReq req) throws IOException, WeChatException {
		String params = beforeSend(req);
		String response = client.send(ORDER_QUERY_URL, null, params, Method.POST);
		return handleResp(OrderQueryResp.class, response);
	}

	public OrderNotify orderNotify(String notify) throws WeChatException {
		return handleResp(OrderNotify.class, notify);
	}

	public void closeOrder(CloseOrderReq req) throws IOException, WeChatException {
		String params = beforeSend(req);
		String response = client.send(CLOSE_ORDER_URL, null, params, Method.POST);
		handleResp(null, response);
	}

	public RefundResp refund(RefundReq req) throws IOException, WeChatException {
		if (client instanceof HttpsClient) {
			String params = beforeSend(req);
			String response = ((HttpsClient) client).sendSSL(REFUND_URL, null, params, Method.POST);
			return handleResp(RefundResp.class, response);
		}
		throw new UnsupportedOperationException("没有设置keyStore");
	}

	public RefundResp refundQuery(RefundReq req) throws IOException, WeChatException {
		String params = beforeSend(req);
		String response = client.send(REFUND_QUERY_URL, null, params, Method.POST);
		return (RefundResp) handleResp(RefundResp.class, response);
	}

	public RefundNotify refundNotify(String notify) throws WeChatException {
		JSONObject resp = handleResp(JSONObject.class, notify);
		String reqInfo = resp.getString("req_info");
		byte[] data = Base64.getDecoder().decode(reqInfo);
		byte[] key_ = MD5Utils.encrypt(key, false).getBytes();
		try {
			SecretKey secretKey = new SecretKeySpec(key_, "ASE");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			reqInfo = new String(cipher.doFinal(data));
			return XmlUtils.toJSON(reqInfo).toJavaObject(RefundNotify.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String beforeSend(Object req) {
		JSONObject map = (JSONObject) JSONObject.toJSON(req, JSON_CONFIG);
		map.put("appid", appid);
		map.put("mch_id", mchId);
		map.put("nonce_str", createNonceStr());
		map.put("sign_type", "MD5");
		map.put("sign", createSign("MD5", map));

		return XmlUtils.parse(map).asXML();
	}

	private void checkResp(JSONObject resp) throws WeChatException {
		if ("FAIL".equals(resp.getOrDefault("return_code", "FAIL"))) {
			throw new WeChatSignalException(resp.getString("return_msg"));
		}
		if ("FAIL".equals(resp.get("result_code"))) {
			throw new WeChatTradeException(resp.getString("err_code"), resp.getString("err_code_des"));
		}

		String sign = resp.getString("sign");
		if (sign == null) {
			return;
		}
		String sign_ = createSign("MD5", resp);
		if (!sign.equals(sign_)) {
			throw new WeChatVerifyException(sign_ + ":" + resp);
		}
	}

	private <T> T handleResp(Class<T> clazz, String response) throws WeChatException {
		try {
			JSONObject resp = XmlUtils.toJSON(response);

			checkResp(resp);

			if (clazz == null) {
				return null;
			}
			if (clazz == JSONObject.class) {
				return (T) resp;
			}
			return resp.toJavaObject(clazz);
		} catch (DocumentException de) {
			throw new WeChatException("Xml response:" + response, de);
		}
	}

	public String createNonceStr() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public String createSign(String type, Map<String, Object> params) {
		//默认先去掉sign值
		params.remove("sign");

		Set<String> keySet = params.keySet();
		String[] keyArray = new String[keySet.size()];
		keySet.toArray(keyArray);
		String temp;
		for (int i = keyArray.length - 1; i > 0; i--) {
			for (int ii = 0; ii < i; ii++) {
				if (keyArray[ii].compareTo(keyArray[ii + 1]) > 0) {
					temp = keyArray[ii + 1];
					keyArray[ii + 1] = keyArray[ii];
					keyArray[ii] = temp;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String key : keyArray) {
			Object v = params.get(key);
			if (v == null) {
				continue;
			}
			String value = v.toString();
			if (value.trim().isEmpty()) {
				continue;
			}
			sb.append(key).append("=").append(value).append("&");
		}
		sb.append("key").append("=").append(key);
		return Transcoder.bytes2HexStr(MD5Utils.encrypt(sb.toString())).toUpperCase();
	}

}
