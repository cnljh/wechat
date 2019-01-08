package pub.ljh.wcpay.model;

public class UnifiedOrderReq {

     private String body;
     private String detail;
     private String attach;

     public String getDetail() {
	  return detail;
     }

     public void setDetail(String detail) {
	  this.detail = detail;
     }
     private String outTradeNo;
     private String feeType;
     private int totalFee;
     private String spbillCreateIp;
     private String timeStart;
     private String timeExpire;
     private String goodsTag;
     private String notifyUrl;
     private String tradeType;
     private String productId;
     private String limitPay;
     private String sceneInfo;
     private String openid;

     public String getBody() {
	  return body;
     }

     public void setBody(String body) {
	  this.body = body;
     }

     public String getAttach() {
	  return attach;
     }

     public void setAttach(String attach) {
	  this.attach = attach;
     }

     public String getOutTradeNo() {
	  return outTradeNo;
     }

     public void setOutTradeNo(String outTradeNo) {
	  this.outTradeNo = outTradeNo;
     }

     public String getFeeType() {
	  return feeType;
     }

     public void setFeeType(String feeType) {
	  this.feeType = feeType;
     }

     public int getTotalFee() {
	  return totalFee;
     }

     public void setTotalFee(int totalFee) {
	  this.totalFee = totalFee;
     }

     public String getSpbillCreateIp() {
	  return spbillCreateIp;
     }

     public void setSpbillCreateIp(String spbillCreateIp) {
	  this.spbillCreateIp = spbillCreateIp;
     }

     public String getTimeStart() {
	  return timeStart;
     }

     public void setTimeStart(String timeStart) {
	  this.timeStart = timeStart;
     }

     public String getTimeExpire() {
	  return timeExpire;
     }

     public void setTimeExpire(String timeExpire) {
	  this.timeExpire = timeExpire;
     }

     public String getGoodsTag() {
	  return goodsTag;
     }

     public void setGoodsTag(String goodsTag) {
	  this.goodsTag = goodsTag;
     }

     public String getNotifyUrl() {
	  return notifyUrl;
     }

     public void setNotifyUrl(String notifyUrl) {
	  this.notifyUrl = notifyUrl;
     }

     public String getTradeType() {
	  return tradeType;
     }

     public void setTradeType(String tradeType) {
	  this.tradeType = tradeType;
     }

     public String getLimitPay() {
	  return limitPay;
     }

     public void setLimitPay(String limitPay) {
	  this.limitPay = limitPay;
     }

     public String getSceneInfo() {
	  return sceneInfo;
     }

     public void setSceneInfo(String sceneInfo) {
	  this.sceneInfo = sceneInfo;
     }

     public String getProductId() {
	  return productId;
     }

     public void setProductId(String productId) {
	  this.productId = productId;
     }

     public String getOpenid() {
	  return openid;
     }

     public void setOpenid(String openid) {
	  this.openid = openid;
     }

}
