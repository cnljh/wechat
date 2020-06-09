package pub.cnljh.wechat.sns;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import pub.cnljh.wechat.client.HttpClient;


public class Sns {

	private final static String JSCODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session";

	private final HttpClient client;
	private final String appid;
	private final String secret;

	public Sns(HttpClient client, String appid, String secret) {
		this.client = client;
		this.appid = appid;
		this.secret = secret;
	}

	public Code2SessionResp code2Session(String code) throws IOException {
		String res = client.send(JSCODE_TO_SESSION_URL, "GET", null, (String method) -> {
			Map<String, Object> params = new HashMap();
			params.put("appid", appid);
			params.put("secret", secret);
			params.put("js_code", code);
			params.put("grant_type", "authorization_code");
			return HttpClient.toUrlParamsFormat(params);
		});
		Map json=JSON.parseObject(res);
		return new Code2SessionResp(json);
	}

	public Map decrypt(String sessionKey, String encryptedData, String iv) {
		Decoder decoder = Base64.getDecoder();
		try {
			Key sKeySpec = new SecretKeySpec(decoder.decode(sessionKey), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");

			cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(decoder.decode(iv)));
			byte[] result = cipher.doFinal(decoder.decode(encryptedData));
			return JSON.parseObject(new String(result, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//生成iv    
	private AlgorithmParameters generateIV(byte[] iv) throws Exception {
		AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
		params.init(new IvParameterSpec(iv));
		return params;
	}

}
