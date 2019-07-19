package com.example.demo1.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/3/20 23:54
 */
@Slf4j
@Component
@EnableScheduling
public class Demo1Service {

    @Scheduled(cron = "0/1 * * * * ?")
    public void test1(){
        log.info("{} test111...", Thread.currentThread().getName());
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void test2(){
        log.info("{} test222...", Thread.currentThread().getName());
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void test3(){
        log.info("{} test333...", Thread.currentThread().getName());
    }

    @Scheduled(cron = "0/4 * * * * ?")
    public void test4(){
        log.info("{} test444...", Thread.currentThread().getName());
    }

}
