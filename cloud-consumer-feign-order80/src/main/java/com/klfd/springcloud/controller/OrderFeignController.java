package com.klfd.springcloud.controller;

import com.klfd.springcloud.entities.CommonResult;
import com.klfd.springcloud.entities.Payment;
import com.klfd.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderFeignController
 * @Description TODO
 * @Author zlguo
 * @Date 2022/2/16
**/
@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "payment/feign/timeOut")
    public String paymentFeignTimeOut() {
        return paymentFeignService.paymentFeignTimeOut();
    }
}
