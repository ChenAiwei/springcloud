package com.cloud.ek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author：aiwei
 * @Description：StartApp
 * @CreateDate：2019/5/11 18:04
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApp {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp.class, args);
	}
}
