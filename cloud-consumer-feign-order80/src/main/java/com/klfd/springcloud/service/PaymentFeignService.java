package com.klfd.springcloud.service;

import com.klfd.springcloud.entities.CommonResult;
import com.klfd.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentFeignService
 * @Description TODO
 * @Author zlguo
 * @Date 2022/2/16
**/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "payment/feign/timeOut")
    String paymentFeignTimeOut();

}
