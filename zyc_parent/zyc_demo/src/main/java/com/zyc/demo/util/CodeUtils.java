package com.zyc.demo.util;

import java.security.MessageDigest;


/**
 * 用来封装加密 解密的 方法 
 * @author zyp
 *
 */
public class CodeUtils {

	public static final String UTF_8 = "UTF-8";
	
	
	/**
	 * 把md5 取 16未
	 * @param buf
	 * @return
	 */
	public static String md5hex16(String buf) {  
	    try {  
	        MessageDigest digist = MessageDigest.getInstance("MD5");  
	        byte[] rs = digist.digest(buf.getBytes(UTF_8));  
	        StringBuffer digestHexStr = new StringBuffer();  
	        for (int i = 0; i < 16; i++) {  
	            digestHexStr.append(byteHEX(rs[i]));  
	        }  
	        return digestHexStr.toString();  
	    } catch (Exception e) {
	    	throw new RuntimeException("md5 diggest failed",e);
	    }  
	    
	}  
	
	public static String byteHEX(byte ib) {  
	    char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
	    char[] ob = new char[1];  
	    ob[0] = Digit[(ib >>> 4) & 0X0F];  
	    String s = new String(ob);  
	    return s;  
	}


	public static void main(String[] args) {

		System.out.println(md5hex16("津AS3698@2"));

	}

}
