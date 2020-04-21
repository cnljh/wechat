package pub.ljh.wcpay.client_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.function.Function;

public class HttpClient {

	public String send(String url, String method, Map<String, String> header, Function<String, String> paramsProvider) throws IOException {
		String params = paramsProvider.apply(method);

		if ("GET".equals(method)) {
			url = url + "?" + params;
		}

		HttpURLConnection connection = openConnection(url, method);
		if (header != null) {
			setHeader(connection, header);
		}

		if ("POST".equals(method)) {
			setBody(connection, params);
		}

		connection.connect();
		String rtn;
		try {
			rtn = handleResponse(connection);
		} finally {
			connection.disconnect();
		}
		return rtn;
	}

	protected HttpURLConnection openConnection(String url, String method) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod(method);
		connection.setDoOutput(true);
		connection.setDoInput(true);
		return connection;
	}

	protected HttpURLConnection setHeader(HttpURLConnection connection, Map<String, String> header) {
		for (Map.Entry<String, String> entrySet : header.entrySet()) {
			String key = entrySet.getKey();
			String value = entrySet.getValue();
			connection.setRequestProperty(key, value);
		}
		return connection;
	}

	protected HttpURLConnection setBody(HttpURLConnection connection, String params) throws IOException {
		PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
		printWriter.write(params);
		printWriter.flush();
		return connection;
	}

	protected String handleResponse(HttpURLConnection connection) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			char[] buf = new char[256];
			int len;
			while ((len = reader.read(buf)) > 0) {
				sb.append(buf, 0, len);
			}
		}
		return sb.toString();
	}

	public static String toUrlParamsFormat(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Object> entrySet : params.entrySet()) {
			String key = entrySet.getKey();
			Object value = entrySet.getValue();
			if (key == null || value == null) {
				continue;
			}
			sb.append(key).append("=").append(value).append("&");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
