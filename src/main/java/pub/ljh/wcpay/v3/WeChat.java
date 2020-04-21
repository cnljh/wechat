package pub.ljh.wcpay.v3;

import lombok.Value;

@Value
public class WeChat {

	private final String appid;

	private final String mchId;
	
	private final String serialNo;

}
