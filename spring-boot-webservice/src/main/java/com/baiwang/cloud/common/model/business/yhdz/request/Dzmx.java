package com.baiwang.cloud.common.model.business.yhdz.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description 对账明细
 * @Author wangyu
 * @Date 2019/7/22 15:09
 */
@XmlRootElement(name = "DZMX")
@XmlAccessorType(value = XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dzmx {

    //请求流水号
    @XmlElement(name = "QQLSH")
    private String QQLSH;

    //处理结果 1：成功 2：失败
    @XmlElement(name = "CLJG")
    private String fphm;

    //金额 处理结果为1时，必填
    @XmlElement(name = "JE")
    private String je;

}
