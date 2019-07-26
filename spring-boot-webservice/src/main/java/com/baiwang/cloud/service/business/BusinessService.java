package com.baiwang.cloud.service.business;

import com.baiwang.cloud.common.model.base.Interface;
import com.baiwang.cloud.common.model.business.common.BusinessResponse;

/**
 * @Description 业务处理接口
 * @Author wangyu
 * @Date 2019/7/25 15:28
 */
public interface BusinessService {

    BusinessResponse doBusiness(Interface interfaceFromXml);

}
