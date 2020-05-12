package com.hyl.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan( basePackages = {"com.hyl.study.api.mapper"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringCloudAlibabaStudyProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAlibabaStudyProviderApplication.class, args);
	}

}
