package com.hyl.study.api.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hyl.study.api.entity.Order;
import com.hyl.study.api.mapper.OrderMapper;
import com.hyl.study.api.service.OrderService;
import com.hyl.study.clients.ProductClient;
import com.hyl.study.vo.ProductVo;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hy
 * on 2020/4/16.
 */
@Service
@Slf4j
public class OrderServiceImpl  extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private ProductClient productClient;


    @Override
    @Transactional
    @GlobalTransactional
    public Order createOrder(Long pid) {
        ProductVo productVo =productClient.findById(pid);
        Order order = Order.builder().pId(pid).pName(productVo.getName()).userId(1L).quantity(1L).build();
        this.insert(order);
        //扣减库存
        productClient.deductionQuantity(pid,1L);
        return order;
    }
}
