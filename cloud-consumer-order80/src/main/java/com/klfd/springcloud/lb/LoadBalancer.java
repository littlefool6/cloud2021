package com.klfd.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName LoadBalancer
 * @Description TODO
 * @Author zlguo
 * @Date 2022/2/15
**/
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
