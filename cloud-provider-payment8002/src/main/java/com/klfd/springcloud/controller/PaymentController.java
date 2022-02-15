package com.klfd.springcloud.controller;

import com.klfd.springcloud.entities.CommonResult;
import com.klfd.springcloud.entities.Payment;
import com.klfd.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author zlguo
 * @Date 2021/10/10
**/
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result + "2222");
        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功，serverPort" + serverPort, result);
        } else {
            return new CommonResult<>(444, "插入数据库失败，serverPort" + serverPort, null);
        }
    }

    @GetMapping(value = "get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功，serverPort" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录,查询ID: " + id + "，serverPort" + serverPort, null);
        }
    }

    @GetMapping(value = "lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
