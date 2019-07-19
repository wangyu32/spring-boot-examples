package com.baiwang.cloud.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @Description
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

    @XmlElement(name = "SignedData")
    private String signedData;

}
