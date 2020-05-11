package pub.cnljh.wechat.payment.v2;

public abstract class NotifyOperation<Resp extends Operation.Response> extends Operation<Operation.Request, Resp> {

	protected String content;

	public void content(String content) {
		this.content = content;
	}
}
