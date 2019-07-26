package com.neo.test;

import com.baiwang.cloud.common.enums.CurrencyEnum;
import com.baiwang.cloud.common.enums.InterfaceEnum;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/25 15:09
 */
public class EnumTest {

    public static void main(String[] args) {
        InterfaceEnum e = InterfaceEnum.valueOf("FPCX");
        System.out.println(e);
        System.out.println(CurrencyEnum.USD.name());
    }

}
