package pub.ljh.wcpay.model;

public class OrderNotify {

     private String openid;
     private String isSubscribe;
     private String tradeType;
     private String bankType;
     private int totalFee;
     private String feeType;
     private int cashFee;
     private String cashFeeType;
     private String transactionId;
     private String outTradeNo;
     private String attach;
     private String timeEnd;

     @Override
     public String toString() {
	  return "OrderNotify{" + "openid=" + openid + ", isSubscribe=" + isSubscribe + ", tradeType=" + tradeType + ", bankType=" + bankType + ", totalFee=" + totalFee + ", feeType=" + feeType + ", cashFee=" + cashFee + ", cashFeeType=" + cashFeeType + ", transactionId=" + transactionId + ", outTradeNo=" + outTradeNo + ", attach=" + attach + ", timeEnd=" + timeEnd + '}';
     }

     public String getOpenid() {
	  return openid;
     }

     public void setOpenid(String openid) {
	  this.openid = openid;
     }

     public String getIsSubscribe() {
	  return isSubscribe;
     }

     public void setIsSubscribe(String isSubscribe) {
	  this.isSubscribe = isSubscribe;
     }

     public String getTradeType() {
	  return tradeType;
     }

     public void setTradeType(String tradeType) {
	  this.tradeType = tradeType;
     }

     public String getBankType() {
	  return bankType;
     }

     public void setBankType(String bankType) {
	  this.bankType = bankType;
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

     public String getAttach() {
	  return attach;
     }

     public void setAttach(String attach) {
	  this.attach = attach;
     }

     public String getTimeEnd() {
	  return timeEnd;
     }

     public void setTimeEnd(String timeEnd) {
	  this.timeEnd = timeEnd;
     }
}
