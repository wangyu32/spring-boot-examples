package com.baiwang.cloud.common.enums;

/**
 * @Description 银行对账
 * @Author wangyu
 * @Date 2019/7/22
 */
public enum YhdzEnum {

    MESSAGE_RECEIVE_ERROR("1004", "报文接收失败"),
    SUCCESS("0000", "成功");

    private String code;

    private String message;

    YhdzEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static YhdzEnum getByCode(String code){
        if (code == null || code.trim().equals("")) {
            return null;
        } else {
            for(YhdzEnum item : YhdzEnum.values()) {
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
