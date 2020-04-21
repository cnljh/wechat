package pub.ljh.wcpay.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;

public class XmlTools {

	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty() || "null".equals(str);
	}

	public static Document parse(String xmlStr) throws DocumentException {
		return DocumentHelper.parseText(xmlStr);
	}

	public static Document parse(Map<String, Object> map) {
		Element currEl = new DOMElement("xml");
		map.forEach((String key, Object value) -> {
			Element el = new DOMElement(key);
			el.setText(String.valueOf(value));
			currEl.add(el);
		});
		return DocumentHelper.createDocument(currEl);
	}

	public static Map<String, Object> toMap(Document doc) {
		Map<String, Object> map = new HashMap();
		Element rootEl = doc.getRootElement();
		rootEl.elements().forEach(el -> map.put(el.getName(), el.getTextTrim()));
		return map;
	}

}
