package pub.ljh.wcpay;

import java.io.File;
import java.io.IOException;
import java.security.Security;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pub.ljh.wcpay.client.HttpClient;
import pub.ljh.wcpay.client.HttpsClient;

public class WeChat {

	static {
		//增加代理，支持PKCS7Padding
		Security.addProvider(new BouncyCastleProvider());
	}

	private final String appid;

	private final String secret;

	private final String mchId;

	private final String key;

	private final File keyStore;

	private Pay pay = null;
	private Sns sns = null;

	private WeChat(String appid, String secret, String mchId, String key, File keyStore) {
		this.appid = appid;
		this.secret = secret;
		this.mchId = mchId;
		this.key = key;
		this.keyStore = keyStore;

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

	public static Builder with() {
		return new Builder();
	}

	public static class Builder {

		private String appid;

		private String secret;

		private String mchId;

		private String key;

		private File keyStore;

		public Builder Appid(String appid) {
			this.appid = appid;
			return this;
		}

		public Builder Secret(String secret) {
			this.secret = secret;
			return this;
		}

		public Builder MchId(String mchId) {
			this.mchId = mchId;
			return this;
		}

		public Builder Key(String key) {
			this.key = key;
			return this;
		}

		public Builder KeyStore(File keyStore) {
			this.keyStore = keyStore;
			return this;
		}

		public WeChat build() {
			return new WeChat(appid, secret, mchId, key, keyStore);
		}

	}

	public static LocalDateTime parse(String time) {
		if (time.matches("^\\d{14}$")) {
			return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		}
		if (time.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")) {
			return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
		return null;
	}

	public Pay pay() {
		return pay;
	}

	public Sns sns() {
		return sns;
	}

	public String getAppid() {
		return appid;
	}

	public String getSecret() {
		return secret;
	}

	public String getMchId() {
		return mchId;
	}

	public String getKey() {
		return key;
	}

	public File getKeyStore() {
		return keyStore;
	}

}
