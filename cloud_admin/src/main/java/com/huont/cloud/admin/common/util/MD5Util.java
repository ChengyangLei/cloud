package com.huont.cloud.admin.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * @author xbird
 * @title: MD5Util
 * @projectName dsedevcommon
 * @description: TODO
 * @date 2019/5/2916:44
 */
public class MD5Util {

    /**
     * 生成MD5摘要
     * @param data
     * @return
     * @throws Exception
     */
    public static String md5Encode(String data) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        byte[] byteArray = new byte[0];
        try {
            byteArray = data.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toUpperCase();
    }

}
