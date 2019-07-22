package com.baiwang.cloud.service;

import com.baiwang.cloud.model.sign.Signature;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 16:45
 */
public interface SignatureValidateService {

    /**
     * 报文校验，返回null说明校验通过，返回非空字符串，说明校验失败，并且表示校验失败的信息
     * @param signature
     * @return
     */
    String validate(Signature signature);

}
