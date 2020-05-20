package pub.cnljh.wechat;

import java.io.FileInputStream;
import java.io.IOException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pub.cnljh.wechat.client.HttpsClient;
import pub.cnljh.wechat.payment.v2.CloseOrder;
import pub.cnljh.wechat.payment.v2.Feedback;
import pub.cnljh.wechat.payment.v2.TradeNotify;
import pub.cnljh.wechat.payment.v2.OrderQuery;
import pub.cnljh.wechat.payment.v2.PaymentV2;
import pub.cnljh.wechat.payment.v2.TradeType;
import pub.cnljh.wechat.payment.v2.UnifiedOrder;

public class WeChatTest extends BaseJunit4Test {

	@Autowired
	private WeChat wechat;
	@Autowired
	private PaymentV2 paymentV2;

	@Test
	public void test() throws IOException {
		PaymentV2 p = wechat.paymentV2();
		System.out.println(p.equals(paymentV2));
		PaymentV2 p2 = wechat.paymentV2("wx6db8e29760c48268", "1503333761", "V85s0fn9YrXIKzHEVLplRSQHNOhUML3L", new FileInputStream("C:\\Users\\Think\\Desktop\\workarea\\WXCertUtil\\cert\\1503333761_20200411_cert\\apiclient_cert.p12"));
		System.out.println(p2.equals(paymentV2));
	}

	@Test
	public void testOrderQuery() throws IOException {
		OrderQuery orderQuery = paymentV2.operation(OrderQuery.class);
		OrderQuery.Request request = orderQuery.request();
		request.setOutTradeNo("123698745");
		Feedback feedback = paymentV2.exec(orderQuery);
		System.out.println(feedback);
		System.out.println(orderQuery.response());
	}

	@Test
	public void testUnifedOrder() throws IOException {
		UnifiedOrder unifiedOrder = paymentV2.operation(UnifiedOrder.class);
		UnifiedOrder.Request request = unifiedOrder.request();
		request.setBody("测试");
		request.setOutTradeNo("123698745");
		request.setTotalFee(1);
		request.setNotifyUrl("127.0.0.1");
		request.setTradeType(TradeType.APP);
		Feedback feedback = paymentV2.exec(unifiedOrder);
		System.out.println(feedback);
		System.out.println(unifiedOrder.response());
	}

	@Test
	public void testCloseOrder() throws IOException {
		CloseOrder closeOrder = paymentV2.operation(CloseOrder.class);
		CloseOrder.Request request = closeOrder.request();
		request.setOutTradeNo("123698745");
		Feedback feedback = paymentV2.exec(closeOrder);
		System.out.println(feedback);
		System.out.println(closeOrder.response());
	}

	@Test
	public void testOrderNotify() throws IOException {
		TradeNotify orderNotify = paymentV2.operation(TradeNotify.class);
		orderNotify.content("<xml>\n"
						+ "  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n"
						+ "  <attach><![CDATA[支付测试]]></attach>\n"
						+ "  <bank_type><![CDATA[CFT]]></bank_type>\n"
						+ "  <fee_type><![CDATA[CNY]]></fee_type>\n"
						+ "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n"
						+ "  <mch_id><![CDATA[10000100]]></mch_id>\n"
						+ "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n"
						+ "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n"
						+ "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n"
						+ "  <result_code><![CDATA[SUCCESS]]></result_code>\n"
						+ "  <return_code><![CDATA[SUCCESS]]></return_code>\n"
						+ "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n"
						+ "  <time_end><![CDATA[20140903131540]]></time_end>\n"
						+ "  <total_fee>1</total_fee>\n"
						+ "<coupon_fee><![CDATA[10]]></coupon_fee>\n"
						+ "<coupon_count><![CDATA[1]]></coupon_count>\n"
						+ "<coupon_type><![CDATA[CASH]]></coupon_type>\n"
						+ "<coupon_id><![CDATA[10000]]></coupon_id>\n"
						+ "<coupon_fee><![CDATA[100]]></coupon_fee>\n"
						+ "  <trade_type><![CDATA[JSAPI]]></trade_type>\n"
						+ "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n"
						+ "</xml>");
		Feedback feedback = paymentV2.exec(orderNotify);

		System.out.println(feedback);
		System.out.println(orderNotify.response());
	}

}
