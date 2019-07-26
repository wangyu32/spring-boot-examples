package com.baiwang.cloud.common.model.business.yhdzjg.response;

import com.baiwang.cloud.common.model.business.common.Fpmxs;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

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

    //明细数量
    @XmlAttribute(name = "size")
    private Integer size;

    //明细
    @XmlElementRef(name = "YHMX", type = Yhmx.class)
    private List<Yhmx> yhmx;
}
