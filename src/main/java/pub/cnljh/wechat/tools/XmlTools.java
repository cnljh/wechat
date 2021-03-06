package pub.cnljh.wechat.tools;

import java.io.IOException;
import java.io.StringWriter;
import static java.lang.String.format;
import java.util.HashMap;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;
import org.dom4j.io.XMLWriter;

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
