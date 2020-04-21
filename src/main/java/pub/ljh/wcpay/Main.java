package pub.ljh.wcpay;

import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception{
	URL url=	new URL("https://api.mch.weixin.qq.com/v3/combine-transactions/out-trade-no?a=1");
		System.out.println(url.getPath());
		System.out.println(url.getQuery());
	}
}
