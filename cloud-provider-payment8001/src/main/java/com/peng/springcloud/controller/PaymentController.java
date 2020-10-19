package com.peng.springcloud.controller;

import com.peng.springcloud.entities.CommonResult;
import com.peng.springcloud.entities.Payment;
import com.peng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    public String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("*****插入结果："+i);
        if (i>0){
            return new CommonResult(200,"插入成功");
        }else{
            return new CommonResult(500,"插入失败");
        }
    }

    @GetMapping("/getPaymentById")
    public CommonResult getPaymentById(Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果"+serverPort+"："+payment);
        if (payment!=null){
            return new CommonResult(payment);
        }else{
            return new CommonResult(500,"查询失败");
        }
    }


    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//服务
        services.forEach(s->{
            log.info(s);
        });

        //具体实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        instances.forEach(i->{
            log.info(i.getServiceId()+"\t"+i.getHost()+"\t"+i.getPort()+"\t"+i.getUri());
        });
        return discoveryClient;
    }


    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping("/paymentFeignTimeout")
    public String paymentFeignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hahhaha";
    }



    /**
     * 链路跟踪
     *
     * @return
     */
    @GetMapping(value = "/zipkin")
    public String paymentZipkin() {
        return "hi,i'am paymentZipkin server fall back,welcome to atguigu,O(∩_∩)O哈哈~";
    }

}
