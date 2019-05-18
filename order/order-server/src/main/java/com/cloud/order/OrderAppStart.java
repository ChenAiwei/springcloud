package com.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author：aiwei
 * @Description：StartApp
 * @CreateDate：2019/5/14 14:30
 */
@EnableFeignClients(basePackages = "com.cloud.product.client")
@EnableDiscoveryClient
@SpringBootApplication
public class OrderAppStart {
	public static void main(String[] args) {
		SpringApplication.run(OrderAppStart.class, args);
	}

}
