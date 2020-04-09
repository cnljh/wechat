package pub.ljh.wcpay.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpClient extends Client {

	@Override
	public String send(String url, Map<String, String> header, String params, Method method) throws IOException {
		StringBuilder URL = new StringBuilder(url);
		if (method == Method.GET) {
			URL.append("?").append(params);
		}
		URL readUrl = new URL(URL.toString());
		HttpURLConnection connection = (HttpURLConnection) readUrl.openConnection();
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
