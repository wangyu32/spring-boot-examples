package com.baiwang.cloud.common.model.ws.business.yhdz.request;

import com.baiwang.cloud.common.model.ws.business.common.BusinessRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description 银行对账提交请求
 * @Author wangyu
 * @Date 2019/7/22 15:02
 */
@XmlRootElement(name = "REQUEST_YHDZ_TJ")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YhdzRequest extends BusinessRequest {

    //对账流水号
    @XmlElement(name = "DZLSH")
    private String dzlsh;

    //对账截至日期，格式：yyyy-MM-dd
    @XmlElement(name = "DZJZRQ")
    private String dzjzrq;

    //对账报文提交结束标志，1=本次对账最后一个批次 0=本次对账还有后续的批次需要提交
    @XmlElement(name = "DZBZ")
    private String DZBZ;

    //发票明细
    @XmlElement(name = "DZMXS")
    private Dzmxs dzmxs;


}
