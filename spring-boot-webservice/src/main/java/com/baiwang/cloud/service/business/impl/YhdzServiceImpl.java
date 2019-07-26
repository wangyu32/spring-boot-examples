package com.baiwang.cloud.service.business.impl;

import com.baiwang.cloud.common.enums.BizErrorEnum;
import com.baiwang.cloud.common.enums.ws.YhdzEnum;
import com.baiwang.cloud.common.enums.ws.InterfaceEnum;
import com.baiwang.cloud.common.model.ws.base.Interface;
import com.baiwang.cloud.common.model.ws.business.yhdz.request.YhdzRequest;
import com.baiwang.cloud.common.model.ws.business.yhdz.response.YhdzResponse;
import com.baiwang.cloud.common.model.ws.business.common.BusinessResponse;
import com.baiwang.cloud.service.BusinessRegisterService;
import com.baiwang.cloud.service.business.FpcxService;
import com.baiwang.cloud.common.util.JaxbUtil;
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
public class YhdzServiceImpl implements FpcxService {

    @Autowired
    private BusinessRegisterService businessRegisterService;

    //每个具体业务处理接口均需要注册
    @PostConstruct
    public void register() {
        businessRegisterService.register(InterfaceEnum.CLJG, this, YhdzRequest.class, YhdzResponse.class);
    }

    @Override
    public BusinessResponse doBusiness(Interface interfaceFromXml) {
        log.info("接收到业务报文：{}", interfaceFromXml.toXml());

        //业务报文
        String content = interfaceFromXml.getData().getContent();

        YhdzResponse response = null;
        try {
            YhdzRequest request = JaxbUtil.xmlToBean(content, YhdzRequest.class);
            //TODO 具体业务处理

            response = success();
            response.setMessage("成功");
        } catch (JAXBException e) {
            log.error(BizErrorEnum.MESSAGE_FORMAT_ERROR.getMessage(), e);
//            return failed(BizErrorEnum.MESSAGE_FORMAT_ERROR);
        }

        return response;
    }

    private YhdzResponse success(){
        YhdzResponse response = new YhdzResponse();
        response.setCode(YhdzEnum.SUCCESS.getCode());
        return response;
    }

    private YhdzResponse failed(YhdzEnum itemEnum){
        YhdzResponse response = new YhdzResponse();
        response.setCode(itemEnum.getCode());
        return response;
    }

}
