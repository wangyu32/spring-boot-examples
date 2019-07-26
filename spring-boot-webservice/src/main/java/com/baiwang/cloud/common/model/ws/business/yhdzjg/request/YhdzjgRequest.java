package com.baiwang.cloud.common.model.ws.business.yhdzjg.request;

import com.baiwang.cloud.common.model.ws.business.common.BusinessRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description 银行对账结果请求
 * @Author wangyu
 * @Date 2019/7/22 15:02
 */
@XmlRootElement(name = "REQUEST_YHDZ_JG")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YhdzjgRequest extends BusinessRequest {

    //对账流水号
    @XmlElement(name = "DZLSH")
    private String dzlsh;

}