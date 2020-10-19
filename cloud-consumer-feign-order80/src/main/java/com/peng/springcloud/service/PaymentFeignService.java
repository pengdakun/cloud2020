package com.peng.springcloud.service;

import com.peng.springcloud.entities.CommonResult;
import com.peng.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("/payment/getPaymentById")
    CommonResult<Payment> getPaymentById(@RequestParam("id") Long id);

    @GetMapping("/payment/paymentFeignTimeout")
    String paymentFeignTimeout();

}
