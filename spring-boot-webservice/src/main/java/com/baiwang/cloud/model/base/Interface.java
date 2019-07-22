package com.baiwang.cloud.model.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/22 10:50
 */
@XmlRootElement(name = "interface")
@XmlAccessorType(value = XmlAccessType.FIELD)
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Interface {

    @XmlElement(name = "globalInfo")
    private GlobalInfo globalInfo;

    @XmlElement(name = "Data")
    private Data data;

    public void setContent(String content){
        if(this.data == null){
            throw new RuntimeException("Data in Interface is null, can`t set content value");
        }
        this.data.setContent(content);
    }
}
