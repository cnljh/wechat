package pub.ljh.wcpay.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;

public class XmlUtils {

	private static Pattern humpPattern = Pattern.compile("[A-Z]");

	public static String humpToLine(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	public static boolean isEmpty(String str) {

		if (str == null || str.trim().isEmpty() || "null".equals(str)) {
			return true;
		}
		return false;
	}

	public static Document parse(Map<String, Object> map) {
		Element root = new DOMElement("xml");
		for (Map.Entry<String, Object> entrySet : map.entrySet()) {
			String key = humpToLine(entrySet.getKey());
			Object v = entrySet.getValue();
			if (v == null) {
				continue;
			}
			String value = v.toString();
			if (value == null) {
				continue;
			}
			Element el = new DOMElement(key);
			el.setText(value);
			root.add(el);
		}
		return DocumentHelper.createDocument(root);
	}

	public static JSONObject toJSON(String xmlStr) throws DocumentException {
		Document dom = DocumentHelper.parseText(xmlStr);
		JSONObject json = dom4j2JSON(dom.getRootElement(), new JSONObject());
		return json;
	}

	public static JSONObject dom4j2JSON(Element element, JSONObject json) {
		//如果是属性
		for (Object o : element.attributes()) {
			Attribute attr = (Attribute) o;
			if (!isEmpty(attr.getValue())) {
				json.put("@" + attr.getName(), attr.getValue());
			}
		}
		List<Element> chdEl = element.elements();
		if (chdEl.isEmpty() && !isEmpty(element.getText())) {//如果没有子元素,只有一个值
			json.put(element.getName(), element.getText());
		}

		for (Element e : chdEl) {//有子元素
			if (!e.elements().isEmpty()) {//子元素也有子元素
				JSONObject chdjson = new JSONObject();
				dom4j2JSON(e, chdjson);
				Object o = json.get(e.getName());
				if (o != null) {
					JSONArray jsona = null;
					if (o instanceof JSONObject) {//如果此元素已存在,则转为jsonArray
						JSONObject jsono = (JSONObject) o;
						json.remove(e.getName());
						jsona = new JSONArray();
						jsona.add(jsono);
						jsona.add(chdjson);
					}
					if (o instanceof JSONArray) {
						jsona = (JSONArray) o;
						jsona.add(chdjson);
					}
					json.put(e.getName(), jsona);
				} else {
					if (!chdjson.isEmpty()) {
						json.put(e.getName(), chdjson);
					}
				}

			} else {//子元素没有子元素
				for (Object o : element.attributes()) {
					Attribute attr = (Attribute) o;
					if (!isEmpty(attr.getValue())) {
						json.put("@" + attr.getName(), attr.getValue());
					}
				}
				if (!e.getText().isEmpty()) {
					json.put(e.getName(), e.getText());
				}
			}
		}

		return json;
	}

}
