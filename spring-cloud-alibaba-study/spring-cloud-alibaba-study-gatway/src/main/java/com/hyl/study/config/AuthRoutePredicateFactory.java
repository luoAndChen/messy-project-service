package com.hyl.study.config;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by hyl
 * on 2020/4/13.
 */
@Component
public class AuthRoutePredicateFactory extends AbstractRoutePredicateFactory<AuthRoutePredicateFactory.Config> {


    public AuthRoutePredicateFactory() {
        super(AuthRoutePredicateFactory.Config.class);
    }

    //将配置文件里面的信息读进来
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("token");
    }
    //断言方法
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return  new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                String token = exchange.getRequest().getQueryParams().getFirst("token");
                if(token!=null&&config.getToken().equals(token)){
                    return true;
                }else{
                    return false;
                }
            }
        };
    }

    @Data
    public static  class Config {
        private String token;
    }
}
