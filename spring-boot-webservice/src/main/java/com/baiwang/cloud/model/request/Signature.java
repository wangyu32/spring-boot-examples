package com.baiwang.cloud.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 10:51
 */
@XmlRootElement(name = "Signature")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signature {

    @XmlElement(name = "SignedInfo")
    private SignedInfo signedInfo;

    @XmlElement(name = "SignatureValue")
    private String signatureValue;

    @XmlElement(name = "KeyInfo")
    private KeyInfo keyInfo;

    @XmlElement(name = "Object")
    private Object object;

}
