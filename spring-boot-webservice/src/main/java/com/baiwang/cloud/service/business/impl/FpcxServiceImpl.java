package com.baiwang.cloud.service.business.impl;

import com.baiwang.cloud.enums.BizErrorEnum;
import com.baiwang.cloud.enums.InterfaceEnum;
import com.baiwang.cloud.model.base.Interface;
import com.baiwang.cloud.model.business.fpcx.request.FpcxRequest;
import com.baiwang.cloud.model.business.fpcx.response.FpcxResponse;
import com.baiwang.cloud.service.BusinessRegisterService;
import com.baiwang.cloud.service.business.FpcxService;
import com.baiwang.cloud.util.JaxbUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/25 15:44
 */
@Slf4j
@Service
public class FpcxServiceImpl implements FpcxService {

    @Autowired
    private BusinessRegisterService businessRegisterService;

    //每个具体业务处理接口均需要注册
    @PostConstruct
    public void register() {
        businessRegisterService.register(InterfaceEnum.FPCX, this, FpcxRequest.class, FpcxResponse.class);
    }

    @Override
    public Object doBusiness(Interface interfaceFromXml) {
        log.info("接收到业务报文：{}", interfaceFromXml.toXml());

        //业务报文
        String content = interfaceFromXml.getData().getContent();

        try {
            FpcxRequest fpcxRequest = JaxbUtil.xmlToBean(content, FpcxRequest.class);
        } catch (JAXBException e) {
            log.error(BizErrorEnum.MESSAGE_FORMAT_ERROR.getMessage(), e);
//            return failed(BizErrorEnum.MESSAGE_FORMAT_ERROR);
        }
        //TODO 具体业务处理

        return null;
    }

}
