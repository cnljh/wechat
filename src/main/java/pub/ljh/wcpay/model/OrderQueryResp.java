package pub.ljh.wcpay.model;

public class OrderQueryResp {

     private String deviceInfo;
     private String openid;
     private String isSubscribe;
     private String tradeType;
     private String tradeState;
     private String bankType;
     private int totalFee;
     private String feeType;
     private int cashFee;
     private String cashFeeType;
     private int settlementTotalFee;
     private String transactionId;
     private String outTradeNo;
     private String attach;
     private String timeEnd;
     private String tradeStateDesc;

     public String getDeviceInfo() {
	  return deviceInfo;
     }

     public void setDeviceInfo(String deviceInfo) {
	  this.deviceInfo = deviceInfo;
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

     public String getTradeState() {
	  return tradeState;
     }

     public void setTradeState(String tradeState) {
	  this.tradeState = tradeState;
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

     public int getSettlementTotalFee() {
	  return settlementTotalFee;
     }

     public void setSettlementTotalFee(int settlementTotalFee) {
	  this.settlementTotalFee = settlementTotalFee;
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

     public String getTradeStateDesc() {
	  return tradeStateDesc;
     }

     public void setTradeStateDesc(String tradeStateDesc) {
	  this.tradeStateDesc = tradeStateDesc;
     }

}
