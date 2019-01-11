package pub.ljh.wcpay;

import java.io.File;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class WeChatUtilsFactory {

	public static WeChat build(String appid, String secret, String mchId, String key, String keyStore) {
		if (secret.isEmpty()) {
			secret = null;
		}
		try {
			return WeChat.with().Appid(appid).Secret(secret).MchId(mchId).Key(key).KeyStore(getFile(keyStore)).build();
		} catch (IOException ioe) {
			throw new IllegalArgumentException(ioe);
		}
	}

	private static File getFile(String path) throws IOException {
		if (path.startsWith("classpath:")) {
			return new ClassPathResource(path.substring(10)).getFile();
		} else {
			return new FileSystemResource(path).getFile();
		}
	}
}
