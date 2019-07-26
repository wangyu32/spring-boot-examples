package com.baiwang.cloud.common.enums.ws;

/**
 * @Description 接口枚举类
 * @Author wangyu
 * @Date 2019/7/22
 */
public enum InterfaceEnum {

    FPCX("发票查询"),
    CLJG("处理结果"),
    YHDZ("银行对账"),
    YHDZJG("银行对账结果");

    private String name;

    InterfaceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
