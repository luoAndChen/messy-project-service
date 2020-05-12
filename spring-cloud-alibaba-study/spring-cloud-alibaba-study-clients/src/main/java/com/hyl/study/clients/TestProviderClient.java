package com.hyl.study.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hyl
 * on 2020/4/9.
 */
@FeignClient(value = "study-provider", contextId = "testProvider")
public interface TestProviderClient {


    @RequestMapping("/get_test")
    String  getTest();
}
