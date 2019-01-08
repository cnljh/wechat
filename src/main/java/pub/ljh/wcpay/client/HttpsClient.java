package pub.ljh.wcpay.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

public class HttpsClient extends HttpClient {

     private SSLContext ctx;

     public HttpsClient(File keyStoreFile, String keyStorePWD) throws IOException {
	  try {
	       KeyStore keyStore = KeyStore.getInstance("PKCS12");
	       try (FileInputStream is = new FileInputStream(keyStoreFile);) {
		    keyStore.load(is, keyStorePWD.toCharArray());
	       }

	       KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
	       kmf.init(keyStore, keyStorePWD.toCharArray());

	       ctx = SSLContext.getInstance("SSL");

	       ctx.init(kmf.getKeyManagers(), null, null);
	  } catch (GeneralSecurityException gse) {
	       ctx = null;
	  }
     }

     public String sendSSL(String url, Map<String, String> header, String params, Method method) throws IOException {
	  StringBuilder URL = new StringBuilder(url);
	  if (method == Method.GET) {
	       URL.append("?").append(params);
	  }
	  URL readUrl = new URL(URL.toString());
	  HttpsURLConnection connection = (HttpsURLConnection) readUrl.openConnection();
	  connection.setSSLSocketFactory(ctx.getSocketFactory());
	  connection.setRequestMethod(method.name());
	  connection.setDoOutput(true);
	  connection.setDoInput(true);
	  if (header != null) {
	       for (Map.Entry<String, String> entrySet : header.entrySet()) {
		    String key = entrySet.getKey();
		    String value = entrySet.getValue();
		    connection.setRequestProperty(key, value);
	       }
	  }

	  if (method == Method.POST) {
	       PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
	       printWriter.write(params);
	       printWriter.flush();
	  }

	  connection.connect();

	  StringBuilder sb = new StringBuilder();
	  try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	       char[] buf = new char[256];
	       int len;
	       while ((len = reader.read(buf)) > 0) {
		    sb.append(buf, 0, len);
	       }
	  } finally {
	       connection.disconnect();
	  }
	  return sb.toString();
     }

}
