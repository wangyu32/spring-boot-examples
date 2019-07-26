package com.baiwang.cloud.common.model.business.yhdz.response;

import com.baiwang.cloud.common.model.business.common.BusinessResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description 银行对账提交返回
 * @Author wangyu
 * @Date 2019/7/22 15:39
 */
@XmlRootElement(name = "response")
@XmlAccessorType(value = XmlAccessType.FIELD)
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class YhdzResponse extends BusinessResponse {

    //响应码，0000成功 1004 报文接受收失败
    @XmlElement(name = "code")
    private String code;

    //响应信息
    @XmlElement(name = "message")
    private String message;

}
