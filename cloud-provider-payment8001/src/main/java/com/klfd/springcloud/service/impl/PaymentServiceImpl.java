package com.klfd.springcloud.service.impl;

import com.klfd.springcloud.dao.PaymentDao;
import com.klfd.springcloud.entities.Payment;
import com.klfd.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Author zlguo
 * @Date 2021/10/10
**/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int saveList(List<Payment> paymentList) {
        return paymentDao.saveList(paymentList);
    }
}
