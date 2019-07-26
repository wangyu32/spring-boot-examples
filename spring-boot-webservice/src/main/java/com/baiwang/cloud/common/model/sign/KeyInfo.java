package com.baiwang.cloud.common.model.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @Description 签名所用的证书信息，填写证书序号(导入证书库后通过工具查看)或证书文件名。此数据域不要求必须填写，也不校验正确性。但为了方便系统交互，建议填写实际值。
 * @Author wangyu
 * @Date 2019/7/19 10:57
 */
@XmlRootElement(name = "KeyInfo")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyInfo {

    @XmlElement(name = "KeyName")
    private String keyName;

}
