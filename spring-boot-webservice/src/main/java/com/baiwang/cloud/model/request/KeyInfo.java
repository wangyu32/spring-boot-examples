package com.baiwang.cloud.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 10:57
 */
@XmlRootElement(name = "KeyInfo")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyInfo {

    @XmlElement(name = "KeyName")
    private String keyName;

}
