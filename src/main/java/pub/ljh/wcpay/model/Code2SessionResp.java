/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub.ljh.wcpay.model;

import lombok.Data;

/**
 *
 * @author Think
 */
@Data
public class Code2SessionResp {

	private String openid;
	private String sessionKey;
	private String unionid;
	private int errcode;
	private String errmsg;
}
