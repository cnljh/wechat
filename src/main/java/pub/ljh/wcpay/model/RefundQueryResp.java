package pub.ljh.wcpay.model;

import java.util.List;

public class RefundQueryResp {

     private String transactionId;
     private String outTradeNo;
     private int totalRefundCount;
     private int totalFee;
     private String feeType;
     private int cashFee;
     private String cashFeeType;
     private int settlementTotalFee;
     private int refundCount;
     private List<Of> of;

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

     public int getTotalRefundCount() {
	  return totalRefundCount;
     }

     public void setTotalRefundCount(int totalRefundCount) {
	  this.totalRefundCount = totalRefundCount;
     }

     public int getTotalFee() {
	  return totalFee;
     }

     public void setTotalFee(int totalFee) {
	  this.totalFee = totalFee;
     }

     public String getFeeType() {
	  return feeType;
     }

     public void setFeeType(String feeType) {
	  this.feeType = feeType;
     }

     public int getCashFee() {
	  return cashFee;
     }

     public void setCashFee(int cashFee) {
	  this.cashFee = cashFee;
     }

     public String getCashFeeType() {
	  return cashFeeType;
     }

     public void setCashFeeType(String cashFeeType) {
	  this.cashFeeType = cashFeeType;
     }

     public int getSettlementTotalFee() {
	  return settlementTotalFee;
     }

     public void setSettlementTotalFee(int settlementTotalFee) {
	  this.settlementTotalFee = settlementTotalFee;
     }

     public int getRefundCount() {
	  return refundCount;
     }

     public void setRefundCount(int refundCount) {
	  this.refundCount = refundCount;
     }

     public List<Of> getOf() {
	  return of;
     }

     public void setOf(List<Of> of) {
	  this.of = of;
     }

     public class Of {

	  private String outTradeNo;
	  private int totalRefundCount;
	  private String refundChanne;
	  private int refundFee;
	  private String refundStatus;
	  private String refundAccount;
	  private String refundRecvAccount;
	  private String refundSuccessTime;

	  public String getOutTradeNo() {
	       return outTradeNo;
	  }

	  public void setOutTradeNo(String outTradeNo) {
	       this.outTradeNo = outTradeNo;
	  }

	  public int getTotalRefundCount() {
	       return totalRefundCount;
	  }

	  public void setTotalRefundCount(int totalRefundCount) {
	       this.totalRefundCount = totalRefundCount;
	  }

	  public String getRefundChanne() {
	       return refundChanne;
	  }

	  public void setRefundChanne(String refundChanne) {
	       this.refundChanne = refundChanne;
	  }

	  public int getRefundFee() {
	       return refundFee;
	  }

	  public void setRefundFee(int refundFee) {
	       this.refundFee = refundFee;
	  }

	  public String getRefundStatus() {
	       return refundStatus;
	  }

	  public void setRefundStatus(String refundStatus) {
	       this.refundStatus = refundStatus;
	  }

	  public String getRefundAccount() {
	       return refundAccount;
	  }

	  public void setRefundAccount(String refundAccount) {
	       this.refundAccount = refundAccount;
	  }

	  public String getRefundRecvAccount() {
	       return refundRecvAccount;
	  }

	  public void setRefundRecvAccount(String refundRecvAccount) {
	       this.refundRecvAccount = refundRecvAccount;
	  }

	  public String getRefundSuccessTime() {
	       return refundSuccessTime;
	  }

	  public void setRefundSuccessTime(String refundSuccessTime) {
	       this.refundSuccessTime = refundSuccessTime;
	  }
     }

}
