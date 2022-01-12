package com.klfd.sprincloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderConsulController
 * @Description TODO
 * @Author zlguo
 * @Date 2022/1/11
**/
@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderConsulController {

    public static final String URL = "http://localhost:8006";

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    public RestTemplate restTemplate;

    @GetMapping
    @RequestMapping(value = "payment/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        System.out.println("消费者调用支付服务(consul)--->result:" + result);
        return result;
    }

    // 当使用带有负载均衡的restTemplate时，要使用服务名进行访问服务，所以接口/consumer/payment/consul/normal访问报错：No instances available for localhost
    @GetMapping
    @RequestMapping(value = "payment/consul/normal")
    public String paymentInfoNormal() {
        String result = restTemplate.getForObject(URL + "/payment/consul", String.class);
        System.out.println("（直连）消费者调用支付服务(consul)--->result:" + result);
        return result;
    }
}
