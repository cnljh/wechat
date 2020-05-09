package pub.cnljh.wechat.payment.v2;

import lombok.Value;

@Value
public class Feedback {

	private final String resultCode;
	private final String errCode;
	private final String errCodeDes;

}
