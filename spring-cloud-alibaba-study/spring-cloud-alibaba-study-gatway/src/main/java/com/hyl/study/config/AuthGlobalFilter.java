package com.hyl.study.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Created by hyl
 * on 2020/4/13.
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    //过滤器逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        String sign = exchange.getRequest().getQueryParams().getFirst("sign");
        //假设我们这里对参数进行验签
        if(token==null||sign==null){
            //设置404状态嘛
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return  exchange.getResponse().setComplete();
        }
        if(!token.equals(sign)){
            //设置404状态嘛
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return  exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    //过滤器的优先级
    @Override
    public int getOrder() {
        return 0;
    }
}
