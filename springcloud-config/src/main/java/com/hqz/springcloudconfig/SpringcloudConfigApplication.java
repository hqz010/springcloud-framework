package com.hqz.springcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
public class SpringcloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigApplication.class, args);
	}
}
