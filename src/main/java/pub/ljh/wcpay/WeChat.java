package pub.ljh.wcpay;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import lombok.Builder;
import lombok.Getter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pub.ljh.wcpay.client.HttpClient;
import pub.ljh.wcpay.client.HttpsClient;

public class WeChat {

	static {
		//增加代理，支持PKCS7Padding
		Security.addProvider(new BouncyCastleProvider());
	}

	@Getter
	private final String appid;
	@Getter
	private final String mchId;

	private Pay pay = null;
	private Sns sns = null;

	public Pay pay() {
		return pay;
	}

	public Sns sns() {
		return sns;
	}

	@Builder(builderMethodName = "with")
	public WeChat(String appid, String secret, String mchId, String key, InputStream keyStore) {
		this.appid = appid;
		this.mchId = mchId;

		HttpClient client = null;
		if (mchId != null && key != null) {
			try {
				client = keyStore == null ? new HttpClient() : new HttpsClient(keyStore, mchId);
				pay = new Pay(client, appid, mchId, key);
			} catch (IOException ioe) {
				throw new IllegalArgumentException(ioe);
			}
		}
		if (secret != null) {
			if (client == null) {
				client = new HttpClient();
			}
			sns = new Sns(client, appid, secret);
		}
	}

}
