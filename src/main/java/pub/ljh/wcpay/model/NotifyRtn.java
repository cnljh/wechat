package pub.ljh.wcpay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class NotifyRtn {

     public enum Code {
	  SUCCESS, FAIL
     }

     private String returnCode;
     private String returnMsg;

     @XmlElement(name = "return_code")
     public String getReturnCode() {
	  return returnCode;
     }

     @XmlElement(name = "return_msg")
     public String getReturnMsg() {
	  return returnMsg;
     }

     public void setReturnCode(String returnCode) {
	  this.returnCode = returnCode;
     }

     public void setReturnMsg(String returnMsg) {
	  this.returnMsg = returnMsg;
     }

     public void setReturnCode(Code returnCode) {
	  this.returnCode = returnCode.name();
     }

     @Override
     public String toString() {
	  return "NotifyRtn{" + "returnCode=" + returnCode + ", returnMsg=" + returnMsg + '}';
     }

}
