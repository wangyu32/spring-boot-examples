package com.baiwang.cloud.service;

import com.baiwang.cloud.common.util.Base64Util;
import com.baiwang.cloud.common.util.RsaUtil;
import com.baiwang.cloud.config.RasConfig;
import com.baiwang.cloud.enums.BizErrorEnum;
import com.baiwang.cloud.enums.InterfaceEnum;
import com.baiwang.cloud.model.base.Interface;
import com.baiwang.cloud.model.business.common.BusinessResponse;
import com.baiwang.cloud.model.factory.SignatureFactory;
import com.baiwang.cloud.model.sign.Signature;
import com.baiwang.cloud.service.business.BusinessService;
import com.baiwang.cloud.util.JaxbUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.security.PublicKey;

/**
 * @Description 业务分发服务
 * @Author wangyu
 * @Date 2019/7/25 16:31
 */
@Slf4j
@Component
public class BusinessDispatchService {

    @Autowired
    private RasConfig rasConfig;

    @Autowired
    private BusinessRegisterService businessRegisterService;

    public BusinessResponse doBusiness(Interface interfaceFromXml) {
        String interfaceCode = interfaceFromXml.getGlobalInfo().getInterfaceCode();
        InterfaceEnum interfaceEnum = InterfaceEnum.valueOf(interfaceCode);
        BusinessService businessService = businessRegisterService.getBusinessService(interfaceEnum);
        return businessService.doBusiness(interfaceFromXml);
    }

    public Signature doBusinessSignature(Interface interfaceFromXml) {
        Signature signatureResponse = null;
        try {
            //业务处理结果
            BusinessResponse businessResponse = doBusiness(interfaceFromXml);
            String businessResponseXml = JaxbUtil.beanToXml(businessResponse);
            String businessResponseXmlEncrypt = Base64Util.encrypt(businessResponseXml);

            RsaUtil rsaUtil = new RsaUtil(rasConfig.getFilePath() + rasConfig.getFileName(), rasConfig.getFilePassword());
            PublicKey publicKey = rsaUtil.getPublicKey();
//            byte[] bytes = rsaUtil.buildSign(businessResponseXmlEncrypt.getBytes(), publicKey);

            String signatureValue = null;
            String signedData = businessResponseXmlEncrypt;
            signatureResponse = SignatureFactory.getDefaultSignatureInstance(signatureValue, signedData);
        } catch (JAXBException e) {
            log.error(BizErrorEnum.RESPONESE_MESSAGE_BUILD_ERROR.getMessage(), e);
        } catch (IOException e) {
            log.error(BizErrorEnum.RESPONESE_MESSAGE_BUILD_ERROR.getMessage(), e);
        } catch (Exception e) {
            log.error(BizErrorEnum.SYSTEM_ERROR.getMessage(), e);
        }
        return signatureResponse;
    }
}
