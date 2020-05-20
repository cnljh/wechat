package pub.cnljh.wechat.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tools {

	private final static char[] UPPER_HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	private final static char[] LOWER_HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	public static byte[] encrypt(String key) {
		try {
			byte[] btInput = key.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			return mdInst.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static String bytes2HexStr(byte[] bs, boolean toUpper) {
		char[] hexChar = toUpper ? UPPER_HEX_CHAR : LOWER_HEX_CHAR;
		char[] buf = new char[bs.length * 2];
		int idx = 0;
		for (byte b : bs) {
			buf[idx * 2 + 1] = hexChar[b & 0x0F];//低位值
			b >>>= 4;
			buf[idx * 2] = hexChar[b & 0x0F];//高位值 
			idx++;
		}
		return new String(buf);
	}

}
