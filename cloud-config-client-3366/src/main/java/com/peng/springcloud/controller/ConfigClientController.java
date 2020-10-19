package com.peng.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //刷新，github配置改后，服务可以第一时间感觉到
//curl -X POST http://localhost:3355/actuator/refresh post请求，手动刷新获取最新的配置文件
public class ConfigClientController {

    @Value("${version}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}