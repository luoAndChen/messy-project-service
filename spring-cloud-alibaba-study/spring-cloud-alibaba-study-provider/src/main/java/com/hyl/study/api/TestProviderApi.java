package com.hyl.study.api;

import com.hyl.study.clients.TestProviderClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hyl
 * on 2020/4/9.
 */
@RestController
public class TestProviderApi implements TestProviderClient {

    @Value("${server.port}")
    private String port;

    private  int i=0;
    @Override
    public String  getTest(){
        i++;
       /* if(i%2==0){
            throw  new RuntimeException();
        }*/
        return "provider测试一下调用端口："+port;
    }
}
