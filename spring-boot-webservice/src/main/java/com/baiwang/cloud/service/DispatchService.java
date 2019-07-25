package com.baiwang.cloud.service;

import com.baiwang.cloud.service.validate.CertificateValidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 10:03
 */
@Slf4j
@Component
@ComponentScan
public class DispatchService implements ApplicationContextAware {

    private ApplicationContext context;

    @Autowired
    private CertificateValidateService certificateValidateService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 启动时初始化
     */
    @PostConstruct
    public void init() throws IOException {
        //校验证书文件
        checkResConfig();
    }

    //校验证书文件
    private void checkResConfig() throws IOException {
        if(!certificateValidateService.exist()){
            throw new RuntimeException("证书文件不存在");
        }
    }

}