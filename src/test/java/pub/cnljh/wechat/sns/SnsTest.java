/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub.cnljh.wechat.sns;

import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import pub.cnljh.wechat.client.HttpClient;

/**
 *
 * @author Think
 */
public class SnsTest {

	private Sns instance = new Sns(new HttpClient(), "wxbd878fc34fb8c6fe", "911d4465848ac9873c1281c0a81b5667");

	@Test
	public void testCode2Session() throws Exception {
		System.out.println("code2Session");
		String code = "023at4xc2ArOQH0pG6Bc2Bs6xc2at4x0";
		Code2SessionResp result = instance.code2Session(code);
		System.out.println(result);
	}

	@Test
	public void testDecrypt() {
		System.out.println("decrypt");
		String sessionKey = "";
		String encryptedData = "";
		String iv = "";
		Sns instance = null;
		Map expResult = null;
		Map result = instance.decrypt(sessionKey, encryptedData, iv);
		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

}
