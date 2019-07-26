package com.baiwang.cloud.common.model.ws.business.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @Description 发票明细
 * @Author wangyu
 * @Date 2019/7/22 15:09
 */
@XmlRootElement(name = "FPMX")
@XmlAccessorType(value = XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fpmx {

    //发票代码
    @XmlElement(name = "FPDM")
    private String fpdm;

    //发票号码
    @XmlElement(name = "FPHM")
    private String fphm;

    //总金额
    @XmlElement(name = "ZJE")
    private String zje;

    //金额
    @XmlElement(name = "JE")
    private String je;

    //发票销售方银行账户及名称
    @XmlElement(name = "YHZH")
    private String yhzh;

    //发票下载码
    @XmlElement(name = "FPXZM")
    private String fpxzm;

}
