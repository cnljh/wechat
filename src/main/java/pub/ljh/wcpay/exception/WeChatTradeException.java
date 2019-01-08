package pub.ljh.wcpay.exception;

public class WeChatTradeException extends WeChatException {

     public WeChatTradeException(String code, String des) {
	  super(code + ":" + des);
     }

}
