package pub.cnljh.wechat.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

public class HttpsClient extends HttpClient {

	private SSLContext ctx;

	public HttpsClient(InputStream is, String keyStorePWD) {
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			keyStore.load(is, keyStorePWD.toCharArray());

			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(keyStore, keyStorePWD.toCharArray());

			ctx = SSLContext.getInstance("SSL");

			ctx.init(kmf.getKeyManagers(), null, null);
		} catch (IOException | GeneralSecurityException e) {
			ctx = null;
			throw new RuntimeException(e);
		}
	}

	@Override
	protected HttpURLConnection openConnection(String url, String method) throws IOException {
		HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
		connection.setSSLSocketFactory(ctx.getSocketFactory());
		connection.setRequestMethod(method);
		connection.setDoOutput(true);
		connection.setDoInput(true);
		return connection;
	}

}
