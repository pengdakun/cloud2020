package com.peng.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {


    /**
     * 正常访问
     * @param id
     * @return
     */
    @GetMapping("/payment/paymentInfoOK")
    String paymentInfo_OK(@RequestParam("id") Integer id);

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/paymentInfoTimeout")
    String paymentInfo_TimeOut(@RequestParam("id") Integer id);

}
