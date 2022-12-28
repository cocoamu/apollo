package com.example.demoapollo.controller;

import com.example.demoapollo.util.ConfigUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Value("${sms.enable}")
    String smsEnable;

    @GetMapping("/test1")
    public void value() {
        String enable = ConfigUtils.getApplicationProperty("sms.enable");
        String rockeraddr = ConfigUtils.getProperty("spring-rocketmq", "mq-address");
        String head = ConfigUtils.getProperty("develop.spring-boot-http", "server.tomcat.remote_ip_header");
        String path =  ConfigUtils.getCommonProperty("server.servlet.context-path");
        System.out.println("ok");
    }

    @RequestMapping("/test2")
    public String user() {
        return smsEnable;
    }

}