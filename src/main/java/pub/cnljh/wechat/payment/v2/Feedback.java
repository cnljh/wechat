package pub.cnljh.wechat.payment.v2;

import lombok.Value;

@Value
public class Feedback {

	private final Class<? extends Operation> type;

	private final String resultCode;
	private final String errCode;
	private final String errCodeDes;

	public boolean isSuccess() {
		return "SUCCESS".equals(resultCode);
	}

}
