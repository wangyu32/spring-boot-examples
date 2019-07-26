package com.baiwang.cloud.common.model.business.fpcx.response;

import com.baiwang.cloud.common.model.business.common.BusinessResponse;
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
public class FpcxResponse extends BusinessResponse {

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
