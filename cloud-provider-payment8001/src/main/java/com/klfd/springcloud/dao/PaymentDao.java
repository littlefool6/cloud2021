package com.klfd.springcloud.dao;

import com.klfd.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName PaymentDao
 * @Description TODO
 * @Author zlguo
 * @Date 2021/10/10
**/
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    int saveList(List<Payment> paymentList);
}
