package com.baiwang.cloud.model.business.fpcx.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

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
public class FpcxResponse {

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
