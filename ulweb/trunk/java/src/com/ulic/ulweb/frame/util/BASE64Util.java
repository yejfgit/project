package com.ulic.ulweb.frame.util;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class BASE64Util {
	private BASE64Util() {
	}
	/**
	 * ??BASE64?????????§ß???
	 * 
	 * @param s
	 * @return
	 */
	public static byte[] getByteFromBASE64(String s) {
		if (s == null) {
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return b;
		}
		catch (Exception e) {
			return null;
		}
	}
	public static String getStringFromBASE64(String s) {
		if (s == null) {
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		}
		catch (Exception e) {
			return null;
		}
	}
	public static String getBASE64(String str) throws Exception {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(str.getBytes("iso-8859-1"));
	}
}
