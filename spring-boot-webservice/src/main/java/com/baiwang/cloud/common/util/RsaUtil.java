package com.baiwang.cloud.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.Enumeration;

/**
 * Rsa加密解密工具类
 * @ClassName: RsaUtil
 * @Description: Rsa加密解密工具类
 * @author luqiang
 * @date 2019年07月22日
 */
public class RsaUtil {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //MD5withRSA和SHA1withRSA两种模式，签名及验签对应即可
    private String signAlgorithm = "SHA1WithRSA";

    /*
     * 使用RSA算法(RSA,RSA/ECB/PKCS1Padding为117位,NoPadding为128位)
     * RSA/ECB/PKCS1Padding的方式是按照PKCS1的标准.即输入数据长度小于等于密钥的位数/8-11
     * 例如：1024位密钥,1024/8-11=117.不足的部分,程序会自动补齐.加密后的数据还是等于密钥的位数/8-11(8至11之间)
     * 如果不指定,那么输入数据就必须等于密钥的位数/8
     */
    private String otherData = "RSA/ECB/PKCS1Padding";

    /** 服务器证书 */
    private Certificate certificate = null;
    /** 服务器公钥 */
    private PublicKey publicKey = null;
    /** 服务器私钥 */
    private PrivateKey privateKey = null;
    /** 密钥类型 */
    private String keyType = "PKCS12";

    /**
     * 加载证书文件，解析证书、公钥、私钥 <br/>
     * @param certFile 证书文件名称
     * @param certPass 让书文件密码
     * @return
     * @throws SecurityException
     */
    public RsaUtil(String certFile, String certPass) throws SecurityException {
        FileInputStream fis = null;
        FileOutputStream ois = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(keyType);
            fis = new FileInputStream(certFile);
            char[] password = null;
            if ((null!=certPass) && !"".equals(certPass)) {
                password = certPass.toCharArray();
            }
            keyStore.load(fis, password);
            fis.close();
            Enumeration enums = keyStore.aliases();
            String keyAlias = null;
            if (enums.hasMoreElements()) {
                keyAlias = (String)enums.nextElement();
            }

            privateKey = (PrivateKey)keyStore.getKey(keyAlias, password);
            certificate = keyStore.getCertificate(keyAlias);
            publicKey = certificate.getPublicKey();

            //对证书、公钥、私钥数据进行输出
            logger.info("is key entry:" + keyStore.isKeyEntry(keyAlias));
            logger.info("cert class  : " + certificate.getClass().getName());
            logger.info("certificate : " + certificate);
            logger.info("public key  : " + publicKey);
            logger.info("private key : " + privateKey);
            DateFormat df = DateFormat.getDateTimeInstance();
            logger.info("server cert start："+df.format(((X509Certificate)certificate).getNotAfter()));
            logger.info("server cert end："+df.format(((X509Certificate)certificate).getNotBefore()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new SecurityException("加载证书文件，解析证书、公钥、私钥失败,失败原因:"+e.getMessage());
        } finally {
            if (null!=ois) try {ois.close();} catch (IOException e) {e.printStackTrace();}
            if (null!=fis) try {fis.close();} catch (IOException e) {e.printStackTrace();}
        }
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * Rsa公钥加密数据 <br/>
     * @param buff 数据
     * @param publicKey 公钥对象
     * @return byte[] 加密后的数据
     * @throws SecurityException
     */
    public byte[] rsaPublicEncrypt(byte[] buff,PublicKey publicKey) throws SecurityException {
        //判断加密数据是否为空
        if (null==buff) {
            throw new SecurityException("RSA加密数据不合法,无法进行数据加密!");
        }
        //判断公钥对象是否为空
        if (null==publicKey) {
            throw new SecurityException("公钥对象为空,无法进行数据加密!");
        }

        try {
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(otherData);
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            //执行加密操作
            return cipher.doFinal(buff);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SecurityException("RSA加密失败,失败原因:"+e.getMessage());
        }
    }
    /**
     * Rsa公钥解密数据 <br/>
     * @param buff 数据
     * @param publicKey 公钥对象
     * @return byte[] 解密后的数据
     * @throws SecurityException
     */
    public byte[] rsaPublicDecrypt(byte[] buff,PublicKey publicKey) throws SecurityException {
        //判断加密数据是否为空
        if (null==buff) {
            throw new SecurityException("RSA加密数据不合法,无法进行数据加密!");
        }
        //判断公钥对象是否为空
        if (null==publicKey) {
            throw new SecurityException("公钥对象为空,无法进行数据解密!");
        }

        try {
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(otherData);
            //用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            //执行加密操作
            return cipher.doFinal(buff);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SecurityException("RSA加密失败,失败原因:"+e.getMessage());
        }
    }
    /**
     * Rsa私钥加密数据 <br/>
     * @param buff 数据
     * @param privateKey 私钥对象
     * @return byte[] 加密后的数据
     * @throws SecurityException
     */
    public byte[] rsaPrivateEncrypt(byte[] buff,PrivateKey privateKey) throws SecurityException {
        //判断加密数据是否为空
        if (null==buff) {
            throw new SecurityException("RSA加密数据不合法,无法进行数据加密!");
        }
        //判断私钥对象是否为空
        if (null==privateKey) {
            throw new SecurityException("私钥对象为空,无法进行数据加密!");
        }

        try {
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(otherData);
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            //执行加密操作
            return cipher.doFinal(buff);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SecurityException("RSA加密失败,失败原因:"+e.getMessage());
        }
    }
    /**
     * Rsa私钥解密数据 <br/>
     * @param buff 数据
     * @param privateKey 私钥对象
     * @return byte[] 解密后的数据
     * @throws SecurityException
     */
    public byte[] rsaPrivateDecrypt(byte[] buff,PrivateKey privateKey) throws SecurityException {
        //判断加密数据是否为空
        if (null==buff) {
            throw new SecurityException("RSA加密数据不合法,无法进行数据加密!");
        }
        //判断私钥对象是否为空
        if (null==privateKey) {
            throw new SecurityException("私钥对象为空,无法进行数据解密!");
        }

        try {
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(otherData);
            //用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            //执行加密操作
            return cipher.doFinal(buff);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SecurityException("RSA加密失败,失败原因:"+e.getMessage());
        }
    }

    /**
     * 生成签名数据
     * @param buff 需要签名的数据
     * @param privateKey 私钥对象
     * @return byte[] 签名后的数据
     */
    public byte[] buildSign(byte[] buff,PrivateKey privateKey) throws SecurityException {
        //判断私钥对象是否为空
        if (null==privateKey) {
            throw new SecurityException("私钥对象为空,无法进行数据签名!");
        }

        try {
            //对数据进行签名
            Signature signature = Signature.getInstance(signAlgorithm);
            signature.initSign(privateKey);
            signature.update(buff);
            return signature.sign();
        } catch(Exception e) {
            e.printStackTrace();
            throw new SecurityException("RSA生成签名数据失败,失败原因:"+e.getMessage());
        }
    }
    /**
     * 校验签名数据
     * @param buff 原始数据
     * @param sign 签名后的数据
     * @param publicKey 公钥对象
     * @return boolean true:验证成功 false:验证失败
     */
    public boolean verifySign(byte[] buff,byte[] sign,PublicKey publicKey) throws SecurityException {
        //判断公钥对象是否为空
        if (null==publicKey) {
            throw new SecurityException("公钥对象为空,无法进行数据验签!");
        }

        try {
            //对数据进行签名
            Signature signature = Signature.getInstance(signAlgorithm);
            signature.initVerify(publicKey);
            signature.update(buff);
            return signature.verify(sign);
        } catch(Exception e) {
            e.printStackTrace();
            throw new SecurityException("RSA校验签名数据失败,失败原因:"+e.getMessage());
        }
    }

    public static void main(String[] args) {
        String certPath = "D://baiwang//cert//";
        String certName = "invoice.pfx";
        String certPass = "chinazxt";

        byte[] buff = "ABCD0123456789".getBytes();
        try {
            //加载证书数据
            RsaUtil rsaUtil = new RsaUtil(certPath+certName,certPass);
            PublicKey publicKey = rsaUtil.getPublicKey();
            PrivateKey privateKey = rsaUtil.getPrivateKey();
            //公钥加密私钥解密------------------------------------------------------------
            //公钥加密
            byte[] pubEncryptBuff = rsaUtil.rsaPublicEncrypt(buff,publicKey);
            System.out.println("公钥加密后的数据："+StringUtil.byteToBase(pubEncryptBuff));
            //私钥解密
            byte[] priDecryptBuff = rsaUtil.rsaPrivateDecrypt(pubEncryptBuff,privateKey);
            System.out.println("私钥加密后的数据："+new String(priDecryptBuff));

            //私钥加密公钥解密------------------------------------------------------------
            //私钥加密
            byte[] priEncryptBuff = rsaUtil.rsaPrivateEncrypt(buff,privateKey);
            System.out.println("私钥加密后的数据："+StringUtil.byteToBase(priEncryptBuff));
            //公钥解密
            byte[] pubDecryptBuff = rsaUtil.rsaPublicDecrypt(priEncryptBuff,publicKey);
            System.out.println("公钥解密后的数据："+new String(pubDecryptBuff));

            //私钥加密公钥解密------------------------------------------------------------
            //生成签名数据
            byte[] signatureBuff = rsaUtil.buildSign(buff,privateKey);
            System.out.println("生成签名数据后的数据："+StringUtil.byteToBase(signatureBuff));
            //校验签名数据
            boolean signatureFlag = rsaUtil.verifySign(buff,signatureBuff,publicKey);
            System.out.println("校验签名数据后的数据："+signatureFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
