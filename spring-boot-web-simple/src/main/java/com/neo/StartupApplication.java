package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/3/22 10:58
 */
@SpringBootApplication
public class StartupApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StartupApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
