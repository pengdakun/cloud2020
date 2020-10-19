package com.peng.springcloud.controller;

import com.peng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/paymentInfoOK")
    public String paymentInfoOK(Integer id){
        String s = paymentService.paymentInfoOK(id);
        return s;
    }

    @GetMapping("/paymentInfoTimeout")
    public String paymentInfoTimeout(Integer id){
        String s = paymentService.paymentInfoTimeout(id);
        return s;
    }


    /**
     * 服务熔断
     * http://localhost:8001/payment/circuit/32
     * @param id
     * @return
     */@GetMapping("/circuit")

    public String paymentCircuitBreaker(Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("***result:" + result);
        return result;
    }


}
