package com.baiwang.cloud.enums;

/**
 * @Description 银行对账
 * @Author wangyu
 * @Date 2019/7/22
 */
public enum BizErrorEnum {

    MESSAGE_IS_NULL("9000", "请求报文为空"),
    MESSAGE_FORMAT_ERROR("9001", "报文格式错误"),
    SIGNATURE_VALUE_CAN_NOT_BE_NULL("9002", "签名值不能为空"),
    SIGNATURE_DATA_CAN_NOT_BE_NULL("9003", "被签名数据不能为空"),
    SIGNATURE_FAILED("9004", "验签失败"),
    BUSINESS_MESSAGE_FORMAT_ERROR("9005", "业务报文格式错误"),
    INTERFACE_CODE_ERROR("9006", "接口编码错误"),
//    MESSAGE_FORMAT_ERROR("9006", ""),
//    MESSAGE_FORMAT_ERROR("9006", ""),
    SUCCESS("0000", "成功");

    private String code;

    private String message;

    BizErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BizErrorEnum getByCode(String code){
        if (code == null || code.trim().equals("")) {
            return null;
        } else {
            for(BizErrorEnum item : BizErrorEnum.values()) {
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
