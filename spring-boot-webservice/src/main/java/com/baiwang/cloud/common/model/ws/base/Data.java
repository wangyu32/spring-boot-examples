package com.baiwang.cloud.common.model.ws.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/22 10:57
 */
@XmlRootElement(name = "Data")
@XmlAccessorType(value = XmlAccessType.NONE)
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    @XmlElement(name = "content")
    private String content;

}
