package com.baiwang.cloud.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/22 10:56
 */
@XmlRootElement(name = "globalInfo")
@XmlAccessorType(value = XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalInfo {

    @XmlElement(name = "version")
    private String version;

    @XmlElement(name = "interfaceCode")
    private String interfaceCode;

    public GlobalInfo(String version) {
        this.version = version;
    }
}
