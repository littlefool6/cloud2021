package com.klfd.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GateWayConfig
 * @Description TODO
 * @Author zlguo
 * @Date 2022/3/3
**/
@Configuration
public class GateWayConfig {

    /**
     * @MethodName customRouteLocator
     * @Description 配置了一个id为route-name的路由规则，当访问地址 http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     * @Param [builder]
     * @Return org.springframework.cloud.gateway.route.RouteLocator
     * @Author zlguo
     * @Date 2022/3/3
    **/
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_klfd", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();

    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_klfd2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

}
