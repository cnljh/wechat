package pub.ljh.wcpay.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

     private final static char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

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

     public static String bytes2HexStr(byte[] bs) {
	  char[] buf = new char[bs.length * 2];
	  int idx = 0;
	  for (byte b : bs) {
	       buf[idx * 2 + 1] = HEX_CHAR[b & 0x0F];//低位值
	       b >>>= 4;
	       buf[idx * 2] = HEX_CHAR[b & 0x0F];//高位值 
	       idx++;
	  }
	  return new String(buf);
     }

     public static String encrypt(String key, boolean toUpperCase) {
	  byte[] bs = encrypt(key);
	  String hexStr = bytes2HexStr(bs);
	  return toUpperCase ? hexStr.toUpperCase() : hexStr;
     }
}
