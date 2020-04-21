package pub.ljh.wcpay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import pub.ljh.wcpay.client_.HttpClient;
import pub.ljh.wcpay.client_.HttpsClient;
import pub.ljh.wcpay.payment.v2.UnifiedOrder;
import pub.ljh.wcpay.tools.MD5Tools;
import pub.ljh.wcpay.tools.XmlTools;

public class PaymentV2 {

	private final static boolean DEBUG = false;
	private final static String SANDBOXNEW = DEBUG ? "/sandboxnew" : "";

	private final static String RETURN_CODE = "return_code";
	private final static String RETURN_MSG = "return_msg";

	private final static Map<Class, String[]> LINK_MAP = new HashMap<Class, String[]>() {
		{
			put(UnifiedOrder.class, new String[]{"https://api.mch.weixin.qq.com" + SANDBOXNEW + "/pay/unifiedorder", "POST"});
		}
	};

	private WeChat context;
	private HttpsClient client;

	public PaymentV2(WeChat context, HttpsClient client) {
		this.context = context;
		this.client = client;
	}

	public <T extends Operation> T operation(Class<T> clazz) {
		String[] link = LINK_MAP.get(clazz);
		T operation = null;
		try {
			operation = clazz.newInstance();
			operation.url = link[0];
			operation.method = link[1];
			Operation.Request request = operation.request();
			request.set(Operation.Request.APPID, context.getAppid());
			request.set(Operation.Request.MCH_ID, context.getMchId());
			request.set(Operation.Request.NONCE_STR, createNonceStr());
			request.set(Operation.Request.SIGN_TYPE, "MD5");
		} catch (InstantiationException | IllegalAccessException e) {
		}
		return operation;
	}

	public void exec(Operation operation) throws IOException {
		Operation.Request request = operation.request();
		Operation.Response response = operation.response();

		String sign = createSign("MD5", request.getStore());
		operation.request().set(Operation.Request.SIGN, sign);

		Map<String, Object> params = request.getStore();
		String respXML = client.send(operation.url(), operation.method(), null, (String method) -> {
			if ("GET".equals(method)) {
				return HttpClient.toUrlParamsFormat(params);
			}
			if ("POST".equals(method)) {
				return XmlTools.parse(params).asXML();
			}
			return null;
		});

		Map<String, Object> respMap;
		try {
			Document doc = XmlTools.parse(respXML);
			respMap = XmlTools.toMap(doc);
		} catch (DocumentException e) {
			throw new InvalidResponseException(respXML);
		}

		String returnCode = (String) respMap.get(RETURN_CODE);
		String returnMsg = (String) respMap.get(RETURN_MSG);
		if (!"SUCCESS".equals(returnCode)) {
			throw new PaymentV2Exception(returnCode + ":" + returnMsg);
		}

		if (response.get(Operation.Response.SIGN).equals(createSign("MD5", respMap))) {
			throw new VerifyFailedException(respXML);
		}

		response.setStore(respMap);
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
		sb.append("key").append("=").append(context.getApiKey());

		return MD5Tools.bytes2HexStr(MD5Tools.encrypt(sb.toString()));
	}
}
