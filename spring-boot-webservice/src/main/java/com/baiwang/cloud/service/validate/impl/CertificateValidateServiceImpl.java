package com.baiwang.cloud.service.validate.impl;

import com.baiwang.cloud.config.RasConfig;
import com.baiwang.cloud.common.enums.ws.CertificateFileEnum;
import com.baiwang.cloud.service.validate.CertificateValidateService;
import com.baiwang.cloud.util.NullUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/24 17:18
 */
@Slf4j
@Service
public class CertificateValidateServiceImpl implements CertificateValidateService {

    @Autowired
    private RasConfig rasConfig;

    @Override
    public boolean exist() {
        String fileType = rasConfig.getFileType();
        if (NullUtil.isNull(fileType)) {
            log.error("证书类型未配置");
            throw new RuntimeException("证书类型未配置");
        }

        if (CertificateFileEnum.valueOf(fileType) == CertificateFileEnum.DIST) {
            //本地硬盘
            String filePath = rasConfig.getFilePath();
            if (NullUtil.isNull(filePath)) {
                log.error("证书文件目录未配置");
                throw new RuntimeException("证书文件目录未配置");
            }

            String fileName = rasConfig.getFileName();
            if (NullUtil.isNull(fileName)) {
                log.error("证书文件名称未配置");
                throw new RuntimeException("证书文件名称未配置");
            }

            String filePassword = rasConfig.getFilePassword();
            if (NullUtil.isNull(filePassword)) {
                log.error("证书文件密码未配置");
                throw new RuntimeException("证书文件密码未配置");
            }

            File file = new File(filePath + fileName);
            if (!file.exists()) {
                log.error("{}证书文件不存在", filePath + fileName);
                throw new RuntimeException(String.format("%s证书文件不存在", filePath + fileName));
            }
        } else if (CertificateFileEnum.valueOf(fileType) == CertificateFileEnum.JAR) {
            //TODO 证书在jar包情况
            return false;
        }
        return true;
    }
}
