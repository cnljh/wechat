package pub.ljh.wcpay.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;

public class XmlTools_ {

	private static Pattern humpPattern = Pattern.compile("[A-Z]");

	private static Pattern symbolPattern = Pattern.compile("^[@_]");

	public static String humpToLine(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	public static String subSymbol(String str) {
		Matcher matcher = symbolPattern.matcher(str);
		return matcher.replaceAll("");
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty() || "null".equals(str);
	}

	public static Document parse(String name, Map<String, Object> map, Function<String, String>... key2Name) {
		return DocumentHelper.createDocument(_parse(name, map, key2Name));
	}

	public static Document parse(Map<String, Object> map) {
		return DocumentHelper.createDocument(_parse("root", map, XmlTools_::subSymbol));
	}

	private static Element _parse(String name, Map<String, Object> map, Function<String, String>... key2Name) {
		Element currEl = new DOMElement(name);
		map.forEach((String key, Object value) -> {
			String _name = key;
			if (key2Name != null) {
				for (Function<String, String> f : key2Name) {
					_name = f.apply(_name);
				}
			}

			if (key.startsWith("@")) {
				//属性
				currEl.addAttribute(_name, String.valueOf(value));
			} else if (key.startsWith("_")) {
				//值
				currEl.setText(String.valueOf(value));
			} else {
				//子节点
				_parse(currEl, _name, value, key2Name);
			}
		});

		return currEl;
	}

	private static void _parse(Element parentEl, String k, Object v, Function<String, String>... key2Name) {
		if (v instanceof Map) {
			parentEl.add(_parse(k, (Map) v, key2Name));
		} else if (v instanceof List) {
			for (Object o : (List) v) {
				_parse(parentEl, k, o, key2Name);
			}
		} else {
			Element e = new DOMElement(k);
			e.setText(String.valueOf(v));
			parentEl.add(e);
		}
	}

	public static Document parse(String xmlStr) throws DocumentException {
		return DocumentHelper.parseText(xmlStr);
	}

	public static Map<String, Object> toMap(Element parentEl) {
		Map<String, Object> parentMap = new HashMap();

		//属性
		parentEl.attributes().forEach(a -> {
			parentMap.put("@" + a.getName(), a.getValue());
		});

		List<Element> childEl = parentEl.elements();
		if (childEl.isEmpty()) {
			if (!isEmpty(parentEl.getText())) {
				parentMap.put("_", parentEl.getText());
			}
		} else {
			childEl.forEach((el) -> {
				Map<String, Object> childMap = toMap(el);
				Object o = parentMap.get(el.getName());
				if (o == null) {
					parentMap.put(el.getName(), childMap);
				} else {
					//存在同名子节点,转为list
					if (o instanceof List) {
						((List) o).add(childMap);
					} else {
						List<Object> list = new ArrayList();
						list.add(o);
						list.add(childMap);
						parentMap.put(el.getName(), list);
					}
				}
			});
		}

		return parentMap;
	}

}
