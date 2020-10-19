package com.peng.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ZKMain80.class,args);
    }

}
