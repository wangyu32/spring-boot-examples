package com.baiwang.cloud.common.model.ws.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @Description 签名对象。这部分主要负责提供被签名的节点，即整个报文的业务数据，其子标签如下。
 * @Author wangyu
 * @Date 2019/7/19 10:58
 */
@XmlRootElement(name = "Object")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Object {

    @XmlAttribute(name = "id")
    private String id;

    //业务数据，根据报文类型确定。内容采用BASE64方式。
    @XmlElement(name = "SignedData")
    private String signedData;

}
