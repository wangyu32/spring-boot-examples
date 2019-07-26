package com.baiwang.cloud.common.enums;

/**
 * @Description 币种
 * @Author wangyu
 * @Date 2019/7/22
 */
public enum CurrencyEnum {

    USD("美元"),
    CNY("人民币");

    private String name;

    CurrencyEnum(String name){
        this.name = name;
    }

    public static CurrencyEnum getCurrencyEnumByName(String name){
        if (name == null || name.trim().equals("")) {
            return null;
        } else {
            for(CurrencyEnum item : CurrencyEnum.values()) {
                if (item.getName().equals(name)) {
                    return item;
                }
            }
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
