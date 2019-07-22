
package com.baiwang.cloud.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 字符串对象是否为空判断工具类
 */
public class StringUtil {
    private static Log logger = LogFactory.getLog(StringUtil.class);
    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

  public static boolean isEmptyObj(Object str) {
    if (str == null || str == "") {
      return true;
    }
    return false;
  }

    public static String  isNull(String str) {
        if (str == null || str.length() == 0 || "null".equals(str)) {
            return "";
        }
        return str;
    }
    public static String  isNull(Object str) {
        if (str == null ) {
            return "";
        }
        if (str.toString().length() == 0 || "null".equals(str)) {
            return "";
        }
        return str.toString();
    }
  public static BigDecimal BigDecToInt(BigDecimal bigDecimal) {
    if (bigDecimal == null ) {
      return  BigDecimal.ZERO;
    }
    return bigDecimal;
  }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字串的真实长度(含中文)
     * @param s
     * @return
     */
    public static int String_length(String s){
        int length = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int ascii = Character.codePointAt(s, i);
            if(ascii >= 0 && ascii <=255)
                length++;
            else
                length += 2;
        }
        return length;
    }

    /**
     * 获取指定字符串之间的字串
     * @param source
     * @param priStr
     * @param fromIndex
     * @param suxStr
     * @return
     */
    public static String getIntervalValue(String source, String priStr, int fromIndex, String suxStr){
        if (source == null)
            return "";
        int iFirst = source.indexOf(priStr, fromIndex);
        int iLast = source.indexOf(suxStr, fromIndex);
        if(iFirst < 0 || iLast < 0)
            return "";
        int beginIndex = iFirst + priStr.length();
        return source.substring(beginIndex, iLast);
    }

    public static String getIntervalValue(String source, String priStr, String suxStr){
        return getIntervalValue(source, priStr, 0, suxStr);
    }


    /**
     * base64转inputStream
     * @param base64string
     * @return
     */
    public static InputStream baseToInputStream(String base64string){
        ByteArrayInputStream stream = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes1 = decoder.decodeBuffer(base64string);
            stream = new ByteArrayInputStream(bytes1);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return stream;
    }

    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }

    /**
     * 过滤特殊字符 过滤规则 [∏,¥,§,℅,€,℃,£,℉,№,℡,‰,$,¢,∮,※,？,&,[,],',<,>,?]
     */

    public static String StringFilter(String str) throws PatternSyntaxException {
        if (!StringUtil.isEmpty(str)) {

            // 清除掉所有特殊字符
            String regEx = "[∏,¥,§,℅,€,℃,£,℉,№,℡,‰,$,¢,∮,※,？,&,[,],',<,>,?]";

            //String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            return m.replaceAll("").trim();
        }
        return "";
    }

    //检查字符串中汉子的个数
    public static int countChinese(String str){
        int count = 0;
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                count=count+1;
            }
        }
        return count;
    }

    /**
     * 如果是空 则返回 true
     * @param str
     * @return boolean
     */
    public static boolean isBlank(String str){
        if(str==null || "null".equals(str) || "".equals(str.trim())){
            return true;
        }
        return false;
    }

    /**
     * 将base64字符串解码为byte[]
     * @param baseData base64字符串
     * @return byte[] 原始数据
     * @author luqiang
     * @date 2018年11月18日
     */
    public static byte[]  baseToByte(String baseData) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(baseData);
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
        return encoder.encode(byteData).replaceAll("(\\\r\\\n|\\\r|\\\n|\\\n\\\r)", "");
    }


}
