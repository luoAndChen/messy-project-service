package com.hyl.study.api;

import com.hyl.study.api.entity.Order;
import com.hyl.study.api.service.OrderService;
import com.hyl.study.clients.TestProviderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hyl
 * on 2020/4/9.
 */
@RestController
@RequestMapping("test_consumer")
@Slf4j
@RefreshScope
public class TestConsumerApi {

    @Autowired
    private TestProviderClient testProviderClient;

    @Autowired
    private OrderService orderService;


   /* @Value("${test.name}")*/
    private String name;

    @RequestMapping("/get_test")
    public String  getTest(){
        String  result = testProviderClient.getTest();
        log.info("远程调用结果:{}",result);
        return  result +"从nacos 配置中西读取到的配置信息："+name;
    }

    @RequestMapping("/create_order")
    public Order createOrder(Long pid){
       return  orderService.createOrder(pid);
    }
}
