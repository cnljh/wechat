package pub.cnljh.wechat.payment.v2;

import java.util.Map;
import org.dom4j.Document;
import org.junit.Test;
import static org.junit.Assert.*;
import pub.cnljh.wechat.tools.XmlTools;

public class PaymentV2Test {

private final String apiKey="V85s0fn9YrXIKzHEVLplRSQHNOhUML3L";

	@Test
	public void testCreateSign() throws Exception {
		String xmlStr = "<xml><return_code><![CDATA[SUCCESS]]></return_code>\n"
						+ "<return_msg><![CDATA[OK]]></return_msg>\n"
						+ "<appid><![CDATA[wx6db8e29760c48269]]></appid>\n"
						+ "<mch_id><![CDATA[1503333761]]></mch_id>\n"
						+ "<device_info><![CDATA[]]></device_info>\n"
						+ "<nonce_str><![CDATA[oIgmKnFWKShRtMD3]]></nonce_str>\n"
						+ "<sign><![CDATA[D31AF8C1BFFB2E033370EE071A90D551]]></sign>\n"
						+ "<result_code><![CDATA[SUCCESS]]></result_code>\n"
						+ "<total_fee>1</total_fee>\n"
						+ "<out_trade_no><![CDATA[123698745]]></out_trade_no>\n"
						+ "<trade_state><![CDATA[NOTPAY]]></trade_state>\n"
						+ "<trade_state_desc><![CDATA[订单未支付]]></trade_state_desc>\n"
						+ "</xml>";
		Document doc = XmlTools.parse(xmlStr);
		Map<String, Object> params = XmlTools.toMap(doc);
		String result = PaymentV2.createSign("MD5", params, apiKey);
		System.out.println(params);
		assertEquals(params.get("sign"), result);
	}

}
