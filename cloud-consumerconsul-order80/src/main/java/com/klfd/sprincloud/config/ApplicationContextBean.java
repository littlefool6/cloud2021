package com.klfd.sprincloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextBean
 * @Description TODO
 * @Author zlguo
 * @Date 2022/1/11
**/
@Configuration
public class ApplicationContextBean {

    @Bean
    @LoadBalanced // 当使用带有负载均衡的restTemplate时，要使用服务名进行访问服务，所以接口/consumer/payment/consul/normal访问报错：No instances available for localhost
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
