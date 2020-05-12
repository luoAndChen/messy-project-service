package com.hyl.study.fallback;

import com.hyl.study.clients.TestProviderClient;
import org.springframework.stereotype.Component;

/**
 * Created by hyl
 * on 2020/4/10.
 */
@Component
public class TestProviderFallBack implements TestProviderClient{

    @Override
    public String getTest() {
        return "调用不到生产者，进行了熔断";
    }
}
