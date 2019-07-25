package com.baiwang.cloud.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/23 17:43
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class RasConfig {

    //认证文件类型
    @Value("${certificate.file.type}")
    private String fileType;

    //认证文件名
    @Value("${certificate.file.name}")
    private String fileName;

    //认证文件目录
    @Value("${certificate.file.path}")
    private String filePath;

    //认证文件密码
    @Value("${certificate.file.password}")
    private String filePassword;

}
