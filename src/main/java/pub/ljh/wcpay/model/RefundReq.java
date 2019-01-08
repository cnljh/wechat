package pub.ljh.wcpay.model;

public class RefundReq {

     private String transactionId;
     private String outTradeNo;
     private String outRefundNo;
     private int totalFee;
     private int refundFee;
     private String refundFeeType;
     private String refundDesc;
     private String refundAccount;
     private String notifyUrl;

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

     public int getTotalFee() {
	  return totalFee;
     }

     public void setTotalFee(int totalFee) {
	  this.totalFee = totalFee;
     }

     public int getRefundFee() {
	  return refundFee;
     }

     public void setRefundFee(int refundFee) {
	  this.refundFee = refundFee;
     }

     public String getRefundFeeType() {
	  return refundFeeType;
     }

     public void setRefundFeeType(String refundFeeType) {
	  this.refundFeeType = refundFeeType;
     }

     public String getRefundDesc() {
	  return refundDesc;
     }

     public void setRefundDesc(String refundDesc) {
	  this.refundDesc = refundDesc;
     }

     public String getRefundAccount() {
	  return refundAccount;
     }

     public void setRefundAccount(String refundAccount) {
	  this.refundAccount = refundAccount;
     }

     public String getNotifyUrl() {
	  return notifyUrl;
     }

     public void setNotifyUrl(String notifyUrl) {
	  this.notifyUrl = notifyUrl;
     }
}
