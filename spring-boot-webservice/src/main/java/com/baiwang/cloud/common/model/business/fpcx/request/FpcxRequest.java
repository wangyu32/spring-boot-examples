package com.baiwang.cloud.common.model.business.fpcx.request;

import com.baiwang.cloud.common.model.business.common.BusinessRequest;
import com.baiwang.cloud.common.model.business.common.Fpmxs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @Description 发票资料和结算金额
 * @Author wangyu
 * @Date 2019/7/22 15:02
 */
@XmlRootElement(name = "REQUEST_FPCXJS")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FpcxRequest extends BusinessRequest {

    //请求流水号
    @XmlElement(name = "QQLSH")
    private String qqlsh;

    //纳税人识别号
    @XmlElement(name = "NSRSBH")
    private String nsrsbh;

    //总结算金额
    @XmlElement(name = "ZJE")
    private String zje;

    //币种
    @XmlElement(name = "BB")
    private String bb;

    //发票明细
    @XmlElement(name = "FPMXS")
    private Fpmxs fpmxs;


}
