package com.klfd.springcloud.service.impl;

import com.klfd.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "ok接口调用失败";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "timout接口调用失败";
    }
}
