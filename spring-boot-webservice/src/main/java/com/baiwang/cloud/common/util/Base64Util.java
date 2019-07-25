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

    /**
     * 将byte[]数据编码为base64字符串
     * @param byteData 原始数据
     * @return String base64字符串
     * @author luqiang
     * @date 2018年11月18日
     */
    public static String byteToBase(byte[] byteData) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(byteData);
    }
}
