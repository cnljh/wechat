package pub.ljh.wcpay.utils;

import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dauh
 * @version 1.1.20170103
 */
public class Transcoder {

     public final static int BIG_ENDIAN = 0;
     public final static int LITTLE_ENDIAN = 1;

     private final static char[] digitsArray = {
	  '0', '1', '2', '3', '4', '5',
	  '6', '7', '8', '9', 'A', 'B',
	  'C', 'D', 'E', 'F'
     };

     private final static String digitsStr = "0123456789ABCDEF";

     public static String bytes2HexStr(List<Byte> bList) {
	  char[] buf = new char[bList.size() * 2];
	  Iterator<Byte> it = bList.iterator();
	  int idx = 0;
	  while (it.hasNext()) {
	       byte b = it.next();
	       buf[idx * 2 + 1] = digitsArray[b & 0x0F];//低位值
	       b >>>= 4;
	       buf[idx * 2] = digitsArray[b & 0x0F];//高位值 
	       idx++;
	  }
	  return new String(buf);
     }

     public static String bytes2HexStr(byte[] bArray) {
	  char[] buf = new char[bArray.length * 2];
	  int idx = 0;
	  for (byte b : bArray) {
	       buf[idx * 2 + 1] = digitsArray[b & 0x0F];//低位值
	       b >>>= 4;
	       buf[idx * 2] = digitsArray[b & 0x0F];//高位值 
	       idx++;
	  }
	  return new String(buf);
     }

     public static byte[] hexStr2Bytes(String hex) {
	  if (hex.length() % 2 != 0) {
	       throw new IllegalArgumentException("hexStr长度必须为2的倍数");
	  }

	  char[] buff = hex.toUpperCase().toCharArray();
	  byte[] bArray = new byte[buff.length / 2];
	  for (int idx = 0, idx1 = 0; idx < buff.length; idx += 2, idx1++) {
	       int t = digitsStr.indexOf(buff[idx]);
	       if (t == -1) {
		    throw new IllegalArgumentException(buff[idx] + "无效字符");
	       }
	       int t1 = digitsStr.indexOf(buff[idx + 1]);
	       if (t1 == -1) {
		    throw new IllegalArgumentException(buff[idx] + "无效字符");
	       }
	       bArray[idx1] = (byte) ((t << 4) + t1);
	  }
	  return bArray;
     }

     public static String asciiHex2Str(String asciiHex) {
	  StringBuilder sb = new StringBuilder();
	  for (int i = 0; i < asciiHex.length(); i = i + 2) {
	       sb.append((char) Integer.parseInt(asciiHex.substring(i, i + 2), 16));
	  }
	  return sb.toString();
     }

     public static String ip2HexStr(InetAddress ip) {
	  return bytes2HexStr(ip.getAddress());
     }

     public static byte[] int2Bytes(int i) {
	  byte[] bArray = new byte[4];
	  for (int idx = 3; idx >= 0; idx--) {
	       bArray[idx] = (byte) (i & 0xFF);
	       i >>>= 8;
	  }
	  return bArray;
     }

     public static int[] bytes2Int(byte[] bArray) {
	  return bytes2Int(bArray, bArray.length);
     }

     /**
      * @param bArray 字节数组
      * @param len 处理bytes的最大长度值，与InputStream.read()结合使用
      * @return 整型数组
      */
     public static int[] bytes2Int(byte[] bArray, int len) {
	  int size = (len > bArray.length ? bArray.length : len) / 4;
	  if (size <= 0) {
	       return null;
	  }

	  int iArray[] = new int[size];
	  for (int idx = 0; idx < size; idx++) {
	       for (int idx_ = 0; idx_ < 4; idx_++) {
		    iArray[idx] <<= 8;
		    iArray[idx] += bArray[idx * 4 + idx_] & 0xFF;
	       }
	  }
	  return iArray;
     }

     /**
      *
      * @param i 转换值
      * @param size 转换大小，例：1为转换一个字节，输出两位字符长度(一个整型最大为4个字节)
      * @return hexStr
      */
     public static String int2HexStr(int i, int size) {
	  int s = (size > 0 && size < 5 ? size : 4) * 2;
	  char[] buf = new char[s];
	  for (int idx = s - 1; idx >= 0; idx -= 2) {
	       buf[idx] = digitsArray[i & 0x0F];
	       i >>>= 4;
	       buf[idx - 1] = digitsArray[i & 0x0F];
	       i >>>= 4;
	  }
	  return new String(buf);
     }

     public static int hexStr2Int(String hex) {
	  return hexStr2Int(hex, BIG_ENDIAN);
	  /*
	   if (hex.length() != 8) {
	   throw new IllegalArgumentException("输入字符必须为8位");
	   }

	   char[] cArray = hex.toUpperCase().toCharArray();
	   int d = 0;
	   for (int idx = 0; idx < 8; idx++) {
	   int i = digitsStr.indexOf(cArray[idx]);
	   if (i == -1) {
	   throw new IllegalArgumentException(cArray[idx] + "无效字符");
	   }
	   d <<= 4;
	   d = d + i;
	   }
	   return d;
	   */
     }

     /**
      *
      * @param hex 16进制字符串
      * @param order 大小端控制
      * @return
      */
     public static int hexStr2Int(String hex, int order) {
	  if (hex.length() != 8) {
	       throw new IllegalArgumentException("输入字符必须为8位");
	  }
	  return hexStr2Digit(hex, 4, order);
     }

     public static short hexStr2Short(String hex) {
	  return (short) hexStr2Short(hex, BIG_ENDIAN);
     }

     /**
      *
      * @param hex 16进制字符串
      * @param order 大小端控制
      * @return
      */
     public static short hexStr2Short(String hex, int order) {
	  if (hex.length() != 4) {
	       throw new IllegalArgumentException("输入字符必须为4位");
	  }
	  return (short) hexStr2Digit(hex, 2, order);
     }

     private static int hexStr2Digit(String hex, int n, int order) {
	  byte[] temp = hexStr2Bytes(hex);

	  int d = 0;
	  for (int idx = 0; idx < n; idx++) {
	       switch (order) {
		    case LITTLE_ENDIAN:
			 d = (d << 8) + (temp[n - 1 - idx] & 0xFF);
			 break;
		    default:
			 d = (d << 8) + (temp[idx] & 0xFF);
			 break;
	       }
	  }
	  return d;
     }
}
