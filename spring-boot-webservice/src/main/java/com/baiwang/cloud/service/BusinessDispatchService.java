package com.baiwang.cloud.service;

import com.baiwang.cloud.enums.InterfaceEnum;
import com.baiwang.cloud.model.base.Interface;
import com.baiwang.cloud.service.business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description 业务分发服务
 * @Author wangyu
 * @Date 2019/7/25 16:31
 */
@Component
public class BusinessDispatchService {

    @Autowired
    private BusinessRegisterService businessRegisterService;

    public Object doBusiness(Interface interfaceFromXml) {
        String interfaceCode = interfaceFromXml.getGlobalInfo().getInterfaceCode();
        InterfaceEnum interfaceEnum = InterfaceEnum.valueOf(interfaceCode);
        BusinessService businessService = businessRegisterService.getBusinessService(interfaceEnum);
        return businessService.doBusiness(interfaceFromXml);
    }
}
