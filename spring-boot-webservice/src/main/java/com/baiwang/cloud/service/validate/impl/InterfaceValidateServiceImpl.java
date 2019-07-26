package com.baiwang.cloud.service.validate.impl;

import com.baiwang.cloud.common.util.Base64Util;
import com.baiwang.cloud.common.enums.BizErrorEnum;
import com.baiwang.cloud.common.enums.ws.InterfaceEnum;
import com.baiwang.cloud.common.model.ws.base.Interface;
import com.baiwang.cloud.common.model.ws.business.common.BusinessRequest;
import com.baiwang.cloud.common.model.ws.validate.ValidateResult;
import com.baiwang.cloud.service.BusinessRegisterService;
import com.baiwang.cloud.service.validate.InterfaceValidateService;
import com.baiwang.cloud.common.util.JaxbUtil;
import com.baiwang.cloud.common.util.NullUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/25 11:42
 */
@Slf4j
@Service
public class InterfaceValidateServiceImpl extends BaseValidateServiceImpl implements InterfaceValidateService {

    @Autowired
    private BusinessRegisterService businessRegisterService;

    @Override
    public ValidateResult validate(String xml) {
        Interface interfaceFromXml = null;
        try {
            //报文解密
            String xmlDecrypt = Base64Util.decrypt(xml);

            //业务报文转业务对象
            interfaceFromXml = JaxbUtil.xmlToBean(xmlDecrypt, Interface.class);

            //globalInfo节点
            if(NullUtil.isNull(interfaceFromXml.getGlobalInfo())){
                return failed(BizErrorEnum.BUSINESS_MESSAGE_FORMAT_ERROR);
            }

            //interfaceCode节点
            if(NullUtil.isNull(interfaceFromXml.getGlobalInfo().getInterfaceCode())){
                return failed(BizErrorEnum.BUSINESS_MESSAGE_FORMAT_ERROR);
            }

            //Data节点
            if(NullUtil.isNull(interfaceFromXml.getData())){
                return failed(BizErrorEnum.BUSINESS_MESSAGE_FORMAT_ERROR);
            }

            //content节点
            if(NullUtil.isNull(interfaceFromXml.getData().getContent())){
                return failed(BizErrorEnum.BUSINESS_MESSAGE_FORMAT_ERROR);
            }

            //接口编码
            String interfaceCode = interfaceFromXml.getGlobalInfo().getInterfaceCode();
            InterfaceEnum interfaceEnum = InterfaceEnum.valueOf(interfaceCode);
            if(interfaceEnum == null){
                log.error("接口编码{}不存在", interfaceCode);
                return failed(BizErrorEnum.INTERFACE_CODE_ERROR);
            }

            //业务报文
            String content = interfaceFromXml.getData().getContent();

            //具体业务请求封装类
            Class clazz = businessRegisterService.getBusinessRequestClass(interfaceEnum);

            log.info("使用JAXB转换报文校验业务报文开始");
            //校验报文
            BusinessRequest businessRequest = (BusinessRequest)JaxbUtil.xmlToBean(content, clazz);
            log.info("使用JAXB转换报文校验业务报文成功, BusinessRequest={}", businessRequest);
        } catch (JAXBException e) {
            log.error(BizErrorEnum.MESSAGE_FORMAT_ERROR.getMessage(), e);
            return failed(BizErrorEnum.MESSAGE_FORMAT_ERROR);
        } catch (IOException e) {
            log.error(BizErrorEnum.MESSAGE_FORMAT_ERROR.getMessage(), e);
            return failed(BizErrorEnum.MESSAGE_FORMAT_ERROR);
        }

        return success(interfaceFromXml);
    }
}
