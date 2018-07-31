package com.liebe.utils;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 
 * @Title: MD5Util.java
 * @Package com.sihai.wx.util
 * @Description: MD5加密 工具类
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年8月31日 下午3:00:42
 * @version V1.0
 */
@Slf4j
public class MD5Util {

	private static final String SIGNATURE = "1f32a83588848d341c89f102dde11d4f";

	public static String MD5(String str) {
		try {
			byte[] bs = str.getBytes("UTF-8");
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(bs);
			String hex = new BigInteger(1, digest.digest()).toString(16);
			// 补齐BigInteger省略的前置0
			return new String(new char[32 - hex.length()]).replace("\0", "0") + hex;
		} catch (Exception e) {
			log.info("MD5加密失败：" + e);
			return null;
		}
	}

	public static String MD5Encrypt(String str) {
		String resultString = MD5Util.MD5(str + MD5Util.MD5(SIGNATURE));
		return resultString;
	}




	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}
