package com.baiwang.cloud.service.validate.impl;

import com.baiwang.cloud.enums.BizErrorEnum;
import com.baiwang.cloud.model.validate.ValidateResult;
import com.baiwang.cloud.service.validate.BaseValidateService;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/25 14:47
 */
public abstract class BaseValidateServiceImpl implements BaseValidateService {

    protected ValidateResult success(){
        ValidateResult validateResult = new ValidateResult();
        validateResult.setSuccess(true);
        return validateResult;
    }
    protected ValidateResult success(Object object){
        ValidateResult validateResult = success();
        validateResult.setObject(object);
        return validateResult;
    }

    protected ValidateResult success(Object object, String message){
        ValidateResult validateResult = success(object);
        validateResult.setMessage(message);
        return validateResult;
    }

    protected ValidateResult failed(){
        ValidateResult validateResult = new ValidateResult();
        validateResult.setSuccess(false);
        return validateResult;
    }

    protected ValidateResult failed(String message){
        ValidateResult validateResult = failed();
        validateResult.setMessage(message);
        return validateResult;
    }

    protected ValidateResult failed(BizErrorEnum bizErrorEnum){
        ValidateResult validateResult = new ValidateResult();
        validateResult.setSuccess(false);
        validateResult.setMessage(bizErrorEnum.getMessage());
        return validateResult;
    }
}
