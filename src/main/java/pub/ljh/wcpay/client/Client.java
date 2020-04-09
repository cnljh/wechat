package pub.ljh.wcpay.client;

import java.io.IOException;
import java.util.Map;

public abstract class Client {

	public abstract String send(String url, Map<String, String> header, String params, Method method) throws IOException;

	public static String toUrlParamsFormat(Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entrySet : params.entrySet()) {
			String key = entrySet.getKey();
			String value = entrySet.getValue();
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
