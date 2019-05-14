package com.cloud.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author：aiwei
 * @Description：StartApp
 * @CreateDate：2019/5/14 14:30
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AppStart {
	public static void main(String[] args) {
		SpringApplication.run(AppStart.class, args);
	}

}
