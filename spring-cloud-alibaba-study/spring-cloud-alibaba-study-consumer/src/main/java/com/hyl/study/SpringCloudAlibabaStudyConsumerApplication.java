package com.hyl.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
		exclude = {
				DataSourceAutoConfiguration.class
		}
)
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.hyl.study.api.mapper")
public class SpringCloudAlibabaStudyConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAlibabaStudyConsumerApplication.class, args);
	}

}
