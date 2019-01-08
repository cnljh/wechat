package pub.ljh.wcpay.model;

public class UnifiedOrderResp {

     private String tradeType;
     private String prepayId;
     private String codeUrl;

     public String getTradeType() {
	  return tradeType;
     }

     public void setTradeType(String tradeType) {
	  this.tradeType = tradeType;
     }

     public String getPrepayId() {
	  return prepayId;
     }

     public void setPrepayId(String prepayId) {
	  this.prepayId = prepayId;
     }

     public String getCodeUrl() {
	  return codeUrl;
     }

     public void setCodeUrl(String codeUrl) {
	  this.codeUrl = codeUrl;
     }

     @Override
     public String toString() {
	  return "UnifiedOrderResp{" + "tradeType=" + tradeType + ", prepayId=" + prepayId + ", codeUrl=" + codeUrl + '}';
     }
}
