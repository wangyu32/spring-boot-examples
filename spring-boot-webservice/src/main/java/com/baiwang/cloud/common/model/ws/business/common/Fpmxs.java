package com.baiwang.cloud.common.model.ws.business.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Description 发票明细集合
 * @Author wangyu
 * @Date 2019/7/22 15:09
 */
@XmlRootElement(name = "FPMXS")
@XmlAccessorType(value = XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fpmxs {

    //发票明细数量
    @XmlAttribute(name = "size")
    private Integer size;

    //发票明细
    @XmlElementRef(name = "FPMX", type = Fpmx.class)
    private List<Fpmx> fpmx;

}
