package com.baiwang.cloud.model.business.cljg.response;

import com.baiwang.cloud.model.business.common.Fpmxs;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/22 15:41
 */
@XmlRootElement(name = "Data")
@XmlAccessorType(value = XmlAccessType.NONE)
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    //请求流水号
    @XmlElement(name = "QQLSH")
    private String qqlsh;

    //发票明细
    @XmlElement(name = "FPMXS")
    private Fpmxs fpmxs;
}
