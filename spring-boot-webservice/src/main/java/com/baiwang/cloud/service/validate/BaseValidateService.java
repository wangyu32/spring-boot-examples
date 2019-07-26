package com.baiwang.cloud.service.validate;

import com.baiwang.cloud.common.model.ws.validate.ValidateResult;

/**
 * @Description 校验抽象类
 * @Author wangyu
 * @Date 2019/7/25 14:39
 */
public interface BaseValidateService {

    /**
     * 报文校验，返回null说明校验通过，返回非空字符串，说明校验失败，并且表示校验失败的信息
     * @param message
     * @return
     */
    ValidateResult validate(String message);

}
