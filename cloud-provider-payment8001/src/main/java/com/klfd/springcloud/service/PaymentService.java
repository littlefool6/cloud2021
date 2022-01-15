package com.klfd.springcloud.service;

import com.klfd.springcloud.entities.Payment;

import java.util.List;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author zlguo
 * @Date 2021/10/10
**/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

    int saveList(List<Payment> paymentList);
}
