package com.klfd.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author zlguo
 * @Date 2022/2/19
**/
@Service
public class PaymentService {

    /**
     * @MethodName paymentInfo_OK
     * @Description 正常访问，一切OK
     * @Param [id]
     * @Return java.lang.String
     * @Author zlguo
     * @Date 2022/2/19
     **/
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O";
    }

    /**
     * @MethodName paymentInfo_TimeOut
     * @Description 超时访问，演示降级
     * @Param [id]
     * @Return java.lang.String
     * @Author zlguo
     * @Date 2022/2/19
     **/
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMillisecond", value = "3000")})
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5000;
//        int age = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O，耗费3秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "8001系统繁忙，请稍后再试,id: " + id + "\t" + "o(╥﹏╥)o";
    }

}
