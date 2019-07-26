package com.baiwang.cloud.common.model.ws.validate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description 验证结果
 * @Author wangyu
 * @Date 2019/7/25 14:24
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateResult {

    //验证结果
    private boolean success;

    //验证错误信息
    private String message;

    //验证结束需要返回的数据
    private Object object;

    public boolean isFailed(){
        return !success;
    }

}
