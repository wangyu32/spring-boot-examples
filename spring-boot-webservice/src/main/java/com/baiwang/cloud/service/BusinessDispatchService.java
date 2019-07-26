package com.baiwang.cloud.service;

import com.baiwang.cloud.common.util.Base64Util;
import com.baiwang.cloud.common.util.RsaUtil;
import com.baiwang.cloud.common.util.StringUtil;
import com.baiwang.cloud.config.RasConfig;
import com.baiwang.cloud.common.enums.BizErrorEnum;
import com.baiwang.cloud.common.enums.InterfaceEnum;
import com.baiwang.cloud.common.model.base.Interface;
import com.baiwang.cloud.common.model.business.common.BusinessResponse;
import com.baiwang.cloud.common.model.factory.SignatureFactory;
import com.baiwang.cloud.common.model.sign.Signature;
import com.baiwang.cloud.service.business.BusinessService;
import com.baiwang.cloud.service.validate.CertificateValidateService;
import com.baiwang.cloud.util.JaxbUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
public class BusinessDispatchService implements ApplicationContextAware {

    @Autowired
    private RasConfig rasConfig;

    @Autowired
    private BusinessRegisterService businessRegisterService;

    private ApplicationContext context;

    @Autowired
    private CertificateValidateService certificateValidateService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 启动时初始化
     */
    @PostConstruct
    public void init() throws IOException {
        //校验证书文件
        checkResConfig();
    }

    //校验证书文件
    private void checkResConfig() throws IOException {
        if(!certificateValidateService.exist()){
            throw new RuntimeException("证书文件不存在");
        }
    }

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
            //返回业务报文base64加密
            String businessResponseXmlEncrypt = Base64Util.encrypt(businessResponseXml);

            RsaUtil rsaUtil = new RsaUtil(rasConfig.getFilePath() + rasConfig.getFileName(), rasConfig.getFilePassword());
            PublicKey publicKey = rsaUtil.getPublicKey();

            //TODO 被加密长度超过 java.lang.SecurityException: RSA加密失败,失败原因:Data must not be longer than 117 bytes
//            byte[] bytes = rsaUtil.rsaPublicEncrypt(businessResponseXmlEncrypt.getBytes(), publicKey);
//            String signedData = StringUtil.byteToBase(bytes);
            String signedData = businessResponseXmlEncrypt;
            String signatureValue = null;
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
