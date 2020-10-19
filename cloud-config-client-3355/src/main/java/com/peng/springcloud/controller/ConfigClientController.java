package com.peng.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //刷新，github配置改后，服务可以第一时间感觉到
//curl -X POST http://localhost:3355/actuator/refresh post请求，手动刷新获取最新的配置文件
//如果使用了bus消息总线实现一处刷新，处处生效，需要调用配置服务接口，curl -X POST http://localhost:3344/actuator/bus-refresh
//如果只需要指定某些服务拉取配置，则需要指定服务名+端口号  curl -X POST http://localhost:3344/actuator/bus-refresh/config-client:3355
public class ConfigClientController {

    @Value("${version}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}