package com.hqz.springcloudconsumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
@RefreshScope
public class testConfig {
    @Value("${myname}") // git配置文件里的key
            String myname;

    @RequestMapping(value = "/test")
    public String test(){
        return myname;
    }
}
