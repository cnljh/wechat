package pub.ljh.wcpay.model;

public class RefundQueryReq {

     private String transactionId;
     private String outTradeNo;
     private String outRefundNo;
     private String refundId;

     public String getTransactionId() {
	  return transactionId;
     }

     public void setTransactionId(String transactionId) {
	  this.transactionId = transactionId;
     }

     public String getOutTradeNo() {
	  return outTradeNo;
     }

     public void setOutTradeNo(String outTradeNo) {
	  this.outTradeNo = outTradeNo;
     }

     public String getOutRefundNo() {
	  return outRefundNo;
     }

     public void setOutRefundNo(String outRefundNo) {
	  this.outRefundNo = outRefundNo;
     }

     public String getRefundId() {
	  return refundId;
     }

     public void setRefundId(String refundId) {
	  this.refundId = refundId;
     }
}
