package com.baiwang.cloud.adapter;

import com.baiwang.cloud.model.base.Interface;
import com.baiwang.cloud.model.sign.Signature;
import com.baiwang.cloud.model.validate.ValidateResult;
import com.baiwang.cloud.service.BusinessDispatchService;
import com.baiwang.cloud.service.validate.InterfaceValidateService;
import com.baiwang.cloud.service.validate.SignatureValidateService;
import com.baiwang.cloud.util.NullUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @Description WebService适配器
 * @Author wangyu
 * @Date 2019/7/23 10:31
 */
@Slf4j
@WebService(serviceName = "WebServiceAdapter", targetNamespace = "http://adapter.entrance.finance.baiwang.com")
@Component
public class WebServiceAdapter{

    @Autowired
    private SignatureValidateService signatureValidateService;

    @Autowired
    private InterfaceValidateService interfaceValidateService;

    @Autowired
    private BusinessDispatchService businessDispatchService;

    @WebMethod
    public String service(@WebParam(name = "service") String message) {
        log.info("请求报文：{}", message);

        //1. message 非空校验
        if(NullUtil.isNull(message)){
            log.error("请求报文为空：{}", message);
            return failed("请求报文为空");
        }

        //2.签名校验
        ValidateResult validateResult = signatureValidateService.validate(message);
        if(validateResult.isFailed()){
            return failed(validateResult);
        }

        Signature signature = (Signature)validateResult.getObject();

        //xml中的被签名的业务数据
        String signedDataBase64 = signature.getObject().getSignedData();
        //3.业务报文校验
        validateResult = interfaceValidateService.validate(signedDataBase64);
        if(validateResult.isFailed()){
            return failed(validateResult);
        }

        //业务报文
        Interface interfaceFromXml = (Interface)validateResult.getObject();
        Signature signatureResponse = this.businessDispatchService.doBusinessSignature(interfaceFromXml);
        return signatureResponse.toXml();
    }

    private String failed(String message){
        return "";
    }

    private String failed(ValidateResult validateResult){
        return validateResult.getMessage();
    }

    private String succss(String message){
        return "";
    }

}