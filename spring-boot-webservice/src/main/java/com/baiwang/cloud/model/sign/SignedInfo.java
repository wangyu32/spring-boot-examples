package com.baiwang.cloud.model.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description 计算签名值所用的算法。这部分主要负责提供签名相关算法等信息
 * @Author wangyu
 * @Date 2019/7/19 10:51
 */
@XmlRootElement(name = "SignedInfo")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignedInfo {

    ////签名算法，固定值<SignatureMethod Algorithm="http://www.w3.org/2000/09/xmldsig#rsa-sha1"/>
    @XmlElement(name = "SignatureMethod")
    private SignatureMethod signatureMethod;

    //指向待签名内容的URI，指向<Object>节点，固定值：<Reference URI="#001">
    @XmlElement(name = "Reference")
    private Reference reference;

}
