package com.baiwang.cloud.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/22 21:18
 */
public class Base64Util {

    public static String encrypt(String key){
        if (key == null || key.length() < 1) {
            return "";
        }
        return new String(new BASE64Encoder().encodeBuffer(key.getBytes()));
    }

    public static String decrypt(String key) throws IOException {
        if (key == null || key.length() < 1) {
            return "";
        }
        return new String(new BASE64Decoder().decodeBuffer(key));
    }

}
