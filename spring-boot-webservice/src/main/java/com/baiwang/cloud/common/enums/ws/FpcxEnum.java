package com.baiwang.cloud.common.enums.ws;

/**
 * @Description 发票查询
 * @Author wangyu
 * @Date 2019/7/22
 */
public enum FpcxEnum {

    INVOICE_NOT_EXIST("1001", "发票不存在"),
    REMAINING_AMOUNT_NOT_ENOUGH  ("1002", "剩余金额不够"),
    REQUEST_DATA_INCOMPLETE("1004", "请求数据不完整"),
    NOT_IN_ELECTRONIC_INVOICE_LIB("1006", "电子发票库不存在此数据"),
    CURRENCY_ERROR("1007", "币种错误"),
    QQLSH_REPEAT("1009", "请求流水号重复"),
    SUCCESS("0000", "成功");

    private String code;

    private String message;

    FpcxEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static FpcxEnum getByCode(String code){
        if (code == null || code.trim().equals("")) {
            return null;
        } else {
            for(FpcxEnum item : FpcxEnum.values()) {
                if (item.getCode().equals(code)) {
                    return item;
                }
            }
            return null;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
