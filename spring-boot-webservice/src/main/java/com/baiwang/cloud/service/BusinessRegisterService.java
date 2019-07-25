package com.baiwang.cloud.service;

import com.baiwang.cloud.enums.InterfaceEnum;
import com.baiwang.cloud.model.business.common.BusinessRequest;
import com.baiwang.cloud.model.business.common.BusinessResponse;
import com.baiwang.cloud.service.business.BusinessService;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 业务注册服务
 * @Author wangyu
 * @Date 2019/7/25 15:37
 */
@Component
public class BusinessRegisterService {

    private static final Map<InterfaceEnum, BusinessService> businessServiceMap = new ConcurrentHashMap<>();
//    private static final Map<InterfaceEnum, BusinessRequest> businessRequestMap = new ConcurrentHashMap<>();
//    private static final Map<InterfaceEnum, BusinessResponse> businessResponseMap = new ConcurrentHashMap<>();

    private static final Map<InterfaceEnum, Class> businessRequestMap = new ConcurrentHashMap<>();
    private static final Map<InterfaceEnum, Class> businessResponseMap = new ConcurrentHashMap<>();

    public void register(InterfaceEnum interfaceEnum, BusinessService businessService){
        businessServiceMap.put(interfaceEnum, businessService);
    }

//    public void register(InterfaceEnum interfaceEnum, BusinessService businessService,
//                         BusinessRequest businessRequest, BusinessResponse businessResponse){
//        businessServiceMap.put(interfaceEnum, businessService);
//        businessRequestMap.put(interfaceEnum, businessRequest);
//        businessResponseMap.put(interfaceEnum, businessResponse);
//    }

    public void register(InterfaceEnum interfaceEnum, BusinessService businessService,
                         Class businessRequest, Class businessResponse){
        businessServiceMap.put(interfaceEnum, businessService);
        businessRequestMap.put(interfaceEnum, businessRequest);
        businessResponseMap.put(interfaceEnum, businessResponse);
    }

    public BusinessService getBusinessService(InterfaceEnum interfaceEnum){
        return businessServiceMap.get(interfaceEnum);
    }

    public Class getBusinessRequestClass(InterfaceEnum interfaceEnum){
        return businessRequestMap.get(interfaceEnum);
    }

    public Class getBusinessResponseClass(InterfaceEnum interfaceEnum){
        return businessResponseMap.get(interfaceEnum);
    }

}
