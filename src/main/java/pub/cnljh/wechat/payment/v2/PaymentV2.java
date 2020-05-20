package pub.cnljh.wechat.payment.v2;

import pub.cnljh.wechat.exception.VerifyFailedException;
import pub.cnljh.wechat.exception.InvalidResponseException;
import pub.cnljh.wechat.exception.PaymentV2Exception;
import java.io.IOException;
import java.security.Security;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.Getter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import pub.cnljh.wechat.client.HttpClient;
import pub.cnljh.wechat.client.HttpsClient;
import pub.cnljh.wechat.tools.MD5Tools;
import pub.cnljh.wechat.tools.XmlTools;

public class PaymentV2 {

	static {
		//增加代理，支持PKCS7Padding
		Security.addProvider(new BouncyCastleProvider());
	}

	private final static boolean DEBUG = false;
	private final static String DOMAIN = "https://api.mch.weixin.qq.com";
	private final static String SANDBOXNEW = DEBUG ? "/sandboxnew" : "";

	private final static Map<Class, String[]> LINK_MAP = new HashMap<Class, String[]>() {
		{
			put(UnifiedOrder.class, new String[]{DOMAIN + SANDBOXNEW + "/pay/unifiedorder", "POST"});
			put(OrderQuery.class, new String[]{DOMAIN + SANDBOXNEW + "/pay/orderquery", "POST"});
			put(CloseOrder.class, new String[]{DOMAIN + SANDBOXNEW + "/pay/closeorder", "POST"});
			put(Refund.class, new String[]{DOMAIN + SANDBOXNEW + "/secapi/pay/refund", "POST"});
			put(RefundQuery.class, new String[]{DOMAIN + SANDBOXNEW + "/pay/refundquery", "POST"});
		}
	};

	@Getter
	private final String appid;
	@Getter
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
		T operation = null;
		try {
			operation = clazz.newInstance();

			if (operation instanceof NotifyOperation) {

			} else if (operation instanceof GenerateOperation) {
				GenerateOperation generateOperation = (GenerateOperation) operation;
				String[] link = LINK_MAP.get(clazz);
				generateOperation.url = link[0];
				generateOperation.method = link[1];
				generateOperation.reqMap = new HashMap() {
					{
						put(Dictionary.appid, appid);
						put(Dictionary.mchId, mchId);
						put(Dictionary.nonceStr, createNonceStr());
						put(Dictionary.signType, "MD5");
					}
				};
			}
		} catch (InstantiationException | IllegalAccessException e) {
		}
		return operation;
	}

	public Feedback exec(Operation operation) throws IOException {
		String respXML;
		if (operation instanceof NotifyOperation) {
			respXML = ((NotifyOperation) operation).content;
		} else {
			GenerateOperation generateOperation = (GenerateOperation) operation;
			Map<String, Object> reqMap = generateOperation.reqMap;

			String sign = createSign("MD5", reqMap);
			reqMap.put(Dictionary.sign, sign);

			Map<String, Object> params = reqMap;
			respXML = client.send(generateOperation.url, generateOperation.method, null, (String method) -> {
				if ("GET".equals(method)) {
					return HttpClient.toUrlParamsFormat(params);
				}
				if ("POST".equals(method)) {
					return XmlTools.parse(params).asXML();
				}
				return null;
			});
		}

		Function<String, Map<String, Object>> xmlToMap = (String xmlStr) -> {
			try {
				Document doc = XmlTools.parse(xmlStr);
				return XmlTools.toMap(doc);
			} catch (DocumentException e) {
				throw new InvalidResponseException(xmlStr);
			}
		};

		Map<String, Object> respMap = xmlToMap.apply(respXML);

		String returnCode = (String) respMap.get(Dictionary.returnCode);
		String returnMsg = (String) respMap.get(Dictionary.returnMsg);
		if (!Dictionary.success.equals(returnCode)) {
			throw new PaymentV2Exception(returnCode + ":" + returnMsg);
		}

		if (operation instanceof RefundNotify) {
			String reqInfo = (String) respMap.get(Dictionary.reqInfo);
			reqInfo = decryptReqInfo(reqInfo);
			Map<String, Object> reqInfoMap = xmlToMap.apply(reqInfo);
			respMap.putAll(reqInfoMap);
		} else {
			if (!respMap.get(Dictionary.sign).equals(createSign("MD5", respMap))) {
				throw new VerifyFailedException(respXML);
			}
		}

		operation.respMap = respMap;

		String resultCode = (String) respMap.getOrDefault(Dictionary.resultCode, Dictionary.success);
		String errCode = (String) respMap.get(Dictionary.errCode);
		String errCodeDes = (String) respMap.get(Dictionary.errCodeDes);
		return new Feedback(operation.getClass(), resultCode, errCode, errCodeDes);
	}

	public static String createNonceStr() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public String createSign(String type, Map<String, Object> params) {
		return createSign(type, params, apiKey);
	}

	public static String createSign(String type, Map<String, Object> params, String apiKey) {
		Predicate<Object> isEmply = str -> str == null || String.valueOf(str).trim().isEmpty();

		String str = params.entrySet().stream()
						.filter(e -> !"sign".equals(e.getKey()) && !isEmply.test(e.getValue()))//排除sign和null值
						.sorted(Map.Entry.comparingByKey())
						.map(e -> e.toString())
						.collect(Collectors.joining("&"));
		str += "&key=" + apiKey;

		return MD5Tools.bytes2HexStr(MD5Tools.encrypt(str), true);
	}

	private String decryptReqInfo(String aStr) {
		byte[] bStr = Base64.getDecoder().decode(aStr);
		byte[] key = MD5Tools.bytes2HexStr(MD5Tools.encrypt(apiKey), false).getBytes();
		try {
			SecretKey secretKey = new SecretKeySpec(key, "ASE");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(bStr));
		} catch (Exception e) {
			throw new RuntimeException("reqInfo解码错误", e);
		}
	}
}
