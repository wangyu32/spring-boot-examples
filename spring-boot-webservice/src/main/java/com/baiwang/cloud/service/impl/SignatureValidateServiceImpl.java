package com.baiwang.cloud.service.impl;

import com.baiwang.cloud.model.sign.Signature;
import com.baiwang.cloud.service.SignatureValidateService;
import com.baiwang.cloud.util.NullUtil;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 16:47
 */
@Service
public class SignatureValidateServiceImpl implements SignatureValidateService {

    @Override
    public String validate(Signature signature) {
        //TODO
        if(NullUtil.isNull(signature.getSignatureValue())){
            return "签名值不能为空";
        }

        if(NullUtil.isNull(signature.getObject())){
            return "签名对象不能为空";
        }

        if(NullUtil.isNull(signature.getObject().getSignedData())){
            return "业务数据不能为空";
        }

        return null;
    }
}
