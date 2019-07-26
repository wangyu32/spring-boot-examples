package com.baiwang.cloud.common.enums;

/**
 * @Description 银行对账结果
 * @Author wangyu
 * @Date 2019/7/22
 */
public enum YhdzjgEnum {

    MESSAGE_RECEIVE_ERROR("1004", "报文接收失败"),
    BATCH_NUMBER_NOT_EXIST("1005", "不存在该批次对账"),
    FADILD("1006", "对账失败"),
    MESSAGE_RECEIVEING_AND_LACK_OF_LAST("1010", "对账数据接收中，还没有收到最后一次批次报文"),
    SUCCESS("0000", "成功");

    private String code;

    private String message;

    YhdzjgEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static YhdzjgEnum getByCode(String code){
        if (code == null || code.trim().equals("")) {
            return null;
        } else {
            for(YhdzjgEnum item : YhdzjgEnum.values()) {
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
