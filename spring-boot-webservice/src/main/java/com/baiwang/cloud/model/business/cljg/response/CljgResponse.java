package com.baiwang.cloud.model.business.cljg.response;

import com.baiwang.cloud.model.business.common.BusinessResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/22 15:39
 */
@XmlRootElement(name = "response")
@XmlAccessorType(value = XmlAccessType.FIELD)
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class CljgResponse extends BusinessResponse {

    //响应码
    @XmlElement(name = "code")
    private String code;

    //响应信息
    @XmlElement(name = "message")
    private String message;

    //响应业务数据
    @XmlElement(name = "Data")
    private Data data;

}
