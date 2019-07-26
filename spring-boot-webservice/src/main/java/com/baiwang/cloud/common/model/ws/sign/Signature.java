package com.baiwang.cloud.common.model.ws.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

/**
 * @Description 请求报文根节点
 * @Author wangyu
 * @Date 2019/7/19 10:51
 */
@XmlRootElement(name = "Signature")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signature {

    //计算签名值所用的算法。这部分主要负责提供签名相关算法等信息
    @XmlElement(name = "SignedInfo")
    private SignedInfo signedInfo;

    //签名值，必须填写，内容为对<SignedData>业务节点（不含标签）签名后的结果。这部分主要负责提供签名后的签名值以用来校验
    @XmlElement(name = "SignatureValue")
    private String signatureValue;

    //签名所用的证书信息，填写证书序号(导入证书库后通过工具查看)或证书文件名。此数据域不要求必须填写，也不校验正确性。但为了方便系统交互，建议填写实际值。
    @XmlElement(name = "KeyInfo")
    private KeyInfo keyInfo;

    //签名对象。这部分主要负责提供被签名的节点，即整个报文的业务数据，其子标签如下。
    @XmlElement(name = "Object")
    private Object object;

    public String checkNullable(){
        if(this.signatureValue == null || this.signatureValue.trim().equals("")){
            return "签名值不能为空";
        }

        if(this.object == null || this.object.getSignedData() == null
                || this.getObject().getSignedData().trim().equals("")){
            return "被签名内容不能为空";
        }

        return null;
    }

    public String toXml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">");

        sb.append("<SignedInfo>");
        sb.append("<SignatureMethod Algorithm=");
        sb.append("\"").append(this.signedInfo.getSignatureMethod().getAlgorithm()).append("\"").append(" />");
        sb.append("<Reference URI=");
        sb.append("\"").append(this.signedInfo.getReference().getUri()).append("\"").append(" >");
        sb.append("</Reference>");
        sb.append("</SignedInfo>");

        sb.append("<SignatureValue>");
        sb.append(signatureValue);
        sb.append("</SignatureValue>");

        sb.append("<KeyInfo>");
        sb.append("<KeyName>");
        sb.append("</KeyName>");
        sb.append("</KeyInfo>");

        sb.append("<Object id=");
        sb.append("\"").append(this.object.getId()).append("\"").append(" >");
        sb.append("<SignedData>");
        sb.append(this.object.getSignedData());
        sb.append("</SignedData>");
        sb.append("</Object>");

        sb.append("</Signature>");
        return sb.toString();
    }

}
