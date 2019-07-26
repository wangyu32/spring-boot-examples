package com.baiwang.cloud.common.model.ws.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description 签名算法，固定值<SignatureMethod Algorithm="http://www.w3.org/2000/09/xmldsig#rsa-sha1"/>
 * @Author wangyu
 * @Date 2019/7/19 11:05
 */
@XmlRootElement(name = "SignatureMethod")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignatureMethod {

    @XmlAttribute(name = "Algorithm")
    private String algorithm;

}
