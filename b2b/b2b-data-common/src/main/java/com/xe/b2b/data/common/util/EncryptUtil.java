package com.xe.b2b.data.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

import com.xe.b2b.data.common.contants.SystemConstant;

public class EncryptUtil {

    /*
     * value encrypt
     */
    public static String encryptMd5(String value) {
    	if (StringUtils.isBlank(value)) {
    		value = SystemConstant.DEFAULT_PASSWORD;
		}
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 Error...");
        }
        md5.update(value.getBytes());
        byte[] bs = md5.digest();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bs.length; i++) {
            int z = bs[i] & 0xff;
            if (z < 16) {
                sBuffer.append(0);
            }
            sBuffer.append(Integer.toHexString(z));
        }
        return sBuffer + "";
    }
    
    public static void main(String[] args) {
		System.out.println(encryptMd5("123456"));
	}
}
