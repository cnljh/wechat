package pub.cnljh.wechat.payment.v2;

import pub.cnljh.wechat.exception.VerifyFailedException;
import pub.cnljh.wechat.exception.InvalidResponseException;
import pub.cnljh.wechat.exception.PaymentV2Exception;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import pub.cnljh.wechat.client.HttpClient;
import pub.cnljh.wechat.client.HttpsClient;
import pub.cnljh.wechat.tools.MD5Tools;
import pub.cnljh.wechat.tools.XmlTools;

public class PaymentV2 {

	private final static boolean DEBUG = false;
	private final static String SANDBOXNEW = DEBUG ? "/sandboxnew" : "";

	private final static Map<Class, String[]> LINK_MAP = new HashMap<Class, String[]>() {
		{
			put(UnifiedOrder.class, new String[]{"https://api.mch.weixin.qq.com" + SANDBOXNEW + "/pay/unifiedorder", "POST"});
			put(OrderQuery.class, new String[]{"https://api.mch.weixin.qq.com" + SANDBOXNEW + "/pay/orderquery", "POST"});
		}
	};

	private final String appid;
	private final String mchId;
	private final String apiKey;
	private final HttpsClient client;

	public PaymentV2(HttpsClient client, String appid, String mchId, String apiKey) {
		this.appid = appid;
		this.mchId = mchId;
		this.client = client;
		this.apiKey = apiKey;
	}

	public <T extends Operation> T operation(Class<T> clazz) {
		String[] link = LINK_MAP.get(clazz);

		T operation = null;
		try {
			operation = clazz.newInstance();
			operation.url = link[0];
			operation.method = link[1];
			operation.reqMap = new HashMap();

			Operation.Request request = operation.request();
			request.setAppid(appid);
			request.setMchId(mchId);
			request.setNonceStr(createNonceStr());
			request.setSignType("MD5");
		} catch (InstantiationException | IllegalAccessException e) {
		}
		return operation;
	}

	public Feedback exec(Operation operation) throws IOException {
		Map<String, Object> reqMap = operation.reqMap;

		String sign = createSign("MD5", reqMap, apiKey);
		reqMap.put(Operation.Request.sign, sign);

		Map<String, Object> params = reqMap;
		String respXML = client.send(operation.url, operation.method, null, (String method) -> {
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

		String returnCode = (String) respMap.get(Operation.Response.returnCode);
		String returnMsg = (String) respMap.get(Operation.Response.returnMsg);
		if (!"SUCCESS".equals(returnCode)) {
			throw new PaymentV2Exception(returnCode + ":" + returnMsg);
		}

		if (!respMap.get(Operation.Response.sign).equals(createSign("MD5", respMap, apiKey))) {
			throw new VerifyFailedException(respXML);
		}

		operation.respMap = respMap;

		String resultCode = (String) respMap.get(Operation.Response.resultCode);
		String errCode = (String) respMap.get(Operation.Response.errCode);
		String errCodeDes = (String) respMap.get(Operation.Response.errCodeDes);
		return new Feedback(resultCode, errCode, errCodeDes);
	}

	public static String createNonceStr() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String createSign(String type, Map<String, Object> params, String apiKey) {
		String str = params.entrySet().stream()
						.filter(e -> !"sign".equals(e.getKey()))//排除sign
						.sorted(Comparator.comparing(Map.Entry::getKey))
						.map(e -> e.toString())
						.collect(Collectors.joining("&"));
		str += "&key=" + apiKey;

		return MD5Tools.bytes2HexStr(MD5Tools.encrypt(str)).toUpperCase();
	}
}
