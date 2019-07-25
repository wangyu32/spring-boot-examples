package com.baiwang.cloud.model.business.cljg.request;

import com.baiwang.cloud.model.business.common.BusinessRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description 银行业务处理结果
 * @Author wangyu
 * @Date 2019/7/22 15:02
 */
@XmlRootElement(name = "REQUEST_YWJG")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CljgRequest extends BusinessRequest {

    //请求流水号
    @XmlElement(name = "QQLSH")
    private String qqlsh;

    //处理结果
    @XmlElement(name = "CLJG")
    private String cljg;

    //金额
    @XmlElement(name = "JE")
    private String je;

}
