package pub.ljh.wcpay.v3;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;
import java.util.UUID;
import pub.ljh.wcpay.client.HttpsClient;

public class PayV3 {

	private WeChat context;

	private HttpsClient client;

	public PayV3(WeChat context, HttpsClient client) {
		this.context = context;
		this.client = client;
	}

	public void operate(Operation opt) throws Exception{
		URL url = new URL(opt.getReqUrl());
		String method = opt.getReqMethod();
		String body = opt.getReqBody();
		String token = createToken(method, url, body);
	}

	private String createToken(String method, URL url, String body) throws UnsupportedEncodingException, NoSuchAlgorithmException, SignatureException {
		String nonceStr = createNonceStr();
		long timestamp = System.currentTimeMillis() / 1000;
		String message = buildMessage(method, url, timestamp, nonceStr, body);
		String signature = sign(message.getBytes("utf-8"));
		return "mchid=\"" + context.getMchId() + "\","
						+ "nonce_str=\"" + nonceStr + "\","
						+ "timestamp=\"" + timestamp + "\","
						+ "serial_no=\"" + context.getSerialNo() + "\","
						+ "signature=\"" + signature + "\"";
	}

	private String buildMessage(String method, URL url, long timestamp, String nonceStr, String body) {
		String canonicalUrl = url.getPath();
		if (url.getQuery() != null) {
			canonicalUrl += "?" + url.getQuery();
		}

		return method + "\n"
						+ canonicalUrl + "\n"
						+ timestamp + "\n"
						+ nonceStr + "\n"
						+ body + "\n";
	}

	private String sign(byte[] message) throws NoSuchAlgorithmException, SignatureException {
		Signature sign = Signature.getInstance("SHA256withRSA");
		sign.initSign(yourPrivateKey);
		sign.update(message);

		return Base64.getEncoder().encodeToString(sign.sign());
	}

	private String createNonceStr() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
