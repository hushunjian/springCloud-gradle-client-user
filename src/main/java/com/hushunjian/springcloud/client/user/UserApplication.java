package com.hushunjian.springcloud.client.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.hushunjian.springcloud.client.user.mapper")
public class UserApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
