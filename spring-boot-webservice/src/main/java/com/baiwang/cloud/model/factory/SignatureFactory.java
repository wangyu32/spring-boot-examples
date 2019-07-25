package com.baiwang.cloud.model.factory;

import com.baiwang.cloud.model.sign.*;
import com.baiwang.cloud.model.sign.Object;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/23 10:31
 */
public class SignatureFactory {

    private static final String DEAULT_ALGORITHM = "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
    private static final String DEAULT_URI = "#001";
//    private static final String DEAULT_KEYNAME = "";
    private static final String DEAULT_OBJECT_ID = "001";

    private SignatureFactory(){
    };

    public static final SignatureFactory getInstance(){
        return InnerClass.instance;
    }

    private static class InnerClass {
        private static SignatureFactory instance = new SignatureFactory();
    }

    /**
     * 生成报文实体类，没有任何默认值的
     * @return
     */
    public static Signature getSignatureInstance(){
        SignatureMethod signatureMethod = new SignatureMethod();
        Reference reference = new Reference();
        SignedInfo signedInfo = new SignedInfo(signatureMethod, reference);
        KeyInfo keyInfo = new KeyInfo();
        Object object = new Object();
        Signature signature = new Signature();
        signature.setSignedInfo(signedInfo);
        signature.setKeyInfo(keyInfo);
        signature.setObject(object);
        return signature;
    }

    /**
     * 生成默认配置的报文实体类,
     * @return
     */
    public static Signature getDefaultSignatureInstance(){
        Signature signature = getSignatureInstance();
        signature.getSignedInfo().getSignatureMethod().setAlgorithm(DEAULT_ALGORITHM);
        signature.getSignedInfo().getReference().setUri(DEAULT_URI);
        signature.getObject().setId(DEAULT_OBJECT_ID);
        return signature;
    }

    /**
     * 生成默认配置的报文实体类,设置签名值和被签名数据
     * @param signatureValue 签名值
     * @param signedData 被签名数据
     * @return
     */
    public static Signature getDefaultSignatureInstance(String signatureValue, String signedData){
        Signature signature = getDefaultSignatureInstance();
        signature.setSignatureValue(signatureValue);
        signature.getObject().setSignedData(signedData);
        return signature;
    }


}
