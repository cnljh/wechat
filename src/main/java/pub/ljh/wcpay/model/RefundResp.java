package pub.ljh.wcpay.model;

public class RefundResp {

     private String transactionId;
     private String outTradeNo;
     private String outRefundNo;
     private String refundId;
     private int refundFee;
     private int settlementRefundFee;
     private int totalFee;
     private int settlementTotalFee;
     private String feeType;
     private int cashFee;
     private String cashFeeType;
     private int cashRefundFee;

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

     public int getCashRefundFee() {
	  return cashRefundFee;
     }

     public void setCashRefundFee(int cashRefundFee) {
	  this.cashRefundFee = cashRefundFee;
     }

}
