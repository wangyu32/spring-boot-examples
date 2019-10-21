package com.neo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/3/22 10:59
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    public String hello(){
        return "hello success";
    }

    @GetMapping("/upload")
    public String upload(HttpServletRequest request){
        String tempPath = request.getSession().getServletContext().getRealPath("/temp");
        System.out.println("tempPath=" + tempPath);
        File tmpFile = new File(tempPath);
        System.out.println(tmpFile.exists());
        return "upload success";
    }

}
