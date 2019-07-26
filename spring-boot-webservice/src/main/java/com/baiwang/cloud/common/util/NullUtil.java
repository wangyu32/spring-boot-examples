package com.baiwang.cloud.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author wangyu
 * @data 2019-02-19
 * @Description:
 */
public class NullUtil {


    public static boolean isNull(String s){
        return s == null || s.trim().equals("");
    }

    public static boolean isNotNull(String s){
        return !isNull(s);
    }

    public static boolean isNull(Object s){
        return s == null;
    }

    public static boolean isNotNull(Object s){
        return !isNull(s);
    }

    public static boolean isNull(List list){
        if(list == null || list.size() == 0){
            return true;
        }
        return false;
    }

    public static boolean isNull(Map map){
        if(map == null || map.size() == 0){
            return true;
        }
        return false;
    }

    public static boolean isNull(Object[] array){
        if(array == null || array.length == 0){
            return true;
        }
        return false;
    }

    public static boolean isNotNull(List list){
        if(list != null && list.size() > 0){
            return true;
        }
        return false;
    }

    public static boolean isNotNull(Map map){
        if(map != null && map.size() > 0){
            return true;
        }
        return false;
    }

    public static boolean isNotNull(Object[] array){
        if(array != null && array.length > 0){
            return true;
        }
        return false;
    }

    public static boolean anyNullObject(Object... objects) {
        return Arrays.stream(objects).filter(Objects::isNull).count() > 0;
    }

    public static void main(String[] args) {
        NullUtil nu = new NullUtil();
        NullUtil nu1 = null;
        System.out.println(anyNullObject(nu));
        System.out.println(anyNullObject(nu1));
    }
}
