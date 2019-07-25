package com.baiwang.cloud.service;

import com.baiwang.cloud.enums.InterfaceEnum;
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

    //保存业务处理接口，key为业务编码枚举类，value为具体业务处理接口
    private static final Map<InterfaceEnum, BusinessService> businessServiceMap = new ConcurrentHashMap<>();
    //保存业务请求报文封装类，key为业务编码枚举类，value为具体业务请求报文封装类
    private static final Map<InterfaceEnum, Class> businessRequestMap = new ConcurrentHashMap<>();
    //保存业务响应报文封装类，key为业务编码枚举类，value为具体业务响应报文封装类
    private static final Map<InterfaceEnum, Class> businessResponseMap = new ConcurrentHashMap<>();

    /**
     * 根据不同业务编码注册业务处理接口，请求报文封装类，响应报文封装类
     * @param interfaceEnum 业务编码枚举类
     * @param businessService 业务处理接口
     * @param businessRequest 请求报文封装类
     * @param businessResponse 响应报文封装类
     */
    public void register(InterfaceEnum interfaceEnum, BusinessService businessService,
                         Class businessRequest, Class businessResponse){
        businessServiceMap.put(interfaceEnum, businessService);
        businessRequestMap.put(interfaceEnum, businessRequest);
        businessResponseMap.put(interfaceEnum, businessResponse);
    }

    /**
     * 根据业务编码获取具体业务处理接口
     * @param interfaceEnum 业务编码枚举类
     * @return
     */
    public BusinessService getBusinessService(InterfaceEnum interfaceEnum){
        return businessServiceMap.get(interfaceEnum);
    }

    /**
     * 根据业务编码获取具体请求报文封装类
     * @param interfaceEnum 业务编码枚举类
     * @return
     */
    public Class getBusinessRequestClass(InterfaceEnum interfaceEnum){
        return businessRequestMap.get(interfaceEnum);
    }

    /**
     * 根据业务编码获取具体响应报文封装类
     * @param interfaceEnum 业务编码枚举类
     * @return
     */
    public Class getBusinessResponseClass(InterfaceEnum interfaceEnum){
        return businessResponseMap.get(interfaceEnum);
    }

}
