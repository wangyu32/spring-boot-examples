package com.baiwang.cloud.common.model.business.yhdzjg.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/22 19:14
 */
@XmlRootElement(name = "YHMX")
@XmlAccessorType(value = XmlAccessType.NONE)
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Yhmx {

    //请求流水号
    @XmlElement(name = "QQLSH")
    private String qqlsh;

    //对账失败代码：1008 请求流水号不存在 1003 对账金额错误 1007 没有被对账流水号
    @XmlElement(name = "ERRCODE")
    private String errcode;

}
