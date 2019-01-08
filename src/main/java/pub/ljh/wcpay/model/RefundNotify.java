package pub.ljh.wcpay.model;

import javax.xml.bind.annotation.XmlRootElement;

public class RefundNotify {

     private String transactionId;
     private String outTradeNo;
     private String refundId;
     private String outRefundNo;
     private int totalFee;
     private int settlementTotalFee;
     private int refundFee;
     private int settlementRefundFee;
     private String refundStatus;
     private String successTime;
     private String refundRecvAccount;
     private String refundAccount;
     private String refundRequestSource;

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

     public String getRefundId() {
	  return refundId;
     }

     public void setRefundId(String refundId) {
	  this.refundId = refundId;
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

     public int getSettlementTotalFee() {
	  return settlementTotalFee;
     }

     public void setSettlementTotalFee(int settlementTotalFee) {
	  this.settlementTotalFee = settlementTotalFee;
     }

     public int getRefundFee() {
	  return refundFee;
     }

     public void setRefundFee(int refundFee) {
	  this.refundFee = refundFee;
     }

     public int getSettlementRefundFee() {
	  return settlementRefundFee;
     }

     public void setSettlementRefundFee(int settlementRefundFee) {
	  this.settlementRefundFee = settlementRefundFee;
     }

     public String getRefundStatus() {
	  return refundStatus;
     }

     public void setRefundStatus(String refundStatus) {
	  this.refundStatus = refundStatus;
     }

     public String getSuccessTime() {
	  return successTime;
     }

     public void setSuccessTime(String successTime) {
	  this.successTime = successTime;
     }

     public String getRefundRecvAccount() {
	  return refundRecvAccount;
     }

     public void setRefundRecvAccount(String refundRecvAccount) {
	  this.refundRecvAccount = refundRecvAccount;
     }

     public String getRefundAccount() {
	  return refundAccount;
     }

     public void setRefundAccount(String refundAccount) {
	  this.refundAccount = refundAccount;
     }

     public String getRefundRequestSource() {
	  return refundRequestSource;
     }

     public void setRefundRequestSource(String refundRequestSource) {
	  this.refundRequestSource = refundRequestSource;
     }

}
