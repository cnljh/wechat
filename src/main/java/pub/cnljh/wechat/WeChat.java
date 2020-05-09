package pub.cnljh.wechat;

import pub.cnljh.wechat.payment.v2.PaymentV2;
import java.io.InputStream;
import java.security.Security;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pub.cnljh.wechat.client.HttpClient;
import pub.cnljh.wechat.client.HttpsClient;
import pub.cnljh.wechat.sns.Sns;

public class WeChat {

	static {
		//增加代理，支持PKCS7Padding
		Security.addProvider(new BouncyCastleProvider());
	}

	@Getter
	private final String appid;
	@Getter
	private final String mchId;
	@Getter
	private final String apiKey;
	@Getter
	private final String secret;
	@Getter
	private final InputStream keyStore;

	private Sns sns = null;
	private PaymentV2 paymentV2;

	public PaymentV2 paymentV2() {
		return paymentV2(appid, mchId, apiKey, keyStore);
	}

	public PaymentV2 paymentV2(@NonNull String appid, @NonNull String mchId, @NonNull String apiKey, @NonNull InputStream keyStore) {
		if (paymentV2 == null) {
			HttpsClient client = new HttpsClient(keyStore, mchId);
			paymentV2 = new PaymentV2(client, appid, mchId, apiKey);
		}
		return paymentV2;
	}

	public Sns sns() {
		return sns(appid, secret);
	}

	public Sns sns(@NonNull String appid, @NonNull String secret) {
		if (sns == null) {
			HttpClient client = new HttpClient();
			sns = new Sns(client, appid, secret);
		}
		return sns;
	}

	@Builder(builderMethodName = "with")
	public WeChat(@NonNull String appid, String secret, @NonNull String mchId, String apiKey, InputStream keyStore) {
		this.appid = appid;
		this.mchId = mchId;
		this.apiKey = apiKey;
		this.secret = secret;
		this.keyStore = keyStore;
	}

}
