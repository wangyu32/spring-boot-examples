package com.baiwang.cloud.service.validate.impl;

import com.baiwang.cloud.common.util.RsaUtil;
import com.baiwang.cloud.common.util.StringUtil;
import com.baiwang.cloud.config.RasConfig;
import com.baiwang.cloud.common.enums.BizErrorEnum;
import com.baiwang.cloud.common.model.sign.Signature;
import com.baiwang.cloud.common.model.validate.ValidateResult;
import com.baiwang.cloud.service.validate.SignatureValidateService;
import com.baiwang.cloud.util.JaxbUtil;
import com.baiwang.cloud.util.NullUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.security.PublicKey;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 16:47
 */
@Slf4j
@Service
public class SignatureValidateServiceImpl extends BaseValidateServiceImpl implements SignatureValidateService  {

    @Autowired
    private RasConfig rasConfig;

    @Override
    public ValidateResult validate(String xml) {
        Signature signature = null;
        try {
            signature = JaxbUtil.xmlToBean(xml.trim(), Signature.class);
            String signatureValue = signature.getSignatureValue();

            //signatureValue节点
            if (NullUtil.isNull(signatureValue)) {
                return failed(BizErrorEnum.SIGNATURE_VALUE_CAN_NOT_BE_NULL);
            }

            //Object节点
            if (NullUtil.isNull(signature.getObject())) {
                return failed(BizErrorEnum.SIGNATURE_DATA_CAN_NOT_BE_NULL);
            }

            //signedData节点
            String signedData = signature.getObject().getSignedData();
            if (NullUtil.isNull(signedData)) {
                return failed(BizErrorEnum.SIGNATURE_DATA_CAN_NOT_BE_NULL);
            }

            RsaUtil rsaUtil = new RsaUtil(rasConfig.getFilePath() + rasConfig.getFileName(), rasConfig.getFilePassword());
            PublicKey publicKey = rsaUtil.getPublicKey();

            //xml中的签名值
            String signatureValueInXml = xml.substring(xml.indexOf("<SignatureValue>") + "<SignatureValue>".length(), xml.indexOf("</SignatureValue>"));
            //xml中的被签名的业务数据
            String signedDataInXml = xml.substring(xml.indexOf("<SignedData>") + "<SignedData>".length(), xml.indexOf("</SignedData>"));

            //公钥验签
            //TODO 此处有一个问题，签名值signatureValueInXml在发报文之前，经过StringUtil.byteToBase 处理了，收到后，再使用 StringUtil.baseToByte 转换回来 需要根据实际情况处理
            boolean signatureFlag = rsaUtil.verifySign(signedDataInXml.getBytes(), StringUtil.baseToByte(signatureValueInXml), publicKey);
            if (!signatureFlag) {
                log.error("业务数据验签失败,signatureValue={},signedData={}", signatureValue, signedData);
                return failed(BizErrorEnum.SIGNATURE_FAILED);
            }

            signature.getObject().setSignedData(signedData);//防止转换过程中的修改
        } catch (JAXBException e) {
            log.error(BizErrorEnum.MESSAGE_FORMAT_ERROR.getMessage(), e);
            return failed(BizErrorEnum.MESSAGE_FORMAT_ERROR);
        } catch (IOException e) {
            log.error(BizErrorEnum.MESSAGE_FORMAT_ERROR.getMessage(), e);
            return failed(BizErrorEnum.MESSAGE_FORMAT_ERROR);
        } catch (SecurityException e) {
            log.error(e.getMessage(), e);
            return failed(BizErrorEnum.SIGNATURE_FAILED);
        }
        return success(signature);
    }
}
